package 조민수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P061_BJ17144_미세먼지안녕 {
	static int[][] before;
	static int[][] after;
	static int[] dr= {0,1,-1,0};
	static int[] dc= {1,0,0,-1};//우하상좌로 탐색
	static int dust=0;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//배열 2개 만들고 확산 Before After 교대로 사용
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		String st[]=br.readLine().split(" ");
		int R=Integer.parseInt(st[0]);
		int C=Integer.parseInt(st[1]);
		int time=Integer.parseInt(st[2]);
		int r2=0;//클리너 좌표인데 좌상->우하 입력이라 2번째 좌표만 저장될 예정, 첫번째 좌표는 r2-1,0
		before= new int[R][C];
		after= new int[R][C];
		for(int i=0;i<R;i++) {
			st=br.readLine().split(" ");
			for(int j=0;j<C;j++) {
				before[i][j]=Integer.parseInt(st[j]);
			if(before[i][j]==-1) {
				r2=i;
			}
			}
		}
		int flag=0;
		for(int tc=0;tc<time;tc++) {//확산->청정 동작 수행
			//flag에 따라 after와 before 배열을 교대로 사용
			//flag:0-> be->af 이동 flag:1-> af->be 이동
			dust=0;//먼지 초기화
			if(flag==0) {//be->af이동
				for(int r=0;r<R;r++) {
					for(int c=0;c<C;c++) {
						//각 좌표에 대해 값 구하기
						//1. 내꺼에서 확산 가능만큼 퍼트리기
						//2. 내 주변에서 확산가능한만큼 받기
						if(before[r][c]==-1) continue;//공기청정기면 패스
						int spread=before[r][c]/5;//한번 확산에 빠져나가는 미세먼지
						int afternum=0;//다음 배열에 넘겨줄 최종값
						for(int i=0;i<4;i++) {
							if(0<=r+i&&r+i<R&&0<=c+i&&c+i<C &&before[r+i][c+i]!=-1) {//갈 수 있으면
								afternum+=before[r+i][c+i]/5;//확산받을거 더하고
								afternum-=spread;//원본값의 확산값 빼준다
							}
						}
						//|<----------(3)------^
						//|                    |
						//(4)                  |
						//|                    (2)
						//|                    |
						//V                    |
						//청정기------(1)------->
						//청정기-------(5)------>
						//^                    |
						//|                    |
						//(8)                  (6)
						//|                    |
						//|                    |
						//<-------(7)--------- V
						//각 영역에 대해 회전 구현
						
						//상단회전
						if(r==r2-1&&0<c&&c<C-1) {//1번 r2-1행의 1~C-1열 까지 우로 한칸씩 이동 
							after[r][c+1]=afternum;
							dust+=afternum;
						}
						else if(c==C-1&&0<r&&r<=r2-1) {//2번 C-1열 r2-1행 위쪽으로 이동
							after[r-1][c]=afternum;
							dust+=afternum;
						}
						else if(r==0&&0<c&&c<=C-1) {//3번 
							after[r][c-1]=afternum;
							dust+=afternum;
						}
						else if(c==0&&r<=0&&r<r2-2) {//4번 청정기위에가 마지막 번호
							after[r+1][c]=afternum;
							dust+=afternum;
						}
						//하단회전
						else if(r==r2&&0<c&&c<C-1) {//5번
							after[r][c+1]=afternum;
							dust+=afternum;
						}
						else if(c==C-1&&r>=r2&&r<R-1) {//6번
							after[r+1][c]=afternum;
							dust+=afternum;
						}
						else if(r==R-1&&0<c&&c<=C-1) {//7번 
							after[r][c-1]=afternum;
							dust+=afternum;
						}
						else if(c==0&&r<=R-1&&r>r2+1) {//8번 
							after[r-1][c]=afternum;
							dust+=afternum;
						}
						else {//영역에 안걸리면 그냥 저장
							after[r][c]=afternum;
							dust+=afternum;
						}
					}
				}
				flag=1;		
			}
			
			if(flag==1) {//af->be이동
				for(int r=0;r<R;r++) {
					for(int c=0;c<C;c++) {
						//각 좌표에 대해 값 구하기
						//1. 내꺼에서 확산 가능만큼 퍼트리기
						//2. 내 주변에서 확산가능한만큼 받기
						if(after[r][c]==-1) continue;//공기청정기면 패스
						int spread=after[r][c]/5;//한번 확산에 빠져나가는 미세먼지
						int afternum=0;//다음 배열에 넘겨줄 최종값
						for(int i=0;i<4;i++) {
							if(0<=r+i&&r+i<R&&0<=c+i&&c+i<C &&after[r+i][c+i]!=-1) {//갈 수 있으면
								afternum+=after[r+i][c+i]/5;//확산받을거 더하고
								afternum-=spread;//원본값의 확산값 빼준다
							}
						}
						//|<----------(3)------^
						//|                    |
						//(4)                  |
						//|                    (2)
						//|                    |
						//V                    |
						//청정기------(1)------->
						//청정기-------(5)------>
						//^                    |
						//|                    |
						//(8)                  (6)
						//|                    |
						//|                    |
						//<-------(7)--------- V
						//각 영역에 대해 회전 구현
						
						//상단회전
						if(r==r2-1&&0<c&&c<C-1) {//1번 r2-1행의 1~C-1열 까지 우로 한칸씩 이동 
							before[r][c+1]=afternum;
							dust+=afternum;
						}
						else if(c==C-1&&0<r&&r<=r2-1) {//2번 C-1열 r2-1행 위쪽으로 이동
							before[r-1][c]=afternum;
							dust+=afternum;
						}
						else if(r==0&&0<c&&c<=C-1) {//3번 
							before[r][c-1]=afternum;
							dust+=afternum;
						}
						else if(c==0&&r<=0&&r<r2-2) {//4번 청정기위에가 마지막 번호
							before[r+1][c]=afternum;
							dust+=afternum;
						}
						//하단회전
						else if(r==r2&&0<c&&c<C-1) {//5번
							before[r][c+1]=afternum;
							dust+=afternum;
						}
						else if(c==C-1&&r>=r2&&r<R-1) {//6번
							before[r+1][c]=afternum;
							dust+=afternum;
						}
						else if(r==R-1&&0<c&&c<=C-1) {//7번 
							before[r][c-1]=afternum;
							dust+=afternum;
						}
						else if(c==0&&r<=R-1&&r>r2+1) {//8번 
							before[r-1][c]=afternum;
							dust+=afternum;
						}
						else {//영역에 안걸리면 그냥 저장
							before[r][c]=afternum;
							dust+=afternum;
						}
					}
				}
				flag=0;		
			}
		
			
			
		}
		System.out.println(dust);
	}

}
