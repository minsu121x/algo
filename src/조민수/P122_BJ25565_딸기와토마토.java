


package 조민수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;

public class P122_BJ25565_딸기와토마토{
    public static int N,M,K;
    public static int[][] map;
    //public static LinkedHashMap<int[],Integer> map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] st = br.readLine().split(" ");
        N = Integer.parseInt(st[0]);
        M = Integer.parseInt(st[1]);
        K = Integer.parseInt(st[2]);
        int total=0;
        map=new int[N+1][M+1];
        int []start=new int[]{};
        int first=0;
        for(int i=1;i<=N;i++){
            st = br.readLine().split(" ");

            for(int j=1;j<=M;j++){
                map[i][j]=Integer.parseInt(st[j-1]);
                if(map[i][j]==1){
                    total++;
                    if(first==0){
                        start=new int[]{i,j};
                        first=1;
                    }
                }
            }
        }
        if(total==K*2){//겹치는게 없으면
            System.out.println(0);
        }
        else if(total==K){//완전히 겹치는 경우
            System.out.println(K);
            if(start[0]+K-1<=N&&map[start[0]+K-1][start[1]]==1) {//토마토가 세로로 존재한다
                for (int i = 0; i < K; i++) {
                        System.out.println((start[0] + i) + " " + start[1]);
                }
            }
            else{
                for(int i=0;i<K;i++) {//가로로 어디서 겹치는지 확인
                    System.out.println((start[0]) + " " + (start[1] + i));
                }
            }
        }
        else if(total==K*2-1){ //수직으로 한점에서 겹치는 경우
            int[] tomato=start;
            if (tomato[0]+K-1<=N&&tomato[1]+K-1<=M&&tomato[0]+K<=N+1&&map[tomato[0]+K-1][tomato[1]]==1&&map[tomato[0]][tomato[1]+K-1]==1){
               //start포인트를 기준으로 아래와 오른쪽으로 모든값이 있다 -> start가 겹치는 지점
                System.out.println(1);
                System.out.println(tomato[0]+" "+tomato[1]);
            }
            else if(tomato[0]+K-1<=N&&map[tomato[0]+K-1][tomato[1]]==1){//토마토가 세로로 존재한다
                for(int i=1;i<K;i++){//가로로 어디서 겹치는지 확인
                    if(0<tomato[1]-1&&map[tomato[0]+i][tomato[1]-1]==1){
                        System.out.println(1);
                        System.out.println((tomato[0]+i)+" "+tomato[1]);
                    }
                    else if(tomato[1]+1<=M&&map[tomato[0]+i][tomato[1]+1]==1){
                        System.out.println(1);
                        System.out.println((tomato[0]+i)+" "+tomato[1]);
                    }
                }
                if(tomato[0]+K<=N&&map[tomato[0]+K][tomato[1]]==1){
                    System.out.println(1);
                    System.out.println((tomato[0]+K-1)+" "+tomato[1]);
                }
            }
            else if(tomato[1]+K-1<=M&&map[tomato[0]][tomato[1]+K-1]==1){//토마토가 세로로 존재한다
                for(int i=1;i<K;i++){//가로로 어디서 겹치는지 확인
                    if(0<tomato[0]-1&&map[tomato[0]-1][tomato[1]+i]==1){
                        System.out.println(1);
                        System.out.println((tomato[0])+" "+(tomato[1]+i));
                    }
                    else if(tomato[0]+1<=N&&map[tomato[0]+1][tomato[1]+i]==1){
                        System.out.println(1);
                        System.out.println(tomato[0]+" "+(tomato[1]+i));
                    }
                }
                if(tomato[1]+K<=M&&map[tomato[0]][tomato[1]+K]==1){
                    System.out.println(1);
                    System.out.println(tomato[0]+" "+(tomato[1]+K-1));
                }
            }
        }
        else{//한줄로 겹치는 경우
            int cnt=K*2-total;//겹치는 개수
            int[] tomato=start;
            if(tomato[0]+K-1<=N&&map[tomato[0]+K-1][tomato[1]]==1){//토마토가 세로로 존재한다
                System.out.println(cnt);
                for(int i=K-cnt;i<K;i++){
                    System.out.println((tomato[0]+i)+" "+tomato[1]);
                }
            }
            else{//토마토가 가로로 존재한다
                System.out.println(cnt);
                for(int i=K-cnt;i<K;i++){
                    System.out.println(tomato[0]+" "+(tomato[1]+i));
                }
            }
        }

    }
//        map=new LinkedHashMap<>();
//        for(int i=1;i<=N;i++){
//            st=br.readLine().split(" ");
//            for(int j=1;j<=M;j++){
//                if(st[j-1].equals("1")){
//                    map.put(new int[]{i,j},1);
//                }
//            }
//        }
//        if(map.size()==K*2){
//            System.out.println(0);
//        }
//        else if(map.size()==K){
//            System.out.println(K);
//            Iterator<int[]> keys=map.keySet().iterator();
//            while(keys.hasNext()){
//                int[] key=keys.next();
//                for(int i:key){
//                    System.out.print(i+" ");
//                }
//                System.out.println();
//            }
//        }
//        else if(map.size()==K*2-1){
//            int[] tomato;
//        }
//    }
}