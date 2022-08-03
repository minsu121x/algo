package 박윤환;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P011_SWEA2001_파리퇴치 {

	public static void main(String[] args) throws Exception {
//		System.setIn(new FileInputStream("input2.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());	// 테스트 케이스 개수 입력
		
		for(int tc=1; tc<=T; tc++) {	// 테스트 케이스 만큼 반복
			String[] st = br.readLine().split(" ");
			int N = Integer.parseInt(st[0]);	//	영역 크기
			int M = Integer.parseInt(st[1]);	// 파리채 크기
			int[][] arr = new int[N][N];	//	 영역 배열 선언
			
			for(int i=0; i<N; i++) {
				st = br.readLine().split(" ");
				for(int j=0; j<N; j++) {
					arr[i][j] = Integer.parseInt(st[j]);	// 영역의 파리개수 초기화
				}
			}
			int max = 0;
			for(int i=0; i<=N-M; i++) {	// i는 0부터 파리채가 세로영역을 벗어나기 전까지
				for(int j=0; j<=N-M; j++) {	// j는 0부터 파리채가 가로영역을 벗어나기 전까지
					int sum = 0;
					for(int k=0; k<M; k++) {
						for(int l=0; l<M; l++) {	// 현재 위치에서 파리채 크기만큼의 파리 갯수 합
							sum += arr[i+k][j+l];
						}
					}
					max = Math.max(max, sum);	// 최대값 비교
				}
			}
			
			sb.append("#").append(tc).append(" ").append(max).append("\n");
			
		}
		
		bw.write(sb.toString());
		
		bw.flush();
		bw.close();
		br.close();
	}

}
