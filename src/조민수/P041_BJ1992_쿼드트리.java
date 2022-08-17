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

        int sum = 0;
        // 현재 크기내 원소합을 구함
        for(int i=r; i<r+n; i++) {
            for(int j=c; j<c+n; j++) {
                sum += arr[i][j];
            }
        }
        if(sum == 0) {  // 합이 0이다-> 값이 모두 0이다 ->0찍고 끝
            sb.append(0);
        } else if(sum == n*n) { // 합이 n*n이다-> 값이 모두 1이다 ->1찍고 끝
            sb.append(1);
        } else {    // 둘다 아니다-> 4등분해서 분할정복
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