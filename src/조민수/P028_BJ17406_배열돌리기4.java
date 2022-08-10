package 조민수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Arrays;

public class P028_BJ17406_배열돌리기4 {
	static final int[] dx= {1, 0, -1, 0};	// 하, 우, 상, 좌
	static final int[] dy= {0, 1, 0, -1};	// 하, 우, 상, 좌
	
	static int N, M, K, min;
	static int[][] arr, opr, permOpr;
	static boolean[] visited;
	
	// 연산 순서를 순열로 저장 nPn
	static void perm(int cnt) {
		if(cnt == K) {//순열이 완성되면
			int[][] newArr = new int [N+1][];//원본 배열이 아닌 카피본으로 테스트
			for(int i=0;i<N+1;i++) {//카피본에 원본배열 복사
				newArr[i]=Arrays.copyOf(arr[i],M+1);
			}
			for(int i=0; i<K; i++) {//각 순열의 결과값으로 연산 동작
				newArr = turnArr(newArr, permOpr[i][0], permOpr[i][1], permOpr[i][2]);
			}
			for(int i=1; i<=N; i++) {
				int sum = 0;
				for(int j=1; j<=M; j++) {//연산 후 행별로 더하기
					sum += newArr[i][j];
				}
				if(sum < min) {//행 합값중 최솟값 저장
					min = sum;
				}
			}
			return;
		}
		
		for(int i=0; i<K; i++) {// 순열 만들기
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
			int x1 = r - i;
			int y1 = c - i;
			
			int temp = array[x1][y1];
			int dir = 0;
			
			while(dir < 4) {//하 우 상 좌 순으로 탐색
				int nx = x1 + dx[dir];
				int ny = y1 + dy[dir];
				
				if(nx < r-i || nx > r+i || ny < c-i || ny > c+i) {
					dir++;
				} else {
					array[x1][y1] = array[nx][ny];
					x1 = nx;
					y1 = ny;
				}
			}
			
			array[x1][y1+1] = temp;
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
		
		visited = new boolean[K];
		permOpr = new int[K][3];
		min = 5000;		// 배열 연산 최댓값= 5000이므로 min 5000으로 초기화
		perm(0);// 연산 순서 순열로 나열
		
		sb.append(min);
		
		System.out.print(sb);
	}
	
}