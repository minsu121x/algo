package 박윤환;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class P004_SWEA1208_Flatten {

	public static void main(String[] args) throws Exception {
//		System.setIn(new FileInputStream("input1.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		for(int i=0; i<10; i++) {	// 10개의 테스트 케이스 반복
			ArrayList<Integer> list = new ArrayList<>();	// 상자가 쌓인 것을 list로 선언
			int cnt = Integer.parseInt(br.readLine());	//	덤프 횟수
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<100; j++) {	//	박스 초기화
				list.add(Integer.parseInt(st.nextToken()));
			}
			dump(list, cnt);	//	덤프 실행
			bw.write("#" + (i+1) + " " + getDiff(list));	// 결과값 출력
			bw.newLine();
		}
		
		bw.flush();
		bw.close();
		br.close();
		
	}
	
	// 덤프를 실행하는 메소드
	static void dump(ArrayList<Integer> list, int cnt) {
		for(int i=0; i<cnt; i++) {	// 덤프 횟수만큼 반복
			int max = Collections.max(list);	// 가장 높은 박스 개수
			int min = Collections.min(list);	// 가장 낮은 박스 개수
			if(max-min > 0) {	// 평탄화가 완료되지 않았을 경우
				int maxIndex = list.indexOf(max);	// 가장 높은 박스가 있는 위치
				int minIndex = list.indexOf(min);	// 가장 낮은 박스가 있는 위치
				list.set(maxIndex, max-1);		// 가장 높은 박스 개수-1
				list.set(minIndex, min+1);		// 가장 낮은 박스 개수+1
			} else {	// 평탄화가 완료 되었을 경우
				return;
			}
		}
	}
	
	// 가장 높은 박스개수와 가장 낮은 박스개수의 차이를 반환하는 메소드
	static int getDiff(ArrayList<Integer> list) {
		int max = Collections.max(list);
		int min = Collections.min(list);
		return max - min;
	}

}
