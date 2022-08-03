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
		
		int T = Integer.parseInt(br.readLine());	// 테스트 케이스 개수
		
		for(int tc=1; tc<=T; tc++) {	// 테스트 케이스 개수만큼 반복
			String[] st = br.readLine().split(" ");
			int h = Integer.parseInt(st[0]);	// 맵의 높이
			int w = Integer.parseInt(st[1]);	// 맵의 너비
			int cordI = 0;	// 현재 탱크의 행 위치를 나타낼 변수
			int cordJ = 0;	// 현재 탱크의 열 위치를 나타낼 변수
			
			char[][] map = new char[h][w];	// 맵 배열 선언
			for(int i=0; i<h; i++) {
				char[] ch = br.readLine().toCharArray();
				for(int j=0; j<w; j++) {	// 맵 초기화
					// 탱크의 초기 위치 저장
					if(ch[j] == '<' || ch[j] == '>' || ch[j] == '^' || ch[j] == 'v') {
						cordI = i;
						cordJ = j;
					}
					// 맵 요소 저장
					map[i][j] = ch[j];
				}
			}
			
			int n = Integer.parseInt(br.readLine());
			char[] action = br.readLine().toCharArray();	// 실행할 동작 저장
			
			// 저장된 동작을 하나씩 실행
			for (char act : action) {
				switch(act) {
					// Up일 경우
					case 'U':
						map[cordI][cordJ] = '^';	// 탱크가 위쪽을 바라보게
						if(cordI-1 >= 0) {	// 맵을 벗어나지 않을 경우에만
							if(map[cordI-1][cordJ] == '.') {	// 위쪽이 평지일경우
								map[cordI][cordJ] = '.';	// 현재 위치를 평지로 바꾸고
								map[cordI-1][cordJ] = '^';	// 탱크를 위쪽으로 이동
								cordI = cordI - 1;	// 현재 위치 변경
							}
						}
						break;
					// Down일 경우
					case 'D':
						map[cordI][cordJ] = 'v';	// 탱크가 아래쪽을 바라보게
						if(cordI+1 <= h-1) {	// 맵을 벗어나지 않을 경우에만
							if(map[cordI+1][cordJ] == '.') {	// 아래쪽이 평지일경우
								map[cordI][cordJ] = '.';	// 현재 위치를 평지로 바꾸고
								map[cordI+1][cordJ] = 'v';	// 탱크를 아래쪽으로 이동
								cordI = cordI + 1;	// 현재 위치 변경
							}
						}
						break;
					// Left일 경우
					case 'L':
						map[cordI][cordJ] = '<';	// 탱크가 왼쪽을 바라보게
						if(cordJ-1 >= 0) {	// 맵을 벗어나지 않을 경우에만
							if(map[cordI][cordJ-1] == '.') {	// 왼쪽이 평지일경우
								map[cordI][cordJ] = '.';	// 현재 위치를 평지로 바꾸고
								map[cordI][cordJ-1] = '<';	// 탱크를 왼쪽으로 이동
								cordJ = cordJ - 1;	// 현재 위치 변경
							}
						}
						break;
					// Right일 경우
					case 'R':
						map[cordI][cordJ] = '>';	// 탱크가 오른쪽을 바라보게
						if(cordJ+1 <= w-1) {	// 맵을 벗어나지 않을 경우에만
							if(map[cordI][cordJ+1] == '.') {	// 오른쪽이 평지일경우
								map[cordI][cordJ] = '.';	// 현재 위치를 평지로 바꾸고
								map[cordI][cordJ+1] = '>';	// 탱크를 오른쪽으로 이동
								cordJ = cordJ + 1;	// 현재 위치 변경
							}
						}
						break;
					// Shoot일 경우
					case 'S':
						// 현재 탱크의 위치를 포탄의 위치로 할당
						int shotI = cordI;
						int shotJ = cordJ;
						// 현재 탱크가 바라보는 방향에 따라 다른 결과
						switch(map[cordI][cordJ]) {
							// 위쪽을 바라볼 경우
							case '^':
								while(shotI-1 >= 0) {	// 맵을 벗어나지 않을 동안
									if(map[shotI-1][shotJ] == '*') {	// 벽돌벽을 만나면
										map[shotI-1][shotJ] = '.';	// 벽돌벽을 평지로 바꾼다
										break;
									} else if(map[shotI-1][shotJ] == '#') {	// 강철벽을 만나면 멈춘다
										break;
									}
									shotI--;	// 위쪽으로 포탄 이동
								}
								break;
							// 아래쪽을 바라볼 경우
							case 'v':
								while(shotI+1 <= h-1) {	// 맵을 벗어나지 않을 동안
									if(map[shotI+1][shotJ] == '*') {	// 벽돌벽을 만나면
										map[shotI+1][shotJ] = '.';	// 벽돌벽을 평지로 바꾼다
										break;
									} else if(map[shotI+1][shotJ] == '#') {	// 강철벽을 만나면 멈춘다
										break;
									}
									shotI++;	// 아래쪽으로 포탄 이동
								}
								break;
							// 왼쪽을 바라볼 경우
							case '<':
								while(shotJ-1 >= 0) {	// 맵을 벗어나지 않을 동안
									if(map[shotI][shotJ-1] == '*') {	// 벽돌벽을 만나면
										map[shotI][shotJ-1] = '.';	// 벽돌벽을 평지로 바꾼다
										break;
									} else if(map[shotI][shotJ-1] == '#') {	// 강철벽을 만나면 멈춘다
										break;
									}
									shotJ--;	// 왼쪽으로 포탄 이동
								}
								break;
							// 오른쪽을 바라볼 경우
							case '>':
								while(shotJ+1 <= w-1) {	// 맵을 벗어나지 않을 동안
									if(map[shotI][shotJ+1] == '*') {	// 벽돌벽을 만나면
										map[shotI][shotJ+1] = '.';	// 벽돌벽을 평지로 바꾼다
										break;
									} else if(map[shotI][shotJ+1] == '#') {	// 강철벽을 만나면 멈춘다
										break;
									}
									shotJ++;	// 왼쪽으로 포탄 이동
								}
								break;
						}
						break;
				}
			}
			// 출력내용 StringBuilder에 저장
			sb.append("#" + tc + " ");
			for(int i=0; i<h; i++) {
				for(int j=0; j<w; j++) {
					sb.append(map[i][j]);
				}
				sb.append("\n");
			}
		}
		
		bw.write(sb.toString());	// 최종내용 출력
		bw.flush();
		bw.close();
		br.close();
	}

}
