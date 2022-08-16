package 조민수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P035_BJ2839_설탕배달 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int cnt=0;	
		cnt+=N/5; //일단 5로 최대치를 채운다
		N=N%5;
		if(N%3==0) {// 나머지가 3으로 떨어진다
			cnt+=N/3; //5로 채우고 나머지를 3으로 채우는게 제일 베스트
		}
		else {//떨어지지 않으면  5를 하나씩 빼면서 나눠지는지 확인
			while(cnt!=0) {
				N=N+5;// 5 하나씩 빼옴
				cnt--;//cnt는 하나씩 감소
				if(N%3==0) {// 현재 나머지+5가 3으로 떨어진다
					cnt+=N/3; //3으로 나눠진 값 더하기
					break;
				}
				
			}
			if(cnt==0) {//다 돌려봤는데 못나눴다.
				cnt=-1;//-1 출력
			}
		}
		//상근아 힘내...
		System.out.println(cnt);
	}

}
