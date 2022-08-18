package 조민수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class P044_BJ1987_알파벳 {

		static final int[]dx= {0,1,0,-1};
		static final int []dy= {1,0,-1,0};
		static int R, C,max;
		static ArrayList<Character> log;
		static char[][] board;
		
		
		static void dfs(int depth, int r, int c) {
			if(depth==R*C){// 기저조건 -> 다돌았으면 return
				max=Math.max(max, log.size());
				return;
			}
			if(log.indexOf(board[r][c])!=-1) {//이미 존재한다
				max=Math.max(max,log.size());
				
				return;
			}
			log.add(board[r][c]);//이동 가능한 칸 추가
			for(int i=0;i<4;i++){//상하좌우로 이동
				if(r+dx[i]<0||r+dx[i]>=R||c+dy[i]<0||c+dy[i]>=C) {//이동가능하지않으면
					continue;//무시하고 다음
				}
				dfs(depth+1,r+dx[i],c+dy[i]);//이동
			}	
			log.remove(log.size()-1);//내가 간 위치가 중복이다 -> 기록에서 제외
		}
		
		
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String []st =br.readLine().split(" ");
		R=Integer.parseInt(st[0]);
		C=Integer.parseInt(st[1]);
		board=new char[R][C];
		
		for (int i = 0; i <R; i++) {
			String s=br.readLine();
			for (int j = 0; j <C; j++) {
				board[i][j]=s.charAt(j);
			}
		}
		log=new ArrayList<>();
		dfs(0,0,0);
		System.out.println(max);
	
	}

}
