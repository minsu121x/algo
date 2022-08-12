package 박윤환;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class P034_SWEA4012_요리사 {

	static int N, min;
	static int[][] syn;
	static boolean[] food;
	static int[] foodA, foodB, ingrA, ingrB;
	static ArrayList<Integer> listA, listB;
	
	// A와 B에서 사용할 식재료들의 조합을 구하는 메소드
	static void combIngr(int[] f, int[] ingr, ArrayList<Integer> list, int cnt, int start) {
		// 2개 선택 됐다면
		if(cnt == 2) {
			int sum = 0;
			sum = syn[ingr[0]][ingr[1]] + syn[ingr[1]][ingr[0]];	// 시너지 합을 구한다
			list.add(sum);	// 리스트에 전력을 저장한다
			return;
		}
		// 가능한 모든 조합 선택
		for(int i=start; i<N/2; i++) {
			ingr[cnt] = f[i];
			combIngr(f, ingr, list, cnt+1, i+1);
		}
		
	}
	
	// 재료를 음식 A와 B로 나누는 조합을 구하는 메소드
	static void combFood(int index, int cnt) {
		// 모든 재료의 선택이 끝났으면
		if(index == N) {
			if(cnt != N/2) return;	// 절반으로 나눠지지 않았다면 다시 선택
			int idxA = 0;
			int idxB = 0;
			for(int i=0; i<N; i++) {	// 선택한 재료를 저장
				if(food[i]) {
					foodA[idxA++] = i;
				} else {
					foodB[idxB++] = i;
				}
			}
			listA = new ArrayList<>();	// A음식의 전력을 저장할 배열
			listB = new ArrayList<>();	// B음식의 전력을 저장할 배열
			
			// 각 음식들에 선택된 식재료들 중 2개를 선택하는 조합
			combIngr(foodA, ingrA, listA, 0, 0);
			combIngr(foodB, ingrB, listB, 0, 0);
			
			int sum = 0;
			for(int i=0; i<listA.size(); i++) {
				sum += listA.get(i);
				sum -= listB.get(i);
			}
			min = Math.min(min, Math.abs(sum));
			
			return;
		}
		// 재료 선택
		food[index] = true;
		combFood(index+1, ++cnt);
		// 재료 미선택
		food[index] = false;
		combFood(index+1, --cnt);
	
	}
	
	public static void main(String[] args) throws Exception {
//		System.setIn(new FileInputStream("sample_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());	// 테스트 케이스 개수
		for(int tc=1; tc<=T; tc++) {	// 테스트 케이스만큼 반복
			N = Integer.parseInt(br.readLine());	// 재료 개수
			syn = new int[N][N];	// 시너지 표
			
			for(int i=0; i<N; i++) {
				String[] st = br.readLine().split(" ");
				for(int j=0; j<N; j++) {
					syn[i][j] = Integer.parseInt(st[j]);
				}
			}
			
			food = new boolean[N];
			foodA = new int[N/2];
			foodB = new int[N/2];
			ingrA = new int[2];
			ingrB = new int[2];
			min = Integer.MAX_VALUE;
			combFood(0, 0);
			
			sb.append("#").append(tc).append(" ").append(min).append("\n");
		}
		System.out.println(sb);
	}

}
