package 박윤환;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P044_BJ1987_알파벳 {

    static final int[] dx = {0, 1, 0, -1};  // 우, 하, 좌, 상
    static final int[] dy = {1, 0, -1, 0};  // 우, 하, 좌, 상

    static char[][] board;
    static boolean[] visited;
    static int R, C, max;

    static void dfs(int cnt, int r, int c) {
        if(cnt == R*C) {  // 모든 칸을 다 탐색했을 경우
            max = cnt;    // 이동 횟수가 알파벳 수 최대
            return;
        }
        for(int i=0; i<4; i++) {    // 4방향 탐색
            if(r+dx[i]>=0 && r+dx[i]<R && c+dy[i]>=0 && c+dy[i]<C &&
                    !visited[board[r+dx[i]][c+dy[i]] - 'A']) {  // 범위 내이면서 방문한적 없는 알파벳이면
                visited[board[r+dx[i]][c+dy[i]] - 'A'] = true;  // 방문 처리
                dfs(cnt+1, r+dx[i], c+dy[i]); // 이동한 위치에서 새로 dfs실행
                visited[board[r+dx[i]][c+dy[i]] - 'A'] = false; // 방문 처리 취소
            }
        }
        max = Math.max(max, cnt);   // 이동할 곳이 없으면 현재 이동 횟수와 최대값 비교
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] st = br.readLine().split(" ");
        R = Integer.parseInt(st[0]);
        C = Integer.parseInt(st[1]);

        board = new char[R][C];     // 알파벳 보드
        for(int i=0; i<R; i++) {
            String s = br.readLine();
            for(int j=0; j<C; j++) {
                board[i][j] = s.charAt(j);
            }
        }

        visited = new boolean[26];  // 모든 알파벳에 대한 방문 기록
        visited[board[0][0] - 'A'] = true;  // 초기 위치 방문처리
        dfs(1, 0, 0);

        System.out.println(max);

    }
}
