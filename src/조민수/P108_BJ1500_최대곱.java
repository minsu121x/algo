package 조민수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P108_BJ1500_최대곱 {
    static int S,K;
    static long result;
    static int[] num;

    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        String [] st=br.readLine().split(" ");
        S=Integer.parseInt(st[0]);
        K=Integer.parseInt(st[1]);
        result=1;
        num=new int[K];
        Arrays.fill(num,S/K);
        int cal=S-(S/K*K);
        for(int i=0;i<K;i++){
            if(cal>0){
                cal--;
                result*=num[i]+1;
            }
            else{
                result*=num[i];
            }

        }

        System.out.println(result);
    }

}
