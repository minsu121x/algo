package 조민수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P125_BJ13335_트럭 {
    static ArrayDeque<int[]> bridge;
    static int[] truck;
    static int n,w,L;//트럭의 갯수 n 다리길이 w 최대하중 L
    static int now,time;//현재 무게총합 now, 결과로 출력할 걸린 시간 time
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] st = br.readLine().split(" ");
        n = Integer.parseInt(st[0]);
        w = Integer.parseInt(st[1]);
        L = Integer.parseInt(st[2]);
        st = br.readLine().split(" ");
        truck = new int[n];
        now=0;
        time=0;
        bridge=new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            truck[i]=Integer.parseInt(st[i]);
        }
        int idx=0;
        while(idx<n){
            for(int[] value:bridge){//다리위에 있는 트럭은 1씩 이동
                value[1]++;
                if(value[1]>w){//이동한 위치가 다리를 통과했다.
                    bridge.poll();//다리에서 제거
                    now-=value[0];//현재 무게에서 -
                }
            }
            if(now+truck[idx]<=L){
                now+=truck[idx];
                bridge.add(new int[]{truck[idx],1});
                idx++;
            }
            time++;//돌때마다 시간추가
        }
        System.out.println(time+w);//time에는 마지막 트럭의 출도착은 저장 X ->마지막 트럭이 다리 w를 건너는 시간 더하기
    }
}
