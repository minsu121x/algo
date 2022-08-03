package 박윤환;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P009_BJ11659_구간합구하기4 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		String[] st = br.readLine().split(" ");
		int n = Integer.parseInt(st[0]);	// 숫자의 개수
		int m = Integer.parseInt(st[1]);	// 합을 구하는 횟수
		
		int[] arr = new int[n+1];		// 0번째 인덱스는 0으로 비우고 1부터 채움
		st = br.readLine().split(" ");
		for(int i=1; i<n+1; i++) {
			arr[i] = arr[i-1] + Integer.parseInt(st[i-1]);	// 배열에 저장하면서 이전까지 숫자의 합을 미리 구하고 저
		}
		
		for(int i=m; i>0; i--) {	// 빠른 연산을 위해 변수를 0과 비교
			st = br.readLine().split(" ");
			int start = Integer.parseInt(st[0]);	// i번째를 가리키는 시작 인덱스
			int end = Integer.parseInt(st[1]);	// j번째를 가리키는 끝 인덱스
			// 미리 합을 구하고 저장했기 때문에 i번째 수부터 j번째 수까지의 합은
			// {i~j까지의 합} = {1~j까지의 합} - {1~(i-1)까지의 합} 이 된다.
			sb.append(arr[end] - arr[start-1]).append("\n");
		}
		
		bw.write(sb.toString());
		
		bw.flush();
		bw.close();
		br.close();
	}

}
