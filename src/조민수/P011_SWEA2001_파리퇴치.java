package 조민수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P011_SWEA2001_파리퇴치 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		StringBuilder sb=new StringBuilder();
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int size=0;
		int catchSz=0;
		int maxfly=0;
		int tc=0;
		String st=br.readLine();
		tc=Integer.parseInt(st);
		st=br.readLine();
		size=Integer.parseInt(st);
		catchSz=Integer.parseInt(st);
		int[][] map=new int[size][size];
		
		for(int i=0;i<size;i++){
			st=br.readLine();
			String[] str=st.split(" ");
			for(int j=0;j<size;j++){
					map[i][j]=Integer.parseInt(str[j]);
				}
			}
				/*for(int t=1;t<=tc;t++) {
				for(int i=0;i<=size-catchSz;i++){
					for(int j=0;j<=size-catchSz;j++){
					
						int result=0;
					
							for(int k=i;k<i+catchSz;k++){
								for(int l=j;l<j+catchSz;l++){
									result+=map[k][l];
								}
							}
							if(result>maxfly)
							{
								maxfly=result;
							}
					}
				}
				System.out.println("#"+tc+" "+maxfly);
			}*/
		}

}
