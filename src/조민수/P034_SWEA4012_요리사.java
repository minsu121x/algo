package 조민수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class P034_SWEA4012_요리사 {

	static int N,diff;
	static int[][] ingr;//식재료 배열
	static ArrayList<Integer> foodA,foodB,Asyn,Bsyn;//A의 조합(N/2) B의 조합(N/2) A의 시너지 B의 시너지
	static int minTotal=50000;//최종 차이
	static int minSubset=50000;//각 부분조합의 합

	static void combIngr(ArrayList<Integer> com,int cnt,int start) {
		
		
		if(cnt==2) {
			///
		}
		for(int i=start;i<N/2;i++) {
			
		}
		
		
	}
	
	
	static void combFood(int cnt,int start) {

			if(foodA.size()==N/2&&foodB.size()==N/2) {//둘 다 꽉 채우면 이제 연산 비교
			//	minTotal=Math.min(minTotal, Math.abs(combIngr(foodA,0,0)-combIngr(foodB,0,0));
				return;
			}
		for(int i=start;i<N;i++) {
			foodA.add(i);
			if(foodB.contains(i)) {
				foodB.remove(foodB.indexOf(i));
			}
			combFood(cnt+1,i+1);
			foodB.add(i);
			foodB.add(i);
			if(foodA.contains(i)) {
				foodA.remove(foodA.indexOf(i));
			}
			combFood(cnt+1,i+1);
		}
	}
	
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T=Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			N=Integer.parseInt(br.readLine());
			ingr=new int[N][N];
			
			for(int i=0;i<N;i++) {
				String[] st=br.readLine().split(" ");
				for(int j=0;j<N;j++) {
					ingr[i][j]= Integer.parseInt(st[j]);
				}
				
			}
			foodA=new ArrayList<>();
			foodB=new ArrayList<>();
			System.out.println();
		}
	}

}
