package 조민수;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class P007_SWEA1954_달팽이숫자 {
	public static void main(String[] args) throws IOException {
		//방향 잡고 
		//사이즈 기준 5면 5-4-4-3-3-2-2-1-1
	
		int tc=0;
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));//입력값을 받아온다
		tc=Integer.parseInt(br.readLine());//테스트 케이스
		for (int i=1;i<=tc;i++){
			int size=Integer.parseInt(br.readLine());
			System.out.println("#"+i);
			snailHouse(size);
			System.out.println();
		}
	}
	public static void snailHouse(int ORG_size) {
		int size=ORG_size;
		int House[][]=new int[size][size];
		int max=size*size;
		int value=1;
		int x=0;
		int y=0;
	
		for (int i = 0; i <size; i++) {//첫줄 채우기
			House[0][i]=value;
			value++;
			x=0;
			y=i;
		}
		size--;
		//하 좌 상 우
		while(value<max) {
			for(int i=1;i<=size;i++)//아래
			{
				x=x+1;
				House[x][y]=value;
				value++;
			}
			if(value==max) {
				House[x][y-1]=value;
				break;
			}
			for(int i=1;i<=size;i++)//좌
			{
				y=y-1;
				House[x][y]=value;
				value++;
			}
			if(value==max) {
				House[x-1][y]=value;
				break;
			}
			size--;
			for(int i=1;i<=size;i++)//상
			{
				x=x-1;
				House[x][y]=value;
				value++;
			}
			if(value==max) {
				House[x][y+1]=value;
				break;
			}
			for(int i=1;i<=size;i++)//우
			{
				y=y+1;
				House[x][y]=value;
				value++;
			}
			size--;
			if(value==max) {
				House[x+1][y]=value;
				break;
			}
			
		}
		for(int i = 0; i <ORG_size ; i++) {
			for(int j = 0; j <ORG_size ; j++) {
				System.out.print(House[i][j]+" ");
			}
			System.out.println();
		}
	}
}
