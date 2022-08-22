package 조민수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;

public class P049_SWEA1238_Contact {
static Queue<int[]> node;//{시작 정점,도착정점,차수}
static HashSet<Integer> isvisited;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int T=10; //테스트케이스
		for(int tc=1;tc<=T;tc++) {
			node=new ArrayDeque<int[]>();
			int cnt=0;//차수 저장
			int last=0;// 최종값 저장
			
			String[] st=br.readLine().split(" ");	
			isvisited=new HashSet<Integer>();
			int N=Integer.parseInt(st[0]);//전체 입력
			int start=Integer.parseInt(st[1]);//시작점
			int[][] graph=new int[N/2][2];//그래프값 저장 [i][0]->[i][1]로 가는 그래프 
			st=br.readLine().split(" ");
			for(int i=0;i<N/2;i++) {
				graph[i][0]=Integer.parseInt(st[2*i]);
				graph[i][1]=Integer.parseInt(st[2*i+1]);
				if(graph[i][0]==start) {//입력값이 start 지점이면 저장
					node.offer(new int[] {graph[i][0],graph[i][1],cnt});
				}
			}
			//지금부터 탐색 시작
			while(!node.isEmpty()) {
				int[]v=node.poll(); //지금 노드 출발점 도착점 지금 차수값 0
				int v0=v[0];
				int v1=v[1];
				int v2=v[2];
				isvisited.add(v[0]);
				if(v[2]>cnt&&!isvisited.contains(v[1])) { //다음차수가 나왔다
					cnt=v[2];
					last=v[1];//마지막차수 값이 얼마든 마지막 차수값 저장
				}
				else if(v[2]==cnt&&last<v[1]&&!isvisited.contains(v[1])) {//지금 차수에서 제일 크다
					last=v[1];//제일 큰 값 저장
				}
				if(!isvisited.contains(v[1])) {//다음 칸을 간적이 없다
					isvisited.add(v[1]);
					for(int i=0;i<N/2;i++) {
						if(graph[i][0]==v[1]) {
							node.offer(new int[] {graph[i][0],graph[i][1],cnt+1});//다음 노드 추가
						}
					}
					
				}
				
			}
			System.out.println("#"+tc+" "+last);
		}
	}

}
