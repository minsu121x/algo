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
            int[][] magnet = new int[4][8];
            String[] st;
            for(int i=0; i<4; i++) {
                st = br.readLine().split(" ");
                for(int j=0; j<8; j++) {
                    magnet[i][j] = Integer.parseInt(st[j]);
                }
            }
            int[] rotation = new int[4];

            for(int k=0; k<K; k++) {
                Arrays.fill(rotation, 0);
                st = br.readLine().split(" ");
                int num = Integer.parseInt(st[0]);
                int dir = Integer.parseInt(st[1]);

                rotation[num-1] = dir;

                for(int i=num; i<4; i++) {
                    if(magnet[i-1][2] != magnet[i][6]) {
                        rotation[i] = rotation[i-1] * -1;
                    }
                }

                for(int i=num-1; i>0; i--) {
                    if(magnet[i][6] != magnet[i-1][2]) {
                        rotation[i-1] = rotation[i] * -1;
                    }
                }

                for(int i=0; i<4; i++) {
                    if(rotation[i] == 1) {
                        int tmp = magnet[i][7];
                        for(int j=7; j>0; j--) {
                            magnet[i][j] = magnet[i][j-1];
                        }
                        magnet[i][0] = tmp;
                    } else if(rotation[i] == -1) {
                        int tmp = magnet[i][0];
                        for(int j=0; j<7; j++) {
                            magnet[i][j] = magnet[i][j+1];
                        }
                        magnet[i][7] = tmp;
                    }
                }
            }

            int sum = 0;
            for(int i=0; i<4; i++) {
                sum += magnet[i][0] * (1<<i);
            }

            sb.append("#").append(tc).append(" ").append(sum).append("\n");
        }
        System.out.println(sb);
    }
}