package 박윤환;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class P015_BJ12891_DNA비밀번호 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String[] st = br.readLine().split(" ");
		int S = Integer.parseInt(st[0]);	// DNA 문자열 길이
		int P = Integer.parseInt(st[1]);	// 사용할 문자열 길이
		char[] DNA = br.readLine().toCharArray();	// DNA 문자열을 char 배열로
		Queue<Character> dq1 = new ArrayDeque<>();	// ArrayDeque를 Queue로 사용
		for (char d : DNA) {	// 첫번째 Queue에 DNA 문자열을 전부 저장
			dq1.offer(d);
		}
		Queue<Character> dq2 = new ArrayDeque<>();	// 두번째 Queue
		
		st = br.readLine().split(" ");
		int[] cmp = new int[4];		// 포함되어야할 문자 개수를 저장하는 배열
		int[] cnt = new int[4];		// 암호로 사용할 문자열에 포함된 문자별 개수를 저장하는 배열
		for(int i=0; i<4; i++) {
			cmp[i] = Integer.parseInt(st[i]);
		}
		
		for(int i=P; i>0; i--) {	// 사용할 문자열 크기만큼 반복
			char c = dq1.poll();	// 첫번째 Queue에 저장한 문자를 하나씩 꺼냄
			switch(c) {		// 각 문자마다 나온 갯수를 올림
				case 'A':
					cnt[0]++;
					break;
				case 'C':
					cnt[1]++;
					break;
				case 'G':
					cnt[2]++;
					break;
				case 'T':
					cnt[3]++;
					break;
			}
			dq2.offer(c);	// 꺼낸 문자를 2번째 Queue에 저장
		}
		
		int result = 0;		// 비밀번호 종류의 수
		
		for(int i=0; i<4; i++) {	// 포함되어야할 개수와 실제 포함된 개수를 비교
			if(cmp[i] > cnt[i]) {	// 하나라도 만족 못할경우 비밀번호로 사용 불가
				break;
			}
			if(i == 3) {	// 전부 만족할 경우 비밀번호로 사용 가능
				result++;
			}
		}
		
		while(!dq1.isEmpty()) {	// Queue가 비워질때까지 반복
			char c = dq1.poll();	// 첫번째 Queue에 저장한 문자를 하나씩 꺼냄
			switch(c) {		// 각 문자마다 나온 갯수를 올림
				case 'A':
					cnt[0]++;
					break;
				case 'C':
					cnt[1]++;
					break;
				case 'G':
					cnt[2]++;
					break;
				case 'T':
					cnt[3]++;
					break;
			}
			dq2.offer(c);	// 꺼낸 문자를 2번째 Queue에 저장
			
			c = dq2.poll();	// 2번째 Queue에서 문자를 하나씩 꺼냄
			switch(c) {		// 각 문자마다 나온 갯수를 내림
			case 'A':
				cnt[0]--;
				break;
			case 'C':
				cnt[1]--;
				break;
			case 'G':
				cnt[2]--;
				break;
			case 'T':
				cnt[3]--;
				break;
			}
			
			for(int i=0; i<4; i++) {	// 포함되어야할 개수와 실제 포함된 개수를 비교
				if(cmp[i] > cnt[i]) {	// 하나라도 만족 못할경우 비밀번호로 사용 불가
					break;
				}
				if(i == 3) {	// 전부 만족할 경우 비밀번호로 사용 가능
					result++;
				}
			}
		}
		
		sb.append(result);
		
		System.out.println(sb);
		
		br.close();
		
	}

}
