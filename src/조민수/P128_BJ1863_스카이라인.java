package 조민수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class P128_BJ1863_스카이라인 {
    static int n,answer;
    static int[] arr;
    static Stack<Integer> tower;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());
        tower=new Stack<Integer>();
        answer=0;
        arr=new int[n+1];
        for(int i=0;i<n;i++){
            String[] st=br.readLine().split(" ");
            arr[i]=Integer.parseInt(st[1]);
        }

        for(int i=0;i<=n;i++){


            while(!tower.isEmpty()&&tower.peek()>arr[i]){
                answer++;
                tower.pop();
            }


            if(!tower.isEmpty()&&tower.peek()==arr[i]){
                continue;
            }
            tower.add(arr[i]);
        }
        System.out.println(answer);
    }

}
