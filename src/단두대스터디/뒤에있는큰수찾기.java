package 단두대스터디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 뒤에있는큰수찾기 {

        public int[] solution(int[] numbers) {
            int[] answer = {};
            return answer;
        }
    public void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String st=br.readLine();
        int[] numbers = new int[st.length()];

        for( int i = 0; i < st.length(); i++ ) {

            numbers[i] = st.charAt(i) - '0';
        }
        System.out.println(solution(numbers));
    }
}
