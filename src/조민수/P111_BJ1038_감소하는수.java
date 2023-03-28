package 조민수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P111_BJ1038_감소하는수{
    static List<Long> list = new ArrayList<>();
    static int N;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        if(N <= 10) {//10이하면 0~10으로 바로 출력 가능
            System.out.print(N);
            return;
        } else if (N >= 1023) {//1023 이상은 범위를 벗어남
            System.out.print(-1);
            return;
        }

        for(int i = 0; i < 10; i++) {//11~1022까지는 리스트에 추가 후 선택하기
            dfs(i);
        }

        Collections.sort(list);//list 정렬
        System.out.print(list.get(N));//N번째 값 출력
    } // End of main

    private static void dfs(long num) {
        list.add(num);
        long modValue = num % 10;//1의 자리가 0인지 확인
        if(modValue == 0) {//나머지 0 ->1의자리가 0 -> 뒤로 더 붙일 숫자가 없다
            return;//return;
        }

        for(long i=modValue-1; i>=0; i--) {//현재 나온 숫자 modeValue보다 뒤에 붙을 숫자 i가 더 작아야함.
            long newValue = num * 10 + i;//원래 수에 뒷자리 i를 추가함
            dfs(newValue);
        }
    }
}
