package 박윤환;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class P054_BJ13055_탈출 {

    // 좌표를 저장할 클래스
    static class Point {
        int x, y, depth;

        public Point(int x, int y, int depth) {
            this.x = x;
            this.y = y;
            this.depth = depth;
        }

    }

    static final int[] dx = {1, 0, -1, 0};  // 하, 우, 상, 좌
    static final int[] dy = {0, 1, 0, -1};  // 하, 우, 상, 좌

    static int R, C;
    static int[][] map;
    static Queue<Point> water;

    // 홍수가 진행되는 메소드
    static void deluge(int depth) { // 매개변수로 현재 bfs의 너비를 받아온다
        while(!water.isEmpty()) {   // 큐가 빌때까지 반복
            if(water.peek().depth == depth) return; // 만약 큐의 front의 높이가 bfs 너비와 같으면 종료
            Point p = water.poll(); // 큐에서 물의 좌표를 꺼냄

            for(int i=0; i<4; i++) {    // 하, 우, 상, 좌 반복
                int nextX = p.x + dx[i];    // 다음 행 위치
                int nextY = p.y + dy[i];    // 다음 열 위치
                if(nextX >= 0 && nextX < R && nextY >= 0 && nextY < C) {    // 범위 내이면서
                    if(map[nextX][nextY] == 0 || map[nextX][nextY] == -2 || map[nextX][nextY] == -1) continue; // 다음 위치가 이미 물이 차있거나 돌이나 비버 소굴이면 넘어감
                    map[nextX][nextY] = -1; // 물을 채움
                    water.offer(new Point(nextX, nextY, p.depth+1));    // 물이 채워진 위치를 큐에 넣고 너비 증가
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] st = br.readLine().split(" ");
        R = Integer.parseInt(st[0]);    // 행의 크기
        C = Integer.parseInt(st[1]);    // 열의 크기
        map = new int[R][C];    // 지도
        Queue<Point> hedgehog = new ArrayDeque<>(); // 고슴도치가 이동하는 좌표를 저장할 큐
        water = new ArrayDeque<>(); // 물이 이동하는 좌표를 저장할 큐

        for(int i=0; i<R; i++) {    // 지도 초기화
            String s = br.readLine();
            for(int j=0; j<C; j++) {
                switch (s.charAt(j)) {  // 문자가 뭐냐에 따라 다른 결과
                    case 'X':   // 돌이라면
                        map[i][j] = 0;  // 지도에 0으로 저장
                        break;
                    case '*':   // 물이라면
                        water.offer(new Point(i, j, 0));    // 물의 위치 좌표와 초기 너비 1을 큐에 저장
                        map[i][j] = -1; // 지도에 -1로 저장
                        break;
                    case 'S':   //  고슴도치라면
                        hedgehog.offer(new Point(i, j, 0));    // 큐에 고슴도치 위치 좌표 저장
                    case '.':   // 비어있는 곳이거나 고슴도치라면
                        map[i][j] = 1;  // 지도에 1로 저장
                        break;
                    case 'D':   // 비버 소굴이면
                        map[i][j] = -2; // 지도에 -2로 저장
                        break;
                }
            }
        }

        int t = 0;  // 이동 시간을 저장할 변수

        Loop:
        while(!hedgehog.isEmpty()) {    // 고슴도치 위치 큐가 빌때까지
            Point p = hedgehog.poll();  // 고슴도치 위치를 꺼냄

            deluge(p.depth);  // 현재 너비에서 홍수를 일으킴

            if(map[p.x][p.y] == -1) {
                continue;
            }

            for(int i=0; i<4; i++) {    // 하, 우, 상, 좌 반복
                int nextX = p.x + dx[i];    // 다음 행 위치
                int nextY = p.y + dy[i];    // 다음 열 위치
                if(nextX >= 0 && nextX < R && nextY >= 0 && nextY < C) {    // 다음 위치가 범위 내라면
                    if(map[nextX][nextY] == 1) {    // 빈곳이라면
                        map[nextX][nextY] = map[p.x][p.y] + 1;  // 현재 너비+1 값을 다음 위치에 저장
                        hedgehog.offer(new Point(nextX, nextY, p.depth+1));    // 다음 위치 좌표 큐에 저장
                    } else if(map[nextX][nextY] == -2) {    // 비버 소굴이라면
                        t = map[p.x][p.y];  // 현재의 너비가 이동시간
                        break Loop; // while문 종료
                    }
                }
            }
        }

        if(t == 0) {    // 비버 소굴까지 갈 수 없으면
            System.out.println("KAKTUS");   // KAKTUS 출력
        } else {    // 도달 했다면
            System.out.println(t);  // 이동시간 출력
        }
    }
}
