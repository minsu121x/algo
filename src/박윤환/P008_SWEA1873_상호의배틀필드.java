package 박윤환;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P008_SWEA1873_상호의배틀필드 {

	public static void main(String[] args) throws Exception {
//		System.setIn(new FileInputStream("input1.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			String[] st = br.readLine().split(" ");
			int h = Integer.parseInt(st[0]);
			int w = Integer.parseInt(st[1]);
			int cordI = 0;
			int cordJ = 0;
			
			char[][] map = new char[h][w];
			for(int i=0; i<h; i++) {
				char[] ch = br.readLine().toCharArray();
				for(int j=0; j<w; j++) {
					if(ch[j] == '<' || ch[j] == '>' || ch[j] == '^' || ch[j] == 'v') {
						cordI = i;
						cordJ = j;
					}
					map[i][j] = ch[j];
				}
			}
			
			int n = Integer.parseInt(br.readLine());
			char[] action = br.readLine().toCharArray();
			
			for (char act : action) {
				switch(act) {
					case 'U':
						map[cordI][cordJ] = '^';
						if(cordI-1 >= 0) {
							if(map[cordI-1][cordJ] == '.') {
								map[cordI][cordJ] = '.';
								map[cordI-1][cordJ] = '^';
								cordI = cordI - 1;
							}
						}
						break;
					case 'D':
						map[cordI][cordJ] = 'v';
						if(cordI+1 <= h-1) {
							if(map[cordI+1][cordJ] == '.') {
								map[cordI][cordJ] = '.';
								map[cordI+1][cordJ] = 'v';
								cordI = cordI + 1;
							}
						}
						break;
					case 'L':
						map[cordI][cordJ] = '<';
						if(cordJ-1 >= 0) {
							if(map[cordI][cordJ-1] == '.') {
								map[cordI][cordJ] = '.';
								map[cordI][cordJ-1] = '<';
								cordJ = cordJ - 1;
							}
						}
						break;
					case 'R':
						map[cordI][cordJ] = '>';
						if(cordJ+1 <= w-1) {
							if(map[cordI][cordJ+1] == '.') {
								map[cordI][cordJ] = '.';
								map[cordI][cordJ+1] = '>';
								cordJ = cordJ + 1;
							}
						}
						break;
					case 'S':
						int shotI = cordI;
						int shotJ = cordJ;
						switch(map[cordI][cordJ]) {
							case '^':
								while(shotI-1 >= 0) {
									if(map[shotI-1][shotJ] == '*') {
										map[shotI-1][shotJ] = '.';
										break;
									} else if(map[shotI-1][shotJ] == '#') {
										break;
									}
									shotI--;
								}
								break;
							case 'v':
								while(shotI+1 <= h-1) {
									if(map[shotI+1][shotJ] == '*') {
										map[shotI+1][shotJ] = '.';
										break;
									} else if(map[shotI+1][shotJ] == '#') {
										break;
									}
									shotI++;
								}
								break;
							case '<':
								while(shotJ-1 >= 0) {
									if(map[shotI][shotJ-1] == '*') {
										map[shotI][shotJ-1] = '.';
										break;
									} else if(map[shotI][shotJ-1] == '#') {
										break;
									}
									shotJ--;
								}
								break;
							case '>':
								while(shotJ+1 <= w-1) {
									if(map[shotI][shotJ+1] == '*') {
										map[shotI][shotJ+1] = '.';
										break;
									} else if(map[shotI][shotJ+1] == '#') {
										break;
									}
									shotJ++;
								}
								break;
						}
						break;
				}
			}
			sb.append("#" + tc + " ");
			for(int i=0; i<h; i++) {
				for(int j=0; j<w; j++) {
					sb.append(map[i][j]);
				}
				sb.append("\n");
			}
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

}
