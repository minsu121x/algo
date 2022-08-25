package 조민수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class P058_SWEA1251_하나로_프림인접리스트 {

	static class Node{
		int vertex;
		double weight;
		Node next;
		public Node(int vertex, double weight, Node next) {

			this.vertex = vertex;
			this.weight = weight;
			this.next = next;
		}
		public Node(int vertex, double weight) {
			this.vertex = vertex;
			this.weight = weight;
		}
	 
		
		
	}
	
	
	
	

	static double E;
	static double distance(int x1, int y1, int x2, int y2) {//거리 가중치
		return E*Math.abs(Math.pow(x2-x1,2)+Math.pow(y2-y1,2));
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		
		int T= Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=T;tc++) {
			int N=Integer.parseInt(br.readLine());
			int[]X= new int[N];
			int[]Y= new int[N];	
			
			String[]st1=br.readLine().split(" ");
			String[]st2=br.readLine().split(" ");
			
			for(int i=0;i<N;i++) {
				X[i]=Integer.parseInt(st1[i]);
				Y[i]=Integer.parseInt(st2[i]);
			}
			E=Double.parseDouble(br.readLine());
			Node[] adjList=new Node[N];
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(i==j)continue;
					adjList[i]=new Node(j,distance(X[i],Y[i],X[j],Y[j]),adjList[i]);
				}
			}
			
			double[] minEdge =new double[N];
			boolean[] visited = new boolean[N];//신장트리에 포함여부
			
			Arrays.fill(minEdge,Long.MAX_VALUE);
			
			minEdge[0]=0;
			double result=0;
			PriorityQueue<Node> pQueue = new PriorityQueue<>(Comparator.comparingDouble(v -> v.weight));
			pQueue.offer(new Node(0, minEdge[0])); // 시작점인 0번 정점 추가
			int cnt=0;
			while(!pQueue.isEmpty()) {
				Node minVertex= pQueue.poll();
				if(visited[minVertex.vertex]) continue;
				visited[minVertex.vertex]=true;
				result+=minVertex.weight;
				if(++cnt==N)break;
				
				for(Node temp = adjList[minVertex.vertex];temp!=null;temp=temp.next) {
					if(!visited[temp.vertex]&&minEdge[temp.vertex]>temp.weight) {
						minEdge[temp.vertex]=temp.weight;
						pQueue.offer(new Node(temp.vertex,minEdge[temp.vertex]));
					}
				}
			}
			System.out.println("#"+tc+" "+Math.round(result));
		}
	}

}
