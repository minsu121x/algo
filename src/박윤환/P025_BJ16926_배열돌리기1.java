package 박윤환;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P025_BJ16926_배열돌리기1 {
	
	static final int[] dx = {0, 1, 0, -1};
	static final int[] dy = {1, 0, -1, 0};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String[] st = br.readLine().split(" ");
		int N = Integer.parseInt(st[0]);	// 배열의 행 크기
		int M = Integer.parseInt(st[1]);	// 배열의 열 크기
		int R = Integer.parseInt(st[2]);	// 회전할 횟수
		
		int[][] arr = new int[N][M];	// NxM 크기의 2차원 배열
		for(int i=0; i<N; i++) {
			st = br.readLine().split(" ");
			for(int j=0; j<M; j++) {
				arr[i][j] = Integer.parseInt(st[j]);	// 배열 저장
			}
		}
		
		int count = (N > M ? M : N) / 2;	// 배열 안에 회전해야할 그룹의 갯수
		
		for(int i=0; i<R; i++) {	// 회전할 횟수만큼 반복
			for(int j=0; j<count; j++) {	// 그룹 개수만큼 반복
				int x = j;	// 시작 지점의 x
				int y = j;	// 시작 지점의 y
				int dir = 0;	// 방향 지정 변수
				int temp = arr[x][y];	// 시작지점을 임시로 저장하여 회전이 끝나고 마지막 빈자리에 채워준다
				
				while(dir < 4) {	// 우, 하, 좌, 상 순서로 옮김
					int nx = x + dx[dir];	// x의 다음 위치
					int ny = y + dy[dir];	// y의 다음 위치
					
					if(nx >= N-j || nx < j || ny >= M-j || ny < j) { // 배열의 범위를 벗어날 경우
						dir++;	// 방향을 전환
					} else {	// 범위내 일경우
						arr[x][y] = arr[nx][ny];	// 다음 수를 현재 위치에 저장
						x = nx;		// x 다음 위치로 이동
						y = ny;		// y 다음 위치로 이동
					}
				}
				arr[x+1][y] = temp;	// 임시저장해둔 시작지점값을 마지막 빈자리에 채움
			}
		
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				sb.append(arr[i][j]).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
		
		
	}

}
