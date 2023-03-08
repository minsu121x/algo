
package 조민수;
import java.io.*;

public class P101_BJ16917_양념반후라이드반 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int result=0;
        //얌념가격 A 후라이드 가격 B 반반 가격 C 얌념갯수 X 후라이드 개수 Y
        String[] st= br.readLine().split(" ");
        int A = Integer.parseInt(st[0]); //얌념가격 A
        int B = Integer.parseInt(st[1]); //후라이드 가격 B
        int C = Integer.parseInt(st[2]); //반반 가격 C
        int X = Integer.parseInt(st[3]); //얌념 최소 개수 X
        int Y = Integer.parseInt(st[4]); // 후라이드 최소 개수 Y
        //데이터 저장
        if(C<=A+B){ //반반가격이 더 저렴하면 반반을 구매하는 게 이득
            if(X>Y){//양념갯수가 더 많으면
                result+=2*C*Y;// 반반으로 구매
                result+=A*(X-Y);//남은 양념개수만큼 구매
            }
            else{
                result+=2*C*X;// 반반으로 구매
                result+=B*(Y-X);//남은 양념개수만큼 구매
            }
        }
        else{// 낱개 구매가 더 저렴하면 낱개로 구매
            result=A*X + B*Y;
        }

        System.out.println(result);//최종값 출력
    }
}

