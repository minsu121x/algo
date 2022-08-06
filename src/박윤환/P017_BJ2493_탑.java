package 박윤환;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P017_BJ2493_탑 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());	// 탑의 개수
		int[] tower = new int[N];	// 탑의 높이를 저장하는 배열
		String[] st = br.readLine().split(" ");
		
		for(int i=0; i<N; i++) {	// 탑의 높이를 저장
			tower[i] = Integer.parseInt(st[i]);
		}
		
		int[] answer = new int[N];	// 탑에서 발사한 레이저 신호를 수신한 탑의 번호가 저장되는 배열
		
		for(int i=N-1; i>0; i--) {	// 마지막 탑부터 첫번째 타워까지 반복
			for(int j=1; j<=i; j++) {	// 왼쪽으로 한칸씩 비교
				if(tower[i-j] >= tower[i]) {	// 왼쪽 탑의 높이가 같거나 크면
					answer[i] = i - j + 1;		// 그 탑의 위치를 저장하고
					break;						// 반복문 탈출
				}
			}
		}
		
		for(int i=0; i<N; i++) {
			sb.append(answer[i]).append(" ");
		}
		sb.append("\n");
		
		System.out.println(sb);
		
	}

}
