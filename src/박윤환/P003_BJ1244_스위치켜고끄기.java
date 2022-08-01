package 박윤환;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class P003_BJ1244_스위치켜고끄기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		int[] s = new int[n+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1; i<=n; i++) {
			s[i] = Integer.parseInt(st.nextToken());
		}
		int m = Integer.parseInt(br.readLine());
		int[][] students = new int[m][2];
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<2; j++) {
				students[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int[] student : students) {
			if(student[0] == 1) {
				int i = 1;
				while(student[1] * i <= n) {
					if(s[student[1]*i] == 0) {
						s[student[1]*i] = 1;
					} else if(s[student[1]*i] == 1) {
						s[student[1]*i] = 0;
					}
					i++;
				}
			} else if(student[0] == 2) {
				if(s[student[1]] == 0) {
					s[student[1]] = 1;
				} else if(s[student[1]] == 1) {
					s[student[1]] = 0;
				}
				int i = 1;
				while(true) {
					if(student[1] - i > 0 && student[1] + i <= n) {
						if(s[student[1]-i] == s[student[1]+i]) {
							if(s[student[1]+i] == 0) {
								s[student[1]+i] = 1;
								s[student[1]-i] = 1;
							} else if(s[student[1]+i] == 1) {
								s[student[1]+i] = 0;
								s[student[1]-i] = 0;
							}
						} else {
							break;
						}
					} else {
						break;
					}
					i++;
				}
			}
		}

		for(int i=1; i<=n; i++) {
			bw.write(s[i] + " ");
			if(i % 20 == 0) {
				bw.newLine();
			}
		}
		bw.newLine();
		
		bw.flush();
		bw.close();
		br.close();
		
	}

}
