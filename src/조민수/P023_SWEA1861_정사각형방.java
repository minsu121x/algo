package 조민수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P023_SWEA1861_정사각형방 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int test=Integer.parseInt(br.readLine());
		for(int tc=1;tc<=test;tc++) {
			int index=1000000;//현재 최대로 간 자리값
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
					
						if(i+1<n&&map[i][j]+1==map[i+1][j]) {
							int curCnt=search(map,i,j,n,1);
							int curIndex=map[i][j];
							if(curCnt>cnt) {
								cnt=curCnt;
								index=curIndex;
							}
							else if(curCnt==cnt&&index>curIndex)//값은 같은데 인덱스가 작다.
								index=curIndex;
							
						}
						else if(i-1>=0&&map[i][j]+1==map[i-1][j]) {
							int curCnt=search(map,i,j,n,1);
							int curIndex=map[i][j];
							if(curCnt>cnt) {
								cnt=curCnt;
								index=curIndex;
							}
							else if(curCnt==cnt&&index>curIndex)//값은 같은데 인덱스가 작다.
								index=curIndex;
							
						}
						else if(j-1>=0&&map[i][j]+1==map[i][j-1]) {
							if(map[i][j]==35) {
								System.out.println("AAA");
							}
							int curCnt=search(map,i,j,n,1);
							int curIndex=map[i][j];
							if(curCnt>cnt) {
								cnt=curCnt;
								index=curIndex;
							}
							else if(curCnt==cnt&&index>curIndex)//값은 같은데 인덱스가 작다.
								index=curIndex;
							
						}
						else if(j+1<n&&map[i][j]+1==map[i][j+1]) {
							int curCnt=search(map,i,j,n,1);
							int curIndex=map[i][j];
							if(curCnt>cnt) {
								cnt=curCnt;
								index=curIndex;
							}
							else if(curCnt==cnt&&index>curIndex)//값은 같은데 인덱스가 작다.
								index=curIndex;
						}
				}
			}
			
			System.out.println("#"+tc+" "+index+" "+cnt);
		}
	}
	public static int search(int[][]map,int i,int j,int n,int cnt) {
		
		if(i+1<n&&map[i][j]+1==map[i+1][j]) {//아래 있다
			cnt++;
			return search(map,i+1,j,n,cnt);
		}
		else if(i-1>=0&&map[i][j]+1==map[i-1][j]) {//위에 있다
			cnt++;
			return search(map,i-1,j,n,cnt);
		}
		else if(j+1<n&&map[i][j]+1==map[i][j+1]) {//오른쪽
			cnt++;
			return search(map,i,j+1,n,cnt);
		}
		else if(j-1>=0&&map[i][j]+1==map[i][j-1]) {//왼쪽
			cnt++;
			return search(map,i,j-1,n,cnt);
		}
		return cnt;
	}
}
