package 조민수;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class P008_SWEA1873_상호의배틀필드 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String st=br.readLine();
		int tc=Integer.parseInt(st);//테스트 케이스
		for(int Test=1;Test<=tc;Test++) {
			st=br.readLine();
			String[] ch=st.split(" ");
			char tank=' ';//기본값
			int h=Integer.parseInt(ch[0]);//높이
			int w=Integer.parseInt(ch[1]);//너비
			int x=0;
			int y=0;
			char[][] map=new char[h][w];
			for(int i=0;i<h;i++) {
				st=br.readLine();
				for(int j=0;j<w;j++) {//map에 저장하면서
					char mapValue=st.charAt(j);
					if(mapValue=='<'||mapValue=='>'||mapValue=='^'||mapValue=='v'){//탱크가 나왔다
						x=i;
						y=j;
						tank=mapValue;//탱크 위치 및 방향 저장
						//탱크 좌표값 저장
					}
					map[i][j]=mapValue;
				}
			}
			st=br.readLine();
			int moveCnt=Integer.parseInt(st);
			st=br.readLine();
			
			for(int i=0;i<moveCnt;i++) {
				char move = st.charAt(i);
				switch(move) {
				case 'U':
					tank='^';
					if(x-1>=0&&map[x-1][y]=='.') {//위가 존재하고 평지면
						map[x][y]='.';//내자리는 평지해놓고
						x=x-1;//올라가기
					}
					break;
				case 'D':
					tank='v';
					if(x+1<h&&map[x+1][y]=='.') {//아래가 존재하고 평지면
						map[x][y]='.';//내자리는 평지해놓고
						x=x+1;//내려가기
					}
					break;
				case 'L':
					tank='<';
					if(y-1>=0&&map[x][y-1]=='.') {//좌측이 존재하고 평지면
						map[x][y]='.';//내자리는 평지해놓고
						y=y-1;//좌로가기
					}
					break;
				case 'R':
					tank='>';
					if(y+1<w&&map[x][y+1]=='.') {//우측이 존재하고 평지면
						map[x][y]='.';//내자리는 평지해놓고
						y=y+1;//우로가기
					}
					break;
				case 'S':
					int Sx=x;
					int Sy=y;//포탄 좌표
					switch(tank) {
					case '^':
						Sx--;
						while(Sx>=0) {//포탄이 벽에 닿을때 까지
							if(map[Sx][Sy]=='#')//강철벽을 만나면
								break;//끝
							else if(map[Sx][Sy]=='*') {//일반벽을 만나면
								map[Sx][Sy]='.';//평지로 변환
								break;
							}
							Sx--;
						}
						break;
					case 'v':
						Sx++;
						while(Sx<h) {//포탄이 벽에 닿을때 까지
							if(map[Sx][Sy]=='#')//강철벽을 만나면
								break;//끝
							else if(map[Sx][Sy]=='*') {//일반벽을 만나면
								map[Sx][Sy]='.';//평지로 변환
								break;
							}
							Sx++;
						}
						break;
					case '<':
						Sy--;
						while(Sy>=0) {//포탄이 벽에 닿을때 까지
							if(map[Sx][Sy]=='#')//강철벽을 만나면
								break;//끝
							else if(map[Sx][Sy]=='*') {//일반벽을 만나면
								map[Sx][Sy]='.';//평지로 변환
								break;
							}
							Sy--;
						}
						break;
					case '>':
						Sy++;
						while(Sy<w) {//포탄이 벽에 닿을때 까지
							if(map[Sx][Sy]=='#')//강철벽을 만나면
								break;//끝
							else if(map[Sx][Sy]=='*') {//일반벽을 만나면
								map[Sx][Sy]='.';//평지로 변환
								break;
							}
							Sy++;
						}
						break;
						
					}
					break;
				}
			}
			map[x][y]=tank;
			System.out.print("#"+Test+" ");
			for(int i=0;i<h;i++) {
				for(int j=0;j<w;j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
		}
	}
}
