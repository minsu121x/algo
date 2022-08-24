package 박윤환;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class P055_BJ16236_아기상어 {

    // 위치와 이동시간을 나타낼 클래스
    static class Point implements Comparable<Point> {   // Comparable을 implements
        int x, y, depth;    // 행위치, 열위치, 이동시간(너비)

        public Point(int x, int y, int depth) { // 생성자
            this.x = x;
            this.y = y;
            this.depth = depth;
        }

        @Override
        public int compareTo(Point o) { // Comparable의 추상 메소드 오버라이드
            if(this.depth == o.depth) { // 이동시간이 같은 곳이라면
                if(this.x == o.x) { // 행 위치가 같은 곳이라면
                    return this.y - o.y;    // 왼쪽에 있는 것부터
                }
                return this.x - o.x;    // 위쪽에 있는 것부터
            }
            return this.depth - o.depth;    // 이동시간이 짧은거부터
        }
    }

    static final int[] dx = {-1, 0, 0, 1};  // 상, 좌, 우, 하
    static final int[] dy = {0, -1, 1, 0};  // 상, 좌, 우, 하
    static int N, size, eat, fish, d;
    static int[][] map;
    static boolean[][] visited;
    static Queue<Point> queue;
    static PriorityQueue<Point> fishQ;

    // 너비우선탐색을 수행하는 메소드
    static void bfs() {
        while(!queue.isEmpty()) {   // 상어 위치를 담은 큐가 빌때까지
            Point p = queue.poll(); // 현재 위치를 꺼냄
            if (map[p.x][p.y] != 0 && map[p.x][p.y] < size) {   // 비어있지 않으면서 상어보다 작은 물고기라면
                fishQ.offer(new Point(p.x, p.y, p.depth));  // 우선순위큐에 물고기 위치와 현재까지 이동시간 저장
            }

            for (int i = 0; i < 4; i++) {   // 상, 좌, 우, 하 탐색
                int nextX = p.x + dx[i];    // 다음 행 위치
                int nextY = p.y + dy[i];    // 다음 열 위치
                if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < N  // 범위 내이면서
                        && !visited[nextX][nextY] && map[nextX][nextY] <= size) {   // 방문하지 않았고 이동가능한 위치라면
                    visited[nextX][nextY] = true;   // 방문처리
                    queue.offer(new Point(nextX, nextY, p.depth + 1));  // 큐에 다음 위치 저장
                }
            }
        }
    }

    // 초기 세팅을 하는 메소드
    static void init() {
        for (boolean[] v :
                visited) {
            Arrays.fill(v, false);  // 방문 기록을 false로 초기화
        }
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {    // 지형 탐색
                if(map[i][j] == 9) {    // 상어가 있는 위치라면
                    map[i][j] = 0;  // 빈칸으로 변경
                    visited[i][j] = true;
                    queue.offer(new Point(i, j, d));    // 상어 위치와 여태까지 이동한 시간을 큐에 저장
                } else if(map[i][j] > size) {   // 상어보다 큰 물고기 위치는
                    visited[i][j] = true;   // 갈수 없으니 방문처리
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());    // 공간의 크기
        map = new int[N][N];    // 지형 배열
        visited = new boolean[N][N];    // 방문기록 배열
        size = 2;   // 상어 크기
        fish = 0;   // 물고기 수
        queue = new ArrayDeque<>(); // 상어의 위치를 담는 큐
        fishQ = new PriorityQueue<>();  // 물고기들의 위치를 담는 우선순위큐

        for(int i=0; i<N; i++) {
            String[] st = br.readLine().split(" ");
            for(int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(st[j]);    // 지형 초기화
                if(map[i][j] != 0 && map[i][j] != 9) {  // 비어있거나 상어가 있는 경우가 아니라면
                    fish++; // 물고기 수 증가
                }
            }
        }

        init(); // 초기 세팅
        while(true) {   // 무한루프
            bfs();  // bfs 수행
            if(fishQ.isEmpty()) {   // 찾아갈 물고기가 없으면
                break;  // 무한루프 종료
            }
            Point f = fishQ.poll();     // 우선선위 큐의 front가 다음에 찾아갈 물고기 위치
            fishQ.clear();  // 우선순위 큐 초기화
            map[f.x][f.y] = 9;  // 상어 위치 이동
            eat++;  // 먹은 수 증가
            fish--; // 물고기 수 감소
            if (eat == size) {  // 먹은 수가 상어 크기와 같으면
                eat = 0;    // 먹은 수 초기화
                size++; // 상어 크기 증가
            }
            d = f.depth;    // 물고기 위치까지 움직인 시간
            if(fish == 0) { // 물고기 수가 다 없어지면
                break;  // 무한루프 종료
            } else {    // 물고기가 남아 있다면
                init(); // 다시 초기 세팅
            }
        }

        System.out.println(d);  // 이동시간 출력

    }
}
