package 조민수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P119_BJ16943_숫자재배치 {
    static int answer, B, C, length;
    static int[] num, cur;
    static boolean[] isselect;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] st = br.readLine().split(" ");
        answer = -1;//기본 값 -1
        B = Integer.parseInt(st[1]);//비교대상 B
        st = st[0].split("");//A는 길이를 알기 위해 쪼개서 저장
        length = st.length;
        num = new int[length];
        cur = new int[length];
        isselect=new boolean[length];
        for (int i = 0; i < length; i++) {
            num[i] = Integer.parseInt(st[i]);
        }
        perm(0);
        System.out.print(answer);
    }

        static void perm(int cnt){
        if(cnt==length){
            if(cur[0]==0){
                return;
            }
            int now=0;
            for(int i=0;i<length;i++){
                now=now*10+cur[i];//숫자 만들기
            }
            if(now>answer&&now<B){
                answer=now;
            }
            return;
        }
        for(int i=0;i<length;i++){
            if(!isselect[i]){
                isselect[i]=true;
                cur[cnt]=num[i];
                perm(cnt+1);
                isselect[i]=false;
            }
        }
    }
}
