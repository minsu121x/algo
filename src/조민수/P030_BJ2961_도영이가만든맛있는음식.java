package 조민수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public abstract class P030_BJ2961_도영이가만든맛있는음식 {

	static int[][] sourBitter;
	static int N,result;
	static boolean[] isSelected;
	
	static void subset(int index) {//부분집합
		if(index==N){ 
			int sourSum=1;//신맛의 합
			int bitterSum=0;//쓴맛의 합
			boolean forFlag=false;//★인덱스가 1일 경우 if문은 안될지만 비교문은 돌기 때문에 계속1이 출력됨
			for (int i = 0; i <N; i++) {
				if(isSelected[i]) {
					forFlag=true;//isSelected를 돌았을 때만
					sourSum*=sourBitter[i][0];
					bitterSum+=sourBitter[i][1];
				}	
			}
			if(forFlag&&Math.abs(sourSum-bitterSum)<result) {//정상적인 값으로 인지 후 출력
				result=Math.abs(sourSum-bitterSum);//지금 차이가 원래 차이보다 작으면 입력
			}
			return;
		}
		isSelected[index]=true;
		subset(index+1);
		isSelected[index]=false;
		subset(index+1);	
	}
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N=Integer.parseInt(br.readLine());
		sourBitter=new int[N][2];
		for(int i=0;i<N;i++) {
			String[] st= br.readLine().split(" ");//신맛 쓴맛 입력
			sourBitter[i][0]=Integer.parseInt(st[0]);//신맛
			sourBitter[i][1]=Integer.parseInt(st[1]);//쓴맛			
		}
		result=1000000000;//Max값
		isSelected=new boolean[N];
		subset(0);
		System.out.println(result);
	}

}
