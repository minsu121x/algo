package 조민수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P023_SWEA1861_정사각형방 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int test=Integer.parseInt(br.readLine());
		for(int tc=1;tc<=test;tc++) {
			int index=0;//현재 최대로 간 자리값
			int cnt=0;//최대 몇칸 갈 수 있나...
			int n=Integer.parseInt(br.readLine());
			int [][]map=new int[n][n];
			for(int i=0;i<n;i++) {
				String st=br.readLine();
				String[] str=st.split(" ");
				for(int j=0;j<n;j++) {
						map[i][j]=Integer.parseInt(str[j]);
				}
			}
			
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					if(map[i][j]+1==map[i+1][j]) {
						
					}
				}
			}
			
			System.out.println("#"+tc+" "+index+" "+cnt);
		}
	}

}
