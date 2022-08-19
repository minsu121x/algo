package 박윤환;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P000_SWEA6485_삼성시의버스노선 {
    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("s_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());    // 테스트케이스 개수
        for(int tc=1; tc<=T; tc++) {    // 모든 테스트케이스 반복
            int N = Integer.parseInt(br.readLine());    // 버스노선의 수
            int[] A = new int[N+1];     // 해당 버스가 다니는 가장 작은 정류장 번호
            int[] B = new int[N+1];     // 해당 버스가 다니는 가장 큰 정류장 번호

            for(int i=1; i<=N; i++) {
                String[] st = br.readLine().split(" ");
                A[i] = Integer.parseInt(st[0]);
                B[i] = Integer.parseInt(st[1]);
            }

            int P = Integer.parseInt(br.readLine());    // 정류장 개수
            int[] C = new int[P+1];     // 정류장 번호를 담는 배열
            int[] cnt = new int[P+1];   // 각 정류장별 다니는 버스 개수를 카운팅할 배열
            for(int i=1; i<=P; i++) {
                C[i] = Integer.parseInt(br.readLine());
            }

            for(int i=1; i<=P; i++) {
                for(int j=1; j<=N; j++) {
                    if(C[i] >= A[j] && C[i] <= B[j]) {  // 해당 범위내에 정류장이 있다면
                        cnt[i]++;   // 그 정류장의 카운트 증가
                    }
                }
            }

            sb.append("#").append(tc).append(" ");
            for(int i=1; i<=P; i++) {
                sb.append(cnt[i]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
