package 박윤환;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P042_BJ3109_빵집 {
    static final int[] dr = {-1, 0, 1}; // 오른쪽, 오른쪽위 대각선, 오른쪽 아래 대각선
    static final int[] dc = {1, 1, 1}; // 오른쪽, 오른쪽위 대각선, 오른쪽 아래 대각선

    static int R, C, cnt;
    static boolean[][] map;

    static boolean dfs(int r, int c) {
        // 최대한 위쪽으로 연결하기 위해 우상, 우, 우하 순서로 이동 방향 3개 반복
        for(int i=0; i<3; i++) {
            int nextR = r + dr[i];
            int nextC = c + dc[i];
            if(nextR>=0 && nextR<R && !map[nextR][nextC]) { // 다음 위치가 범위 내이면서 연결 가능하면
                map[nextR][nextC] = true;   // 연결할 위치를 true로 바꿈
                if(nextC == C-1) {  // 마지막 위치라면
                    return true;    // 연결을 성공했으므로 true 반환
                }
                if(dfs(nextR, nextC)) { // 다음 위치에서 또 연결을 성공했으면
                    return true;    // true 반환
                }
            }
        }
        return false;   // 연결을 실패했으면 false 반환
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] st = br.readLine().split(" ");
        R = Integer.parseInt(st[0]);
        C = Integer.parseInt(st[1]);
        map = new boolean[R][C];    // 지도를 boolean 2차원 배열로 표현

        for(int i=0; i<R; i++) {
            String s = br.readLine();
            for(int j=0; j<C; j++) {
                if(s.charAt(j) == 'x') {    // 건물이 있는 위치는 true
                    map[i][j] = true;
                }
            }
        }
        // 원웅이 빵집의 위쪽에서부터 최대한 근처 빵집의 위쪽으로 연결해야 최대로 연결 가능
        for(int i=0; i<R; i++) {
            if(dfs(i, 0)) { // 연결이 성공할때마다 카운트 증가
                cnt++;
            }
        }

        System.out.println(cnt);

    }
}
