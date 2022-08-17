package 박윤환;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class P039_BJ1541_잃어버린괄호 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] st = br.readLine().split("\\-");   // 주어진 식을 -로 분할
        Queue<Integer> dq = new ArrayDeque<>();

        for (String s : st) {
            int sum = 0;
            String[] tmp = s.split("\\+");  // 분할한 식을 +로 또 분할
            for (String t : tmp) {
                sum += Integer.parseInt(t); // 분할된 수들의 합을 구해서
            }
            dq.offer(sum);  // 큐에 저장
        }

        int result = dq.poll();
        while(!dq.isEmpty()) {      // 큐에 저장된 합들의 차를 구하면 최소값
            result -= dq.poll();
        }

        System.out.println(result);
    }
}
