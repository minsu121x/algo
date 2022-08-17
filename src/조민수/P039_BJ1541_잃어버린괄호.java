package 조민수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P039_BJ1541_잃어버린괄호 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] st=br.readLine().split("\\-");
		int Sum[]=new int[st.length];
		int cnt=0;
		int result=0;
		for(String s: st) {
			int sum=0;
			String[]tmp=s.split("\\+");
			for(String t: tmp ) {
				sum+=Integer.parseInt(t);
			}
			Sum[cnt]=sum;
			cnt++;
		}
		result=Sum[0];
		for(int i=1;i<Sum.length;i++) {
			result-=Sum[i];
		}
		System.out.println(result);
	}
	
}
     