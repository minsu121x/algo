package 박윤환;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P010_BJ11660_구간합구하기5 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		String[] st = br.readLine().split(" ");
		int n = Integer.parseInt(st[0]);
		int m = Integer.parseInt(st[1]);
		int[][] arr = new int[n+1][n+1];	//	0번째 인덱스는 0으로 비우고 1부터
		
		for(int i=1; i<n+1; i++) {
			st = br.readLine().split(" ");
			for(int j=1; j<n+1; j++) {		// 한줄씩 이전 요소와의 합을 미리 구해서 저장
				arr[i][j] = arr[i][j-1] + Integer.parseInt(st[j-1]);
			}
		}
		
		for(int k=m; k>0; k--) {
			st = br.readLine().split(" ");
			int startI = Integer.parseInt(st[0]);	// x_1
			int startJ = Integer.parseInt(st[1]);	// y_1
			int endI = Integer.parseInt(st[2]);		// x_2
			int endJ = Integer.parseInt(st[3]);		// y_2
			int sum = 0;
			for(int i=startI; i<=endI; i++) {		// 한줄씩 저장된 합을 최종합에 더한다
				sum += arr[i][endJ] - arr[i][startJ-1];
			}
			sb.append(sum).append("\n");
		}
		
		bw.write(sb.toString());
		
		bw.flush();
		bw.close();
		br.close();
	}

}
