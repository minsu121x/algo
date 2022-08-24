package 조민수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class P056_BJ7576_토마토 {
	static int[] dr= new int[]{-1,1,0,0};
	static int[] dc= new int[]{0,0,-1,1};//상하좌우
	static Queue<int[]> tomato;//bfs 토마토 저장할  큐 
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[] st=br.readLine().split(" ");
		int c=Integer.parseInt(st[0]);//열
		int r=Integer.parseInt(st[1]);//행
		int[][] tomatoBox=new int[r][c];//토마토박스
		int remain=0;//남은 안익은 토마토수를 저장하자
		int day=0; //총 걸린 일수
		tomato=new ArrayDeque<int[]>();
		boolean[][]visited=new boolean[r][c];
		for(int i=0;i<r;i++) {
			st=br.readLine().split(" ");
			for(int j=0;j<c;j++) {
				tomatoBox[i][j]=Integer.parseInt(st[j]);
				switch(tomatoBox[i][j]) {
				case 0://안익은거//개수 파악해서 다 없어지면 출력
					remain++;
				break;
				case 1://익은거//큐에 저장해서 bfs
					tomato.offer(new int[] {i,j,day});
					visited[i][j]=true;
					break;
				case -1://빈거 -> 방문필요 X -> isVisited인걸로 표시해버리기
					visited[i][j]=true;
					break;
				}
			}
		}
		
		while(remain!=0&&!tomato.isEmpty()) {//토마토가 남아있고, 확산할 토마토가 아직 있다-> 반복
			int[]point = tomato.poll();//큐에 저장된 토마토 차례로 반환
			if(tomatoBox[point[0]][point[1]]==0) {
				remain--;//지금 자리가 0이면 토마토 하나 감소
			}
			if(day!=point[2]) {//날이 넘어갔다
				day=point[2];//날 업데이트
			}
			for(int i=0;i<4;i++) {
				int nxtR=point[0]+dr[i];//다음 방문할 행
				int nxtC=point[1]+dc[i];//다음 방문할 열
				if(0<=nxtR&&nxtR<r&&0<=nxtC&&nxtC<c&&!visited[nxtR][nxtC]) {//범위안이고 방문 안했다
					visited[nxtR][nxtC]=true;//방문지 방문값 true 저장
					
					tomato.offer(new int[]{nxtR,nxtC,day+1});//방문할 배열에 저장
				}
			}
		}
		if(remain!=0) {//while을 탈출했을 때 토마토가 남아있다 -> 마무리할 수 없다 -1 출력
			System.out.println(-1);
			
		}
		else {//토마토가 끝나면 최종 걸린 날 출력
			System.out.println(day);
		}
	}

}
