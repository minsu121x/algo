package 박윤환;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class P018_SWEA1228_암호문1 {

	public static void main(String[] args) throws Exception {
//		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for(int tc=1; tc<=10; tc++) {	// 테스트 케이스 10개 반복
			int N = Integer.parseInt(br.readLine());	// 입력되는 암호문의 개수
			List<Integer> plain = new ArrayList<>();	// 암호문을 저장할 리스트
			String[] st = br.readLine().split(" ");
			
			for(int i=0; i<N; i++) {
				plain.add(Integer.parseInt(st[i]));		// 초기 암호문을 저장
			}
			
			int M = Integer.parseInt(br.readLine());	// 명령의 개수
			st = br.readLine().split(" ");
			int into = 0;	// 삽입할 위치를 저장하는 변수
			int num = 0;	// 삽입할 암호문의 개수를 저장하는 변수
			for(int i=0; i<st.length; i++) {	// 명령어 개수 만큼 반복
				if(st[i].equals("I")) {		// I로 시작하면 명령 시작
					into = Integer.parseInt(st[++i]);	// 삽입할 위치
					num = Integer.parseInt(st[++i]);	// 삽입할 암호문의 개수
					List<Integer> order = new ArrayList<>();	// 현재 삽입할 암호문을 저장하기 위한 리스트
					for(int j=0; j<num; j++) {
						order.add(Integer.parseInt(st[++i]));	// 삽입할 암호문을 저장
					}
					plain.addAll(into, order);	// 삽입할 위치에 암호문을 삽입
				}
			}
			
			sb.append("#").append(tc).append(" ");
			for(int i=0; i<10; i++) {
				sb.append(plain.get(i)).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
		
		
	}

}
