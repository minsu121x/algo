package 조민수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class P134_BJ10610_30 {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        String[]st=br.readLine().split("");
        Integer[] numbers=new Integer[st.length];
        boolean zero=false;
        int sum=0;
        for(int i=0;i<st.length;i++){
            numbers[i]=Integer.parseInt(st[i]);
            if(numbers[i]==0){
                zero=true;
            }
            sum+=numbers[i];
        }
        if(sum%3!=0||!zero){
            System.out.println(-1);
        }else{
            Arrays.sort(numbers, Collections.reverseOrder());
            StringBuilder sb= new StringBuilder();
        for(int i=0;i<numbers.length;i++){
               sb.append(numbers[i]);
            }
        System.out.println(sb);
        }


    }
}
