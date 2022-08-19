package 박윤환;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P046_SWEA3234_준환이의양팔저울 {
    static int N, cnt;
    static int[] weight;
    static boolean[] isSelected;

    static void subset(int start, int index, int sumL, int sumR) {
        if(sumL < sumR) return;
        if(index == N) {
            cnt++;
            System.out.println(Arrays.toString(isSelected));
            return;
        }
        if(index == start) {
            subset(start, index+1, sumL, sumR);
            return;
        }

        isSelected[index] = true;
        subset(start, index+1, sumL+weight[index], sumR);
        isSelected[index] = false;
        subset(start, index+1, sumL, sumR+weight[index]);


    }

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int tc=1; tc<=T; tc++) {
            N = Integer.parseInt(br.readLine());
            String[] st = br.readLine().split(" ");
            weight = new int[N];
            isSelected = new boolean[N];

            for(int i=0; i<N; i++) {
                weight[i] = Integer.parseInt(st[i]);
            }
            Arrays.sort(weight);

            for(int i=0; i<N; i++) {
                isSelected[i] = true;
                subset(i, 0, weight[i], 0);
                isSelected[i] = false;
            }

            sb.append("#").append(tc).append(" ").append(cnt).append("\n");

        }

        System.out.println(sb);
    }
}
