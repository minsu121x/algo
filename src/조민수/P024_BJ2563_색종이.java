package 조민수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P024_BJ2563_색종이 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		int[][] paper=new int [100][100];
		int total=0;
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int tc=Integer.parseInt(br.readLine());
		for(int i=1;i<=tc;i++) {
			String[] str=br.readLine().split(" ");
			int x=Integer.parseInt(str[0]);
			int y=Integer.parseInt(str[1]);
			for(int j=x;j<x+10;j++) {
				for(int k=y;k<y+10;k++) {
					if(paper[j][k]==0) {
					paper[j][k]=1;
					total++;
					}
				}		
			}
		}
		System.out.println(total);
				
	}
}

