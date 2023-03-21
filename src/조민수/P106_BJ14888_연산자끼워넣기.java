package 조민수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P106_BJ14888_연산자끼워넣기 {

    static int N,max,min;
    static int [] num,operator,operators;//숫자 저장 배열 num , 연산자 갯수 저장배열 operator, 연산에 사용할 연산자 저장 배열 calculate
    public static void main(String[] args) throws IOException {
        operator=new int[4]; // + - * / 순서
        max=Integer.MIN_VALUE;
        min=Integer.MAX_VALUE;
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());//연산할 숫자의 수
        num=new int[N];
        operators=new int[N];
        String []st=br.readLine().split(" ");
        for(int i=0;i<N;i++){
            num[i]=Integer.parseInt(st[i]);
        }
        st=br.readLine().split(" ");
        for(int i=0;i<4;i++){
            operator[i]=Integer.parseInt(st[i]);
        }
        dfs(0);
        System.out.println(max+"\n"+min);

    }

    public static void dfs(int cnt) {
        if(cnt==N-1){//연산자를 모두 선택했다.
            int result=num[0];//연산의 결과를 저장할 result 변수
            for(int i=1;i<N;i++){//생성된 연산자 순열과 숫자배열을 이용해 연산 수행
                result=calculate(result,num[i],operators[i]);//calculate 함수를 이용, result와 숫자를 연산
            }
            if(result>max){//최댓값 비교 후 갱신
                max=result;
            }
            if(result<min){//최솟값 비교 후 갱신
                min=result;
            }
        }
        for(int i=0;i<4;i++){//operator를 돌면서 사용가능한 연산자를 사용
            if(operator[i]>0){//현재 연산자가 1개이상 존재한다.
                operator[i]--;//현재 연산자를 사용
                operators[cnt+1]=i;//현재 연산자를 순열에 기록
                dfs(cnt+1);//다음 연산자를 선택하러 이동
                operator[i]++;//dfs가 끝나면 연산자는 선택 초기화
            }
        }

    }

    private static int calculate(int result, int i, int operator) {
        switch (operator){//operator에 입력된 값에 따라 사칙연산 진행
            case 0:
                return result+i;
            case 1:
                return result-i;
            case 2:
                return result*i;
            case 3:
                return result/i;
        }
        return 0;
    }

}
