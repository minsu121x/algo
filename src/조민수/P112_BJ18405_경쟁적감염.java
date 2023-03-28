package 조민수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class P112_BJ18405_경쟁적감염 {
    public static final int[] dx={-1,1,0,0};
    public static final int[] dy={0,0,-1,1};
    public static int N,K,S,X,Y;
    public static int[][] map;
    public static PriorityQueue<int[]> PQ_1,PQ_2;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String []st=br.readLine().split(" ");
        N=Integer.parseInt(st[0]);//맵 크기 NxN
        K=Integer.parseInt(st[1]);//바이러스의 최댓값

        PQ_1=new PriorityQueue<int[]>((o1, o2) -> o1[0]-o2[0]);//바이러스 번호를 기준으로 오름차순 정렬
        PQ_2=new PriorityQueue<int[]>((o1, o2) -> o1[0]-o2[0]);
        map=new int[N+1][N+1];
        for(int i=1;i<=N;i++){
            st=br.readLine().split(" ");
            for (int j=1;j<=N;j++){
                map[i][j]=Integer.parseInt(st[j-1]);
                if(map[i][j]!=0){
                   PQ_1.add(new int[]{map[i][j],i,j});//값,X,Y좌표 저장
                }
            }
        };
        st=br.readLine().split(" ");
        S=Integer.parseInt(st[0]);// 반복될 시간
        X=Integer.parseInt(st[1]);//타겟 X 좌표
        Y=Integer.parseInt(st[2]);//타겟 Y 좌표
        if(map[X][Y]!=0){
            System.out.println(map[X][Y]);
            return;
        }
        spread();

    }

    private static void spread() {
        for(int i=0;i<S;i++){
            if(i%2==0){
                while(!PQ_1.isEmpty()){
                    int[]point=PQ_1.poll();
                    int virus=point[0];
                    int x=point[1];
                    int y=point[2];
                    for(int j=0;j<4;j++){//사방 탐색
                        if(0<x+dx[j]&&x+dx[j]<=N&&0<y+dy[j]&&y+dy[j]<=N&&map[x+dx[j]][y+dy[j]]==0){
                            map[x+dx[j]][y+dy[j]]=virus;
                            if(x+dx[j]==X&&y+dy[j]==Y){
                                System.out.println(virus);
                                return;
                            }
                            PQ_2.add(new int[]{virus,x+dx[j],y+dy[j]});
                        }
                    }
                }
            }
            else{
                while(!PQ_2.isEmpty()){
                    int[]point=PQ_2.poll();
                    int virus=point[0];
                    int x=point[1];
                    int y=point[2];
                    for(int j=0;j<4;j++){//사방 탐색
                        if(0<=x+dx[j]&&x+dx[j]<N&&0<=y+dy[j]&&y+dy[j]<N&&map[x+dx[j]][y+dy[j]]==0){
                            map[x+dx[j]][y+dy[j]]=virus;
                            if(x+dx[j]==X&&y+dy[j]==Y){
                                System.out.println(virus);
                                return;
                            }
                            PQ_1.add(new int[]{virus,x+dx[j],y+dy[j]});
                        }
                    }

                }
            }
        }
        System.out.println(0);
        return;
    }
}
