package 조민수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P046_SWEA3234_준환이의양팔저울 {
	static int left;
	static int right;
	static int[] weight;
	static int size;
	static int result;
	static boolean [] visited;
	static int[] factorial=new int[] {1,1,2,6,24,120,720,5040,40320,362880,3628800};
	
	static void swap(int n1,int n2) {
		int temp=weight[n1];
		weight[n1]=weight[n2];
		weight[n2]=temp;
		
	}
	
	static void choice(int i) {

		System.out.println("choice i:"+i );
		if(i==weight.length){//다 돌았다
			System.out.println("choice end");
			if(right<=left){
				System.out.println("R L is "+right+" "+left);
				result++;
			}
			return;
		}
		
		
		if(right+weight[i]<=left) {//조건가능
			right+=weight[i];
			System.out.println("add "+weight[i]+"right is"+right);
			choice(i+1);//다음거 보러
			right-=weight[i];
		}
		
		left+=weight[i];
		System.out.println("add "+weight[i]+"left is "+left);
		choice(i+1);
		left-=weight[i];
	}
	static void scale( int start) {
	int length=weight.length;
	  if(start==length) {
		System.out.println(Arrays.toString(weight));
		System.out.println("go choice");
		right=0;
		left=0;
		choice(0);
	  }
	  for(int i=start;i<length;i++) {
		swap(start,i);
		scale(start+1);
		swap(start,i);
		
	  }
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			result=0;
			size= Integer.parseInt(br.readLine());
			weight=new int[size];
		
			String[] st=br.readLine().split((" "));
			for(int i=0;i<size;i++) {
				weight[i]=Integer.parseInt(st[i]);//무게 저장
			}
			scale(0);
			System.out.println("#"+tc+" "+result);
		}
	}

}
