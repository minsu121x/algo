package 박윤환;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class P032_BJ15686치킨배달 {
	
	static int N, M, totalMin;
	static int[][] map;
	static ArrayList<int[]> home, KFC;
	static boolean[] isSelected;
	
	// 존재할 수 있는 모든 치킨집의 부분집합을 구하는 메소드
	static void subset(int index, int cnt) {
		if(index == KFC.size()) {	// 치킨집 크기 까지
			if(cnt > M) return;		// 고른 치킨집 개수가 M개를 넘어가면 아웃
			int sum = 0;
			for(int i=0; i<home.size(); i++) {
				int min = 100;
				for(int j=0; j<KFC.size(); j++) {
					if(isSelected[j]) {		// 선택된 치킨집과 집과의 치킨거리를 구하고 최소값을 구한다
						int diffX = Math.abs(home.get(i)[0] - KFC.get(j)[0]);
						int diffY = Math.abs(home.get(i)[1] - KFC.get(j)[1]);
						min = Math.min(min, diffX+diffY);
					}
				}
				sum += min;	// 도시의 치킨거리
			}
			
			totalMin = Math.min(sum, totalMin);	// 도시의 치킨거리 최소
			
			return;
		}
		
		// 원소 선택
		isSelected[index] = true;
		subset(index + 1, ++cnt);
		
		// 원소 미선택
		isSelected[index] = false;
		subset(index + 1, --cnt);
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String[] st = br.readLine().split(" ");
		N = Integer.parseInt(st[0]);	// 도시 크기
		M = Integer.parseInt(st[1]);	// 최대 남아야하는 치킨집 수
		map = new int[N][N];
		
		home = new ArrayList<>();
		KFC = new ArrayList<>();
		
		for(int i=0; i<N; i++) {
			st = br.readLine().split(" ");
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st[j]);
				if(map[i][j] == 1) {
					home.add(new int[] {i, j});		// 집들의 좌표 저장
				} else if(map[i][j] == 2) {
					KFC.add(new int[] {i, j});		// 치킨집들의 좌표 저장
				}
			}
		}
		
		isSelected = new boolean[KFC.size()];
		totalMin = Integer.MAX_VALUE;
		
		subset(0, 0);
		
		System.out.println(totalMin);
		
	}
}
