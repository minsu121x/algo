package 조민수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class P047_BJ17135_캐슬디펜스 {
	static int[][] map;//맵 상태 저장
	static int r,c,d;//맵의 행,열,궁수 사거리 저장
	static int[] archerPos;
	static int maxKill;// 궁수가 제거한 적 최대값
	static boolean[] visited;
	static Queue<int[]> shoot=new ArrayDeque<int[]>();
	static void shooting(int[][]curmap) {
		int killCnt=0;//현재 궁수위치조합의 적 처치수 저장

		
		for(int tc=r;tc>0;tc--) {//밑에서 부터 올라간다 맵이 아래로 움직임X 궁수가 위로O
			for(int i=0;i<c;i++) {//현재줄에 궁수 위치 파악
				if(curmap[tc][i]==1) {//지금 자리에 궁수가 존재한다.
					int D =d+1;//거리 최솟값 비교
					int last[]=new int[2];
					boolean isKill=false;
					for(int j=tc-1;j>=tc-d;j--) {//바로위에 줄부터 사격가능거리까지 범위 탐색 
						for(int k=i-d;k<=i+d;k++) {
							if(j<0||k<0||k>=c){
								continue; //범위 벗어나면 볼필요 x
							}
							int nowD=Math.abs(tc-j)+Math.abs(i-k);//현재 궁수-목표 거리
							if(nowD>D) {//현재거리가 더 길거나 같으면 볼필요 X 더 짧아질때만 본다
								continue;
							}
							if(nowD==D&&last[1]<k) {//거리는 같은데 오른쪽이다
								continue;
							}
							if(nowD<=d&&curmap[j][k]==1) {//1. k가 범위를 넘지 않으면서  2.거리내에 상대가 있다. 3. 궁수가 아직 사격하지 않았다
								
								//조건을 통과했다 -> 사격 가능한 (현재)최소 거리에 적이 있다
								D=nowD;//최솟값 갱신
								last[0]=j;
								last[1]=k;
								isKill=true;
								//최종값 저장
							}
						}
						//현재 궁수가 최종 사냥할 목표 ->last[0][1]
					}
					if(!shoot.contains(new int[]{last[0],last[1]})&&isKill) {//이미 있으면
						shoot.offer(new int[]{last[0],last[1]});
					}
				}

			}
			while(!shoot.isEmpty()) {
				int isShoot[]=shoot.poll();
				int x=isShoot[0];
				int y=isShoot[1];
				if(curmap[x][y]==1) {//값이 살아있으면 죽이고 카운트++ 앞에서 죽인애 또 죽이기 가능
					curmap[x][y]=0;
					killCnt++;
				}
			}
			for(int i=0;i<c;i++) {//한턴이 끝나면 궁수자리 앞으로
				curmap[tc-1]=curmap[tc];//궁수자리 위로 이동
			}
			
		}

		if(maxKill<killCnt) {
			maxKill=killCnt;
		}
	}
	
	
	static void comb(int start,int cnt) {
		if(cnt==3) {	//3개를 뽑았으면
		Arrays.fill(map[r], 0);//궁수 자리 초기화
		for(int i=0;i<3;i++) {
			map[r][archerPos[i]]=1;//조합으로 뽑은 궁수 자리 지정
		}
		int[][] curMap=new int[r+1][c];
		for(int i=0;i<r+1;i++) {
			for(int j=0;j<c;j++) {//맵 데이터 저장
				curMap[i][j]=map[i][j];
			}
		}
		shooting(curMap);
		return;
		}
		for(int i=start;i<c;i++) {
			archerPos[cnt]=i;
			comb(i+1,cnt+1);
		}
			
			
	}
	
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[]st= br.readLine().split(" ") ;
		r=Integer.parseInt(st[0]);//행의 수
		c=Integer.parseInt(st[1]);//열의 수 
		d=Integer.parseInt(st[2]);//궁수의 최대 공격거리
		map=new int[r+1][c];//r*c맵+궁수자리까지 r+1행 배열 생성
		archerPos=new int[3];
		visited=new boolean[c];
		for(int i=0;i<r;i++) {
			st= br.readLine().split(" ") ;
			for(int j=0;j<c;j++) {//맵 데이터 저장
				map[i][j]=Integer.parseInt(st[j]);
			}
		}
		comb(0,0);
		System.out.println(maxKill);
			
	}
}