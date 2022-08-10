package 조민수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P026_BJ16935_배열돌리기3 {
	static int N;
	static int M;
	static int R;
	static int[][] arr;
	
	static void oprt1() {
		int n=arr.length;
		int m=arr[0].length;
		int mid=n/2;
		int [][]result=new int[n][m];
		for(int i=0;i<mid;i++) {
				result[i]=arr[n-1-i];
				result[n-1-i]=arr[i];
		}
		arr=result;
	}
	
	static void oprt2() {
		int n=arr.length;
		int m=arr[0].length;
		int mid=m/2;
		int [][]result=new int[n][m];
		for(int i=0;i<n;i++) {
			for(int j=0;j<mid;j++) {
				result[i][j]=arr[i][m-1-j];
				result[i][m-1-j]=arr[i][j];
			}
		}
		arr=result;
	}	
	static void oprt3() {
		int n=arr.length;
		int m=arr[0].length;
		int [][]result=new int[m][n];
		for(int i =0;i<m;i++) {
			for(int j =0;j<n;j++) {
				result[i][j]=arr[n-1-j][i];
			}
		}
		arr=result;
	}	
	static void oprt4() {
		int n=arr.length;
		int m=arr[0].length;
		int [][]result=new int[m][n];
		for(int i =0;i<m;i++) {
			for(int j =0;j<n;j++) {
				result[i][j]=arr[j][m-1-i];
			}
		}
		arr=result;
	}	
	static void oprt5() {
		int n=arr.length;
		int m=arr[0].length;
		int midN=n/2;
		int midM=m/2;
		int [][]result=new int[n][m];
		for(int i=0;i<midN;i++) {//4->1번자리
			for(int j=0;j<midM;j++) {
				result[i][j]=arr[i+midN][j];
			}
		}
		for(int i=0;i<midN;i++) {//1->2
			for(int j=midM;j<m;j++) {
				result[i][j]=arr[i][j-midM];
			}
		}
		for(int i=midN;i<n;i++) {//2->3
			for(int j=midM;j<m;j++) {
				result[i][j]=arr[i-midN][j];
			}
		}
		for(int i=midN;i<n;i++) {//3->4
			for(int j=0;j<midM;j++) {
				result[i][j]=arr[i][j+midM];
			}
		}
		arr=result;
	}	
	static void oprt6() {
		int n=arr.length;
		int m=arr[0].length;
		int midN=n/2;
		int midM=m/2;
		int [][]result=new int[n][m];
		for(int i=0;i<midN;i++) {
			for(int j=0;j<midM;j++) {
				result[i][j]=arr[i][j+midM];
			}
		}
		for(int i=0;i<midN;i++) {
			for(int j=midM;j<m;j++) {
				result[i][j]=arr[i+midN][j];
			}
		}
		for(int i=midN;i<n;i++) {
			for(int j=midM;j<m;j++) {
				result[i][j]=arr[i][j-midM];
			}
		}
		for(int i=midN;i<n;i++) {
			for(int j=0;j<midM;j++) {
				result[i][j]=arr[i-midN][j];
			}
		}
		arr=result;
	}
	
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String [] st=br.readLine().split(" ");
		 N=Integer.parseInt(st[0]);
		 M=Integer.parseInt(st[1]);
		 R=Integer.parseInt(st[2]);
		 arr= new int[N][M];
		
		for(int i=0;i<N;i++) {
			st=br.readLine().split(" ");
			for(int j=0;j<M;j++) {
				arr[i][j]=Integer.parseInt(st[j]);
			}
		}
		st=br.readLine().split(" ");
		for(int i=0;i<R;i++) {
			int opr=Integer.parseInt(st[i]);
			switch(opr) {
			case 1:
				oprt1();
				break;
			case 2:
				oprt2();
				break;
			case 3:
				oprt3();
				break;
			case 4://여기까진 못탐
				oprt4();
				break;
			case 5://이것도 타는데 이상해
				oprt5();
				break;
			case 6://이건 탐
				oprt6();
				break;
			}
		}
		for(int i =0; i<arr.length;i++) {
			for(int j=0;j<arr[0].length;j++) {
				sb.append(arr[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
