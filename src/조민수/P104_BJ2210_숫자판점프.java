package 조민수;

import java.io.*;
import java.util.*;
public class P104_BJ2210_숫자판점프 {
    static int[][] board;//5*5 숫자판을 저장할 2차원 배열
    static int[] line;//6개의 숫자를 저장할 배열
    static HashSet<String> set; //완성돤 라인을 중복값을 제거하고 저장할 HashSet
    static int[] dx={-1,1,0,0};//사방탕색 - 상하좌우
    static int[] dy={0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        String []st;
        board=new int[5][5];//보드 초기화
        line=new int[6];//문자열 생성할 라인배열 초기화
        set=new HashSet<String>();
        for(int i=0;i<5;i++){
            st=br.readLine().split(" ");
            for(int j=0;j<5;j++){
                board[i][j]=Integer.parseInt(st[j]);//board에 값 저장
            }
        }
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                //0,0부터 4,4까지 시작점으로 하여 사방탐색
                search(i,j,0);
            }
        }
        System.out.println(set.size());

    }
    public static void search(int x, int y, int cnt){
        line[cnt]=board[x][y];
        if(cnt==5){//6개를 다 모으면
            set.add(Arrays.toString(line));//배열을 문자열로 변환하여 set에 중복제거저장
            return;
        }

        for(int i=0;i<4;i++){
            if(0<=x+dx[i]&&x+dx[i]<5&&0<=y+dy[i]&&y+dy[i]<5){//재방문허용 -> visit 체크 X
                search(x+dx[i],y+dy[i],cnt+1);//다음칸으로 이동 + cnt 하나 상승ㄴ
            }
        }
    }
}
