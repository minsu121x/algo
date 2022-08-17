package 박윤환;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P040_BJ15683_감시 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] st = br.readLine().split(" ");
        int N = Integer.parseInt(st[0]);
        int M = Integer.parseInt(st[1]);
        int[][] office = new int[N][M];

        for(int i=0; i<N; i++) {
            st = br.readLine().split(" ");
            for(int j=0; j<M; j++) {
                office[i][j] = Integer.parseInt(st[j]);
            }
        }



    }
}
