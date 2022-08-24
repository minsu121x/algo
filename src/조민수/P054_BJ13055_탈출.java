package 조민수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class P054_BJ13055_탈출 {
	static Queue<int[]> water;
	static Queue<int[]> move;
	static int[] dr =new int[]{-1,1,0,0};
	static int[] dc =new int[]{0,0,-1,1};
	static boolean visited;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		String str[]=br.readLine().split(" ");
		int r=Integer.parseInt(str[0]);
		int c=Integer.parseInt(str[1]);
		int[] start=new int[2];
		int time=0;
		char[][] map= new char[r][c];
		water= new ArrayDeque<int[]>();
		move= new ArrayDeque<int[]>();
		for(int i=0;i<r;i++) {
			String st=br.readLine();
			for(int j=0;j<c;j++) {
				map[i][j]=st.charAt(j);
				if(map[i][j]=='S') {//고슴도치 위치
					move.offer(new int[] {i,j});//물위치 저장//물위치 저장
				}
				if(map[i][j]=='*') {
					water.offer(new int[] {i,j});//물위치 저장
				}
			}
		}
		while(!move.isEmpty()) {
			//물 먼저 비우기
			int wsize=water.size();//현재 크기
			for(int w=0;w<wsize;w++) {//지금 큐에 있는 물 다 퍼트리기
				int[] wMove=water.poll();
				for(int i=0;i<4;i++) {
					int nxtR=wMove[0]+dr[i];
					int nxtC=wMove[1]+dc[i];
					if(0<=nxtR&&nxtR<r&&0<=nxtC&&nxtC<c&&(map[nxtR][nxtC]=='.'||map[nxtR][nxtC]=='M')) {//범위안이고 아무것도 없는 칸이다
							map[nxtR][nxtC]='*';//물로 만들고
							water.offer(new int[] {nxtR,nxtC});//물로 만든 칸 큐에 추가
					}	
				}	
			}
			//이제 이동해보자
			
				time++;
			int msize=move.size();//현재 크기
			for(int m=0;m<msize;m++) {//지금 큐에 있는 물 다 퍼트리기
				int[] sMove=move.poll();
				for(int i=0;i<4;i++) {
				int nxtR=sMove[0]+dr[i];
				int nxtC=sMove[1]+dc[i];
					if(0<=nxtR&&nxtR<r&&0<=nxtC&&nxtC<c&&map[nxtR][nxtC]=='.') {//범위안이고 아무것도 없는 칸이다
						map[nxtR][nxtC]='M';
						move.offer(new int[] {nxtR,nxtC});//물로 만든 칸 큐에 추가
					}
					else if (0<=nxtR&&nxtR<r&&0<=nxtC&&nxtC<c&&map[nxtR][nxtC]=='D'){
						System.out.println(time);
						return;
					}
				}	
			}
		}
		System.out.println("KAKTUS");
		return;
	}
}
