package 박윤환;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class P022_SWEA6808_규영이와인영이의카드게임 {
	
	static int win;		// 이긴 횟수를 카운트하는 변수
	static int lose;	// 진 횟수를 카운트하는 변수
	static int[] me;	// 규영이가 가진 카드를 담는 배열
	static int[] oppnt;	// 인영이가 가진 카드를 담는 배열
	static int[] numbers;	// 인영이가 가진 카드로 만들 수 있는 순서를 임시로 담는 배열
	static boolean[] isSelected;	// 숫자가 선택됐는지 기록하는 배열

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("s_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());	// 테스트 케이스 입력
		for(int tc=1; tc<=T; tc++) {
			int[] cards = new int[19];		// 18개의 카드 (인덱스 1부터)
			me = new int[9];				// 규영이가 가진 카드
			oppnt = new int[9];				// 인영이가 가진 카드
			isSelected = new boolean[9];
			String[] st = br.readLine().split(" ");
			for(int i=0; i<9; i++) {
				me[i] = Integer.parseInt(st[i]);	// 규영이가 가진 카드를 입력
				cards[me[i]] = 1;					// 18개의 카드 중 규영이가 가진 카드는 1로 표기
			}
			
			int idx = 0;
			for(int i=1; i<19; i++) {
				if(cards[i] == 0) {				// 18개의 카드 중 0으로 표기된 카드는 인영이 카드로 입력
					oppnt[idx++] = i;
				}
			}
			numbers = new int[9];
			win = 0;
			lose = 0;
			perm(0, 9);		// 9!의 경우의 수 탐색
			sb.append("#").append(tc).append(" ").append(win).append(" ").append(lose).append("\n");
		}
		System.out.println(sb);
	}
	
	static void perm(int cnt, int N) {
		if(cnt == N) {	// 마지막 수를 선택 했을 경우
			int scoreMe = 0;	// 규영이 점수
			int scoreOp = 0;	// 인영이 점수
			for(int i=0; i<9; i++) {	// 모든 카드 비교
				if(me[i] > numbers[i]) {	// 규영이 카드가 더 크면
					scoreMe += me[i] + numbers[i];	// 규영이 점수 증가
				} else if(me[i] < numbers[i]) {		// 인영이 카드가 더 크면
					scoreOp += me[i] + numbers[i];	// 인영이 점수 증가
				}
			}
			if(scoreMe > scoreOp) {	// 규영이 점수가 더 높으면
				win++;	// 규영이 승리횟수 증가
			} else if(scoreMe < scoreOp) {	// 인영이 점수가 더 높으면
				lose++;	// 규영이 패배횟수 증가
			}
			return;	// 이번 경우의 수 종료
		}
		
		for(int i=0; i<N; i++) {	// 가능한한 모든 수 시도
			if(isSelected[i]) {	// 이미 선택된 수인지 판단
				continue;
			}
			numbers[cnt] = oppnt[i];	// 앞쪽에서 선택되지 않은 수를 사용
			isSelected[i] = true;		// 선택된 수로 체크
			
			perm(cnt+1, N);		// 다음 수 선택
			
			isSelected[i] = false;	// 사용했던 수 되돌리기
		}
	}
}
