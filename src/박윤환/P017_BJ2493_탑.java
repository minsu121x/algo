package 박윤환;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class P017_BJ2493_탑 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());	// 탑의 개수
		Deque<int[]> tower = new ArrayDeque<>();	// ArrayDeque를 스택으로 사용
		String[] st = br.readLine().split(" ");
		sb.append(0).append(" ");	// 첫번째 탑은 왼쪽에 수신할 탑이 없으므로 0
		tower.offer(new int[] {0, Integer.parseInt(st[0])});	// 첫번째 탑을 스택에 저장
		
		for(int i=1; i<N; i++) {	// 2번째 탑부터 마지막탑까지 반복
			int now = Integer.parseInt(st[i]);	// 현재 탑의 높이
			while(true) {
				if(tower.isEmpty()) {	// 스택이 비어있으면
					tower.offer(new int[] {i, now});	// 현재 타워 높이를 저장
					sb.append(0).append(" ");	// 현재 탑의 신호를 수신한 탑이 없으므로 0 출력
					break;
				}
				if(tower.peekLast()[1] < now) {	// 스택의 top이 현재 탑보다 작을경우
					tower.pollLast();	// top을 꺼내고
				} else if(tower.peekLast()[1] >= now) {	// 현재 탑이 클 경우
					sb.append(tower.peekLast()[0]+1).append(" ");	// 현재 탑의 신호를 수신한 탑의 위치 출력
					tower.offer(new int[] {i, now});	// 현재 탑을 스택에 저장
					break;
				}
			}
		}
		
		System.out.println(sb);
		
		br.close();
		
	}

}
