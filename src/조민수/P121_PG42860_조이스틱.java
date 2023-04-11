package 조민수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P121_PG42860_조이스틱 {
    //0 1  2  3  4  5  6  7  8  9  10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25
    //A  B  C  D  E  F  G  H  I  J  K  L  M  N  O  P  Q  R  S  T  U  V  W  X  Y  Z
    //0 25 24 23 22 21 20 19 18 17 16 15 14 13 12 11 10  9  8  7  6  5  4  3  2  1
    //65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90
    // 문자 -'A' VS 'Z'-문자 +1 중 작은거
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String name=br.readLine();
        solution(name);
    }
    public static int solution(String name) {
        char [] word=name.toCharArray();
        int answer = 0;
        int move=word.length-1;//이동에 사용할 횟수 기본값은 문자값-1

        for(int i=0;i<word.length;i++){
            answer+=Math.min((word[i]-'A'),('Z'+1-word[i]));
            int index=i+1;
            while(index < word.length &&word[index] == 'A'){
                index++;//연속된 A 패스
            }

            // 순서대로 가는 것과, 뒤로 돌아가는 것 중 이동수가 적은 것을 선택
            move = Math.min(move, i * 2 + word.length - index);//정방향 move VS 역방향 (온 거리 i 반대로 가면 *2 거기서부터 갈만큼 이동)
            move = Math.min(move, (word.length - index) * 2 + i);//시작부터 반대로 가는 경우도 있다..!

        }
        answer+=move;
        return answer;
    }

}
