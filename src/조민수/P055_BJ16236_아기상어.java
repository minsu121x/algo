package 조민수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;

public class P055_BJ16236_아기상어 {

	static int[] dr =new int[] {-1,1,0,0};
	static int[] dc =new int[] {0,0,-1,1};
	static int N;
	static int[][] sea;
	static int dfs(int r, int c, int desR, int desC, int baby,int cnt,boolean[][] visited) {
			visited[r][c]=true;
			if(r==desR&&c==desC) {
				return cnt;
			}
			for(int i=0;i<4;i++) {
				int nxtR=r+dr[i];
				int nxtC=c+dc[i];
				if(0<=nxtR&&nxtR<N&&0<=nxtC&&nxtC<N&&sea[nxtR][nxtC]<=baby&&!visited[nxtR][nxtC]) {//범위안에 있고 상어 크기보다 작거나 같아야만 지나갈 수 있음
					visited[nxtR][nxtC]=true;
					dfs(nxtR,nxtC,desR,desC,baby,cnt+1,visited);
					visited[nxtR][nxtC]=false;
				}	
			}
			return Integer.MAX_VALUE;//목적지가 못가는 값이다.
	}
		
		
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String st=br.readLine();
		 N=Integer.parseInt(st);//열
		PriorityQueue<int[]> fish = new PriorityQueue<>((o1,o2)-> {
			if(o2[2]==o1[2]) {//값이 같으면
				if(o2[0]==o1[0]) {//높이비교 ,,,도 같으면
					return o1[1]-o2[1];//열 차
				}
				return o2[0]-o1[0];
			}return o1[2]-o2[2];//근본은 값비교
		});//물고기 값이 작은 애들부터 정렬
		PriorityQueue<int[]> canEat = new PriorityQueue<>((o1,o2)->o1[3]-o2[3]);//먹을 수 있는 물고기들을 뽑아와서 거리가 가까운순으로 정렬
		int move=0;
		int r=0;//상어의 시작 좌표 r
		int c=0;//상어의 시작 좌표 c
		int baby=2; //상어의 크기 : 초기값 2-> 자기 사이즈만큼 물고기 먹을때마다 사이즈 1업
		int eat=0;
		sea=new int[N][N];//맵 사이즈 N*N;
		for(int i=0;i<N;i++) {//맵 정보 입력과 동시에 필요정보(물고기 크기위치 - 상어 시작위치)도 저장
			String[]str=br.readLine().split(" ");
			for(int j=0;j<N;j++) {
				sea[i][j]=Integer.parseInt(str[j]);
				if(sea[i][j]==9) {//상어의 위치 저장
					r=i;
					c=j;
				}
				if(1<=sea[i][j]&&sea[i][j]<=6) {//값이 있을 때만
					fish.offer(new int[] {i,j,sea[i][j],0});//fish[size]에 좌표 저장 r좌표 c좌표 물고기값,dfs값(초기값 0)
				}
				
				}
			}
		while(true) {//무한반복
			int[] canEatTemp;
				while(!fish.isEmpty()&&fish.peek()[2]<baby) {//fish에 값이 있고 최상단값(정렬된 제일 작은값)이 상어보다 작다.
					canEatTemp=fish.poll();//임시저장
					canEatTemp[3]=dfs(r,c,canEatTemp[0],canEatTemp[1],baby,0,new boolean[N][N]);
					if(canEatTemp[3]!=Integer.MAX_VALUE) {//갈 수 있는 애들만 저장
						canEat.offer(canEatTemp);//먹을 수 있는거 다 땡겨와서 저장
					}
					else System.out.println("너는 왜...");
					
				}//먹을 수 있는거 다옮김
				
				if(!canEat.isEmpty()) {
					//fish에서 먹을 수 있는 애들빼서 canEat에 저장
					canEatTemp=canEat.poll();//제일 위에 있는 애 꺼내기
					move+=canEatTemp[3];//제일 위까지 이동한 최소거리 +
					r=canEatTemp[0];//이동한 자리 좌표
					c=canEatTemp[1];//이동한 자리 좌표
					eat++;
					if(eat==baby) {//사이즈업 가능
						eat=0;
						baby++;
					}
					while(!canEat.isEmpty()) {
						fish.offer(canEat.poll());//canEat에 있는 애들 다시 fish로 이동
					}
					
				}
				else {//먹을 게 없다
					System.out.println(move);//지금까지의 이동 출력
					return;
				}
		
		}
	
	}
}
