package 박윤환;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P030_BJ2961_도영이가만든맛있는음식 {
	
	static int N, result;
	static int[][] sourBitter;
	static boolean[] isSelected;
	
	// 가능한 재료 조합 구하기
	static void subset(int index) {
		// 재료를 골랐다면
		if(index == N) {
			int sourSum = 1;
			int bitterSum = 0;
			boolean forFlag = false;	// 원소개수가 1개일 경우 계산하지 않기위해 넣는 flag 변수
			for(int i=0; i<N; i++) {	// 재료 개수만큼 반복
				if(isSelected[i]) {	// 선택된 재료일 경우
					forFlag = true;	// flag에 체크하고
					sourSum *= sourBitter[i][0];	// 신맛을 구하고
					bitterSum += sourBitter[i][1];	// 쓴맛을 구한다
				}
			}
			if(forFlag && Math.abs(sourSum-bitterSum) < result) {
				result = Math.abs(sourSum-bitterSum);	// 신맛과 쓴맛의 차이의 최소값 저장
			}
			
			return;
 		}
		
		isSelected[index] = true;
		subset(index+1);
		isSelected[index] = false;
		subset(index+1);
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());	// 재료의 개수
		sourBitter = new int[N][2];	// 재료를 저장할 배열
		for(int i=0; i<N; i++) {
			String[] st = br.readLine().split(" ");
			sourBitter[i][0] = Integer.parseInt(st[0]);
			sourBitter[i][1] = Integer.parseInt(st[1]);
		}
		
		result = 1_000_000_000;		// 최소값을 저장할 변수
		isSelected = new boolean[N];
		subset(0);
		
		System.out.println(result);
	}

}
