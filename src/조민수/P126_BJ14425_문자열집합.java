package 조민수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class P126_BJ14425_문자열집합 {
    static HashMap<String,Integer>map;
    static int n,m,answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        String[]st=br.readLine().split(" ");
        n=Integer.parseInt(st[0]);
        m=Integer.parseInt(st[1]);
        answer=0;
        map=new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(br.readLine(),1);
        }
        for(int i=0;i<m;i++){
            if(map.containsKey(br.readLine())){
                answer++;
            }
        }
        System.out.println(answer);
    }
}
