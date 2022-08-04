package 조민수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class P013_SWEA1225_암호생성기 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Deque<Integer> password=new ArrayDeque<>();
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String sr="";
		
		
		for(int tc=1;tc<=10;tc++) {
			sr=br.readLine();
			System.out.println(Integer.parseInt(sr));
			sr=br.readLine();
			String[] str= sr.split(" ");
			for (int i = 0; i < 8; i++) {
				password.offer(Integer.parseInt(str[i]));
			
			}
			System.out.println("#num"+password.toString());
			int cycle= 0;
			while(true) {
				cycle=cycle%5;//1 2 3 4 5만 나오도록
				cycle++;
				int num=password.poll()-cycle;
				if(num<=0) {
					password.offer(0);
					System.out.print("#"+tc+" ");
					for (int i = 0; i <8; i++) {
						System.out.print(password.poll()+" ");
					}
					System.out.println();
					password.clear();
					break;
				}
				password.offer(num);
			}
		}
		
		
		/*for(int tc=1;tc<=10;tc++) {
			sr=br.readLine();
			System.out.println(Integer.parseInt(sr));
			sr=br.readLine();
			String[] str= sr.split(" ");
			for (int i = 0; i < 8; i++) {
				int passnum=Integer.parseInt(str[i]);
				password.offer(passnum%15);
			
			}
			System.out.println("#num"+password.toString());

			if(password.contains(0)) {//싸이클 하나 전으로
				for (int i = 0; i < 8; i++) {
					password.offer(password.poll()+15);
				}
				System.out.println("#Cal"+password.toString());

			}
			int cycle= 0;
			while(true) {
				cycle=cycle%5;//1 2 3 4 5만 나오도록
				cycle++;
				int num=password.poll()-cycle;
				if(num<=0) {
					password.offer(0);
					System.out.print("#"+tc+" ");
					for (int i = 0; i <8; i++) {
						System.out.print(password.poll()+" ");
					}
					System.out.println();
					password.clear();
					break;
				}
				password.offer(num);
				System.out.println("#Cycle"+password.toString());
			}
		}*/
	}

}
