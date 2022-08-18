package 박윤환;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class P044_BJ1987_알파벳 {

    static final int[] dx = {0, 1, 0, -1};  // 우, 하, 좌, 상
    static final int[] dy = {1, 0, -1, 0};  // 우, 하, 좌, 상

    static char[][] board;
    static int R, C, max;
    static ArrayList<Character> log;

    static void dfs(int depth, int r, int c) {
        if(depth == R*C) {
            max = Math.max(max, log.size());
            return;
        }
        if(depth != 0 && log.indexOf(board[r][c]) != -1) {
            max = Math.max(max, log.size());
            log.remove(log.size()-1);
            return;
        }
        for(int i=0; i<4; i++) {
            if(r+dx[i]<0 || r+dx[i]>=R || c+dy[i]<0 || c+dy[i]>=C) {
                continue;
            }
            System.out.println("R : " + r+dx[i]);
            System.out.println("C : " + c+dy[i]);
            log.add(board[r+dx[i]][c+dy[i]]);
            dfs(depth+1, r+dx[i], c+dy[i]);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] st = br.readLine().split(" ");
        R = Integer.parseInt(st[0]);
        C = Integer.parseInt(st[1]);

        board = new char[R][C];
        for(int i=0; i<R; i++) {
            String s = br.readLine();
            for(int j=0; j<C; j++) {
                board[i][j] = s.charAt(j);
            }
        }

        log = new ArrayList<>();
        log.add(board[0][0]);
        dfs(0, 0, 0);

        System.out.println(max);

    }
}
