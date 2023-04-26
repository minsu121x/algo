package 조민수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P127_BJ6198_옥상정원꾸미기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int[] building=new int[n];
        long answer=0;
        for(int i=0;i<n;i++){
            building[i]=Integer.parseInt(br.readLine());
        }
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
               if(building[i]>building[j]){
                   answer++;
               }
               else{
                   break;
               }
            }
        }
        System.out.println(answer);
    }
}
