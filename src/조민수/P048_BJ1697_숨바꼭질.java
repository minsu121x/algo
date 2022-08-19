package 조민수;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Queue;

public class P048_BJ1697_숨바꼭질{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String []st =br.readLine().split(" ");
		//input -> (수빈이의 위치 ,동생의 위치)
		 int catch_Min=0;
		 int subin= Integer.parseInt(st[0]);//수빈이의 위치
		 int sister= Integer.parseInt(st[1]);//동생의 위치
		 Queue<Integer> pos=new ArrayDeque<>(); // 위치를 저장
		 Queue<Integer> move =new ArrayDeque<>();//위치까지 이동한 횟수
		 boolean[]visited = new boolean [100001];
	
		pos.offer(subin);//최초 위치
		move.offer(0);//최초 이동거리
		while(true) {
			int curPos=pos.poll();
			int curMove=move.poll();
			visited[curPos]=true;
			if(sister==curPos) {
				catch_Min=curMove;
				break;
			}
			if(2*curPos<=100000) {
				pos.offer(curPos*2);
				move.offer(curMove+1);
			}
			if(curPos>0&&!visited[curPos-1]) {
				pos.offer(curPos-1);
				move.offer(curMove+1);
			}
			if(curPos<100000&&!visited[curPos+1]) {
				pos.offer(curPos+1);
				move.offer(curMove+1);
			}
			
			
			
		}
		System.out.println(catch_Min);
	} 
	
	
	
	
	
	
}
