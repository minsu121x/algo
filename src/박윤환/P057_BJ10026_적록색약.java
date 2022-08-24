package 박윤환;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P057_BJ10026_적록색약 {

    static final int[] dr = {1, 0, -1, 0};  // 하, 우 , 상, 좌
    static final int[] dc = {0, 1, 0, -1};  // 하, 우, 상, 좌
    static int N;
    static char[][] paint;
    static boolean[][] visited;

    static boolean dfs(int r, int c, char color, boolean pcb) {
        if(r < 0 || r >= N || c < 0 || c >= N) {  // 범위를 벗어나면 false
            return false;
        }
        if(pcb) {
            if(paint[r][c] == 'R' && color == 'G') {   // 색약이면서 탐색할 색이 R이고 현재 색이 G라면
                color = 'R';    // R로 인식
            } else if(paint[r][c] == 'G' && color == 'R') { // 색약이면서 탐색할 색이 G고 현재 색이 R이라면
                color = 'G';    // G로 인식
            }
        }
        if(!visited[r][c] && paint[r][c] == color) {    // 방문하지 않았으면서 색이 같으면
            visited[r][c] = true;   // 방문 처리
            for(int i=0; i<4; i++) {    // 하, 우, 상, 좌 반복
                int nextR = r + dr[i];  // 다음 위치
                int nextC = c + dc[i];  // 다음 위치
                dfs(nextR, nextC, color, pcb);  // 다음 위치 탐색
            }
            return true;    // 정상적으로 탐색됐으면 true 반환
        }
        return false;   // 그 외에는 false 반환
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());    // 그림 크기
        paint = new char[N][];  // 그림 배열
        for(int i=0; i<N; i++) {
            paint[i] = br.readLine().toCharArray();
        }
        visited = new boolean[N][N];    // 방문 기록
        int cnt = 0;    // 구역 개수 카운트
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(dfs(i, j, paint[i][j], false)) { // i, j 시작점으로부터 주변에 같은 색까지 탐색, 이미 탐색했으면 false 반환
                    cnt++;  // 탐색 안한 구역이면 카운트 증가
                }
            }
        }
        sb.append(cnt).append(" "); // 일반인이 봤을떄의 색 구역 개수

        visited = new boolean[N][N];    // 방문기록 초기화
        cnt = 0;    // 구역 개수 초기화
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(dfs(i, j, paint[i][j], true)) {  // i, j 시작점으로부터 주변에 같은 색까지 탐색, 이미 탐색했으면 false 반환
                    cnt++;  // 탐색 안한 구역이면 카운트 증가
                }
            }
        }
        sb.append(cnt); // 색약인 사람이 봤을때의 색 구역 개수

        System.out.println(sb); // 최종 출력
    }
}
