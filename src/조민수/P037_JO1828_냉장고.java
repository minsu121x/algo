package 조민수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P037_JO1828_냉장고 {

	static class Temper implements Comparable<Temper>{
		int low,high;

		public Temper(int low, int high) {
			super();
			this.low = low;
			this.high = high;
		}
	@Override
	public int compareTo(Temper o) {// 최고온도 기준 오름차순 , 같으면 최저온도 기준 오름차순
		// TODO Auto-generated method stub
		return this.high!=o.high? this.high-o.high : this.low-o.low;// 삼항연산으로 end가 다르면 end 오름차순 같으면 start 오름차순
	}
	@Override
	public String toString() {
		return "Temper [low=" + low + ", high=" + high + "]\n";
	}
	
	}
	
	static List<Temper> getSchedule(Temper [] chem){
		 List<Temper> result = new ArrayList<Temper>();
		 System.out.println(Arrays.toString(chem));
		 Arrays.sort(chem);
		 System.out.println(Arrays.toString(chem));
		 result.add(chem[0]);
		 for (int i = 1,size=chem.length; i <size; i++) {
			if(result.get(result.size()-1).high<chem[i].low) {
				result.add(chem[i]);
			}
		}
		return result;
	}
	
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Temper[] chem= new Temper[N];
		for (int i = 0; i < N; i++) {
			String[] st=br.readLine().split(" ");
			chem[i]=new Temper(Integer.parseInt(st[0]),Integer.parseInt(st[1]));
			
		}
		List<Temper> result =getSchedule(chem);
		System.out.println(result.size());
	}

}
