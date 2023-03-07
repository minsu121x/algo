package 조민수;
import java.io.*;

public class P100_BJ16968_차량번호판1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        String [] st=br.readLine().split("");
        int result=1;//최종 출력할 결과값 / 기본값 1
        String index=st[0];//맨처음 문자부터 시작
        if(index.equals("c")){// 맨처음 문자가 c면 -> 문자입력 가능
            result=result*26;//경우의 수 26가지
        }
        else{//d일 경우 숫자 입력
            result=result*10;//10가지 경우의 수
        }
        for(int i=1;i<st.length;i++){//첫 문자를 제외한 나머지 문자 확인

            //현재 문자의 c d 여부에 따라 계산
            if(st[i].equals("c")){

                //현재 문자가 이전 문자와 같은 경우
                //같은 문자가 올 수 없기 때문에 경우의 수가 -1로 줄어든다.
                if(st[i].equals(index)){
                    result=result*25;
                }
                else{
                    result=result*26;
                }
                index=st[i];
            }
            else{

                if(st[i].equals(index)){
                    result=result*9;
                }
                else{
                    result=result*10;
                }
                index=st[i];//현재 문자값을 인덱스에 저장 후 다음과 비교 반복
            }
        }
        System.out.println(result);//최종값 출력
    }
}
