package 조민수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;

public class P122_BJ25565_딸기와토마토{
    public static int N,M,K;
    public static LinkedHashMap<int[],Integer> map;
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        String []st=br.readLine().split(" ");
        N=Integer.parseInt(st[0]);
        M=Integer.parseInt(st[1]);
        K=Integer.parseInt(st[2]);
        map=new LinkedHashMap<>();
        for(int i=1;i<=N;i++){
            st=br.readLine().split(" ");
            for(int j=1;j<=M;j++){
                if(st[j-1].equals("1")){
                    map.put(new int[]{i,j},1);
                }
            }
        }
        if(map.size()==K*2){
            System.out.println(0);
        }
        else if(map.size()==K){
            System.out.println(K);
            Iterator<int[]> keys=map.keySet().iterator();
            while(keys.hasNext()){
                int[] key=keys.next();
                for(int i:key){
                    System.out.print(i+" ");
                }
                System.out.println();
            }
        }
        else if(map.size()==K*2-1){
            int[] tomato=map.
        }
    }
}