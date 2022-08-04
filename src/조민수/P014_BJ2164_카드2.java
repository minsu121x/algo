package 조민수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class P014_BJ2164_카드2 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		Queue<Integer> card=new LinkedList<>();//Linkedlist로 입력 카드 저장
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int num=Integer.parseInt(br.readLine());
		for (int i = 1; i <=num; i++) {
			card.offer(i);//카드에 값 저장 1~N
		}
		while(card.size()!=1) {//한장 남을때까지 회전
			int BackCard=0;
			card.poll();//첫장 버리기
			BackCard=card.poll();//다음장 저장
			card.offer(BackCard);//맨뒤로 더하기
		}
		System.out.println(card.poll());
	}
	
	//제일 심플한 알고리즘이다
	
	

}
