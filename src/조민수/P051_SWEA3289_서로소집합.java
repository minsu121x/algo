package 조민수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P051_SWEA3289_서로소집합 {

	
	static int[] MakeSet(int size) {
		int[] arr=new int [size+1];
		for(int i=0;i<arr.length;i++) {
			arr[i]=i;
		}
		return arr;
	}
	
	static void union (int[]parent,int a,int b) {
		a=find(parent,a);
		b=find(parent,b);
		if(a>b) {
			parent[a]=b;
		}
		else {
			parent[b]=a;
		}
	}
	
	static int find(int[] parent,int x) {
		if(parent[x]==x) {
			return x;
		}
		else {
			return find(parent,parent[x]);
		}
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb;
		String st=br.readLine();
		int T=Integer.parseInt(st);
		for (int tc=1;tc<=T; tc++) {
			sb=new StringBuilder();
			String[] str=br.readLine().split(" ");
			int N=Integer.parseInt(str[0]);
			int M=Integer.parseInt(str[1]);
			int []parent=MakeSet(N);
			for(int i=0;i<M;i++) {
				str=br.readLine().split(" ");
				int state=Integer.parseInt(str[0]);
				int a=Integer.parseInt(str[1]);
				int b=Integer.parseInt(str[2]);
				if(state==0) {
					union(parent,a,b);
				}
				else if(state==1) {
					if(find(parent,a)==find(parent,b)) {
						sb.append("1");
					}
					else {
						sb.append("0");
					}
				}
			}
			System.out.println("#" +tc+" "+sb);
		}
		
	}

}
