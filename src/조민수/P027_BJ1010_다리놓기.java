package 조민수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P027_BJ1010_다리놓기 {
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc=Integer.parseInt(br.readLine());
		for(int i=1;i<=tc;i++) {
			String[] str= br.readLine().split(" ");
			int r=Integer.parseInt(str[0]);
			int n=Integer.parseInt(str[1]);//헷갈리니까 거꾸로 넣기 str[1]이 무조건 크거나 같다. str[1]->n
			int bigger= n-r>r? n-r:r;// 둘중에 큰값을 bigOne으로 가져감->값을조금이라도 줄이기위해
			int smaller= n-r>r? r:n-r;// 둘중에 큰값을 bigOne으로 가져감->값을조금이라도 줄이기위해
			long result=0;//최종 결과
			long rFac=1;//분자 !값
			long nFac=1;//분모 !값
			//동쪽 n에서 서쪽r 까지 연결할 수 있는 조합이므로 nCr
			//nCr= n!/(n-r)!*r!
			
				for(int j=bigger+1;j<=n;j++)//bigger까지의 값은 분모 분자 공통 약분->메모리+ 시간 줄이기
				{
					rFac=rFac*j;//분자 계산
				}
				for(int j=1;j<=smaller;j++ )//r이랑 n-r 중 작은값이 smaller에 저장되어 분모로 계산
				{
					nFac=nFac*j;//분모 계산
				}
				
				result=rFac/nFac ;    // 최종
			sb.append(result).append("\n");
			
		}
		System.out.println(sb);
	}

}
