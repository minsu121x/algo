package 조민수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class P053_SWEA7465_창용마을무리의개수 {

	static int find(int[] parent, int a) {
		if(parent[a]==a) {
			return a;
		}
		return find(parent,parent[a]);
	}
	
	
	static void union(int[] parent, int a, int b) {
		int parentA= find(parent,a);
		int parentB= find(parent,b);
		
		if(parentA>parentB) {
			parent[parentA]=parentB;
		}
		else {
			parent[parentB]=parentA;
		}
			

	}
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		StringBuilder sb= new StringBuilder();
		
		for(int tc=1;tc<=T;tc++) {
			HashSet <Integer>  set= new HashSet<>();
			String[] st=br.readLine().split(" ");
			int N=Integer.parseInt(st[0]);
			int M=Integer.parseInt(st[1]);
			int []parent =new int[N+1];
			
			
			for(int i=1;i<=N;i++) {
				parent[i]=i;
			}
			int [][] edge=new int[M][2];
			for(int i=0;i<M;i++) {
				st=br.readLine().split(" ");
				edge[i][0]=Integer.parseInt(st[0]);
				edge[i][1]=Integer.parseInt(st[1]);
			}
			for(int[] e:edge) {
				int a=e[0];
				int b=e[1];
				union(parent,a,b);
			}
			for(int i=1;i<=N;i++) {
				set.add(find(parent,i));
			}
			 sb.append("#").append(tc).append(" ").append(set.size()).append("\n");  // HashSet의 크기가 집단의 개수
		}
		System.out.println(sb);
	}

}
