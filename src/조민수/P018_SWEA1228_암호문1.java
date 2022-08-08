package 조민수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P018_SWEA1228_암호문1 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int tc=10;
		for (int i=1;i<=tc;i++) {
			int password=Integer.parseInt(br.readLine());
			String st=br.readLine();
			String[] str=st.split(" ",11);//10개만 볼거다 0~9 : 유호값  10 :버릴거
			st=br.readLine();
			String[] pass=st.split("I");
			for(int k=0;k<password;k++) {
				String[] word=pass[k].split(" ");
				int index=Integer.parseInt(word[0]);
				int len=Integer.parseInt(word[1]);
				for(int j=index;j<=len;j++) {
					if(j>9) {
						break;
					}
					for(int l=2;l<2+len;l++) {
						str[j]=word[l];
					}
					
				}
			}
			System.out.print("#"+tc+" ");
			for(int j=0;j<10;j++) {
				System.out.print(str[j]+" ");  
			}
		}
	}

}
