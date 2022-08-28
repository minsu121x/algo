package 박윤환;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P000_A형연습_낚시터자리잡기 {

    static int N, min;
    static int[][] enter, picked;

    static void perm(int cnt, int flag) {
        if(cnt == 3) {
            boolean[] spot = new boolean[N+1];
            int sum = 0;
            for(int i=0; i<3; i++) {
                int start = picked[i][0];
                int people = picked[i][1];
                int d = 0;
                while(people > 0) {
                    if(start + d <= N && !spot[start + d] && people > 0) {
                        spot[start + d] = true;
                        sum += 1 + d;
                        people--;
                    }
                    if(start - d >= 1 && !spot[start - d] && people > 0) {
                        spot[start - d] = true;
                        sum += 1 + d;
                        people--;
                    }
                    d++;
                }
            }
            min = Math.min(min, sum);
            Arrays.fill(spot, false);
            sum = 0;
            for(int i=0; i<3; i++) {
                int start = picked[i][0];
                int people = picked[i][1];
                int d = 0;
                while(people > 0) {
                    if(start - d >= 1 && !spot[start - d] && people > 0) {
                        spot[start - d] = true;
                        sum += 1 + d;
                        people--;
                    }
                    if(start + d <= N && !spot[start + d] && people > 0) {
                        spot[start + d] = true;
                        sum += 1 + d;
                        people--;
                    }
                    d++;
                }
            }
            min = Math.min(min, sum);
            return;
        }
        for(int i=0; i<3; i++) {
            if((flag & 1<<i) == 0) {
                picked[cnt] = enter[i];
                perm(cnt+1, flag | 1<<i);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("sample_input1.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int tc=1; tc<=T; tc++) {
            N = Integer.parseInt(br.readLine());
            enter = new int[3][2];
            picked = new int[3][2];
            for (int i = 0; i < 3; i++) {
                String[] st = br.readLine().split(" ");
                enter[i][0] = Integer.parseInt(st[0]);
                enter[i][1] = Integer.parseInt(st[1]);
            }

            min = Integer.MAX_VALUE;
            perm(0, 0);

            sb.append("#").append(tc).append(" ").append(min).append("\n");
        }

        System.out.println(sb);
    }
}
