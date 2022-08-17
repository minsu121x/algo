package 조민수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class P040_BJ15683_감시 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//4중포문 돌려서
		//각각의 경우의 최댓값
		  String[] st = br.readLine().split(" ");
	        int N = Integer.parseInt(st[0]);
	        int M = Integer.parseInt(st[1]);
	        int[][] office = new int[N][M];
	        int []IsCctv=new int [6]; //cctv 1~5의 갯수 저장
	        ArrayList<Integer[][]> CCTV = new ArrayList<Integer[][]>();
	        for(int i=0; i<N; i++) {
	            st = br.readLine().split(" ");
	            for(int j=0; j<M; j++) {
	            	
	            	int num=Integer.parseInt(st[j]);
	                office[i][j] = num;
	                if(num>=1&&num<=5) {//cctv 유무 판단
	                	cctv[num]++;
	                }
	            }
		
	        }
	        //4중포문
	        for(int q=1;q<=4;q++)
	        {
	        	
	        }
	}
}
