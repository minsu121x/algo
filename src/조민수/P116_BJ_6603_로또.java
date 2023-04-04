package 조민수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P116_BJ_6603_로또 {
    static int N,K;
    static int [] num,select;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        select=new int[6];
       while(true){
           String []st=br.readLine().split(" ");
           K=Integer.parseInt(st[0]);
           if(K==0){//첫 입력값이 0이면 수행 종료
               return;
           }
           num=new int[K];//입력받은 K만큼 배열 생성

           for(int i=0;i<K;i++){
               num[i]=Integer.parseInt(st[i+1]);
           }
           comb(0,0,0);
           System.out.println();//테스트 케이스마다 줄바꿈으로 구분
       }

    }
        static void comb(int start,int idx,int cnt){
            if(cnt==6){//숫자를 모두 입력받으면
                for(int i=0;i<6;i++){
                    System.out.print(select[i]+" ");//출력
                }
                System.out.println();
                return;
            }
            for(int i=start;i<K;i++){
                select[idx]=num[i];//이번 자리에 숫자 저장
                comb(i+1,idx+1,cnt+1);//start: 현재 저장한값에서 +1(다음값)부터 시작
            }
        }
}
