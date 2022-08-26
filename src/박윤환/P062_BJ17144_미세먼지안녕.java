package 박윤환;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class P062_BJ17144_미세먼지안녕 {

    static final int[] dr = {0, 1, 0, -1};  // 우, 하, 좌, 상
    static final int[] dc = {1, 0, -1, 0};  // 우, 하, 좌, 상
    static int R, C, T;
    static int[] airPrf;
    static int[][] map;
    static Queue<int[]> queue;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] st = br.readLine().split(" ");
        R = Integer.parseInt(st[0]);    // 행 크기
        C = Integer.parseInt(st[1]);    // 열 크기
        T = Integer.parseInt(st[2]);    // 시간

        map = new int[R][C];    // 방 정보를 담는 배열
        queue = new ArrayDeque<>();     // 먼지의 위치와 양을 담을 큐
        airPrf = new int[2];    // 공기 청정기 행 위치 기록
        int ap = 0; // 공기청정기 위치 배열 인덱스
        for(int i=0; i<R; i++) {
            st = br.readLine().split(" ");
            for(int j=0; j<C; j++) {
                map[i][j] = Integer.parseInt(st[j]);    // 방 정보 기록
                if(map[i][j] == -1) {   // 공기 청정기
                    airPrf[ap++] = i;   // 공기청정기 행 위치 기록
                }
            }
        }

        for(int t=0; t<T; t++) {    // 주어진 시간만큼 반복

            // 방 안에 먼지 위치 파악
            for(int i=0; i<R; i++) {
                for(int j=0; j<C; j++) {    // 방 탐색
                    if(map[i][j] > 0) { // 먼지가 있다면
                        queue.offer(new int[] {i, j, map[i][j]});   // 해당 위치와 먼지 양을 큐에 기록
                    }
                }
            }

            // 먼지 확산
            while(!queue.isEmpty()) {   // 큐가 빌때까지 반복
                int[] cur = queue.poll();   // 현재 먼지를 꺼냄

                for(int i=0; i<4; i++) {    // 우, 하, 좌, 상 반복
                    int nextR = cur[0] + dr[i];     // 다음 행 위치
                    int nextC = cur[1] + dc[i];     // 다음 열 위치
                    if(nextR >= 0 & nextR < R && nextC >= 0 && nextC < C    // 다음 위치가 방 범위를 벗어나지 않고
                            && map[nextR][nextC] != -1) {   // 공기청정기가 아니라면
                        map[nextR][nextC] += cur[2]/5;  // 다음 위치에 현재 먼지의 일부가 확산
                        map[cur[0]][cur[1]] -= cur[2]/5;    // 현재 위치의 먼지 양 감소
                    }
                }
            }

            // 공기청정기 윗부분 순환
            int r = 0;  // 왼쪽 위 순환 시작 행
            int c = 0;  // 왼쪽 위 순환 시작 열
            int tmp = map[r][c];    // 시작 지점의 먼지 양을 임시 저장
            int dir = 0;    // 방향을 나타낼 변수
            while(dir < 4) {    // 우, 하, 좌, 상 반복
                int nextR = r + dr[dir];    // 다음 행 위치
                int nextC = c + dc[dir];    // 다음 행 위치

                if(nextR < 0 || nextR > airPrf[0] || nextC < 0 || nextC >= C) { // 범위를 벗어나면
                    dir++;  // 방향 전환
                } else if(map[nextR][nextC] == -1) {    // 다음 위치가 공기청정기라면
                    map[r][c] = 0;  // 현재 위치는 공기청정기의 깨끗한 공기가 채워지고 먼지가 없어짐
                    r = nextR;  // 다음 위치로 이동
                    c = nextC;
                } else if(map[r][c] == -1) {    // 현재위치가 공기청정기라면
                    r = nextR;  // 그냥 다음 위치로 이동
                    c = nextC;
                }else { // 그 외에는
                    map[r][c] = map[nextR][nextC];  // 다음 위치의 먼지를 현재 위치로
                    r = nextR;  // 위치 이동
                    c = nextC;
                }
            }
            map[1][0] = tmp;    // 마지막 부분을 임시 저장한 먼지로 채움

            // 공기청정기 아래부분 순환
            r = R-1;  // 오른쪽 아래 순환 시작 행
            c = C-1;  // 오른쪽 아래 순환 시작 열
            tmp = map[r][c];    // 시작 지점의 먼지 양을 임시 저장
            dir = 3;    // 방향을 나타낼 변수
            while(dir >= 0) {    // 상, 좌, 하, 우 반복
                int nextR = r + dr[dir];    // 다음 행 위치
                int nextC = c + dc[dir];    // 다음 행 위치

                if(nextR < airPrf[1] || nextR >=R || nextC < 0 || nextC >= C) { // 범위를 벗어나면
                    dir--;  // 방향 전환
                } else if(map[nextR][nextC] == -1) {    // 다음 위치가 공기청정기라면
                    map[r][c] = 0;  // 현재 위치는 공기청정기의 깨끗한 공기가 채워지고 먼지가 없어짐
                    r = nextR;  // 다음 위치로 이동
                    c = nextC;
                } else if(map[r][c] == -1) {    // 현재위치가 공기청정기라면
                    r = nextR;  // 그냥 다음 위치로 이동
                    c = nextC;
                }else { // 그 외에는
                    map[r][c] = map[nextR][nextC];  // 다음 위치의 먼지를 현재 위치로
                    r = nextR;  // 위치 이동
                    c = nextC;
                }
            }
            map[R-1][C-2] = tmp;    // 마지막 부분을 임시 저장한 먼지로 채움

        }

        int result = 0;
        for(int i=0; i<R; i++) {
            for(int j=0; j<C; j++) {    // 모든 상황이 끝난 뒤 방 탐색
                if(map[i][j] > 0) {  // 먼지가 있다면
                    result += map[i][j];   // 결과에 더해줌
                }
            }
        }

        System.out.println(result);
    }
}
