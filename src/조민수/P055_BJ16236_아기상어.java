package 조민수;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class P055_BJ16236_아기상어 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String st=br.readLine();
		int N=Integer.parseInt(st);//열
		
		int[][] sea=new int[N][N];//토마토박스
		for(int i=0;i<N;i++) {
			String[]str=br.readLine().split(" ");
			for(int j=0;j<N;j++) {
				sea[i][j]=Integer.parseInt(str[j]);

				}
			}
		}
	}

}
