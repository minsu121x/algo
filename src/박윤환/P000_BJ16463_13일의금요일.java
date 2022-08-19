package 박윤환;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P000_BJ16463_13일의금요일 {
    static int cnt;

    static void count13thOfFriday(int day, boolean flag) {  // 해당년도의 1월1일 요일과 윤년 여부를 매개변수로 받음
        int date = 1;   // 1월1일
        day %= 7;   // 요일수가 7로 나눈 나머지로
        if(day != 5) {  // 금요일이 아닐 경우 금요일인 날짜로 변환
            if(5 - day > 0) {
                date += 5 - day;
            } else {
                date += 12 - day;
            }
        }
        for(int month=1; month<=12; month++) {  // 1월부터 12월까지 반복
            switch(month) {
                // 31일까지 있는 달
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    while(date <= 31) {     // 1달내에
                        if(date == 13) {    // 13일의 금요일일 경우
                            cnt++;  // 카운트 증가
                        }
                        date += 7;  // 일주일 증가
                    }
                    date -= 31; // 31일을 빼서 다음달로
                    break;
                // 2월
                case 2:
                    int maxDate = flag ? 29 : 28;   // 윤년 여부에 따라 최대 일수가 달라짐
                    while(date <= maxDate) {
                        if(date == 13) {    // 13일의 금요일일 경우
                            cnt++;  // 카운트 증가
                        }
                        date += 7;  // 일주일 증가
                    }
                    date -= maxDate;    // 2월의 최대일수만큼 뺴고 3월로
                    break;
                // 30일까지 있는 달
                case 4:
                case 6:
                case 9:
                case 11:
                    while(date <= 30) {     // 1달내에
                        if(date == 13) {    // 13일의 금요일일 경우
                            cnt++;  // 카운트 증가
                        }
                        date += 7;  // 일주일 증가
                    }
                    date -= 30; // 30일을 빼고 다음달로
                    break;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        // 월: 1, 화: 2, 수: 3, 목: 4, 금: 5, 토: 6, 일: 7
        int day = 2;  // 화요일
        for(int year=2019; year<=N; year++) {
            if((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
                // 윤년
                count13thOfFriday(day, true);
                day += 2;
            } else {
                // 평년
                count13thOfFriday(day, false);
                day++;
            }
        }

        System.out.println(cnt);

    }

}
