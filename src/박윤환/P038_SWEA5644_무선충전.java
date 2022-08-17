package 박윤환;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class P038_SWEA5644_무선충전 {

    static boolean contains(ArrayList<int[]> list, int[] array) {
        return list.stream()
                .anyMatch(x -> Arrays.equals(x, array));
    }

    public static void main(String[] args) throws Exception{
//        System.setIn(new FileInputStream("sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int tc=1; tc<=T; tc++) {
            String[] st = br.readLine().split(" ");
            int M = Integer.parseInt(st[0]);
            int A = Integer.parseInt(st[1]);
            int result = 0;
            int[][] info = new int[2][M];
            int[][] BC = new int[A][4];
            int[][] user = new int[2][2];
            ArrayList<ArrayList<int[]>> list = new ArrayList<>();
            for(int i=0; i<A; i++) {
                list.add(new ArrayList<>());
            }
            user[0][0] = 1;
            user[0][1] = 1;
            user[1][0] = 10;
            user[1][1] = 10;

            for(int i=0; i<2; i++) {
                st = br.readLine().split(" ");
                for(int j=0; j<M; j++) {
                    info[i][j] = Integer.parseInt(st[j]);
                }
            }

            for(int i=0; i<A; i++) {
                st = br.readLine().split(" ");
                for(int j=0; j<4; j++) {
                    BC[i][j] = Integer.parseInt(st[j]);
                }
            }

            for (int k=0; k<A; k++) {
                int x = BC[k][0];
                int y = BC[k][1];
                int c = BC[k][2];
                int P = BC[k][3];

                for(int i=0; i<=c; i++) {
                    for(int j=0; j<=c-i; j++) {
                        list.get(k).add(new int[] {x+i, y+j});
                        list.get(k).add(new int[] {x+i, y-j});
                        list.get(k).add(new int[] {x-i, y+j});
                        list.get(k).add(new int[] {x-i, y-j});
                    }
                }
            }

            for(int i=-1; i<M; i++) {
                int max = 0;
                if(i != -1) {
                    switch (info[0][i]) {
                        case 1:
                            user[0][1]--;
                            break;
                        case 2:
                            user[0][0]++;
                            break;
                        case 3:
                            user[0][1]++;
                            break;
                        case 4:
                            user[0][0]--;
                            break;
                    }
                    switch (info[1][i]) {
                        case 1:
                            user[1][1]--;
                            break;
                        case 2:
                            user[1][0]++;
                            break;
                        case 3:
                            user[1][1]++;
                            break;
                        case 4:
                            user[1][0]--;
                            break;
                    }
                }
                boolean[][] cnt = new boolean[2][A];
                int[] a = {user[0][0], user[0][1]};
                int[] b = {user[1][0], user[1][1]};
                for(int j=0; j<A; j++) {
                    cnt[0][j] = contains(list.get(j), a);
                    cnt[1][j] = contains(list.get(j), b);
                }

                for(int j=0; j<A; j++) {
                    for(int k=0; k<A; k++) {
                        if(cnt[0][j]) {
                            if(cnt[1][k]) {
                                if(j == k) {
                                    max = Math.max(max, BC[j][3]);
                                } else {
                                    max = Math.max(max, BC[j][3] + BC[k][3]);
                                }
                            } else {
                                max= Math.max(max, BC[j][3]);
                            }
                        } else {
                            if(cnt[1][k]) {
                                max = Math.max(max, BC[k][3]);
                            }
                        }
                    }
                }

                result += max;
            }


            sb.append("#").append(tc).append(" ").append(result).append("\n");
        }

        System.out.println(sb);
    }
}
