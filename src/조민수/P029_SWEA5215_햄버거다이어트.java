package 조민수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P029_SWEA5215_햄버거다이어트 {

	static int N,L,max;
	static int [][]ingr;
	static boolean[] isselected;
	
	static void subset(int index) {
		if(index==N) {
			int sum=0;
			int cal=0;
			for (int i =0;i<N;i++) {
				if(isselected[i]) {
					sum+=ingr[i][0];
					cal+=ingr[i][1];
				}	
			}
			if(cal<=L&&sum>max){
				max=sum;
			}
			System.out.println("리턴");
			return;
		}
		isselected[index]=true;
		subset(index+1);
		isselected[index]=false;
		subset(index+1);
		
	}
		
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T=Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			String[] st=br.readLine().split(" ");
			 N=Integer.parseInt(st[0]);  //재료수
			 L=Integer.parseInt(st[1]);	//칼로리 제한
			ingr =new int[N][2]; // 재료를 담는 배열
			for(int i=0;i<N;i++) {
				st=br.readLine().split(" ");
				ingr[i][0]=Integer.parseInt(st[0]);
				ingr[i][1]=Integer.parseInt(st[1]);
			}
			isselected=new boolean[N];
			subset(0);
			sb.append("#").append("tc").append(" ").append(max).append("\n");
		}
		System.out.println(sb);
	}
	
}
