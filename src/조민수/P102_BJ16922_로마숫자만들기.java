package 조민수;
import java.io.*;
public class P102_BJ16922_로마숫자만들기 {

    static boolean []number =new boolean [10001];//hashset은 시간초과 뜬다,,,
    static int[] roma= {1,5,10,50};
    static int answer,N;
    public static void main(String[] args) throws IOException{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
       //백트래킹을 이용해서 DFS로 모든 가능한 조합 비교 후 중복 제거
        answer=0;
        dfs(0,0,0);
        System.out.println(answer);

    }
    public static void dfs(int n,int start,int sum){
        if(n==N){//원하는 숫자만큼 숫자가 뽑히면 종료
            if(number[sum]){//이미 뽑힌 숫자면
                return;//종료
            }
            else{//처음나온 숫자다
                number[sum]=true;//숫자 표시
                answer++;//결과값 +1
                return;
            }
        }
        for(int i=start;i<4;i++){
            dfs(n+1,i,sum+roma[i]);
        }

    }



}
