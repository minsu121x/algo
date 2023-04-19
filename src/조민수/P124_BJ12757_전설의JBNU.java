package 조민수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

public class P124_BJ12757_전설의JBNU {
    static TreeMap<Integer,Integer>map;
    static int N,M,K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String []st =br.readLine().split(" ");
        N=Integer.parseInt(st[0]);
        M=Integer.parseInt(st[1]);
        K=Integer.parseInt(st[2]);
        map=new TreeMap<>();
        map.put(-2000000000,-1);
        map.put(2000000000,-1);
        for(int i=0;i<N;i++){
            st=br.readLine().split(" ");
            map.put(Integer.parseInt(st[0]),Integer.parseInt(st[1]));//map에 저장
        }
        for(int i=0;i<M;i++){
            st=br.readLine().split(" ");
            int type=Integer.parseInt(st[0]);//어떤 동작인지 분류
            int key=0; //사용될 키
            switch (type){
                case 1: //key와 값 추가
                    map.put(Integer.parseInt(st[1]),Integer.parseInt(st[2]));
                    break;
                case 2: //key의 해당하는 값 수정
                    key=Integer.parseInt(st[1]);
                    if(map.containsKey(key)){
                        map.put(key,Integer.parseInt(st[2]));
                    }
                    else{
                        int rightkey=map.ceilingKey(key);
                        int leftkey=map.floorKey(key);
                            if(rightkey-key>key-leftkey&&key-leftkey<=K){
                                map.put(leftkey,Integer.parseInt(st[2]));
                            }
                            else if(rightkey-key<key-leftkey&&rightkey-key<=K){
                                map.put(rightkey,Integer.parseInt(st[2]));
                            }
                        }
                    break;
                case 3: //다음 입력받는 값을 key로 조회 오차 ±K만큼 가능
                    key=Integer.parseInt(st[1]);
                    if(map.containsKey(key)){
                        System.out.println(map.get(key));
                    }
                    else{
                        int rightkey=map.ceilingKey(key);
                        int leftkey=map.floorKey(key);
                        if(rightkey-key==key-leftkey&&rightkey-key<=K){
                            System.out.println("?");
                        }
                        else if(rightkey-key>key-leftkey&&key-leftkey<=K){
                            System.out.println(map.get(leftkey));
                        }
                        else if(rightkey-key<key-leftkey&&rightkey-key<=K){
                            System.out.println(map.get(rightkey));
                        }
                        else{
                            System.out.println(-1);
                        }
                    }
                    break;
            }
        }
    }
}
