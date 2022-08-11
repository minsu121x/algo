package 박윤환;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class P029_SWEA5215_햄버거다이어트 {

	static int N, L, max;
	static int[][] ingr;
	static boolean[] isSelected;
	
	// 재료 조합을 찾는 메소드
	static void subset(int index) {
		if(index == N) {	// 마지막 재료까지 선택을 마쳤다면
			int sum = 0;
			int cal = 0;
			for(int i=0; i<N; i++) {	// 재료 개수만큼 반복
				if(isSelected[i]) {		// 선택된 재료라면
					sum += ingr[i][0];	// 점수를 합하고
					cal += ingr[i][1];	// 칼로리를 합한다
				}
			}
			// 칼로리가 제한이하이고 점수가 최대보다 크면
			if(cal <= L && sum > max) {
				max = sum;	// 새로운 최대 갱신
			}
			return;
		}
		
		// 재료 선택
		isSelected[index] = true;
		subset(index + 1);
		
		// 재료 미선택
		isSelected[index] = false;
		subset(index + 1);
	}
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("sample_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());	// 테스트케이스 개수
		for(int tc=1; tc<=T; tc++) {		// 테스트 케이스만큼 반복
			String[] st = br.readLine().split(" ");
			N = Integer.parseInt(st[0]);	// 재료 수
			L = Integer.parseInt(st[1]);	// 칼로리 제한
			ingr = new int[N][2];	// 재료 정보를 담는 배열
			
			for(int i=0; i<N; i++) {	// 재료 정보 입력
				st = br.readLine().split(" ");
				ingr[i][0] = Integer.parseInt(st[0]);
				ingr[i][1] = Integer.parseInt(st[1]);
			}
			
			isSelected = new boolean[N];	// 재료 선택 기록
			max = 0;	// 최대값 초기화
			subset(0);
			
			sb.append("#").append(tc).append(" ").append(max).append("\n");
		}
		System.out.println(sb);
	}

}
