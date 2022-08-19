package 박윤환;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class P045_BJ1260_DFS와BFS {

    static int N, M, V;
    static int[][] adjMat;
    static boolean[] visited;
    static StringBuilder sb;

    static void dfs(int cur) {
        visited[cur] = true;
        sb.append(cur).append(" ");

        // 갈수 있는 만큼 깊게
        for(int i=1; i<=N; i++) {
            if(!visited[i] && adjMat[cur][i] != 0) {    // 방문하지 않았으며 인접한 경우
                dfs(i);
            }
        }
    }

    static void bfs() {
        Queue<Integer> q = new ArrayDeque<>();

        visited[V] = true;
        q.offer(V);

        while(!q.isEmpty()) {
            int cur = q.poll();
            sb.append(cur).append(" ");

            // 현재 정점의 인접정점들을 큐에 넣어서 차후 탐색
            for(int i=1; i<=N; i++) {
                if(!visited[i] && adjMat[cur][i] != 0) {    // 방문하지 않았으며 인접한 경우
                    visited[i] = true;
                    q.offer(i);
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        String[] st = br.readLine().split(" ");
        N = Integer.parseInt(st[0]);    // 정점의 개수
        M = Integer.parseInt(st[1]);    // 간선의 개수
        V = Integer.parseInt(st[2]);    // 시작 정점

        adjMat = new int[N+1][N+1];     // 인접행렬
        for(int i=0; i<M; i++) {    // 간선 정보 입력
            st = br.readLine().split(" ");
            int from = Integer.parseInt(st[0]);
            int to = Integer.parseInt(st[1]);
            adjMat[from][to] = adjMat[to][from] = 1;    // 무향그래프
        }

        visited = new boolean[N+1]; // 방문기록 초기화
        dfs(V);
        sb.append("\n");
        visited = new boolean[N+1]; // 방문기록 초기화
        bfs();

        System.out.println(sb);
    }
}
