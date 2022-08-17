package 박윤환;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

class CCTV {    // cctv 정보를 담을 객체
    int n, i, j;
    public CCTV(int n, int i, int j) {
        this.n = n;     // cctv 종류
        this.i = i;     // cctv의 행 위치
        this.j = j;     // cctv의 열 위치
    }
}

public class P040_BJ15683_감시 {
    static final int[] dx = {0, 1, 0, -1};  // 상, 우, 하, 좌
    static final int[] dy = {-1, 0, 1, 0};  // 상, 우, 하, 좌

    static int N, M, size, min;
    static int[] dir;
    static int[][] office;
    static ArrayList<CCTV> list;

    // cctv 개수에 맞게 돌릴 방향을 정할 중복순열
    static void perm(int cnt) {
        // 방향이 정해지면
        if(cnt == size) {
            int[][] copy = new int[N][M];   // 원본 사무실배치를 저장할 복사본 배열
            int count = 0;  // 사각지대를 카운트할 변수
            for(int i=0; i<N; i++) {
                copy[i] = Arrays.copyOf(office[i], M);  // 원본 복사
            }
            for(int i=0; i<size; i++) {     // list에 있는 cctv만큼 반복
                int r = list.get(i).i;  // 현재 cctv의 행 위치
                int c = list.get(i).j;  // 현재 cctv의 열 위치
                switch(list.get(i).n) { // cctv 종류에 따라
                    // 1번 종류일 경우
                    case 1:
                        // 해당 방향을 계속 감지
                        while(true) {
                            r = r + dx[dir[i]];
                            c = c + dy[dir[i]];
                            if(r<0 || r>=N || c<0 || c>=M) break;   // 끝에 도달하거나
                            if(copy[r][c] == 6) break;  // 벽을 만나면 종료
                            copy[r][c] = -1;    // cctv 감지 범위는 -1로 저장
                        }
                        break;
                    // 2번 종류일 경우
                    case 2:
                        // 해당 방향을 감지
                        while(true) {
                            r = r + dx[dir[i]];
                            c = c + dy[dir[i]];
                            if(r<0 || r>=N || c<0 || c>=M) break;
                            if(copy[r][c] == 6) break;
                            copy[r][c] = -1;
                        }
                        r = list.get(i).i;
                        c = list.get(i).j;
                        // 반대방향을 감지
                        while(true) {
                            r = r - dx[dir[i]];
                            c = c - dy[dir[i]];
                            if(r<0 || r>=N || c<0 || c>=M) break;
                            if(copy[r][c] == 6) break;
                            copy[r][c] = -1;
                        }
                        break;
                    // 3번 종류일 경우
                    case 3:
                        // 해당 방향을 감지
                        while(true) {
                            r = r + dx[dir[i]];
                            c = c + dy[dir[i]];
                            if(r<0 || r>=N || c<0 || c>=M) break;
                            if(copy[r][c] == 6) break;
                            copy[r][c] = -1;
                        }
                        r = list.get(i).i;
                        c = list.get(i).j;
                        // 오른쪽으로 90도 꺾어서 감지
                        while(true) {
                            r = r + dx[(dir[i]+1)%4];
                            c = c + dy[(dir[i]+1)%4];
                            if(r<0 || r>=N || c<0 || c>=M) break;
                            if(copy[r][c] == 6) break;
                            copy[r][c] = -1;
                        }
                        break;
                    // 4번 종류일 경우
                    case 4:
                        // 해당 방향으로 감지
                        while(true) {
                            r = r + dx[dir[i]];
                            c = c + dy[dir[i]];
                            if(r<0 || r>=N || c<0 || c>=M) break;
                            if(copy[r][c] == 6) break;
                            copy[r][c] = -1;
                        }
                        r = list.get(i).i;
                        c = list.get(i).j;
                        // 오른쪽으로 90도 꺾어서 감지
                        while(true) {
                            r = r + dx[(dir[i]+1)%4];
                            c = c + dy[(dir[i]+1)%4];
                            if(r<0 || r>=N || c<0 || c>=M) break;
                            if(copy[r][c] == 6) break;
                            copy[r][c] = -1;
                        }
                        r = list.get(i).i;
                        c = list.get(i).j;
                        // 왼쪽으로 90도 꺾어서 감지
                        while(true) {
                            r = r - dx[(dir[i]+1)%4];
                            c = c - dy[(dir[i]+1)%4];
                            if(r<0 || r>=N || c<0 || c>=M) break;
                            if(copy[r][c] == 6) break;
                            copy[r][c] = -1;
                        }
                        break;
                    case 5:
                        // 해당 방향으로 감지
                        while(true) {
                            r = r + dx[dir[i]];
                            c = c + dy[dir[i]];
                            if(r<0 || r>=N || c<0 || c>=M) break;
                            if(copy[r][c] == 6) break;
                            copy[r][c] = -1;
                        }
                        r = list.get(i).i;
                        c = list.get(i).j;
                        // 반대 방향으로 감지
                        while(true) {
                            r = r - dx[dir[i]];
                            c = c - dy[dir[i]];
                            if(r<0 || r>=N || c<0 || c>=M) break;
                            if(copy[r][c] == 6) break;
                            copy[r][c] = -1;
                        }
                        r = list.get(i).i;
                        c = list.get(i).j;
                        // 오른쪽으로 90도 꺾어서 감지
                        while(true) {
                            r = r + dx[(dir[i]+1)%4];
                            c = c + dy[(dir[i]+1)%4];
                            if(r<0 || r>=N || c<0 || c>=M) break;
                            if(copy[r][c] == 6) break;
                            copy[r][c] = -1;
                        }
                        r = list.get(i).i;
                        c = list.get(i).j;
                        // 왼쪽으로 90도 꺾어서 감지
                        while(true) {
                            r = r - dx[(dir[i]+1)%4];
                            c = c - dy[(dir[i]+1)%4];
                            if(r<0 || r>=N || c<0 || c>=M) break;
                            if(copy[r][c] == 6) break;
                            copy[r][c] = -1;
                        }
                        break;
                }
            }
            // 감지가 끝난 배열 탐색
            for(int i=0; i<N; i++) {
                for(int j=0; j<M; j++) {
                    if(copy[i][j] == 0) {   // 사각지대일 경우
                        count++;    // 카운트 올림
                    }
                }
            }
            min = Math.min(min, count); // 최소값일 경우 갱신

            return;
        }

        for(int i=0; i<4; i++) {
            dir[cnt] = i;
            perm(cnt+1);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] st = br.readLine().split(" ");
        N = Integer.parseInt(st[0]);
        M = Integer.parseInt(st[1]);
        office = new int[N][M];     // 사무실 배치 배열
        list = new ArrayList<>();   // cctv 정보를 저장할 리스트

        for(int i=0; i<N; i++) {
            st = br.readLine().split(" ");
            for(int j=0; j<M; j++) {
                office[i][j] = Integer.parseInt(st[j]);
            }
        }

        // 사무실 탐색
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                // 빈칸이거나 벽이 아닐 경우 해당 CCTV를 리스트에 추가
                if(office[i][j] != 0 && office[i][j] != 6) {
                    list.add(new CCTV(office[i][j], i, j));
                }
            }
        }
        size = list.size();
        dir = new int[size];
        min = (int)1e9;

        perm(0);

        System.out.println(min);


    }
}
