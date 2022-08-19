package 조민수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.sun.imageio.plugins.common.InputStreamAdapter;

public class P999_과목평가대비_13일_금요일 {

	static int year=2019;//2019년부터 시작
	static int[] month_13Fri=new int[] {0,6,2,2,5,0,3,5,1,4,6,2,4,};//각 달의 13일의 요일을 1~12칸에 저장(0은 계산 편의를 고려해사용 X)
	//요일은 일요일부터 각각 0일 1월 2화 3수 4목 5금 6토
	//2018년을 표준기점으로 저장하고 
	//윤년이 아닐경우 -> 해마다 요일이 하나씩 밀림
	//윤년일 경우 -> 1-2월을 제외한 3~12월은 2일씩 밀림 1-2월은 마찬가지로 1일씩

	
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));//입력값을 저장하는 buffer
		int targetYear=Integer.parseInt(br.readLine());//목표 년 입력값으로 받아 저장
		int numOf13Fri=0;//13일의 금요일의 총합
		for(int i=year;i<=targetYear;i++) {
			if(i%400==0||(i%100!=0&&i%4==0)) {//400의 배수이거나 100의 배수가 아니면서 4의 배수면 윤달
				//이번년이 윤년이다.
				//전체적으로 2일씩 밀리지만 1-2월 13일은 2월29일 전이기 때문에 1일만 밀고 확인 후 나머지 1일을 민다.
				month_13Fri[1]=(month_13Fri[1]+1)%7;//작년 요일에 한칸 밀기 요일이 넘어가면(토->일) %7로 초기화 
				if(month_13Fri[1]==5)numOf13Fri++;//올해 1월13일이 금요일이다 -> 카운트 추가
				month_13Fri[1]=(month_13Fri[1]+1)%7;
				month_13Fri[2]=(month_13Fri[2]+1)%7;//작년 요일에 한칸 밀기 요일이 넘어가면(토->일) %7로 초기화
				if(month_13Fri[2]==5)numOf13Fri++;//올해 2월13일이 금요일이다 -> 카운트 추가
				month_13Fri[2]=(month_13Fri[2]+1)%7;
				//1 2월은 한칸씩만
				for(int j=3;j<=12;j++) {
					month_13Fri[j]=(month_13Fri[j]+2)%7;//윤년->작년 요일에 두칸씩 밀기 요일이 넘어가면(토->일) %7로 초기화 
					if(month_13Fri[j]==5)numOf13Fri++;//올해 j월13일이 금요일이다 -> 카운트 추가

				}
			}
			//윤년이 아닐경우
			else {
				for(int j=1;j<=12;j++) {
					month_13Fri[j]=(month_13Fri[j]+1)%7;//모든 달에 대해 작년 요일에 한칸씩 밀기 요일이 넘어가면(토->일) %7로 초기화 
					if(month_13Fri[j]==5) numOf13Fri++;//올해 j월13일이 금요일이다 -> 카운트 추가

				}
			}
			
		}
		System.out.println(numOf13Fri);//결과값 출력
	}

}
