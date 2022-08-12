package 조민수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class P032_BJ15686치킨배달 {
	
	static ArrayList<int[]> home,KFC,picked;//집 좌표 home, 치킨집 좌표 KFC, 치킨집 좌표중 내가 선택한 치킨집 좌표 picked
	static int N,M,totalMin;//맵 사이즈 N 치킨집의 최대개수 M 최종 치킨거리 totalMin;
	static int[][] map ;
	static boolean[] isSelected;//부분집합을 위한 배열
	
	static void subset(int index,int cnt) {
		if (index==KFC.size()) {
			if(cnt<=M) {//M갯수만큼 뽑았으면
				//연산 시작
				
				int sum=0;
				for(int i=0;i<home.size();i++) {//각 집별로
					int min=100;
					for(int j=0;j<KFC.size();j++) {
						if(isSelected[j]) {
							int diffx= Math.abs(home.get(i)[0]-KFC.get(j)[0]);
							int diffy= Math.abs(home.get(i)[1]-KFC.get(j)[1]);	
							min=Math.min(min,diffx+diffy);//가장 가까운 치킨집 좌표 구한다.
						}
					}
					sum+=min;//집집마다 최소 거리값을 더한다.
				}
				totalMin=Math.min(sum, totalMin);//각 치킨거리중 가장 작은값 산출
			}
			return;
		}
		
		isSelected[index]=true;
		cnt++;
			subset(index+1,cnt);
		isSelected[index]=false;
				cnt--;
				subset(index+1,cnt);	
	
	}
	
	
	
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String[] st=br.readLine().split(" ");
		N=Integer.parseInt(st[0]);//맵 사이즈
		M=Integer.parseInt(st[1]);//삭제할 치킨집
		map = new int[N][N];
		home= new ArrayList<>();
		KFC= new ArrayList<>();

		
		for(int i=0;i<N;i++) {
			st=br.readLine().split(" ");
			for(int j=0;j<N;j++) {
				map[i][j]=Integer.parseInt(st[j]);
				if(map[i][j]==1){
					home.add(new int[] {i,j});
				}
				else if(map[i][j]==2){
					KFC.add(new int[] {i,j});
				}
			}
		}
		totalMin=Integer.MAX_VALUE;
		isSelected =new boolean[KFC.size()];
		subset(0,0);
		sb.append(totalMin);
		System.out.println(sb);
	}
}