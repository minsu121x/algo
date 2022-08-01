package 조민수;

import java.util.Scanner;

public class P003_BJ1244_스위치켜고끄기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 스위치 갯수 -스위치 상태-테스트 갯수 - 성별 스위치위치 
		//남자 1 여자 2
		//남자-입력수 배수	 여자-입력수 좌우대칭 
		Scanner sc= new Scanner(System.in);
		int num=sc.nextInt();
		int []Switch=new int[num+1];//1부터 사용
		for(int i=1;i<Switch.length;i++) {
			Switch[i]=sc.nextInt();
		}
		
		int Tc=sc.nextInt();
		for(int t=1;t<=Tc;t++)
		{
			int gender = sc.nextInt();
			int pos = sc.nextInt();
			
			if(gender==1) {//남자면
				int m=1;//배수처리용
				while(pos*m<=num){
					Switch[pos*m]=change(Switch[pos*m]);
					m++;
				}
			}
			else{//여자면
				int d=1;//대칭확인변수
				Switch[pos]=change(Switch[pos]);
				while(pos-d>0&&pos+d<=num)
				{
					if((Switch[pos-d]==Switch[pos+d])) {
					Switch[pos-d]=change(Switch[pos-d]);
					Switch[pos+d]=change(Switch[pos+d]);
					d++;
					}
					else break;
				}
			}
		}
		
		for (int i = 1; i < Switch.length; i++) {
			System.out.print(Switch[i]+" ");
			if(i%20==0)
			{
				System.out.println();
			}
		}
	}
	static int change(int n) {
		if(n==0)return 1;
		else return 0;
	}
}
