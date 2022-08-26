package 조민수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P061_BJ4485_녹색옷입은애가젤다지_다익스트라 {

	static int N;
	static int[][] map;
	static class Node{
		int vertex;
		double weight;
	}
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		int tc=1;//테스트케이스
		while(true) {
			N=Integer.parseInt(br.readLine());
			if(N==0) {//0이 들어오면 입력 종료
				break;
			}
			
			for(int i=0;i<N;i++) {
				String st[]=br.readLine().split(" ");
				for(int j=0;j<N;j++) {
					map[i][j]=Integer.parseInt(st[j]);
				}
			}
			
		}
		
	}

}
