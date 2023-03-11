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
            for(int j=i+1;j<N;j++){ // 1번-2번부터 N-1번 N번까지 순서대로 비교
               IsStick(sticker[i],sticker[j]);
            }
        }
        System.out.println(answer);
    }
    public static void IsStick(int[] first, int[] second){
        int first_h=first[0];
        int first_w=first[1];
        int second_h=second[0];
        int second_w=second[1];
        //경우의 수
        //(수직/수평) * (1번스티커 무회전/회전) * (2번스티커 무회전/회전) = 8가지
        //8가지 경우를 비교해 가능한 경우 중 현재 최댓값보다 클 경우 갱신
        int sticker_size=first_h*first_w+second_h*second_w;
        if(first_h+second_h<=H&&Math.max(first_w,second_w)<=W&&answer<sticker_size){
            //수직 - 무회전 - 무회전
            answer=sticker_size;
        }
        else if(first_h+second_w<=H&&Math.max(first_w,second_h)<=W&&answer<sticker_size){
            //수직 - 무회전 - 회전
            answer=sticker_size;
        }
        else if(first_w+second_h<=H&&Math.max(first_h,second_w)<=W&&answer<sticker_size){
            //수직 - 회전 - 무회전
            answer=sticker_size;
        }
        else if(first_w+second_w<=H&&Math.max(first_h,second_h)<=W&&answer<sticker_size){
            //수직 - 회전 - 회전
            answer=sticker_size;
        }
        else if(first_w+second_w<=W&&Math.max(first_h,second_h)<=H&&answer<sticker_size){
            //수평 - 회전 - 회전
            answer=sticker_size;
        }
        else if(first_h+second_h<=W&&Math.max(first_w,second_w)<=H&&answer<sticker_size){
            //수평 - 무회전 - 무회전
            answer=sticker_size;
        }
        else if(first_h+second_w<=W&&Math.max(first_w,second_h)<=H&&answer<sticker_size){
            //수평 - 무회전 - 회전
            answer=sticker_size;
        }
        else if(first_w+second_h<=W&&Math.max(first_h,second_w)<=H&&answer<sticker_size){
            //수평 - 회전 - 무회전
            answer=sticker_size;
        }
    }
}
