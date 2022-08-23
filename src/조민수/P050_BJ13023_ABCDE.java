package 조민수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Queue;

public class P050_BJ13023_ABCDE {
	static ArrayList<Integer>[] node;
	static int result;
	
	
	static void DFS(boolean[] isVisited, int start, int cnt) {
		if(cnt>=5) {
			result=1;
			return;
		}
		isVisited[start]=true;
		for(int i=0;i<node[start].size();i++){
			int next=node[start].get(i);
			if(!isVisited[next]) {
				DFS(isVisited,next,cnt+1);
			}	
		}isVisited[start]=false;
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] st=br.readLine().split(" ");
		int N=Integer.parseInt(st[0]);
		int M=Integer.parseInt(st[1]);
		int[][] link=new int[M][2];
		node =new ArrayList[N];
		result=0;
		for(int i=0;i<N;i++) {
			node[i]=new ArrayList<Integer>();
		}
		boolean[] isVisited;
		for(int i=0;i<M;i++) {
			 st=br.readLine().split(" ");
			 link[i][0]=Integer.parseInt(st[0]);
			 link[i][1]=Integer.parseInt(st[1]);
			 node[link[i][0]].add(link[i][1]);
			 node[link[i][1]].add(link[i][0]);
			 //링크(연결관계)값 저장
		}
		for(int i=0;i<N;i++) {
			isVisited=new boolean[N]; //노드의 방문여부 확인
			isVisited[i]=true;
			int cnt=1;
			DFS(isVisited,i,cnt);
			if(result==1) {
				break;
			}

		}
		System.out.println(result);
		return;
		
	}
}

