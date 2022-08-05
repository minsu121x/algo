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
		
		for(int t=1;t<=tc;t++) {
			st=br.readLine();
			String[] str=st.split(" ");
			size=Integer.parseInt(str[0]);
			catchSz=Integer.parseInt(str[1]);
			int[][] map=new int[size][size];
				
				for(int i=0;i<size;i++){
					st=br.readLine();
					str=st.split(" ");
					for(int j=0;j<size;j++){
							map[i][j]=Integer.parseInt(str[j]);//맵 값 입력받기
						}
					}
				
				
				for(int i=0;i<=size-catchSz;i++){
					for(int j=0;j<=size-catchSz;j++){//사이즈를 넘기지 않기 위해 size-catchSz전까지만 돈다
					
						int result=0;
					
							for(int k=i;k<i+catchSz;k++){//현재 좌표부터 catchSz만큼 파리값 더하기
								for(int l=j;l<j+catchSz;l++){
									result+=map[k][l];
								}
							}
							if(result>maxfly)//현재 위치에서 잡은 값이 최댓값보다 크다
							{
								maxfly=result;//최댓값 변경
							}
					}
				}	
				System.out.println("#"+t+" "+maxfly);
				maxfly=0;
			}
		}

}
