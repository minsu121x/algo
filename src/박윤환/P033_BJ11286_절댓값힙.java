package 박윤환;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class P033_BJ11286_절댓값힙 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// 우선순위 큐에 comparator를 절대값이 같으면 작은 것부터 절대값이 다르면 절대값이 작은것부터 들어가도록 설정
		PriorityQueue<Integer> absHeap = new PriorityQueue<>((a, b) -> Math.abs(a) == Math.abs(b) ? a - b : Math.abs(a) - Math.abs(b));

		int N = Integer.parseInt(br.readLine());	// 연산 개수
		
		for(int i=0; i<N; i++) {
			int x = Integer.parseInt(br.readLine());
			
			if(x != 0) {	// 연산이 0이 아닐 경우
				absHeap.offer(x);	// 절대값 값을 추가
			} else {	// 연산이 0일 경우
				if(absHeap.size() == 0) {	// 힙이 비어 있다면
					sb.append(0).append("\n");	// 0을 출력
				} else {	// 비어 있지 않으면
					sb.append(absHeap.poll()).append("\n");	// 큐의 front 값을 제거하고 출력
				}
			}
		}
		
		System.out.println(sb);

	}

}
