package 조민수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P010_BJ11660_구간합구하기5 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		String stBr= br.readLine();
		String[] st=stBr.split(" ");
		int size=Integer.parseInt(st[0]);
		int tc=Integer.parseInt(st[1]);
		int[][] map=new int[size+1][size+1];
		for(int i=1;i<=size;i++) {
			 stBr= br.readLine();
			 st=stBr.split(" ");
			 int sum=0;
			for(int j=1;j<=size;j++) {
				sum+=Integer.parseInt(st[j-1]);
				map[i][j]=sum;
			}
		}
		
		for (int i=1;i<=tc;i++) {
			int []xy= {0,0,0,0};//x1,y1,x2,y2;
			int result=0;
			 stBr= br.readLine();
			 st=stBr.split(" ");
			 for(int j=0;j<4;j++){
				 xy[j]=Integer.parseInt(st[j]);
			 }
			for(int j=xy[0];j<=xy[2];j++) {//알고리즘은 P009 구간합4 문제와 동일 각 줄마다 합을 구해서 행으로 for문 합함.  

				result+=map[j][xy[3]]-map[j][xy[1]-1];
			}
			sb.append(result).append("\n");
		}
		System.out.println(sb);
	}

}
