package 박윤환;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class P056_BJ7576_토마토 {

    // 좌표 클래스
    static class Point {
        int x, y, day;  // 행, 열, 날짜

        public Point(int x, int y, int day) {   // 생성자
            this.x = x;
            this.y = y;
            this.day = day;
        }
    }

    static final int[] dx = {1, 0, -1, 0};  // 하, 우, 상, 좌
    static final int[] dy = {0, 1, 0, -1};  // 하, 우, 상, 좌

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] st = br.readLine().split(" ");
        int M = Integer.parseInt(st[0]);    // 열
        int N = Integer.parseInt(st[1]);    // 행
        int[][] tomatoBox = new int[N][M];    // 토마토박스
        int remain = 0;   // 남은 안익은 토마토수를 저장
        int day = 0;    // 총 걸린 일수
        Queue<Point> tomato = new ArrayDeque<>();   // 다음 위치를 담는 큐
        boolean[][] visited = new boolean[N][M];    // 방문 기록

        for(int i=0; i<N; i++) {
            st = br.readLine().split(" ");
            for(int j=0; j<M; j++) {
                tomatoBox[i][j] = Integer.parseInt(st[j]);
                switch (tomatoBox[i][j]) {
                    case 0:     // 안익은거 개수 파악해서 다 없어지면 출력
                        remain++;
                        break;
                    case 1:     // 익은거 큐에 저장해서 bfs
                        tomato.offer(new Point(i, j, 0));
                        break;
                    case -1:    // 빈거 -> 방문필요 X -> visited인걸로 표시해버리기
                        visited[i][j] = true;
                        break;
                }
            }
        }

        if(remain == 0) {   // 이미 다 익어 있다면
            System.out.println(0);  // 0 출력하고
            System.exit(0); // 프로그램 종료
        }

        while(!tomato.isEmpty()) {  // 모든 토마토가 익을때까지 반복
            Point p = tomato.poll(); // 현재 위치 꺼냄

            if(p.x < 0 || p.x >= N || p.y < 0 || p.y >= M) {    // 범위 벗어나면
                continue;   // 다른 곳 탐색
            }

            if(!visited[p.x][p.y]) {    // 방문하지 않았다면
                visited[p.x][p.y] = true;   // 방문처리
                if(tomatoBox[p.x][p.y] == 0) remain--;  // 만약 안익은 토마토라면 남은 토마토 개수 감소
                day = Math.max(day, p.day); // 가장 오래걸린 날짜로 갱신
                for(int i=0; i<4; i++) {    // 하, 우, 상, 좌 순서로 다음 위치 선정
                    int nextX = p.x + dx[i];
                    int nextY = p.y + dy[i];
                    tomato.offer(new Point(nextX, nextY, p.day+1)); // 다음 위치 저장
                }
            }
        }

        if(remain == 0) {   // 남은 악익은 토마토가 없으면
            System.out.println(day);    // 걸린 날짜 출력
        } else {
            System.out.println(-1); // 다 익을 수 없으면 -1 출력
        }
    }
}

