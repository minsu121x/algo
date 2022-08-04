package 박윤환;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class P012_SWEA1218_괄호짝짓기 {

	public static void main(String[] args) throws Exception {
//		System.setIn(new FileInputStream("input1.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for(int tc=1; tc<=10; tc++) {
			int n = Integer.parseInt(br.readLine());	// 괄호의 개수
			char[] ch = br.readLine().toCharArray();	// 괄호를 담을 char 배열
			Deque<Character> dq = new ArrayDeque<>();	// deque를 stack으로 활용
			int valid = 1;	// 유효성 확인 변수
			
			for (char c : ch) {	// 괄호 배열을 하나씩 탐색
				if(c == '(' || c == '[' || c == '{' || c == '<') {	// 여는 괄호일 경우는 스택에 무조건 삽입
					dq.offer(c);
				} else {	// 닫는 괄호일 경우
					if(dq.isEmpty()) {	// 스택이 비어 있을 경우에 닫는 괄호가 나온다면
						valid = 0;	// 유효하지 않은 경우 이므로 valid를 0으로
						break;		// 반복문 break
					}
					char now = dq.pollLast();	// 비어 있지 않을경우 마지막 요소를 꺼냄
					if(c == ')') {	// 현재 닫는 괄호가 무엇인지에 따라
						if(now != '(') {	// 마지막 요소가 알맞은 여는 괄호가 아닐 경우
							valid = 0;		// 유효하지 않은 경우 이므로 valid를 0으로
							break;			// 반복문 break
						}
					} else if(c == ']') {	// 위와 동일
						if(now != '[') {
							valid = 0;
							break;
						}
					} else if(c == '}') {	// 위와 동일
						if(now != '{') {
							valid = 0;
							break;
						}
					} else if(c == '>') {	// 위와 동일
						if(now != '<') {
							valid = 0;
							break;
						}
					}
				}
			}
			if(!dq.isEmpty()) {	// 괄호를 전부 처리하였지만 스택에 괄호가 남아있다면 유효하지 않은 경우이므로
				valid = 0;	// valid를 0으로
			}
			
			sb.append("#").append(tc).append(" ").append(valid).append("\n");
			
		}
		
		System.out.println(sb);
	}

}
