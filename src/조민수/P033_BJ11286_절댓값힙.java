package 조민수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class P033_BJ11286_절댓값힙 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		PriorityQueue<Integer> absHeap=new PriorityQueue<>((a,b)->{//우선순위 큐에 저장
			return Math.abs(a)==Math.abs(b)? a-b:Math.abs(a)-Math.abs(b);//우선순위: 절댓값으로 비교 후 값이 다르면 숫자순정렬 같으면 부호포함정렬
					});
		
		
		int N =Integer.parseInt(br.readLine());//입력받을 연산 수
		
		for(int i=0;i<N;i++){
			int x=Integer.parseInt(br.readLine());//연산 입력
			if(x!=0) {//0이 아니면
				absHeap.offer(x);//우선순위 큐에 저장
			}
			else {//입력값이 0이면
				if(absHeap.size()==0) {//큐가 비었는지 확인
					sb.append(0).append("\n");//비었으면 0 sb에 저장
				}
				else {
					sb.append(absHeap.poll()).append("\n");//큐가있으면 큐의 제일 앞값 sb에 저장
				}
			}
			
		}
		System.out.println(sb);//sb 출력
	}

}
