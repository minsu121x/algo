package 조민수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P012_SWEA1218_괄호짝짓기 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		int []Bracket=new int[4]; //괄호의 종류별로 배열 생성 순서대로 (), {}, [], <>
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int size=0;//수행개수저장
		
		for (int tc = 1; tc <= 10; tc++) {
			size=Integer.parseInt(br.readLine());
			String sr=br.readLine();
			String[] str=sr.split("");
			int flag=0;//불합여부 판정
			for (int i = 0; i < str.length; i++) {
				switch(str[i]) {
					case "(":
						Bracket[0]++;
						break;
					case ")":
						Bracket[0]--;
						if(Bracket[0]<0) {
							flag=1;
						}
						break;
					case "{":
						Bracket[1]++;
						break;
					case "}":
						Bracket[1]--;
						if(Bracket[1]<0) {
							flag=1;
						}
						break;
					case "[":
						Bracket[2]++;
						break;
					case "]":
						Bracket[2]--;
						if(Bracket[2]<0) {
							flag=1;
						}
						break;
					case "<":
						Bracket[3]++;
						break;
					case ">":
						Bracket[3]--;
						if(Bracket[3]<0) {
							flag=1;
						}
						break;
				}
				if(flag==1)
				{
					break;//더이상 볼 필요 X
				}
			}
			for(int i=0;i<4;i++) {
				if(Bracket[i]!=0) {
					flag=1;
				}
			}
			if(	flag==1)
			System.out.println("#"+tc+" "+0);
			else
			System.out.println("#"+tc+" "+1);
			Arrays.fill(Bracket,0);
		}
	}

}
