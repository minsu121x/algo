package 조민수;

import com.sun.tools.javac.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P113_BJ1484_다이어트 {
    public static long[] square;
    public static int N;
    public static double pre,post;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        //int size=0;
        int max=100000;//N의 최댓값이 100,000일 때, 50,001^2 - 50,000^2 부터 100,000을 넘어간다
        if(N==1){//N의 가능한 최소값이 2^2-1^2 = 3 이므로, 3보다 작으면 가능한 수가 없음
        System.out.println("-1");
        return;
        }

//        for(int i=1;i<=max;i++){
//            pre=i*i;
//            post=(i+1)*(i+1);
//            if(post-pre>N){
//                size=i+1;
//                break;
//            }
//        }
        square=new long[max+2];

        for(int i=1;i<=max;i++){
            square[i]=i*i;
        }
        boolean flag=false;
        int start=1;
        int end =1;
        while(true) {
            long G = square[end] - square[start];
            if(end - start == 1 && G > N)    break;
            if(G == N) {
                flag=true;
                System.out.println(end);
            }
            if(G > N) {
                start++;
            }
            if(G <=N) {
                end++;
            }
        }
//        for(int i=2;i<size;i++){
//            for(int j=i-1;j>=1;j--){
//                if(square[i]-N==square[j]){
//                    flag=true;
//                    System.out.println(i);
//                }
//                else if(square[i]-square[j]>N){//더 확인할 필요없이 종료
//                    break;
//                }
//            }
//        }
        if(!flag){
            System.out.println("-1");
            return;
        }
    }
}
