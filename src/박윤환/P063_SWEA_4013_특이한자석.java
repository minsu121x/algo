package 박윤환;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P063_SWEA_4013_특이한자석 {
    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int tc=1; tc<=T; tc++) {
            int K = Integer.parseInt(br.readLine());
            int[][] magnet = new int[4][8]; // 자석을 나타내는 배열, 행 : 자석번호, 열 : 톱니 상태
            String[] st;
            for(int i=0; i<4; i++) {
                st = br.readLine().split(" ");
                for(int j=0; j<8; j++) {
                    magnet[i][j] = Integer.parseInt(st[j]);
                }
            }
            int[] rotation = new int[4];    // 자석 4개의 회전 방향을 나타낼 배열

            for(int k=0; k<K; k++) {
                Arrays.fill(rotation, 0);   // 회전방향 초기화
                st = br.readLine().split(" ");
                int num = Integer.parseInt(st[0]);
                int dir = Integer.parseInt(st[1]);

                rotation[num-1] = dir;  // 현재 번호의 자석 회전방향 기록

                for(int i=num; i<4; i++) {  // 현재 자석의 오른쪽 자석들의 회전방향 기록
                    if(magnet[i-1][2] != magnet[i][6]) {
                        rotation[i] = rotation[i-1] * -1;
                    }
                }

                for(int i=num-1; i>0; i--) {    // 현재 자석의 왼쪽 자석들의 회전방향 기록
                    if(magnet[i][6] != magnet[i-1][2]) {
                        rotation[i-1] = rotation[i] * -1;
                    }
                }

                for(int i=0; i<4; i++) {
                    if(rotation[i] == 1) {  // 1일 경우 시계 방향 회전
                        int tmp = magnet[i][7];
                        for(int j=7; j>0; j--) {
                            magnet[i][j] = magnet[i][j-1];  // 톱니상태 배열을 오른쪽으로 한칸씩 움직임
                        }
                        magnet[i][0] = tmp;
                    } else if(rotation[i] == -1) {  // -1일 경우 반시계 회전
                        int tmp = magnet[i][0];
                        for(int j=0; j<7; j++) {
                            magnet[i][j] = magnet[i][j+1];  // 톱니상태 배열을 왼쪽으로 한칸씩 움직임
                        }
                        magnet[i][7] = tmp;
                    }
                }
            }

            int sum = 0;
            for(int i=0; i<4; i++) {
                sum += magnet[i][0] * (1<<i);   // 제일 앞의 톱니가 S극 이면 2^(자석번호-1) 만큼 점수 획득
            }

            sb.append("#").append(tc).append(" ").append(sum).append("\n");
        }
        System.out.println(sb);
    }
}