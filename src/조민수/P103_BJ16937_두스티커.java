package 조민수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P103_BJ16937_두스티커 {
    static int H,W,N,answer;//모눈종이의 길이 H, 너비 W, 스티커의 총 갯수 N,최종 결과 answer
    static int[][] sticker;
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        String[] str=br.readLine().split(" ");
        H=Integer.parseInt(str[0]);
        W=Integer.parseInt(str[1]);
        String st=br.readLine();
        N=Integer.parseInt(st);
        answer=0;
        sticker=new int[N][2];
        for(int i=0;i<N;i++){
            str=br.readLine().split(" ");
            sticker[i][0]=Integer.parseInt(str[0]);
            sticker[i][1]=Integer.parseInt(str[1]);
        }
        for(int i=0;i<N;i++){
            for(int j=i+1;j<N;j++){
               stick(sticker[i],sticker[j]);
            }
        }
        System.out.println(answer);
    }
    public static void stick(int[] first, int[] second){
        int first_h=first[0];
        int first_w=first[1];
        int second_h=second[0];
        int second_w=second[0];
        int sticker_size=first_h*first_w+second_h*second_w;
        if(first_h+second_h<=H&&first_w+second_w<=W&&answer<sticker_size){
            answer=sticker_size;
        }
        else if(first_h+second_w<=H&&first_w+second_h<=W&&answer<sticker_size){
            answer=sticker_size;
        }
        else if(first_w+second_h<=H&&first_h+second_w<=W&&answer<sticker_size){
            answer=sticker_size;
        }
        else if(first_w+second_w<=H&&first_h+second_h<=W&&answer<sticker_size){
            answer=sticker_size;
        }
    }
}
