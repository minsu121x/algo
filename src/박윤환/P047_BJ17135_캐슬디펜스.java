package 박윤환;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P047_BJ17135_캐슬디펜스 {
    static int N, M, D;
    static int[][] map;
    static boolean[] bowyer;

    static int distance(int i, int j, int x, int y) {
        return Math.abs(x-i) + Math.abs(y-j);
    }

    static boolean isEmpty(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;
        int sum = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                sum += arr[i][j];
            }
        }
        if(sum == 0) {
            return true;
        } else {
            return false;
        }
    }

    static void comb(int index, int cnt) {
        if(cnt == 3) {
            int[][] copy = new int[N][M];
            for(int i=0; i<N; i++) {
                copy[i] = Arrays.copyOf(map[i], M);
            }

            while(!isEmpty(copy)) {
            }
        }
        if(index == M) return;

        for(int i=0; i<M; i++) {
            bowyer[i] = true;
            comb(index+1, cnt+1);
            bowyer[i] = false;
            comb(index+1, cnt);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] st = br.readLine().split(" ");
        N = Integer.parseInt(st[0]);
        M = Integer.parseInt(st[1]);
        D = Integer.parseInt(st[2]);

        for(int i=0; i<N; i++) {
            st = br.readLine().split(" ");
            for(int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(st[j]);
            }
        }
        bowyer = new boolean[M];
        comb(0, 0);



    }
}
