package 박윤환;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class P043_SWEA1247_최적경로 {

    static int N, min;
    static int[][] map;
    static boolean[] visited;

    // 모든 고객을 방문하고 집까지 가는 최단거리를 구하는 메소드
    static void search(int n, int cnt, int sum) {
        if(cnt == N) {  // 모든 고객을 다 방문했다면
            min = Math.min(min, sum+map[n][1]); // 집까지 거리를 더하고 최소값 비교
            return;
        }
        // 모든 좌표를 목적지로 반복
        for(int i=0; i<N+2; i++) {
            if(i==1) continue;  // 집은 마지막에 방문해야하므로 패스
            if(n != i && !visited[i]) { // 현재 위치가 아니면서 방문 안한 곳이라면
                visited[i] = true;  // 방문 처리
                search(i, cnt+1, sum+map[n][i]); // 그 위치에서 다시 탐색
                visited[i] = false; // 방문 처리 취소
            }
        }
    }

    // 맨하탄 거리를 구하는 메소드
    static int distance(int[] a, int[] b) {
        return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
    }

    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());    // 테스트케이스 개수
        for(int tc=1; tc<=T; tc++) {    // 테스트케이스만큼 반복
            N = Integer.parseInt(br.readLine());    // 고객의 수
            int[][] cord = new int[N+2][2];     // 모든 좌표 기록
            map = new int[N+2][N+2];    // 인접행렬 작성
            visited = new boolean[N+2]; // 방문기록 작성
            String[] st = br.readLine().split(" ");

            for(int i=0, j=0; i<N+2; i++) {
                cord[i][0] = Integer.parseInt(st[j++]);
                cord[i][1] = Integer.parseInt(st[j++]);
            }

            for(int i=0; i<N+2; i++) {
                for(int j=0; j<N+2; j++) {
                    map[i][j] = distance(cord[i], cord[j]); // 입력받은 순서대로 인접행렬에 기록
                }
            }

            min = 987654321;
            visited[0] = true;  // 회사 방문 기록
            search(0, 0, 0);

            sb.append("#").append(tc).append(" ").append(min).append("\n");
        }
        System.out.println(sb);
    }
}
