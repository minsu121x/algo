package 조민수;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class P009_BJ11659_구간합구하기4 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int size=0;
		int tc=0;
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		String stBr= br.readLine();
		String[] st=stBr.split(" ");
		size=Integer.parseInt(st[0]);
		tc=Integer.parseInt(st[1]);
		int sum=0;
		int []map=new int[size+1];//0 1 2 3 4 5 
		stBr= br.readLine();
		st=stBr.split(" ");
		for(int i=1;i<=size;i++) {
			sum+=Integer.parseInt(st[i-1]);//1 2 3 4 5 를 저장 X 거기까지의 합을 저장 ex)3-> 1~3까지의 합
			map[i]=sum;
		}
	
		for(int i=1;i<=tc;i++) {
			stBr= br.readLine();
			st=stBr.split(" ");
			int start=Integer.parseInt(st[0]);
			int end=Integer.parseInt(st[1]);
			int result=map[end]-map[start-1];//2~3까지 더한값 -> 1~3까지 더한 값(map[3]) - 1~2(map[2])까지 더한값
			sb.append(result);
		}
		System.out.println(sb);
	}

}
