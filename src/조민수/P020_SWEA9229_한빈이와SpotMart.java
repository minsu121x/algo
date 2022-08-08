package 조민수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P020_SWEA9229_한빈이와SpotMart {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int tc= Integer.parseInt(br.readLine());
		for(int i=1;i<=tc;i++) {
			int result=-1;
			String st=br.readLine();
			String[] str=st.split(" ");
			int n=Integer.parseInt(str[0]);
			int size=Integer.parseInt(str[1]);
			int one=0;
			int two=0;
			st=br.readLine();
			str=st.split(" ");
			for(int j=0;j<str.length-1;j++) {
				for(int k=j+1;k<str.length;k++) {
					one=Integer.parseInt(str[j]);
					two=Integer.parseInt(str[k]);
					if(one+two>result&&one+two<=size) {
						result=one+two;
					}
				}
			}
			System.out.println("#"+i+" "+result);
		}
		
	}
}

