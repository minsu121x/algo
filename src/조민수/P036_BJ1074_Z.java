package 조민수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P036_BJ1074_Z {
	static int num=0;
	
	
	static void Z(int size,int r,int c) {//X: 열 Y: 행
		if(size==1) {//size가 1 -> 최소단위까지 분할 끝
			return;//종료
		}
		 if(r < size/2 && c < size/2) {  // 1사분면
	            Z(size/2, r, c);//숫자는 변함 X
	        }
	     else if(r < size/2 && c>=  size/2) {  // 2사분면
	            num += size*size/4; // 2사분면-> 현재 사이즈값의 1/4
	            Z(size/2, r,c-size/2);// Y범위 조정 ->3사분면을 전체로 해서 다시 분할
	        }  
	     else if(r >= size/2 && c <size/2) {  // 3사분면
	            num += size*size/4*2;// 3사분면 -> 현재 사이즈값의 2/4
	            Z(size/2, r-size/2, c);// X범위 조정 ->2사분면을 전체로 해서 다시 분할
	        } 
	     else if(r >= size/2 && c >= size/2) { // 4사분면
	            num +=size*size/4*3 ; // 4사분면> 현재 사이즈값의 3/4
	            Z(size/2, r-size/2, c-size/2);//범위 조정 ->4사분면을 전체로 해서 다시 분할
	        }
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] st= br.readLine().split(" ");
		int N= Integer.parseInt(st[0]);
		int r= Integer.parseInt(st[1]);
		int c= Integer.parseInt(st[2]);
		int size=(int)Math.pow(2,N);
		Z(size,r,c);
		System.out.println(num);
		
		}

}
