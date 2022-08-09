package 박윤환;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class P023_SWEA1861_정사각형방 {	
	
	static int cnt;
	
	public static void main(String[] args) throws Exception {
//		System.setIn(new FileInputStream("input2.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());	// 테스트 케이스 갯수
		
		for(int tc=1; tc<=T; tc++) {
			int N = Integer.parseInt(br.readLine());	// 방의 크기
			int[][] room = new int[N][N];
			
			for(int i=0; i<N; i++) {
				String[] st = br.readLine().split(" ");
				for(int j=0; j<N; j++) {
					room[i][j] = Integer.parseInt(st[j]);	//	방의 내용 입력
				}
			}
			
			int max = 0;
			int start = 1000000;
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {	//	모든 방 탐색
					cnt = 1;
					nav(room, N, i, j);		// 상, 하, 좌, 우 재귀적 탐색
					if(max < cnt) {		// 이동한 방이 최대값보다 작으면
						start = room[i][j];		// 해당 방을 시작점으로
						max = cnt;				// 최대값 저장
					} else if(max == cnt) {		// 만약 최대값과 같다면
						start = Math.min(start, room[i][j]);	// 더 작은 번호를 시작점으로
					}
				}
			}
			
			sb.append("#").append(tc).append(" ").append(start).append(" ").append(max).append("\n");
		}

		System.out.println(sb);
		
	}
	
	static void nav(int[][] room, int N, int i, int j) {	// 방 탐색 메소드
		if(i > 0 && room[i-1][j] == room[i][j]+1) {		// 방을 벗어나지 않으면서 위쪽으로 이동했을때 번호가 1증가할 경우
			cnt++;		// 이동 횟수 증가
			nav(room, N, i-1, j);	// 계속 탐색
		}
		if(i < N-1 && room[i+1][j] == room[i][j]+1) {	// 방을 벗어나지 않으면서 아래쪽으로 이동했을때 번호가 1증가할 경우
			cnt++;		// 이동 횟수 증가
			nav(room, N, i+1, j);	// 계속 탐색
		}
		if(j > 0 && room[i][j-1] == room[i][j]+1) {		// 방을 벗어나지 않으면서 왼쪽으로 이동했을때 번호가 1증가할 경우
			cnt++;		// 이동 횟수 증가
			nav(room, N, i, j-1);	// 계속 탐색
		}
		if(j < N-1 && room[i][j+1] == room[i][j]+1) {	// 방을 벗어나지 않으면서 오른쪽으로 이동했을때 번호가 1증가할 경우
			cnt++;		// 이동 횟수 증가
			nav(room, N, i, j+1);	// 계속 탐색
		}
		
		return;
	}

}
