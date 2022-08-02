package 조민수;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
public class P004_SWEA1208_Flatten {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int tc=10;
		int result=0;
		
		for(int i=1;i<=tc;i++)
		{
			int dump=Integer.parseInt(br.readLine());
			ArrayList<Integer> box= new ArrayList<Integer>();
			int avg=0;//평탄화 완료 확인 
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<100;j++)
			{
				int value=Integer.parseInt(st.nextToken());
				box.add(value);//박스값 저장
				avg+=value;
				
			}
			avg=avg/100;
			for (int k = 1; k <=dump; k++) {
				int max=Collections.max(box);//최댓값
				int min=Collections.min(box);//최솟값
				int maxIndex=box.indexOf(max);
				int minIndex=box.indexOf(min);
				box.set(maxIndex,max-1);//max값 하나 빼기
				box.set(minIndex,min+1);//min값 하나 더하기
//				if(box.get(maxIndex)-avg<=1&&box.get(maxIndex)-avg>=-1) {//오차범위 이내다
//					result=box.get(Collections.max(box))-box.get(Collections.min(box));
//					break;
//				}
			}
			result=Collections.max(box)-Collections.min(box);
			System.out.println("#"+i+" "+result);
		}
	}

}
