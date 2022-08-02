package 조민수;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
public class P006_SWEA2805_농작물수확하기 {

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));//입력값을 받아온다
		int tc=Integer.parseInt(br.readLine());//테스트 케이스
		for (int i=1;i<=tc;i++) {
			int size=Integer.parseInt(br.readLine());
			int[][] farm=new int[size][size];
			for(int j=0;j<size;j++) {
				String cur_br=br.readLine();
				for(int k=0;k<size;k++) {
					farm[j][k]=cur_br.charAt(k)-'0';
				}
			
			}
			
			int result = 0;	
			result=countfarm(farm);
			System.out.println("#"+i+" "+result);
		}

	}
	
	public static int countfarm(int[][]farm)
	{
			int result=0;
			int cut= (farm.length-1)/2;//상-하단부 나눠서 처리 ->2
			int cnt=cut;//앞에 패스->가운데부터 받을거니까
			for (int i = 0; i <=cut; i++) { 
			
					for (int j = 0; j <=i*2; j++) {
						result+=farm[i][cnt+j];	//j->  0 1 2 ->cnt 한칸씩 -> 1 2 3 
					}
					cnt--;
				}
		
			cnt=cut;
			for (int i = farm.length-1; i >cut; i--) {
				for (int j = 0; j <=(farm.length-1-i)*2; j++) {
					
						result+=farm[i][cnt+j];
					
					}
				cnt--;
			}
			return result;
	}

}
