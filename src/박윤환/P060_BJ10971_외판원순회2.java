package 박윤환;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P060_BJ10971_외판원순회2 {

    static int N, min;
    static int[][] W;
    static boolean[] visited;

    // dfs 탐색
    static void dfs(int cnt, int cur, int sum) {
        visited[cur] = true;    // 현재 방문 처리

        if(cnt == N-1) {    // 방문한 도시가 N-1개 라면
            if(W[cur][0] != 0) {    // 0번쨰 도시로 돌아갈수 있다면
                sum += W[cur][0];   // 0으로 돌아오는 만큼 비용 추가
                min = Math.min(min, sum);   // 최소값 갱신
            }
        }

        for(int j=0; j<N; j++) {    // 도시개수만큼 반복
            if(!visited[j] && W[cur][j] != 0) { // 방문하지 않았거나 비용이 0이 아닌경우
                dfs(cnt + 1, j, sum + W[cur][j]);   // 해당 도시 방문
            }
        }
        visited[cur] = false;   // 방문처리 취소하고 백트래킹
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());    // 도시 개수
        W = new int[N][N];  // 지도 배열
        visited = new boolean[N];   // 방문기록 배열
        String[] st;
        for(int i=0; i<N; i++) {
            st = br.readLine().split(" ");
            for(int j=0; j<N; j++) {
                W[i][j] = Integer.parseInt(st[j]);
            }
        }

        min = Integer.MAX_VALUE;    // 최소값 갱신을 위한 큰 값 세팅
        dfs(0, 0, 0);   // dfs 탐색

        System.out.println(min);

    }
}
