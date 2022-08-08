package 조민수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P019_BJ1158_요세푸스문제 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int N=0;
		int K=0;
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String st= br.readLine();
		String[] str= st.split(" ");
		N=Integer.parseInt(str[0]);//전체 길이
		K=Integer.parseInt(str[1]);//제거할 자리수
		boolean[] isRemoved= new boolean[N+1];//좌석.1부터 사용
		int [] removed= new int[N];//제거된 순으로 저장
		int clear=0;//N이 다 나올때까지 반복
		int cnt=0;
		while(clear!=N) {//다 제거될 때 까지 반복
			
			for(int i=1;i<=N;i++) {
				if(isRemoved[i]==false)//i번이 살아있다
				{
					cnt++;//cnt++
					if(cnt==K) {//내가 없앨 값이다.
						isRemoved[i]=true;//없앴다고 표기
						removed[clear]=i;//값 저장
						clear++;
						cnt=0;//cnt 초기화
					}
				}
			}
			
		}
		System.out.print("<");
		for(int i=0;i<N-1;i++) {
			System.out.print(removed[i]+", ");
		}
		System.out.print(removed[N-1]);
		System.out.print(">");
	}

	
}
