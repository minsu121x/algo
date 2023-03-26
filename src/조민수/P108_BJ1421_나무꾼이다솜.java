package 조민수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P108_BJ1421_나무꾼이다솜 {
    static int N,C,W,max,result;

    static int[] woods;

    public static void main(String[] args) throws IOException {
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    String []st=br.readLine().split(" ");
    N=Integer.parseInt(st[0]);
    C=Integer.parseInt(st[1]);
    W=Integer.parseInt(st[2]);
    woods=new int[N];
    max=Integer.MIN_VALUE;

    result=Integer.MIN_VALUE;
        for(int i=0;i<N;i++){
        st=br.readLine().split(" ");
        woods[i]=Integer.parseInt(st[0]);
        if(max<woods[i]){
            max=woods[i];
        }
    }
        for (int i = 1; i <= max; i++) {
            int sum = 0;
            for (int j = 0; j < N; j++) {
                int cut = 0;
                if(woods[j] >= i) {
                    if(woods[j] % i == 0) cut = woods[j] / i - 1;
                    else cut = woods[j] / i;
                    if(W * i * (woods[j] /i) - cut * C > 0) sum += W * i * (woods[j] /i) - cut * C;
                }
            }
            result = Math.max(result, sum);
        }
        System.out.println(result);
    }

}

//    public static void cut(int i) {
//        int sum=0;
//        for(int j=0;j<N;j++){
//            int piece=woods[j] / i;
//            int cut=0;
//            if(woods[j]>=i){
//                if(woods[j]%i==0) {
//                    cut = woods[j] / i -1;
//                }
//                else{
//                    cut = woods[j] / i;
//                }
//
//                if(W*i*piece -cut*C>0){
//                    sum+=W*i*piece -cut*C;
//                }
////                int now=0;
////                now+=W*size*piece;
////                now-=C*cut;
////                if(now>0){
////                    sum+=now;
////                }
//            }
//
//
//
//        }
//
//        if(sum>result){
//            result=sum;
//        }
//    }
//}

