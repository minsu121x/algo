package 박윤환;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P007_SWEA1954_달팽이숫자 {

	public static void main(String[] args) throws Exception {
//		System.setIn(new FileInputStream("input4.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());	// 테스트 케이스 개수
		
		for(int tc=1; tc<=T; tc++) {
			int n = Integer.parseInt(br.readLine());	// 달팽이 크기
			int[][] snail = new int[n][n];				// 달팽이 배열 선언
			makeSnail(n, snail);		// 달팽이 만드는 메소드 호출
			bw.write("#" + tc);
			bw.newLine();
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					bw.write(snail[i][j] + " ");
				}
				bw.newLine();
			}
			
		}
		bw.flush();
		bw.close();
		br.close();
	}
	
	// 달팽이를 만드는 메소드
	static void makeSnail(int n, int[][] snail) {
		int i = 0;
		int j = 0;
		int cnt = 1;	// 1부터
		snail[i][j] = cnt++;
		while(true) {
			// 오른쪽으로
			while(j < n-1 && snail[i][j+1] == 0) {
				snail[i][j+1] = cnt++;
				j++;
			}
			// 아래쪽으로
			while(i < n-1 && snail[i+1][j] == 0) {
				snail[i+1][j] = cnt++;
				i++;
			}
			// 왼쪽으로
			while(j > 0 && snail[i][j-1] == 0) {
				snail[i][j-1] = cnt++;
				j--;
			}
			// 위쪽으로
			while(i > 0 && snail[i-1][j] == 0) {
				snail[i-1][j] = cnt++;
				i--;
			}
			// 마지막으로 입력된 값이 배열 크기 n의 제곱이면 break
			if(cnt-1 == Math.pow(n, 2)) {
				break;
			}
		}
	}

}
