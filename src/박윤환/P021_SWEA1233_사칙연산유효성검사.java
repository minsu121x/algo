package 박윤환;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class P021_SWEA1233_사칙연산유효성검사 {

	public static void main(String[] args) throws Exception {
//		System.setIn(new FileInputStream("input1.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for(int tc=1; tc<=10; tc++) {
			int N = Integer.parseInt(br.readLine());	// 노드의 갯수
			int leafStart = N / 2 + 1;		// 노드가 N개일 경우에 리프노드의 시작번호
			sb.append("#").append(tc).append(" ");
			int result = 1;
			for(int i=1; i<=N; i++) {	//	마지막 노드까지 반복
				String[] st = br.readLine().split(" ");
				if(Integer.parseInt(st[0]) < leafStart) {	//	리프노드번호보다 작을경우
					if(!st[1].equals("+") && !st[1].equals("-")
							&& !st[1].equals("*") && !st[1].equals("/")) {	// 사칙연산이 아니면
						result = 0;		// 잘못된 식
					}
				} else {	// 리프노드번호 이상일 경우
					if(st[1].equals("+") || st[1].equals("-")
							|| st[1].equals("*") || st[1].equals("/")) {	// 사칙연산이라면
						result = 0;		// 잘못된 식
					}
				}
			}
			sb.append(result).append("\n");
		}
		
		System.out.println(sb);
	}

}
