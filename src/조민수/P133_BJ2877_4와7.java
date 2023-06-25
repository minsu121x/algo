package 조민수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P133_BJ2877_4와7 {
    public static void main(String[] args) throws IOException {
        //4와7을 이진법 0과1로 치환해서 풀이
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine())+1;//1일때 4(0) 2일 때 7(1) 3일 때 44(00) 이 나와야함. ->N+1을 이진법으로 바꾼 후 맨앞자리는 제거 3->(1)00 ==44
        StringBuilder sb=new StringBuilder();
        while(N>1){//이진법으로 치환
            if(N%2==0){
                sb.insert(0,0);
                N=N/2;
            }
            else{
                sb.insert(0,1);
                N=N/2;
            }
        }
        for(int i=0;i<sb.length();i++){//이진법으로 계산된 sb를 4와7로 치환
            if(sb.charAt(i)=='0'){
                System.out.print("4");
            }
            else{
                System.out.print("7");
            }
        }
    }
}
