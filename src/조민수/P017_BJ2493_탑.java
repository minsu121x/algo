package 조민수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class P017_BJ2493_탑 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());//탑 개수 입력
		Stack<int[]> topStack= new Stack<>();//탑의 높이+인덱스를 저장  
		StringTokenizer tk= new StringTokenizer(br.readLine());//하나씩 받는다.
		for(int i=1;i<=N;i++) {
		  	 int top = Integer.parseInt(tk.nextToken());//현재 탑의 높이
	         while(!topStack.isEmpty()) {//저장된 탑을 전체확인
	             if(topStack.peek()[1] >= top) {//지금 탑의 높이보다 높거나 같은 탑이 있다->레이져에 맞았다
	                 System.out.print(topStack.peek()[0] + " ");//레이져가 맞은 인덱스를 출력
	                 break;
	             }
	             topStack.pop();//레이져에 맞지 않았다->굳이 가지고 있을 필요 X
	         }
	         if(topStack.isEmpty()) {//스택이 비어있으면 레이져 맞는거 X
	             System.out.print("0 ");// 0 출력
	         }
	         topStack.push(new int[] {i, top}); //현재 값 스택에 저장
		}
	}

}
