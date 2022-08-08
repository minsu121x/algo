package 박윤환;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class P020_SWEA9229_한빈이와SpotMart {
	
	static int max = 0;
	
	public static void main(String[] args) throws Exception {
//		System.setIn(new FileInputStream("sample_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());	// 테스트 케이스의 개수
		
		for(int tc=1; tc<=T; tc++) {
			String[] st = br.readLine().split(" ");
			int N = Integer.parseInt(st[0]);	// 과자 봉지의 개수
			int M = Integer.parseInt(st[1]);	// 무게 제한
			
			int[] snack = new int[N];		// 과자 봉지의 무게를 담는 배열
			int[] pick = new int[2];		// 2개의 고른 과자의 무게를 담는 배열
			st = br.readLine().split(" ");
			for(int i=0; i<N; i++) {
				snack[i] = Integer.parseInt(st[i]);
			}
			max = 0;	// 최대 무게 합을 저장하는 변수
			
			comb(snack, pick, N, M, 0, 0);	// combination으로 재귀적 호출
			if(max == 0) {	// 무게제한 안으로 고를 수 있는 과자가 없을 경우
				max = -1;	// -1을 출력하기 위해 저장
			}
			sb.append("#").append(tc).append(" ").append(max).append("\n");
		}
		
		System.out.println(sb);

	}
	
	// cnt : 직전까지 뽑은 수의 개수, start: 시도할 수의 시작 위치
	static void comb(int[] snack, int[] pick, int N, int M, int cnt, int start) {
		// combination 재귀적 호출
		if(cnt == 2) {	// 2가지를 골랐으면
			int sum = 0;
			for (int p : pick) {	// 고른 2개의 과자 봉지 무게 합을 구한다
				sum += p;
			}
			if(sum <= M) {	// 무게합이 무게제한보다 적다면
				max = Math.max(max, sum);	// 최대값에 저장
			}
			return;
		}
		
		for(int i=start; i<N; i++) {
			pick[cnt] = snack[i];	// 앞쪽에서 선택되지 않았으면 선택
			comb(snack, pick, N, M, cnt+1, i+1);	// 다음 과자 선택
		}
		
	}

}
