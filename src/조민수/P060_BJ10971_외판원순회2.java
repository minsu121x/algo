package 조민수;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P060_BJ10971_외판원순회2 {
	static int N;
	static int[][] map;
	static boolean[] visited;
	static int min = Integer.MAX_VALUE;
	static int start;
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


		N = Integer.parseInt(br.readLine());

		map = new int[N][N];
		visited = new boolean[N];

		for (int i = 0; i < N; i++) {
			String[] st = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st[j]);//경로 비용값 저장
				
			}
		}

		visited[0] = true;//시작점 방문 체크
		start=0;//0부터 시작
		dfs(0, 1, 0);

		System.out.println(min);

	}

	public static void dfs( int now, int cnt, int cost) {

		if (now == start && cost > 0&&min>cost) {//시작점으로 돌아왔다.+현재 비용이 최소값보다 적다
			min=cost;//최소값 갱신
			return;
		}

		for (int n = 0; n < N; n++) {

			if (map[now][n] > 0) {// 다음의 갈곳이 길이 있다

				if (n == start && cnt == N) {//다돌고 시작점으로 돌아가야할때
					cost += map[now][n];
					dfs( n, cnt + 1, cost);//시작점으로 이동
				}

				else if (!visited[n]) {//방문 안했으면
					visited[n] = true;//방문체크
					cost += map[now][n];//값추가

					dfs( n, cnt + 1, cost);//이동

					cost -= map[now][n];//이동끝나면 값 복구
					visited[n] = false;//방문도 복구
				}
			}
		}
	}

}