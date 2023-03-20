package 조민수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P105_BJ15649_N과M1 {
    static int M, N;
    static int [] num;
    static boolean[] visit;
    static StringBuilder sb = new StringBuilder();//출력이 많을 경우, sb로 푸는게 매우매우 빠름...
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        String [] st =br.readLine().split(" ");
        N=Integer.parseInt(st[0]);
        M=Integer.parseInt(st[1]);
        num = new int[M];
        visit=new boolean[N+1];
        dfs(0);
        System.out.println(sb);
    }

    public static void dfs(int cnt){
        if(cnt==M){
            for(int i=0;i<M;i++){
                sb.append(num[i]).append(' ');
            }
            sb.append('\n');
            return;
        }
        for(int i=1;i<=N;i++){
            if(!visit[i]){
                num[cnt]=i;
                visit[i]=true;
                dfs(cnt+1);
                visit[i]=false;
            }

        }
    }
}
