package 박윤환;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class P047_BJ17135_캐슬디펜스 {
    static int N, M, D, max;
    static int[][] map;
    static boolean[] bowyer;

    // 적들의 배치를 한줄씩 아래로 움직이는 메소드
    static void moveEnemy(int[][] arr) {
        for(int i=N-1; i>0; i--) {  // 제일 아래 행부터 위쪽으로 반복
            arr[i] = Arrays.copyOf(arr[i-1], M);    // 바로 위의 줄을 복사
        }
        Arrays.fill(arr[0], 0); // 첫번째 줄은 0으로 채움
    }

    // 궁수와 적간의 맨하탄 거리를 반환하는 메소드
    static int distance(int i, int j, int x, int y) {
        return Math.abs(x-i) + Math.abs(y-j);
    }

    // 적들이 남아있는지 체크해주는 메소드
    static boolean isEmpty(int[][] arr) {
        int sum = 0;
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                sum += arr[i][j];   // 배열 내의 모든 원소의 합을 구한다
            }
        }
        return sum == 0;    // 원소합이 0이면 적이 없으므로 true 0이 아니면 적이 있으므로 false 반환
    }

    // 궁수의 위치를 선택하고 공격 횟수를 구하는 메소드
    static void comb(int index, int cnt) {
        if(index == M) {    // 모든 위치를 다 고려 했다면
            if(cnt != 3) return;    // 궁수를 배치한 위치가 3개가 아니라면 다시 선택ㅋ
            int[][] copy = new int[N][M];   // 다른 경우도 고려해야하므로 원본맵을 복사할 복사본배열
            Queue<Integer> q = new ArrayDeque<>();  // 궁수들이 공격한 위치를 담는 큐
            int count = 0;  // 공격횟수 카운트 변수

            for(int i=0; i<N; i++) {
                copy[i] = Arrays.copyOf(map[i], M); // 원본을 딥카피
            }

            while(!isEmpty(copy)) { // 지도에 적이 없어질때까지
                for(int k=0; k<M; k++) {    // 모든 궁수 위치 탐색
                    if(bowyer[k]) {     // 궁수가 있는 자리면
                        int min = 987654321;
                        int minR = -1;
                        int minC = -1;
                        for(int i=N-1; i>=0; i--) {
                            for(int j=0; j<M; j++) {    // 지도의 모든 칸 탐색
                                int d = distance(i, j, N, k);
                                if(d <= D && copy[i][j] == 1) { // 해당 위치의 거리가 D이하고 적이 있다면
                                    if(d < min) {   // 그 위치가 현재까지 공격거리 중 최소면
                                        min = d;    // 최소거리 갱신
                                        minR = i;   // 최소 위치 갱신
                                        minC = j;   // 최소 위치 갱신
                                    } else if(d == min) {   // 만약 같으면
                                        if(minC > j) {  // 기존 최소 위치보다 왼쪽이라면
                                            minR = i;   // 위치 갱신
                                            minC = j;   // 위치 갱신
                                        }
                                    }
                                }
                            }
                        }
                        if(minR != -1 && minC != -1) {  // 공격한 위치가 한번이라도 갱신됐다면
                            q.offer(minR);  // 큐에 해당 위치 삽입
                            q.offer(minC);  // 큐에 해당 위치 삽입
                        }
                    }
                }
                while(!q.isEmpty()) {   // 큐가 빌때까지 반복
                    int r = q.poll();
                    int c = q.poll();
                    if(copy[r][c] == 1) {   // 해당 위치에 적이 있다면
                        copy[r][c] = 0; // 적을 없애고
                        count++;    // 공격 카운트 증가
                    }
                }

                moveEnemy(copy);    // 적들 아래로 이동
            }

            max = Math.max(max, count); // 공격횟수 최대 비교
            return;
        }

        // 궁수 위치 선택
        bowyer[index] = true;
        comb(index+1, cnt+1);
        // 궁수 위치 미선택
        bowyer[index] = false;
        comb(index+1, cnt);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] st = br.readLine().split(" ");
        N = Integer.parseInt(st[0]);
        M = Integer.parseInt(st[1]);
        D = Integer.parseInt(st[2]);

        map = new int[N][M];

        for(int i=0; i<N; i++) {
            st = br.readLine().split(" ");
            for(int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(st[j]);
            }
        }
        bowyer = new boolean[M];
        comb(0, 0);

        System.out.println(max);

    }
}
