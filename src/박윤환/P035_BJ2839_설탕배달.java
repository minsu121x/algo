package 박윤환;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P035_BJ2839_설탕배달 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int cnt = N / 5;    // 5로 나눈 만큼 초기 카운트
        N %= 5;     // 5로 나눈 나머지
        if(N % 3 == 0) {    // 나머지가 3으로 나눠지면
            cnt += N/3;     // 3으로 나눈 수를 카운트하고 끝
        } else {    // 3으로 안나눠지면
            while(cnt != 0) {   // 5로 나눈 수를 하나씩 줄여가며 0이 될때까지 반복
                N += 5;     // 다시 설탕 무게에 5kg를 더하고
                cnt--;      // 카운트 1 감소
                if(N % 3 == 0) {    // 그 뒤에 3으로 나눠지면
                    cnt += N/3;     // 3으로 나눈 수를 카운트하고 끝
                    break;
                }
            }
            if(cnt == 0) {      // 다 할때까지 3으로 안나눠지면
                cnt = -1;       // 정확하게 N킬로그램으로 만들 수 없으므로 -1
            }
        }

        System.out.println(cnt);
    }
}
