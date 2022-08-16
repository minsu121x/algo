package 박윤환;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P036_BJ1074_Z {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] chem = new int[N][2];

        for(int i=0; i<N; i++) {
            String[] st = br.readLine().split(" ");
            chem[i][0] = Integer.parseInt(st[0]);
            chem[i][1] = Integer.parseInt(st[1]);
        }


    }
}
