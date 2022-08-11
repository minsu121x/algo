package 조민수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P031_BJ3040_백설공주와일곱난쟁이 {

	static int[] hat,dwarf;
	static final int N=9;
	static final int R=7;
	//9명중7명 뽑기 고정
	static StringBuilder sb;
	
	
	public static void comb(int cnt,int start) {
		if(cnt==R) {//조합이 모두 뽑히면
			int sum=0;
			for(int d:dwarf) {
				sum+=d;//조합에 대한 합 계산
			}
			if(sum==100) {//합이 100 -> 난쟁이를 찾았다.
				for(int d:dwarf) {
					sb.append(d).append("\n");//출력
				}
			}
			return;
		}
		for(int i=start;i<N;i++) {//조합 (중복X)
			dwarf[cnt]=hat[i];
			comb(cnt+1,i+1);
		}
	}
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		hat=new int[9];// 입력 난쟁이 9명 저장
		dwarf= new int[7];//출력 난쟁이 7명
		for(int i=0;i<N;i++) {
			hat[i]=Integer.parseInt(br.readLine());
		}
		
		comb(0,0);//조합을 통해 계산 9C7
		System.out.println(sb);
	}

}
