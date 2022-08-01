package 조민수;

import java.util.Scanner;

public class P001_SWEA1289_원재의메모리복구하기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);//일단 받아옵니다..
		int cnt= sc.nextInt();// 반복횟수
		for (int i=1;i<=cnt;i++)//돌리고
		{
			int result=0;
			String num=sc.next();//문자열로 값 받기 -> 길이를 볼라고
			int []mem= new int[num.length()];//저장할 배열 생성
			for(int j=0;j<num.length();j++) {//길이만큼 돌면서
				mem[j]=Integer.parseInt(num.substring(j,j+1));//쪼개서 저장 배열에
			}
			 
			result=writeCount(mem);
			
			System.out.println("#"+i+" "+result );
			
		}	
		sc.close();
	}
	public static int writeCount(int[] mem) {
		int Switch=0;//값 변화를 보는 변수   얘가 1이고   
		int result=0;//결과값 저장
		for(int i=0;i<mem.length;i++){
			if(mem[i]==0&&Switch==0)
			{
				continue;
			}
			else if(mem[i]==1&&Switch==1)
			{
				continue;
			}
			else {
				result++;
				if(Switch==1) Switch=0;
				else Switch=1;
			}
		}
		return result;
	}
}
