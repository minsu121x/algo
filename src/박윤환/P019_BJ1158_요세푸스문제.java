package 박윤환;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class P019_BJ1158_요세푸스문제 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String[] st = br.readLine().split(" ");
		int N = Integer.parseInt(st[0]);	// 1번부터 N번까지
		int K = Integer.parseInt(st[1]);	// K번째 사람를 제거
		
		Queue<Integer> dq = new ArrayDeque<>();	// ArrayDeque를 Queue로 사용
		for(int i=1; i<=N; i++) {	// 1부터 N까지 Queue에 저장
			dq.offer(i);
		}
		sb.append("<");
		while(dq.size() != 1) {	// 한 사람이 남을 때까지 반복
			for(int i=K-1; i>0; i--) {	// 앞에 K-1개의 사람을 뒤로 옮김
				dq.offer(dq.poll());
			}
			sb.append(dq.poll()).append(", ");	// K번째 사람 제거
		}
		sb.append(dq.poll()).append(">");	// 마지막 사람 제거
		
		System.out.println(sb);
		
	}

}
