package 조민수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;


public class P045_BJ1260_DFS와BFS {
	static int[][] graph;//정점과 간선 정보 저장
	static boolean[]visited;//방문여부 탐색
	static int vertex;
	static int node;
	static int start;
	static Queue<Integer> bfsQ;

	
	static void doBFS() {
		while(!bfsQ.isEmpty())
		{
			int v=bfsQ.poll();
			System.out.print(v+" ");//꺼내는 순서대로 출력
			for(int i=1;i<=vertex;i++) {//모든 정점을 수가 작은수부터 탐색
				if(graph[i][v]==1&&visited[i]==false) {//해당 정점이 현재 정점과 연결되어있고 방문한적이 없다
					visited[i]=true;
					bfsQ.offer(i);//queue에 저장	
				}
			
			}
		}
	}
	
	static void doDFS(int v ) {
		visited[v]=true;
		System.out.print(v+" ");
		for(int i=1;i<=vertex;i++) {//모든 정점을 수가 작은수부터 탐색
			if(graph[i][v]==1&&visited[i]==false) {//해당 정점이 현재 정점과 연결되어있고 방문한적이 없다
				doDFS(i);
			}
		
		}
	}
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		String [] st= br.readLine().split(" ");
		vertex=Integer.parseInt(st[0]);
		node=Integer.parseInt(st[1]);
		start=Integer.parseInt(st[2]);
		visited=new boolean[vertex+1];//편의상 1부터 사용
		graph=new int[vertex+1][vertex+1];//편의상 1부터 사용
		for(int i=0;i<node;i++) {
			st=br.readLine().split(" ");
			graph[Integer.parseInt(st[0])][Integer.parseInt(st[1])]=graph[Integer.parseInt(st[1])][Integer.parseInt(st[0])]=1;//서로 연결된 정점은 1로 표기->대칭이므로 양쪽 다 표기
		}
		doDFS(start);//DFS 수행
		Arrays.fill(visited,false);//방문 배열 초기화
		System.out.println();
		bfsQ=new ArrayDeque<Integer>();
		bfsQ.offer(start);
		visited[start]=true;
		doBFS();
		
	}

}
 