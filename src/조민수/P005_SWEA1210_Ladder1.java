package 조민수;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.util.StringTokenizer;
import java.io.InputStreamReader;
public class P005_SWEA1210_Ladder1  {

	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		int [][]ladder=new int[100][100];//사다리 값 저장 배열
		int tc=10;//testcase
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));//입력값을 받아온다
	
		for (int test = 1; test <=tc; test++) {//메인 탐색 동작 반복
			int t=Integer.parseInt(br.readLine());//테스트 케이스(1~10)
			int result=0;
			for (int i = 0; i <100; i++) {
				String cur=br.readLine();
				String[] st = cur.split(" ");//사다리 한줄씩
				for (int j = 0; j <100; j++) {
					ladder[i][j]=Integer.parseInt(st[j]);//사다리 값 저장
				}
			}
			for(int j=0;j<100;j++) {//마지막줄을 돌면서 도착점을 탐색
				if(ladder[99][j]==2) {//2-> 여기가 도착점
				result=findStart(ladder,j);//메서드에서 탐색
				break;
				}
			}
			System.out.println("#"+t+" "+result);
		}
		
		br.close();
		
	}
	public static int findStart(int ladder[][], int endPoint) {//사다리 정보와 시작점 start
		int result=0;//반환할 결과값
		int i=99;//세로축
		int j=endPoint;//가로축
		int vec=0;//가로축 진행방향을 나타냄 무한루프 안빠질라고
		while(i>=0) {//시작점-끝점도착 전까지 탐색
			if(j-1>=0&&ladder[i][j-1]==1) {//첫번째 조건(가로축 존재여부) 우선 확인 후 통과면 두번째 조건(가로축 이동가능여부),세번째(방문여부)
				if(vec==1) {//이미 타고온 가로축이다
					vec=0;
					i--;
					continue;
				}
				vec=-1;
				while(j-1>=0&&ladder[i][j-1]==1) {
					j--;//이동가능한만큼 가로축 이동
				}
			}
			else if(j+1<100&&ladder[i][j+1]==1) {//첫번째 조건(가로축 존재여부) 우선 확인 후 통과면 두번째 조건(가로축 이동가능여부),세번째(방문여부)
				if(vec==-1) {//이미 타고온 가로축이다
					vec=0;
					i--;
					continue;
				}
				vec=1;
				while(j+1<100&&ladder[i][j+1]==1) {
					j++;//이동가능한만큼 가로축 이동
					
				}
			}
			else{//가로가 없다
				i--; //위로로 이동
				vec=0;
			}
		}
		//while을 돌고 나오면 j는 2가 나오는 사다리의 startPoint를 저장중이다
		
		result= j;//
		return result;//결과값 반환
	}

}
