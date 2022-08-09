package 박윤환;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class P005_SWEA1210_Ladder1 {

	public static void main(String[] args) throws Exception {
//		System.setIn(new FileInputStream("input2.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		for(int tc=1; tc<=10; tc++) { // 테스트 케이스 10번 반복
			int T = Integer.parseInt(br.readLine());
			int start = 0;
			int[][] ladders = new int[100][100];	// 사다리 배열 초기화
			for(int i=0; i<100; i++) {	// 사다리 내용 초기화
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0; j<100; j++) {
					ladders[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for(int j=0; j<100; j++) {
				if(ladders[0][j] == 1) {	// 사다리 시작 부분일 경우 시작
					start = j;
					if(path(ladders, start) == 2) {	// 최종 도착점이 2일 경우 
						break;
					}
				}
			}
			
			bw.write("#" + T + " " + start);
			bw.newLine();
			
		}
		
		bw.flush();
		bw.close();
		br.close();
		
	}
	
	// 사다리의 특정 시작점에서의 도착값 반복
	static int path(int[][] ladders, int j) {
		int i = 0;
		while(i < 99) {		// 제일 아래 도달할때까지 반복
			int direction = 0;	// 좌, 우 방향을 나타내는 변수
			while(j > 0 && ladders[i][j-1] == 1) {	// 왼쪽으로 갈 수 있을 경우
				j--;	// 갈 수 있을때까지 왼쪽으로
				direction = -1;
			}
			if(direction == -1) {	// 왼쪽 방향으로 다 갔으면
				i++;				// 아래로 한칸 내려가
				continue;			// 다시 while 처음으로
			}
			while(j < 99 && ladders[i][j+1] == 1) {	// 오른쪽으로 갈 수 있을 경우
				j++;	// 갈 수 있을때까지 오른쪽으로
				direction = 1;
			}
			if(direction == 1) {	// 오른쪽 방향으로 다 갔으면
				i++;				// 아래로 한칸 내려가
				continue;			// 다시 while 처음으로
			}
			i++;	// 좌 우 갈 곳 없을 경우 아래로
		}
		return ladders[i][j];	// 도착값 반환
	}
}
