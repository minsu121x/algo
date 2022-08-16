package 조민수;

import java.io.*;
import java.util.*;

public class P022_SWEA6808_규영이와인영이의카드게임 {
	
	
	static int[] IYcard;//인영이가 받을 카드
	static int[] GYcard;//규영이가 받을 카드
	static boolean[] isSelected;//인영이 카드순열을 만들기 위한 isSelected
	static int win;//이긴 횟수
	static int lose;//진 횟수
	
	static void perm(int cnt) {
		if(cnt==9) {//9장 다뽑았다
			int IYsum=0; //인영이 포인트;
			int GYsum=0;//규영이 포인트;
			for(int i=0;i<9;i++) {//누가 이기나 보자
				if(IYcard[i]>GYcard[i]) {

					 IYsum+=IYcard[i]+GYcard[i];

				}
				else {
					 GYsum+=IYcard[i]+GYcard[i];
				}
				if(IYsum>85) {//총합 171의 절반만 넘기면 이미 승리
					lose++;
					return;
				}
				else if(GYsum>85) {
					win++;
					return;
				}
			}
		}
		
		for(int i=1;i<19;i++) {//전체 카드에 대해
			if(isSelected[i]) {
				continue;//규영이가 뽑았거나 이미 골라졌다
			}
			IYcard[cnt]=i;
			isSelected[i]=true;
			
			perm(cnt+1);
			isSelected[i]=false;
		}
		
	}

	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T= Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			IYcard=new int[9];
			GYcard=new int[9];
			isSelected=new boolean[19];//1~18 저장 위해 19칸 생성
			String[]st =br.readLine().split(" ");
			for(int i=0;i<9;i++) {
				int temp=Integer.parseInt(st[i]);
				GYcard[i]=temp;//규영이 카드 저장
				isSelected[temp]=true;//규영이가 뽑은 카드 기록	
			}
			win=0;//횟수 초기화
			lose=0;
			perm(0);
			System.out.println("#"+tc+" "+win+" "+lose);
		}
	}	
}