package 박윤환;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P031_BJ3040_백설공주와일곱난쟁이 {
	
	static final int N = 9;		// 모자 개수
	static final int R = 7;		// 난쟁이 수
	static int[] hat, dwarf;
	static StringBuilder sb;
	
	// 난쟁이가 쓸 모자를 고르는 메소드
	static void comb(int cnt, int start) {
		// 모자를 난쟁이 수만큼 골랐다면
		if(cnt == R) {
			int sum = 0;
			for (int d : dwarf) {	// 모자 번호의 합을 구한다
				sum += d;
			}
			if(sum == 100) {	// 합이 100이면
				for (int d : dwarf) {
					sb.append(d).append("\n");	// 결과 출력
				}
			}
			return;
		}
		
		// 가능한 모든 수에 대해 시도
		for(int i=start; i<N; i++) {
			// 앞쪽에서 선택되지 않았다면 수를 사용
			dwarf[cnt] = hat[i];
			// 다음 수 뽑으러 가기
			comb(cnt + 1, i+1);
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		hat = new int[N];	// 모자 배열
		dwarf = new int[R];	// 난쟁이 배열
		
		for(int i=0; i<N; i++) {
			hat[i] = Integer.parseInt(br.readLine());
		}
		
		comb(0, 0);
		
		System.out.println(sb);
		
	}

}
