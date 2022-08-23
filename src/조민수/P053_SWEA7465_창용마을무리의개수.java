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
		return parent[a]=find(parent,parent[a]);
	}
	
	
	static boolean union(int[] parent, int a, int b) {
		int parentA= find(parent,a);
		int parentB= find(parent,b);
		
		if(parentA==parentB) {
			return false;
		}
		else {
			parent[parentB]=parentA;
			return true;
		}
	}
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		HashSet <Integer>  set= new HashSet<>();
		for(int tc=1;tc<=T;tc++) {
			String[] st=br.readLine().split(" ");
			int N=Integer.parseInt(st[0]);
			int M=Integer.parseInt(st[1]);
			int []parent =new int[N];
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
				if(union(parent,a,b)) {
					
				}
			}
			for(int i=1;i<=N;i++) {
				//set.add();
			}
		}
	}

}
