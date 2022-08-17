package 조민수;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P041_BJ1992_쿼드트리 {

    static int N;
    static int[][] arr;
    static StringBuilder sb;

    static void dnq(int n, int r, int c) {
        // 사이즈 1이면
        if(n == 1) {
            if(arr[r][c] == 0) {    
                sb.append(0);   
            } else if(arr[r][c] == 1) {
                sb.append(1);  
            }
            return;
        }

        boolean same = true;
        // 현재 크기내 원소가 
        for(int i=r; i<r+n; i++) {
            for(int j=c+1; j<c+n; j++) {//내값과 내 앞값 비교를 위해 시작을 +1로
            	if(arr[i][j]!=arr[i][j-1]) {//내값과 내 앞값 비교
            		same=false;
            		break;//같지않으면 바로 탈출
            	}
            }
            if(!same) {
            	break;//같지않으면 바로 탈출
            }
        }
        if(same) {  // 값이 다 같다
            sb.append(arr[r][c]);//아무값이나 하나 넣어주면 됨 편의상 제일 앞값
        } 
        else {    // 다르면 4등분 분할해서 연산반복
            sb.append("(");
            // 1사분면
            dnq(n / 2, r, c);

            // 2사분면
            dnq(n / 2, r, c + n / 2);

            // 3사분면
            dnq(n / 2, r + n / 2, c);

            // 4사분면
            dnq(n / 2, r + n / 2, c + n / 2);
            sb.append(")");
        }

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        for(int i=0; i<N; i++) {
            String[] st = br.readLine().split("");
            for(int j=0; j<N; j++) {
                arr[i][j] = Integer.parseInt(st[j]);
            }
        }

        dnq(N, 0, 0);

        System.out.println(sb);

    }
}