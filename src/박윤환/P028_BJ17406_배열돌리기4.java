package 박윤환;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P028_BJ17406_배열돌리기4 {

	static final int[] dx= {1, 0, -1, 0};	// 하, 우, 상, 좌
	static final int[] dy= {0, 1, 0, -1};	// 하, 우, 상, 좌
	
	static int N, M, K, min;
	static int[][] arr, opr, permOpr;
	static boolean[] visited;
	
	// 연산 순서를 정하는 메소드
	static void perm(int cnt) {
		if(cnt == K) {
			int[][] newArr = new int[N+1][];	// 원본을 저장하기 위한 복사본 배열
			for(int i=0; i<N+1; i++) {
				newArr[i] = Arrays.copyOf(arr[i], M+1);	// 원본을 deep copy
			}
			for(int i=0; i<K; i++) {
				newArr = turnArr(newArr, permOpr[i][0], permOpr[i][1], permOpr[i][2]);
			}
			for(int i=1; i<=N; i++) {
				int sum = 0;
				for(int j=1; j<=M; j++) {
					sum += newArr[i][j];
				}
				if(sum < min) {
					min = sum;
				}
			}
			return;
		}
		
		for(int i=0; i<K; i++) {
			if(!visited[i]) {
				visited[i] = true;
				permOpr[cnt] = opr[i];
				perm(cnt+1);
				
				visited[i] = false;
			}
		}
	}
	
	// 배열을 돌리는 메소드
	static int[][] turnArr(int[][] array, int r, int c, int s) {
			
		for(int i=1; i<=s; i++) {
			int x1 = r - i;		// 시작 지점 x
			int y1 = c - i;		// 시작 지점 y
			
			int temp = array[x1][y1];	// 시작 지점을 임시로 저장
			int dir = 0;
			
			while(dir < 4) {	// 모든 방향을 다 돌때까지
				int nx = x1 + dx[dir];	// x이동
				int ny = y1 + dy[dir];	// y이동
				
				if(nx < r-i || nx > r+i || ny < c-i || ny > c+i) {	// 범위를 벗어날 경우
					dir++;	// 방향 전환
				} else {
					array[x1][y1] = array[nx][ny];	//	다음 값을 현재위치에 저장
					x1 = nx;
					y1 = ny;
				}
			}
			
			array[x1][y1+1] = temp;		// 임시로 저장한 처음 값을 마지막 위치에 저장
		}
		
		return array;
		
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String[] st = br.readLine().split(" ");
		N = Integer.parseInt(st[0]);	// 배열 행 크기
		M = Integer.parseInt(st[1]);	// 배열 열 크기
		K = Integer.parseInt(st[2]);	// 연산 개수
		arr = new int[N+1][M+1];	// 배열 선언
		opr = new int[K][3];		// 연산 저장 배열
		
		for(int i=1; i<=N; i++) {
			st = br.readLine().split(" ");
			for(int j=1; j<=M; j++) {
				arr[i][j] = Integer.parseInt(st[j-1]);
			}
		}
		
		// K번의 연산 수행
		for(int i=0; i<K; i++) {
			st = br.readLine().split(" ");
			for(int j=0; j<3; j++) {
				opr[i][j] = Integer.parseInt(st[j]);
			}
		}
		
		visited = new boolean[K];	//	선택 기록을 나타내는 매열
		permOpr = new int[K][3];	// 선택된 연산을 담는 배열
		min = 5000;		// 최대로 나올수 있는 수 있는 합이 5000이므로 min값으로 설정
		perm(0);
		
		sb.append(min);
		
		System.out.print(sb);
	}
	
}
