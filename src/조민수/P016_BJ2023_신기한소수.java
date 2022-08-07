package 조민수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class P016_BJ2023_신기한소수 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		int start=1;
		int notPrime=0;
		for(int i=1;i<n;i++) {
			start=start*10;//자릿수 계산
		}
		int end=start*10;
		
		for(int num=start;num<end;num++) {
			notPrime=0;
			int curnum=0;
			int scale=start;
			for(int i=n-1;i>=0;i--) {//각 자리수로 볼거다
				curnum=num/scale;//앞자리부터 계산
				scale=scale/10;
				if(i==n-1) {//앞자리가 1이면 검사할 필요 X
					if(curnum==1) {
						notPrime=1;
						break;
					}
				}
			
				for(int j=2;j<=Math.sqrt(curnum);j++) {//소수인지 판별
					if(curnum%j==0) {
						notPrime=1;//소수가 아니다
						break;
					}
					
				}
				if(notPrime==1) {
					break;
					}
				
			}
			if(notPrime==0) {//모든 자리가 소수다
				sb.append(num).append("\n");
			}
		}
		System.out.println(sb);
		
	}
}

