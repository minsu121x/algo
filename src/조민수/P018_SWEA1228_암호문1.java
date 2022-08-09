package 조민수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class P018_SWEA1228_암호문1 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

		for (int tc=1;tc<=10;tc++) {
			int passwordlen=Integer.parseInt(br.readLine());//길이
			List<Integer> password=new ArrayList<>();
			String st=br.readLine();//password
			String[] str=st.split(" ");
			for(int i=0;i<10;i++) {
				password.add(Integer.parseInt(str[i]));
			}
			int input=Integer.parseInt(br.readLine());//입력받을 개수
			st=br.readLine();//이제부터 입력


			str=st.split(" ");

			for(int j=0;j<str.length;j++) {
				if(str[j].equals("I")) {//여기부터 시작
					int index=Integer.parseInt(str[++j]);//추가할 자리
					int len=Integer.parseInt(str[++j]);//추가할 길이
					
					if(index>9) {
						continue;//무시가능
					}
					for(int k=1;k<=len;k++) {
						if(index+k>9) {
							break;
						}
						
						password.add(index,(Integer.parseInt(str[j+k])));
					}
					
				}	
			}
			
				
			
			System.out.print("#"+tc+" ");
			for(int j=0;j<10;j++) {
				System.out.print(password.get(j)+" ");  
			}
			System.out.println();
		}
	}

	
}
