package 조민수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P107_BJ1182_부분수열의합 {
    static int N,target,result;//숫자갯수 N 타겟넘버 target 결과저장 result
    static int[]num;//숫자 저장
    static boolean[]isvisit;//방문여부 판단 배열
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] st = br.readLine().split(" ");
        N=Integer.parseInt(st[0]);
        target=Integer.parseInt(st[1]);
        result=0;
        num=new int[N];
        isvisit=new boolean[N];
        st = br.readLine().split(" ");
        for(int i=0;i<N;i++){
            num[i]=Integer.parseInt(st[i]);
        }
        select(0);
        System.out.println(result);
    }

    public static void select(int cnt){
        if(cnt==N){
            int sum=0;
            boolean istrue=false;
            for(int i=0;i<N;i++){
                if(isvisit[i]){
                    istrue=true;
                    sum+=num[i];
                }
            }
            if(sum==target&&istrue){
                result++;
            }
            return;
        }

            isvisit[cnt]=true;
            select(cnt+1);
            isvisit[cnt]=false;
            select(cnt+1);

    }
}
