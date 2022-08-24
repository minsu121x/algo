package 조민수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class P057_BJ10026_적록색약 {
	
	static ArrayDeque<int[]> node=new ArrayDeque<int[]>();
	static int[]dr=new int[] {-1,1,0,0};
	static int[]dc=new int[] {0,0,-1,1};
	static boolean[][] isVisited;
	static int N;
	static char [][] paint;
	
	static int bfs(boolean isSick) {
		int cnt=0;
		for(int r=0;r<N;r++) {//행 
			for(int c=0;c<N;c++) {//이건 열이다
				if(isVisited[r][c]==false) {//지금 칸을 방문한적이 없으면
					cnt++;
					node.offer(new int[]{r,c});//큐에 넣고 사방탐색
					while(!node.isEmpty()) {
						int[]point=node.poll();
						isVisited[point[0]][point[1]]=true;
						for(int i=0;i<4;i++) {
							int nextR=point[0]+dr[i];
							int nextC=point[1]+dc[i];
							if(nextR>=0&&nextR<N&&nextC>=0&&nextC<N) {
								if(isVisited[nextR][nextC]==false&&paint[nextR][nextC]==(paint[r][c])) {//방문한적이 없다&&색상이 같다
									node.offer(new int[]{nextR,nextC});
								}
								else if(isVisited[nextR][nextC]==false&&isSick) {
									if((paint[nextR][nextC]=='R'&&paint[r][c]=='G')||(paint[nextR][nextC]=='G'&&paint[r][c]=='R')) {
										node.offer(new int[]{nextR,nextC});
									}
								}
							}
						}
					}
				}
			}
		}
		return cnt;
		
	}
	public static void main(String[] args) throws Exception {//각박한 세상으로 날 던져
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		 N= Integer.parseInt(br.readLine());
		//N*N 배열 입력 받는다
		paint= new char[N][N];
		for(int r=0;r<N;r++) {//행 
			String st = br.readLine();
			for(int c=0;c<N;c++) {//이건 열이다
				paint[r][c]=st.charAt(c);//문자열->캐릭터로 바꿔서 받는다
			}
		}
		isVisited=new boolean[N][N];
		int person=bfs(false);
		for(int i=0;i<N;i++) {
		Arrays.fill(isVisited[i],false);	
		}
		
		int sickPerson=bfs(true);
		System.out.println(person+" "+sickPerson);
		
	}

}
