package 박윤환;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P024_BJ2563_색종이 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int[][] drwPpr = new int[100][100];		// 도화지 배열
		int n = Integer.parseInt(br.readLine());	// 색종이 갯수
		int[][] clrPpr = new int[n][];		//	색종이의 위치를 담는 배열
		for(int i=0; i<n; i++) {
			clrPpr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();	// 색종이의 위치를 저장
		}
		for(int i=0; i<n; i++) {	// 색종이 갯수만큼 반복
			for(int j=clrPpr[i][0]; j<clrPpr[i][0]+10; j++) {	// 해당 색종이의 가로 사이즈만큼
				for(int k=clrPpr[i][1]; k<clrPpr[i][1]+10; k++) {	// 해당 색종이의 세로 사이즈만큼
					drwPpr[j][k] = 1;	// 색종이가 차지하는 부분을 도화지에 1로 채움
				}
			}
		}
		
		sb.append(Arrays.stream(drwPpr).flatMapToInt(Arrays::stream).sum());	// 도화지 내용의 합이 색종이의 넓이
		
		System.out.println(sb);
		
	}

}
