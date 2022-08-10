package 박윤환;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P027_BJ1010_다리놓기 {

	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			String[] st = br.readLine().split(" ");
			int r = Integer.parseInt(st[0]);	// 서쪽 사이트 개수
			int n = Integer.parseInt(st[1]);	// 동쪽 사이트 개수
			long result = 0;
			
			// 동쪽 사이트에서 어떤 서쪽 사이트와 연결할 지를 고르므로 nCr
			// nCr = n! / (n-r)!r!
			int bigger = n-r > r ? n-r : r;		// n-r과 r중 큰수
			int smaller = n-r > r ? r : n-r;	// n-r과 r중 작은수
			long rFac = 1L;		// 분자
			long nFac = 1L;		// 분모
			
			// 분자를 n-r과 r중 큰 번호의 다음수부터 n까지의 곱으로 구하고
			for(int i=bigger+1; i<=n; i++) {	
				rFac = rFac * i;
			}
			// 분모를 n-r과 r중 작은 번호의 factorial로 한다.
			for(int i=1; i<=smaller; i++) {
				nFac = nFac * i;
			}
			
			// nCr
			result = rFac / nFac;
			
			sb.append(result).append("\n");
		}
		
		System.out.println(sb);
	}

}
