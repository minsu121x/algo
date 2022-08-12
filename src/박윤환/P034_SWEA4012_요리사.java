package 박윤환;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class P034_SWEA4012_요리사 {

	static int N, min;
	static int[][] syn;
	static boolean[] food;
	
	// 재료를 음식 A와 B로 나누는 조합을 구하는 메소드
	static void combFood(int index, int cnt) {
		// 모든 재료의 선택이 끝났으면
		if(index == N) {
			if(cnt != N/2) return;	// 절반으로 안나뉘었으면 다시 선
			int sumA = 0;
			int sumB = 0;
			for(int i=0; i<N; i++) {	// 처음부터 탐색
				for(int j=i+1; j<N; j++) {	// 재료 하나를 고르고 그 뒤부터 탐색
					// true이면 음식A에, false면 음식B에 사용
					if(food[i] && food[j]) {	// i와 j가 음식A에 선택됐다면
						sumA += syn[i][j] + syn[j][i];	// A의 시너지 합 계산
					} else if(!food[i] && !food[j]) {	// i와 j가 음식B에 선택됐다면
						sumB += syn[i][j] + syn[j][i];	// B와 시너지 합 계산
					}
				}
			}
			// 계산한 시너지 합의 차를 계산하고 최솟값인지 판별 후 저장
			min = Math.min(Math.abs(sumA - sumB), min);
			
			return;
		}
		
		// 재료 선택
		food[index] = true;
		combFood(index+1, cnt+1);
		// 재료 미선택
		food[index] = false;
		combFood(index+1, cnt);
	
	}
	
	public static void main(String[] args) throws Exception {
//		System.setIn(new FileInputStream("sample_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());	// 테스트 케이스 개수
		for(int tc=1; tc<=T; tc++) {	// 테스트 케이스만큼 반복
			N = Integer.parseInt(br.readLine());	// 재료 개수
			syn = new int[N][N];	// 시너지 표
			
			for(int i=0; i<N; i++) {
				String[] st = br.readLine().split(" ");
				for(int j=0; j<N; j++) {
					syn[i][j] = Integer.parseInt(st[j]);
				}
			}
			
			food = new boolean[N];	// 어떤 음식에 어떤 재료를 쓸지 기록하는 배열
			min = Integer.MAX_VALUE;
			combFood(0, 0);
			
			sb.append("#").append(tc).append(" ").append(min).append("\n");
		}
		System.out.println(sb);
	}

}
