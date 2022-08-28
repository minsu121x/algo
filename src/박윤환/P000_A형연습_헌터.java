package 박윤환;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class P000_A형연습_헌터 {

    static class Dest {
        int x, y, w;

        public Dest(int x, int y, int w) {
            this.x = x;
            this.y = y;
            this.w = w;
        }
    }

    static int N, M, min;
    static int[][] map;
    static Dest[] picked;
    static ArrayList<Dest> dests;

    static int distance(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }

    static void perm(int cnt, int flag) {
        if(cnt == M) {
            int sum = 0;
            int x = 0;
            int y = 0;
            for (Dest d :
                    picked) {
                sum += distance(x, y, d.x, d.y);
                x = d.x;
                y = d.y;
            }
            min = Math.min(min, sum);
            return;
        }

        for(int i=0; i<M; i++) {
            if((flag & 1<<i) == 0) {
                Dest now = dests.get(i);
                if(now.w < 0) {
                    int count = 0;
                    for(int j=0; j<cnt; j++) {
                        if(picked[j].w == -1 * now.w) {
                            break;
                        }
                        count++;
                    }
                    if(count == cnt) continue;
                }
                picked[cnt] = now;
                perm(cnt+1, flag | 1<<i);
            }
        }
    }

    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("sample_input2.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int tc=1; tc<=T; tc++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            dests = new ArrayList<>();
            for(int i=0; i<N; i++) {
                String[] st = br.readLine().split(" ");
                for(int j=0; j<N; j++) {
                    map[i][j] = Integer.parseInt(st[j]);
                    if(map[i][j] != 0) {
                        dests.add(new Dest(i, j, map[i][j]));
                    }
                }
            }
            M = dests.size();
            picked = new Dest[M];
            min = Integer.MAX_VALUE;

            perm(0, 0);

            sb.append("#").append(tc).append(" ").append(min).append("\n");
        }

        System.out.println(sb);
    }
}
