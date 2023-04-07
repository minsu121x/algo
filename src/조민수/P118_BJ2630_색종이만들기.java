package 조민수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class P118_BJ2630_색종이만들기 {
    static int white,blue,N;
    static int [][] map;
    static boolean [][]visit;
    static ArrayDeque<int[]> deque;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        map=new int[N+1][N+1];
        visit=new boolean[N+1][N+1];
        blue=0;
        white=0;
        String[]st;
        deque=new ArrayDeque<int[]>();
        for(int i=1;i<=N;i++){
            st=br.readLine().split(" ");
            for (int j=1;j<=N;j++){
                map[i][j] = Integer.parseInt(st[j-1]);
            }
        }
        deque.add(new int[]{1,N,1,N,map[1][1]});//첫 시작은 전체 범위에 대해서 맵의 1,1값으로 비교
        while(!deque.isEmpty()){
            int[]point=deque.poll();
            int start_x=point[0];
            int end_x=point[1];
            int start_y=point[2];
            int end_y=point[3];
            int color=point[4];
            boolean check=false;
            for(int i=start_x;i<=end_x;i++){
                for(int j=start_y;j<=end_y;j++){
                    if(map[i][j]!=color){//색이 다른 블록이 하나라도 나오면
                        //사분면으로 분리 후 다시 탐색하도록 큐에 저장해야함
                        //1사분면
                        deque.add(new int[]{start_x,start_x+(end_x-start_x)/2,start_y,start_y+(end_y-start_y)/2,map[start_x][start_y]});
                        //2사분면
                        deque.add(new int[]{start_x,start_x+(end_x-start_x)/2,start_y+(end_y-start_y)/2+1,end_y,map[start_x][start_y+(end_y-start_y)/2+1]});
                        //3사분면
                        deque.add(new int[]{start_x+(end_x-start_x)/2+1,end_x,start_y,start_y+(end_y-start_y)/2,map[start_x+(end_x-start_x)/2+1][start_y]});
                        //4사분면
                        deque.add(new int[]{start_x+(end_x-start_x)/2+1,end_x,start_y+(end_y-start_y)/2+1,end_y,map[start_x+(end_x-start_x)/2+1][start_y+(end_y-start_y)/2+1]});

                        check=true;//다른색 블록이 나왔음을 체크
                        break;
                    }
                }
                if(check){
                    break;//색이 다른 블록이 있었다면 더 돌릴 필요 없이 break;
                }
            }
            if(!check){//다른 블록이 없이 for 문을 다 돌았다면
                if(color==1){//컬러에 따라 색종이 추가
                    blue++;
                }
                else{
                    white++;
                }
            }
        }
        System.out.println(white+"\n"+blue);//출력
    }
}
