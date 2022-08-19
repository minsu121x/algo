package 조민수;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P048_BJ1697_숨바꼭질{
	
	static int catch_Min;
	static int subin;
	static void catchSister(int sister,int catchCnt,int last) {
		System.out.println(catchCnt+"번째 재귀");
		System.out.println(sister+" "+subin);
		if(sister==subin) {//찾았다!
			System.out.println(catchCnt+"에서 찾았다!");
			if(catchCnt<catch_Min) {//현재 잡은 값이 최저다.
				catch_Min=catchCnt; //최저값 저장
			}
			return;
		}
		if(sister<=0) {//0보다 작아지면 볼 필요 X
			System.out.println(catchCnt+"번째 재귀는 끝");
			return;
		}
		if(last==1) {//이전 연산이 +였다 -> 이번 연산에 -하면 안됨!
			if(sister%2==0) {
				if(sister/2==0) {
					return;
				}
				catchSister(sister/2,catchCnt+1,0);
			}
			catchSister(sister+1, catchCnt+1,2);//현재 상태에서 -1한 값
		}
		else if(last==2) {//이전 연산이 -였다 -> 이번 연산에 +하면 안됨!
			if(sister%2==0) {
				catchSister(sister/2,catchCnt+1,0);
			}
			catchSister(sister-1, catchCnt+1,2);//현재 상태에서+1한 값
	
		}
		else {//0이다 -> 다 조사 가능
			System.out.println(sister+"어디");
			catchSister(sister-1, catchCnt+1,2);//현재 상태에서 -1한 값
			catchSister(sister+1, catchCnt+1,1);//현재 상태에서+1한 값
			if(sister%2==0) {
				catchSister(sister/2,catchCnt+1,0);
			}
		}
		
		

//		if(catchCnt>catch_Min) {//최저값을 구했을 때, 그것보다 크게 넘어가는 애들은 더 볼 필요가 없다..!
//			System.out.println(catchCnt+" 볼필요 없어!");
//			return;//백트래킹
//		}
//
//		if(subin>sister) {// 수빈이가 동생을 지나쳤다..!
//			System.out.println("지나쳤다");
//			catchSister(sister, catchCnt+(subin-sister));//현재 상태에서 동생 값까지 바로이동 
//		}
//		if(subin<0) {
//			return;
//		}
		
		
		
	}
	
	
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String []st =br.readLine().split(" ");
		//input -> (수빈이의 위치 ,동생의 위치)
		int sister= Integer.parseInt(st[0]);//수빈이의 위치
		subin= Integer.parseInt(st[1]);//동생의 위치
		System.out.println(sister+" "+subin);
		catch_Min=100000;
		catchSister(sister,0,0);
		System.out.println(catch_Min);
	} 
	
	
	
	
	
	
}
