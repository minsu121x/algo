package 박윤환;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class P061_BJ4485_녹색옷입은애가젤다지_다익스트라 {

    // 정점의 정보를 포함한 클래스
    static class Vertex {
        int r, c, w;    // 행 위치, 열 위치, 가중치

        public Vertex(int r, int c, int w) {
            this.r = r;
            this.c = c;
            this.w = w;
        }
    }

    static final int[] dr = {1, 0, -1, 0};  // 하, 우, 상, 좌
    static final int[] dc = {0, 1, 0, -1};  // 하, 우, 상, 좌

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = 1; // 테스트케이스 마다 하나씩 증가

        while(true) {   // 입력을 중단할때까지 무한루프
            int N = Integer.parseInt(br.readLine());    // 지도의 크기
            if(N == 0) break;   // 0을 입력 받았으면 무한루프 종료
            int[][] map = new int[N][N];

            for(int i=0; i<N; i++) {
                String[] st = br.readLine().split(" ");
                for(int j=0; j<N; j++) {
                    map[i][j] = Integer.parseInt(st[j]);
                }
            }

            int[][] D = new int[N][N];  // 최단거리 테이블
            for(int i=0; i<N; i++) {
                Arrays.fill(D[i], Integer.MAX_VALUE);   // 최소값을 구하기 위해 큰 값 저장
            }

            boolean[][] visited = new boolean[N][N];    // 방문기록 테이블
            D[0][0] = map[0][0];    // 초기 위치의 가중치를 최단거리 테이블에 세팅

            PriorityQueue<Vertex> pQueue = new PriorityQueue<>(Comparator.comparingInt(v -> v.w));  // 가중치 기준 오름차순 우선순위 큐
            pQueue.offer(new Vertex(0, 0, D[0][0]));

            while(!pQueue.isEmpty()) {
                Vertex cur = pQueue.poll(); // 현재 위치 꺼냄

                if(visited[cur.r][cur.c]) continue; // 방문했다면 버림
                visited[cur.r][cur.c] = true;   // 방문 처리

                for(int i=0; i<4; i++) {    // 하, 우, 상, 좌 반복
                    int nextR = cur.r + dr[i];  // 인접 행 위치
                    int nextC = cur.c + dc[i];  // 인접 열 위치
                    if(nextR >= 0 && nextR < N && nextC >= 0 && nextC < N   // 지도 범위 내이면서
                            && !visited[nextR][nextC]   // 방문한적 없고
                            && D[nextR][nextC] > D[cur.r][cur.c] + map[nextR][nextC]) { // 현재까지의 최단거리합이 더 적다면
                        D[nextR][nextC] = D[cur.r][cur.c] + map[nextR][nextC];  // 최단거리테이블 갱신
                        pQueue.offer(new Vertex(nextR, nextC, D[nextR][nextC]));    // 다음 위치 큐에 삽입
                    }
                }
            }

            sb.append("Problem ").append(tc++).append(": ").append(D[N-1][N-1]).append("\n");   // 출력결과 저장
        }
        System.out.println(sb); // 최종 출력
    }
}
