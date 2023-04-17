package 조민수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P123_BJ1189_컴백홈 {
    static final int[]dx={-1,1,0,0};
    static final int[]dy={0,0,-1,1};
    static char[][]map;
    static int answer,R,C,K;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] st = br.readLine().split(" ");
        R = Integer.parseInt(st[0]);
        C = Integer.parseInt(st[1]);
        K = Integer.parseInt(st[2]);
        answer=0;
        visited=new boolean[R][C];
        map=new char[R][C];
        for(int i=0;i<R;i++){
            st= br.readLine().split("");
            for (int j=0;j<C;j++){
                map[i][j]=st[j].charAt(0);
            }
        }
        visited[R-1][0]=true;//출발지점에 대한 방문체크를 안하면 틀린다..
        dfs(R-1,0,1);//시작위치부터 탐색 시작
        System.out.println(answer);
    }
    static void dfs(int x,int y,int cnt){
        if(x==0&&y==C-1){//집에 도착했으면
            if(cnt==K){//현재 이동거리가 목표치 K와 같은지 비교
                answer++;//같다면 정답으로 처리
            }
            return;
        }
        for(int i=0;i<4;i++){
            if(0<=x+dx[i]&&x+dx[i]<R&&0<=y+dy[i]&&y+dy[i]<C&&map[x+dx[i]][y+dy[i]]!='T'&&!visited[x+dx[i]][y+dy[i]]){
                //조건: map범위내의 수 &&이동할 위치가 T(장애물)가 아님&&이동할 위치가 아직 방문 X
                visited[x+dx[i]][y+dy[i]]=true;//방문 처리
                dfs(x+dx[i],y+dy[i],cnt+1);//이동
                visited[x+dx[i]][y+dy[i]]=false;//이동후 돌아오면 방문처리 해제
            }
        }
    }

}
