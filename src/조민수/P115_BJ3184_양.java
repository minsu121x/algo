package 조민수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class P115_BJ3184_양 {
    static int[]dx={-1,1,0,0};//상하좌우순으로 탐색
    static int[]dy={0,0,-1,1};
    static char[][]map;//입력값 저장
    static boolean[][]visited;//방문여부 판단
    static int R,C,wolf,sheep;//map의 행 열 R C, 최종 양과 늑대의 수 저장할 wolf sheep
    static ArrayDeque<int[]> queue;//이동 가능한 좌표를 저장할 덱
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        String [] st=br.readLine().split(" ");
        R=Integer.parseInt(st[0]);
        C=Integer.parseInt(st[1]);
        map=new char[R][C];
        visited=new boolean[R][C];
        queue=new ArrayDeque<int[]>();
        for(int i=0;i<R;i++){
            st=br.readLine().split("");
            for (int j=0;j<C;j++){
                map[i][j]=st[j].charAt(0);
            }
        }
        for(int i=0;i<R;i++){
            for (int j=0;j<C;j++){
                if(map[i][j]!='#'&&!visited[i][j]){//이동가능한 좌표 (./v/o) &방문한 적 없는 좌표
                    queue.add(new int[]{i,j});//좌표 저장
                    visited[i][j]=true;
                    bfs();//탐색
                }
            }
        }
    System.out.println(sheep+" "+wolf);
    }

    public static void bfs(){
        int _wolf=0;//현재 울타리 내의 늑대 수
        int _sheep=0;//현재 울타리 내의 양 수
        while(!queue.isEmpty()){
            int[] point=queue.poll();
            int x=point[0];
            int y=point[1];
          //  visited[x][y]=true;//현재 좌표의 방문 처리
            if(map[x][y]=='o'){//현재 좌표가 양이면
                _sheep++;
            }
            else if (map[x][y]=='v') {//현재 좌표가 늑대면
                _wolf++;
            }
            for(int i=0;i<4;i++){
                if(0<=x+dx[i]&&x+dx[i]<R&&0<=y+dy[i]&&y+dy[i]<C&&map[x+dx[i]][y+dy[i]]!='#'&&!visited[x+dx[i]][y+dy[i]]){
                    //이동 가능하고 방문한 적 없는 좌표면
                    queue.add(new int[]{x+dx[i],y+dy[i]});
                    visited[x+dx[i]][y+dy[i]]=true;//현재 좌표의 방문 처리
                }
            }
        }
        if(_wolf<_sheep){//울타리내에 양 수가 더 많으면
            sheep+=_sheep;//양만 살아남는다.
        }
        else{//늑대가 더 많거나 같은경우
            wolf +=_wolf;//늑대만 살아남는다.
        }
    }
}
