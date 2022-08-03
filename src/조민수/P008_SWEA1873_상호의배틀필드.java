package 조민수;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class P008_SWEA1873_상호의배틀필드 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String st=br.readLine();
		int tc=Integer.parseInt(st);
		for(int Test=1;Test<=tc;Test++) {
			st=br.readLine();
			String[] ch=st.split(" ");
			char tank='^';//기본값
			int h=Integer.parseInt(ch[0]);
			int w=Integer.parseInt(ch[1]);
			System.out.println(h+" "+w);
			int x=0;
			int y=0;
			char[][] map=new char[h][w];
			for(int i=0;i<h;i++) {
				st=br.readLine();
				for(int j=0;j<w;j++) {
					char mapValue=st.charAt(j);
					if(mapValue=='<'||mapValue=='>'||mapValue=='^'||mapValue=='v'){
						x=i;
						y=j;
						tank=mapValue;
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
						y=y-1;//올라가기
					}
					break;
				case 'R':
					tank='>';
					if(y+1<w&&map[x][y+1]=='.') {//우측이 존재하고 평지면
						map[x][y]='.';//내자리는 평지해놓고
						y=y+1;//올라가기
					}
					break;
				case 'S':
					int Sx=x;
					int Sy=y;//포탄 좌표
					switch(tank) {
					case '^':
						Sx--;
						while(Sx>=0) {
							if(map[Sx][Sy]=='#')//강철벽
								break;
							else if(map[Sx][Sy]=='*') {
								map[Sx][Sy]='.';
								break;
							}
							Sx--;
						}
						break;
					case 'v':
						Sx++;
						while(Sx<h) {
							if(map[Sx][Sy]=='#')//강철벽
								break;
							else if(map[Sx][Sy]=='*') {
								map[Sx][Sy]='.';
								break;
							}
							Sx++;
						}
						break;
					case '<':
						Sy--;
						while(Sy>=0) {
							if(map[Sx][Sy]=='#')//강철벽
								break;
							else if(map[Sx][Sy]=='*') {
								map[Sx][Sy]='.';
								break;
							}
							Sy--;
						}
						break;
					case '>':
						Sy++;
						while(Sy<w) {
							if(map[Sx][Sy]=='#')//강철벽
								break;
							else if(map[Sx][Sy]=='*') {
								map[Sx][Sy]='.';
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
