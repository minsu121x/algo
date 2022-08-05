package 조민수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class P015_BJ12891_DNA비밀번호 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int dnaLen=0;
		int codeLen=0;
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		String st=br.readLine();
		String[] str=st.split(" ");
		dnaLen=Integer.parseInt(str[0]);//비교할 DNA 길이
		codeLen=Integer.parseInt(str[1]);//맞춰볼 코드 길이
		int[] ans =new int[4];//정답으로 인정하는 코드(A,C,G,T)
		int[] code= new int[4];//비교할 코드
		int result=0;//결과값 저장
		boolean checkflag=true;//code의 합 불합을 체크하는 플래그 맞으면 true 틀리면 false
		Queue<String> codeCheck = new LinkedList<String>(); 
		String dnacode=br.readLine();
		st=br.readLine();
		str=st.split(" ");
		for(int i=0;i<4;i++){
			ans[i]=Integer.parseInt(str[i]);
		}
		String[] dnaStr=dnacode.split("");
		for(int i=0;i<dnaLen;i++) {
			if(i<codeLen-1) {//code 최소 비굑길이 이전이 될때까진 코드채우기 비교길이가 4면 3까지만 채우기
				switch (dnaStr[i]) {
				case "A":
					code[0]++;
					codeCheck.offer("A");
					break;
				case "C":
					code[1]++;
					codeCheck.offer("C");
					break;
				case "G":
					code[2]++;
					codeCheck.offer("G");
					break;
				case "T":
					code[3]++;
					codeCheck.offer("T");
					break;
				}
			}
			else {//지금부턴 결과랑 비교
				switch (dnaStr[i]) {
				case "A":
					code[0]++;
					codeCheck.offer("A");
					break;
				case "C":
					code[1]++;
					codeCheck.offer("C");
					break;
				case "G":
					code[2]++;
					codeCheck.offer("G");
					break;
				case "T":
					code[3]++;
					codeCheck.offer("T");
					break;
				}
				for(int j=0;j<4;j++) {
					if(ans[j]>code[j]) {
						checkflag=false;
						break;
					}
			}
				if(checkflag) {//code가 맞는다
					switch (codeCheck.poll()) {//맨 앞자리 버리기 +결과값 +1
						case "A":
							code[0]--;
							result++;
							break;
						case "C":
							code[1]--;
							result++;
							break;
						case "G":
							code[2]--;
							result++;
							break;
						case "T":
							code[3]--;
							result++;
							break;
						}
					
					}
				
				
				else{//맞지않는다
					switch (codeCheck.poll()) {//맨 앞자리 버리기 +flag값 원복
					case "A":
						code[0]--;
						checkflag=true;
						break;
					case "C":
						code[1]--;
						checkflag=true;
						break;
					case "G":
						code[2]--;
						checkflag=true;
						break;
					case "T":
						code[3]--;
						checkflag=true;
						break;
					}
				
				}
				}
			}
			System.out.println(result);
		}
		
	}

