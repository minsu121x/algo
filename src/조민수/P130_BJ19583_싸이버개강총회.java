package 조민수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;

public class P130_BJ19583_싸이버개강총회 {

    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        String[] st=br.readLine().split(" ");
        int startTime=Integer.parseInt(st[0].replaceAll(":",""));
        int endTime=Integer.parseInt(st[1].replaceAll(":",""));
        int streamingTime=Integer.parseInt(st[2].replaceAll(":",""));
        HashSet<String> list=new HashSet();
        System.out.println(startTime+ " "+endTime+ " "+streamingTime);
        String str="";
        int answer=0;
        while((str=br.readLine())!=null&&str.length()>0) {
            st = str.split(" ");
            int chatTime=Integer.parseInt(st[0].replaceAll(":",""));
            if(startTime-chatTime>=0){//시작전에 친 채팅이 있다
                list.add(st[1]);
            }
            else if (chatTime-endTime>=0&&streamingTime-chatTime>=0&&list.contains(st[1])) {
                answer++;
            }
        }
        System.out.println(answer);
    }
}
