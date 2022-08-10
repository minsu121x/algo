package 조민수;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class P025_BJ16926_배열돌리기1_시간초과 {

	static final char[]dir= {'우', '하', '좌', '상'};
	static final int[]dx= {0,1,0,-1};//우,하,좌,상
	static final int[]dy= {1,0,-1,0};//우,하,좌,상
	
		
	public static void main(String[] args) throws Exception {
		long startTime=System.nanoTime();
		//Scanner sc = new Scanner(new File("input.txt"));
		//Scanner sc = new Scanner(System.in);
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		//StringBuilder sb=new StringBuilder(100);
		
		//int T=sc.nextInt();//테스트케이스
		//for(int tc=1;tc<=T;tc++) {
		String[] line = br.readLine().split(" ");	
		int N=Integer.parseInt(line[0]);//행
			int M=Integer.parseInt(line[1]);;//열
			int R=Integer.parseInt(line[2]);//회전수
			int data[][]=new int[N][M];
			for(int i=0;i<N;i++) {		
				String[] line1 = br.readLine().split(" ");
				for(int j=0;j<M;j++) {
					
					data[i][j]=Integer.parseInt(line1[j]);
					//System.out.printf("%d ",data[i][j]);
				}
				//System.out.println();
			}//데이터 초기화 완료
			
			////////// TO DO //////////////
			int min=N>M?M:N;
			int grpNo=min/2;//회전해야 할 그룹 갯수			
			
			for(int i=0;i<R;i++) {
				//System.out.printf("====%d회전===\n",i+1);
				for(int j=0;j<grpNo;j++) {
					//System.out.printf("\t====%d그룹===\n",j+1);
					int x=j;//시작 위치가 (0,0) (1,1) (2,2)...이기 때문에
					int y=j;
					int temp=data[x][y];//스와핑을 위해 현재 데이터 값을 보관
					int idx=0;//방향
					while(idx<4) {//우하좌상 순서로 처리
					//	System.out.println("\t\twhile..."+idx+" : "+dir[idx]+"측 방향 탐색");
						int nx=x+dx[idx];
						int ny=y+dy[idx];
					//	System.out.printf("\t\t\t(%d,%d)인접 (%d,%d)에 값이 있느냐?",x,y,nx,ny);
						if(nx<j || nx>=N-j || ny<j || ny>=M-j) {//범위밖으로
							//System.out.println("없음,방향 바꿔 탐색하겠음\n");
							idx++;//범위를 벗어나면 방향 전환하여 조건에 맞을때까지 탐색
						}
						else {
							//System.out.printf("네,%s에 있음 (%d,%d)값을 (%d,%d)에 넣기 \n",dir[idx], nx,ny,x,y);
							data[x][y]=data[nx][ny];
							x=nx;
							y=ny;
							
						}
					}
					data[j+1][j]=temp;

			}
			for(int k=0;k<N;k++) {					
				for(int j=0;j<M;j++) {					
					System.out.print(data[i][j]+" ");
				}
				System.out.println();
			}
		long endTime=System.nanoTime();
	System.out.println("\n"+((endTime-startTime)*0.000000001)+"초");
	}
	
	}
}
