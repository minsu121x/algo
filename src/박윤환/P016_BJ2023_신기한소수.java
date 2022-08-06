package 박윤환;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P016_BJ2023_신기한소수 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());	// N자리 수 중에서만
		
 		int under = (int) Math.pow(10, N-1); // N자리 가장 작은 수
 		int bound = (int) Math.pow(10, N);	// N자리 가장 큰 수 + 1
 		int scale = under;	// 왼쪽부터 1~N자리 계산을 위해 나누는 수
 		for(int i=under; i<bound; i++) {	// N자리 수 탐색
 			// 앞자리 수가 소수인 경우만
			if(i / scale == 2 || i / scale == 3 
					|| i / scale == 5 || i / scale == 7) {
				// 그 다음 자리수까지가 소수인지 판별
				if(isPrime(scale/10, i)) {
					sb.append(i).append("\n");	// N자리까지 모두 소수였을 경우 출력결과물에 추가
				}
			}
 		}
		
		System.out.println(sb);
		
		br.close();
	}
	
	// 주어진 수에서 왼쪽부터 특정 자리수까지 소수인지 판별하는 메소드
	static boolean isPrime(int scale, int n) {
		// N자리수까지 전부 소수였다면 true 반환
		if(scale == 0) {
			return true;
		}
		int num = n / scale;	// 특정 자리수까지의 수 num
		for(int i = 2; i<=Math.sqrt(num); i++) { // 2부터 num의 제곱근까지의 정수 중에서
			if(num % i == 0) {	// num을 나눌 수 있는 수가 있다면
				return false;	// false 반환
			}
		}
		return isPrime(scale/10, n);	// 그 다음 자리수까지 소수인지 다시 재귀적으로 판별
	}

}
