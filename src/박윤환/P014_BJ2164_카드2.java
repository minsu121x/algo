package 박윤환;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class P014_BJ2164_카드2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());	// 카드의 장수
		Queue<Integer> dq = new ArrayDeque<>();		// queue로 사용할 ArrayDeque 선언
		
		for(int i=1; i<=N; i++) {	// 1부터 N까지의 카드를 저장
			dq.offer(i);
		}
		
		while(dq.size() != 1) {	//	큐의 사이즈가 1이 될때까지 반복
			dq.poll();	// 바닥에 버림
			if(dq.size() == 1) {	// 바닥에 버린 직후 큐의 사이즈가 1이 되면 break
				break;
			}
			dq.offer(dq.poll());	// 제일 위의 카드를 밑으로 넣기
		}
		
		sb.append(dq.poll()).append("\n");
		System.out.println(sb);
		
		br.close();
	}

}
