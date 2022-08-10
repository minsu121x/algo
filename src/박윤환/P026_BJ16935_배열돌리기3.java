package 박윤환;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P026_BJ16935_배열돌리기3 {

	static int N, M, R;
	static int[][] arr;
	
	// 배열 상하 반전 연산
	static void oprt1() {
		int n = arr.length;		// 현재 배열의 행 크기
		int m = arr[0].length;	// 현재 배열의 열 크기
		int mid = n / 2;		// 행의 크기의 절반
		int[][] result = new int[n][m];	// 연산을 실행한 배열을 저장할 임시 배열
		for(int i=0; i<mid; i++) {	// 행 크기의 절반만큼 반복
			result[i] = arr[n-1-i];	// 아래 줄을 위에 저장
			result[n-1-i] = arr[i];	// 위 줄을 아래에 저장
		}
		arr = result;	// 임시 배열 주소를 원래 배열 공간에 할당
	}
	
	// 배열 좌우 반전 연산
	static void oprt2() {
		int n = arr.length;		// 현재 배열의 행 크기
		int m = arr[0].length;	// 현재 배열의 열 크기
		int mid = m / 2;		// 열의 크기의 절반
		int[][] result = new int[n][m];	// 연산을 실행한 배열을 저장할 임시 배열
		for(int i=0; i<n; i++) {
			for(int j=0; j<mid; j++) {	// 행마다 열 크기의 절반만큼 반복
				result[i][j] = arr[i][m-1-j];	// 오른쪽 줄을 왼쪽에 저장
				result[i][m-1-j] = arr[i][j];	// 왼쪽 줄을 오른쪽에 저장
			}
		}
		arr = result;	// 임시 배열 주소를 원래 배열 공간에 할당
	}
	
	// 배열 오른쪽으로 90도 회전 연산
	static void oprt3() {
		int n = arr.length;		// 현재 배열의 행 크기
		int m = arr[0].length;	// 현재 배열의 열 크기
		int[][] result = new int[m][n];	// 연산을 실행한 배열을 저장할 임시 배열
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {	// 좌하단 값부터 채워 넣음
				result[i][j] = arr[n-1-j][i];
			}
		}
		arr = result;	// 임시 배열 주소를 원래 배열 공간에 할당	
	}
	
	// 배열 왼쪽으로 90도 회전 연산
	static void oprt4() {
		int n = arr.length;		// 현재 배열의 행 크기
		int m = arr[0].length;	// 현재 배열의 열 크기
		int[][] result = new int[m][n];	// 연산을 실행한 배열을 저장할 임시 배열
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {	// 우하단 값부터 채워 넣음
				result[i][j] = arr[j][m-1-i];
			}
		}
		arr = result;	// 임시 배열 주소를 원래 배열 공간에 할당
	}
	
	// 배열을 4등분하여 시계방향으로 돌리는 연산
	static void oprt5() {
		int n = arr.length;		// 현재 배열의 행 크기
		int m = arr[0].length;	// 현재 배열의 열 크기
		int midN = n / 2;		// 행의 크기의 절반
		int midM = m / 2;		// 열의 크기의 절반
		int[][] result = new int[n][m];	// 연산을 실행한 배열을 저장할 임시 배열
		
		// 4번 지역 -> 1번 지역
		for(int i=0; i<midN; i++) {
			for(int j=0; j<midM; j++) {
				result[i][j] = arr[i+midN][j];
			}
		}
		// 1번 지역 -> 2번 지역
		for(int i=0; i<midN; i++) {
			for(int j=midM; j<m; j++) {
				result[i][j] = arr[i][j-midM];
			}
		}
		// 2번 지역 -> 3번 지역
		for(int i=midN; i<n; i++) {
			for(int j=midM; j<m; j++) {
				result[i][j] = arr[i-midN][j];
			}
		}
		// 3번 지역 -> 4번 지역
		for(int i=midN; i<n; i++) {
			for(int j=0; j<midM; j++) {
				result[i][j] = arr[i][j+midM];
			}
		}
		
		arr = result;	// 임시 배열 주소를 원래 배열 공간에 할당
	}
	
	// 배열을 4등분하여 반시계 방향으로 돌리는 연산
	static void oprt6() {
		int n = arr.length;		// 현재 배열의 행 크기
		int m = arr[0].length;	// 현재 배열의 열 크기
		int midN = n / 2;		// 행의 크기의 절반
		int midM = m / 2;		// 열의 크기의 절반
		int[][] result = new int[n][m];	// 연산을 실행한 배열을 저장할 임시 배열
		
		// 2번 지역 -> 1번 지역
		for(int i=0; i<midN; i++) {
			for(int j=0; j<midM; j++) {
				result[i][j] = arr[i][j+midM];
			}
		}
		// 3번 지역 -> 2번 지역
		for(int i=0; i<midN; i++) {
			for(int j=midM; j<m; j++) {
				result[i][j] = arr[i+midN][j];
			}
		}
		// 4번 지역 -> 3번 지역
		for(int i=midN; i<n; i++) {
			for(int j=midM; j<m; j++) {
				result[i][j] = arr[i][j-midM];
			}
		}
		// 1번 지역 -> 4번 지역
		for(int i=midN; i<n; i++) {
			for(int j=0; j<midM; j++) {
				result[i][j] = arr[i-midN][j];
			}
		}
		
		arr = result;	// 임시 배열 주소를 원래 배열 공간에 할당
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String[] st = br.readLine().split(" ");
		N = Integer.parseInt(st[0]);	// 배열 행 크기
		M = Integer.parseInt(st[1]);	// 배열 열 크기
		R = Integer.parseInt(st[2]);	// 연산 개수
		arr = new int[N][M];	// NxM 크기의 배열
		
		for(int i=0; i<N; i++) {
			st = br.readLine().split(" ");
			for(int j=0; j<M; j++) {
				arr[i][j] = Integer.parseInt(st[j]);
			}
		}
		
		st = br.readLine().split(" ");
		for(int i=0; i<R; i++) {
			int opr = Integer.parseInt(st[i]);
			switch(opr) {	// 연산 번호에 따른 연산 수행
				case 1:
					oprt1();
					break;
				case 2:
					oprt2();
					break;
				case 3:
					oprt3();
					break;
				case 4:
					oprt4();
					break;
				case 5:
					oprt5();
					break;
				case 6:
					oprt6();
					break;
			}
		}
		
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[0].length; j++) {
				sb.append(arr[i][j]).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}

}
