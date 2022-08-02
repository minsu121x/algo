package 박윤환;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class P006_SWEA2805_농작물수확하기 {

	public static void main(String[] args) throws Exception {
//		System.setIn(new FileInputStream("input3.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());	// 테스트 케이스 개수
		
		for(int tc=1; tc<=T; tc++) {
			int n = Integer.parseInt(br.readLine());	// 농장의 크기 N
			int[][] farm = new int[n][n];				// NxN 크기의 농장 배열 선언
			
			for(int i=0; i<n; i++) {
				char[] ch = br.readLine().toCharArray();
				for(int j=0; j<n; j++) {
					farm[i][j] = ch[j] - '0';		// 농장 배열 초기화
				}
			}
			
			int mid = n / 2;	// 중간 인덱스
			int sum = 0;	// 최종 수
			for(int i=0; i<=mid; i++) {		// 윗부분부터 중간까지
				sum += farm[i][mid];		// 행의 가운데 값을 수익에 더한다
				for(int j=1; j<=i; j++) {	// 행을 내려갈수록 더하는 옆 칸의 개수 증가
					sum += farm[i][mid+j];
					sum += farm[i][mid-j];
				}
			}
			for(int i=n-1; i>mid; i--) {	// 끝부터 중간 아래까
				sum += farm[i][mid];		// 행의 가운데 값을 수익에 더한다
				for(int j=1; j<=(n-1)-i; j++) {	// 행을 올라갈수록 더하는 옆 칸의 개수 증가
					sum += farm[i][mid+j];
					sum += farm[i][mid-j];
				}
			}
			System.out.println("#" + tc + " " + sum);	// 최종 출력
		}
		
		br.close();
	}

}
