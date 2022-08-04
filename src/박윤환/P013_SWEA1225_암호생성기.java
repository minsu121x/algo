package 박윤환;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class P013_SWEA1225_암호생성기 {

	public static void main(String[] args) throws Exception {
//		System.setIn(new FileInputStream("input2.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for(int tc=1; tc<=10; tc++) {
			int T = Integer.parseInt(br.readLine());
			Queue<Integer> dq = new ArrayDeque<>();	// ArrayDeque를 queue로 활용
			
			String[] st = br.readLine().split(" ");
			for(int i=0; i<8; i++) {	// 8개의 plain data를 queue에 저장
				dq.offer(Integer.parseInt(st[i]));
			}
			
			Loop :
			while(true) {	// 조건을 만족할때까지 무한루프
				for(int i=1; i<=5; i++) {	// 한번의 암호생성 사이클 수행
					int now = dq.poll() - i;	// 제일 앞의 숫자를 꺼내고 값을 감소
					if(now < 0) {	// 감소시킨 숫자가 0보다 작을 경우
						now = 0;	// 저장할 암호는 0으로
					}
					dq.offer(now);	// 감소시킨 숫자를 새로 저장
					if(now == 0) {	// 새로 저장한 숫자가 0이었을 경우
						break Loop;	// 무한 루프 탈출
					}
				}
			}
			
			sb.append("#").append(tc).append(" ");
			while(!dq.isEmpty()) {
				sb.append(dq.poll()).append(" ");
			}
			sb.append("\n");
			
		}
		System.out.println(sb);
	}

}
