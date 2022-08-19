package 조민수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class 삼성시의_버스_노선 {
	static ArrayList station=new ArrayList<>();//중복값도 가능하다
	static int[] stationCnt;
	static int stationNum;
	static Queue<Integer> bus=new LinkedList<Integer>();
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			int busNum=Integer.parseInt(br.readLine());
			for(int i=0;i<busNum;i++) {
				String[] st=br.readLine().split(" ");
				bus.offer(Integer.parseInt(st[0]));
				bus.offer(Integer.parseInt(st[1]));
			}
			stationNum=Integer.parseInt(br.readLine());
			stationCnt=new int[stationNum];
			
			for(int i=0;i<stationNum;i++) {
				String st=br.readLine();
				station.add(Integer.parseInt(st));
			}
			
			for(int i=0;i<busNum;i++) {
				int start=bus.poll();
				int end=bus.poll();
				for(int j=0;j<stationNum;j++) {
					if(start<=(int)station.get(j)&&(int)station.get(j)<=end) {
						stationCnt[j]++;	
					}
				}
			}
			
			System.out.print("#"+tc+" ");
			for(int i=0;i<stationNum;i++) {
				if(stationCnt[i]!=0)
				{
					System.out.print(stationCnt[i]+" ");
				}
			}
			bus.clear();
			System.out.println();
			
			
			
			
			
		}
	}

}
