package 조민수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class P999_과목평가대비_삼성시의_버스_노선 {
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));//입력 값을 저장하는 buffer br
		int T=Integer.parseInt(br.readLine());//테스트케이스의 수 저장
		for(int tc=1;tc<=T;tc++) {//테스트 케이스만큼 동작 반복
			int busNum=Integer.parseInt(br.readLine()); //버스 노선의 수 저장
			int[][]bus=new int[busNum][2]; //각 노선에 대하여 [i][0]: i번노선의 시점 [i][1]:i번 노선의 종점
			for(int i=0;i<busNum;i++) {
				String[] st=br.readLine().split(" ");//노선 시종점 정보를 띄어쓰기로 구분하여 저장
				bus[i][0]=Integer.parseInt(st[0]);//시점 저장
				bus[i][1]=Integer.parseInt(st[1]);//종점 저장
			}
			int stationNum=Integer.parseInt(br.readLine());//정류장의 수 저장
			int [][]station=new int[stationNum][2];//[i][0]: [i]역의 값(정류장번호) [i][1]:[i]정류장을 지나는 노선의 수 저장
			
			for(int i=0;i<stationNum;i++) {
				station[i][0]=Integer.parseInt(br.readLine());//정류장번호를 [i][0]에 저장
				
			}
			
			for(int i=0;i<busNum;i++) {//모든 노선에 대해
				for(int j=0;j<stationNum;j++) {//모든 정류장이 지나는지 탐색
					if(bus[i][0]<=station[j][0]&&station[j][0]<=bus[i][1]) {//bus(노선)의 시점과 종점사이에 정류장이 있다
						station[j][1]++;//해당 i노선이 j정류장을 지나므로 station[i][1]에 값 증가
					}
				}
			}
			
			System.out.print("#"+tc+" ");//테스트케이스 번호 출력
			for(int i=0;i<stationNum;i++) {//각 정류장에 대해
					System.out.print(station[i][1]+" ");//정류장을 지나는 노선의 수를 띄어쓰기로 구분해 출력
				
			}
			System.out.println();//출력후 줄바꿈
			
			
			
			
			
		}
	}

}
