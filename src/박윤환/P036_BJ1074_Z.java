package 박윤환;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P036_BJ1074_Z {

    static int cnt;

    static void search(int size, int r, int c) {
        if(size == 1) {
            return;
        }
        // r, c의 위치가 어느 분면이냐에 따라
        if(r < size/2 && c < size/2) {  // 1사분면
            search(size/2, r, c);
        } else if(r < size/2 && c >= size/2) {  // 2사분면
            cnt += size*size/4;     // 2사분면의 번호 시작은 현재 크기의 절반의 제곱
            search(size/2, r, c-size/2);    // 시작번호만큼 카운트를 더하고 사분면내에 새로운 탐색
        } else if(r >= size/2 && c < size/2) {  // 3사분면
            cnt += size*size/4 * 2; // 3사분면은 2사분면 시작의 2배
            search(size/2, r-size/2, c);
        } else if(r >= size/2 && c >= size/2) { // 4사분면
            cnt += size*size/4 * 3; // 4사분면은 2사분면 시작의 3배
            search(size/2, r-size/2, c-size/2);
        }

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] st = br.readLine().split(" ");

        int N = Integer.parseInt(st[0]);
        int r = Integer.parseInt(st[1]);
        int c = Integer.parseInt(st[2]);

        int size = (int) Math.pow(2, N);    // 배열의 크기는 2^N

        search(size, r, c);

        System.out.println(cnt);
    }
}
