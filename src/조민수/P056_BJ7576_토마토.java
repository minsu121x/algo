package 조민수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class P056_BJ7576_토마토 {

	static Queue<int[]> tomato;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[] st=br.readLine().split(" ");
		int c=Integer.parseInt(st[0]);
		int r=Integer.parseInt(st[1]);
		int[][] tomatoBox=new int[r][c];
		int remainTomato=0;//남은 안익은 토마토수를 저장하자
		int day=0; //총 걸린 일수
		tomato=new ArrayDeque<int[]>();
		boolean[][]isVisited=new boolean[r][c];
		for(int i=0;i<r;i++) {
			st=br.readLine().split(" ");
			for(int j=0;j<c;j++) {
				tomatoBox[i][j]=Integer.parseInt(st[j]);
				switch(tomatoBox[i][j]) {
				case 0://안익은거//개수 파악해서 다 없어지면 출력
					remainTomato++;
				break;
				case 1://익은거//큐에 저장해서 bfs
					tomato.offer(new int[] {i,j});
					break;
				case -1://빈거 -> 방문필요 X -> isVisited인걸로 표시해버리기
					isVisited[i][j]=true;
					break;
				}
			}
		}
		
		while(remainTomato!=0) {//모든 토마토가 익을때까지 반복
			int[]point = tomato.poll();
		}
	}

}
