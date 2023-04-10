package 조민수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P120_BJ9081_단어맞추기 {
    static char[] wordArr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        for (int t=0;t<TC;t++) {
            String word = br.readLine();
            wordArr=new char[word.length()];
            for(int i=0;i<word.length();i++){
                wordArr[i]=word.charAt(i);
            }
            if(nextPerm()) {
             System.out.println(new String(wordArr));

            } else {
            System.out.println(word);
            }
        }

    }

    static boolean nextPerm() {
        /*
            다음순열 알고리즘:
            1. 이번 단어의 다음 순서에 올려면 뒤에서 부터 탐색필요
            2. 뒤에서 부터 오름차순이 깨지는 가장 첫 위치 i 저장
            3. 다시 뒤에서부터 탐색하며 i보다 큰 값이 나오는 첫 위치 j 저장
            4. 둘의 위치 변경 후 i~문자열 끝까지 문자를 정렬(이리 내림차순으로 정렬이므로 뒤집기만 해도 오름차순)


         */
        int length=wordArr.length-1;
        int i = length;
        while(i>0 && wordArr[i-1]>=wordArr[i]) --i;
        if (i==0) return false;  // i가 0이라면 정렬 끝으로 다음 순열이 없으므로 false 리턴

        // 2. 교환할 위치 찾기
        int j = length;
        while(wordArr[i-1]>=wordArr[j]) --j;

        // 3. 교환
        char temp = wordArr[i-1];
        wordArr[i-1] = wordArr[j];
        wordArr[j] = temp;

        // 4. 교환 위치 이후 값 정렬
        int k =length;
        while(i<k) {
            temp = wordArr[i];
            wordArr[i] = wordArr[k];
            wordArr[k] = temp;
            ++i; --k;
        }
        return true;
    }
}
