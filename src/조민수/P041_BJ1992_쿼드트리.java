package 조민수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P041_BJ1992_쿼드트리 {

	
	static int[][]arr;
	static int N;
	static StringBuilder sb;
	
	private void dnq(int N,int x, int y) {
		if(N==1) {
			return;
		}
		//1사분면
		sb.append("(");
		dnq(N/2,x,y);
		sb.append(")");
		//2사분면
		sb.append("(");
		dnq(N/2,x-N/2,y);
		sb.append(")");
		//3사분면
		sb.append("(");
		dnq(N/2,x,y-N/2);
		sb.append(")");
		//4사분면
		sb.append("(");
		dnq(N/2,x-N/2,y-N/2);
		sb.append(")");
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		arr= new int[N][N];
		for(int i=0;i<N;i++) {
			String[] st=br.readLine().split("");
			for(int j=0;j<N;j++) {
				arr[i][j]=Integer.parseInt(st[j]);
			}
		}
		System.out.println(sb);
	}

}
