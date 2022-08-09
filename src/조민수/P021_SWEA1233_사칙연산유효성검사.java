package 조민수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P021_SWEA1233_사칙연산유효성검사 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[] str=new String[] {};
		for(int tc=1;tc<=10;tc++) {
			int result=1;
			int line=Integer.parseInt(br.readLine());
			for(int i=1;i<=line;i++) {
				str=br.readLine().split(" ");
				if(str[1].equals("/")||str[1].equals("*")||str[1].equals("-")||str[1].equals("+") ) {
					continue;
				}
				else {
					if(str.length==2) {//leaf다
						continue;
					}
					result=0;
					for(int j=i;j<line;j++) {
						String st=br.readLine();
					}
					break;
				}
				
			}
			System.out.println("#"+tc+" "+result);
			
		}
	}
}
