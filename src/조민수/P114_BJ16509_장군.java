package 조민수;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class P114_BJ16509_장군 {
    static int sangX,sangY,kingX,kingY;//상과 왕의 X,Y 좌표
    //상이 이동 가능한 좌표
    static int[] dx={-3,-3,-2,2,3,3,2,-2};//상좌 상우 우상 우하 후우 하좌 좌하 좌상 순서
    static int[] dy={-2,2,3,3,2,-2,-3,-3};
    static boolean [][] board; //장기판 boolean을 이용해 방문 처리
    static PriorityQueue<int[]> queue;//방문 순서 저장
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String []st=br.readLine().split(" ");
        sangX=Integer.parseInt(st[0]);
        sangY=Integer.parseInt(st[1]);
        st=br.readLine().split(" ");
        kingX=Integer.parseInt(st[0]);
        kingY=Integer.parseInt(st[1]);
        board=new boolean[10][9];
        queue=new PriorityQueue<int[]>((o1, o2) -> o1[2] -o2[2]);
        queue.add(new int[]{sangX,sangY,0});
        while(!queue.isEmpty()) {
            int [] point=queue.poll();
            int x=point[0];
            int y=point[1];
            int cnt=point[2];
            if(x==kingX&&y==kingY){// 현재 좌표가 왕이면 왕을 잡았다.
                System.out.println(cnt);//현재 cnt 출력
                return;
            }
            board[x][y]=true;
            for(int i=0;i<8;i++){
                if(0<=x+dx[i]&&x+dx[i]<10&&0<=y+dy[i]&&y+dy[i]<9&&!board[x+dx[i]][y+dy[i]]){
                    //이동할 좌표가 이동가능하고 방문한 적 없는지 체크
                    boolean flag=false;
                    switch (i){
                        //장애물이 없는지 체크

                        case 0:
                            //상좌로 이동 ->x 위로 1번 , 상좌 대각 2번 이동
                            for(int j=0;j<2;j++){
                                if(x-j-1==kingX&&y-j==kingY){
                                    //x좌표는 위로 한칸 이동-> -1 하고 좌상 대각이동
                                    flag=true;//가는길에 왕을 만나면 체크
                                    break;
                                }
                            }
                            if(!flag){
                                queue.add(new int[]{x+dx[i],y+dy[i],cnt+1});
                            }

                            break;
                        case 1:
                            //상우
                            for(int j=0;j<2;j++){
                                if(x-j-1==kingX&&y+j==kingY){
                                    flag=true;
                                    break;
                                }
                            }
                            if(!flag){
                                queue.add(new int[]{x+dx[i],y+dy[i],cnt+1});
                            }

                            break;
                        case 2:
                            //우상
                            for(int j=0;j<2;j++){
                                if(x-j==kingX&&y+j+1==kingY){
                                    flag=true;
                                    break;
                                }
                            }
                            if(!flag){
                                queue.add(new int[]{x+dx[i],y+dy[i],cnt+1});
                            }
                            break;
                        case 3:
                            //우하
                            for(int j=0;j<2;j++){
                                if(x+j==kingX&&y+j+1==kingY){
                                    flag=true;
                                    break;
                                }
                            }
                            if(!flag){
                                queue.add(new int[]{x+dx[i],y+dy[i],cnt+1});
                            }
                            break;
                        case 4:
                            //하우
                            for(int j=0;j<2;j++){
                                if(x+j+1==kingX&&y+j==kingY){
                                    flag=true;
                                    break;
                                }
                            }
                            if(!flag){
                                queue.add(new int[]{x+dx[i],y+dy[i],cnt+1});
                            } break;
                        case 5:
                            //하좌
                            for(int j=0;j<2;j++){
                                if(x+j+1==kingX&&y-j==kingY){
                                    flag=true;
                                    break;
                                }
                            }
                            if(!flag){
                                queue.add(new int[]{x+dx[i],y+dy[i],cnt+1});
                            } break;
                        case 6:
                            //좌하
                            for(int j=0;j<2;j++){
                                if(x+j==kingX&&y-j-1==kingY){
                                    flag=true;
                                    break;
                                }
                            }
                            if(!flag){
                                queue.add(new int[]{x+dx[i],y+dy[i],cnt+1});
                            }
                            break;
                        case 7:
                            //좌상
                            for(int j=0;j<2;j++){
                                if(x-j==kingX&&y-j-1==kingY){
                                    flag=true;
                                    break;
                                }
                            }
                            if(!flag){
                                queue.add(new int[]{x+dx[i],y+dy[i],cnt+1});
                            }
                            break;

                    }

                }
            }

        }
        System.out.println(-1);
    }
}
