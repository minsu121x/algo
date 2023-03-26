package 조민수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class P110_BJ2668_숫자고르기 {
    static int[] num;//숫자 저장 배열
    static int start,N,result;
    static PriorityQueue<Integer> resultNum,nowNum;
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        num=new int[N+1];//1부터 N까지 사용
        start=0;
        resultNum=new PriorityQueue<Integer>();
        nowNum=new PriorityQueue<Integer>();
        for(int i=1;i<=N;i++){
            num[i]=Integer.parseInt(br.readLine());//숫자 입력
        }
        for(int i=1;i<=N;i++){
            start=i;//현재 시작점 ->노드를 순회하다 시작점으로 돌아오면 cycle
            nowNum.add(i);//시작점 큐에 저장
            dfs(num[i]);//dfs로 순회
            nowNum.clear();//순회 후 큐 초기화
        }
        int size=resultNum.size();
        System.out.println(size);{
            for(int i=0;i<size;i++){
                System.out.println(resultNum.poll());
            }
        }
    }
    static public void dfs(int node){
        if(node==start){//출발지점으로 돌아왔다 -> 순환으로 성립 가능 -> 결과 큐에 추가
            int size=nowNum.size();
            for(int i=0;i<size;i++){
                int num=nowNum.poll();
                if(!resultNum.contains(num)){//현재 큐에 포함이 안된 값만 포함
                    resultNum.add(num);
                }


            }
            return;
        }
        if(nowNum.contains(node)){//이미 포함된 노드면 순환 X
            return;//바로 종료
        }
        nowNum.add(node);//현재 값을 큐에 넣고 다음 노드로 순회
        dfs(num[node]);


    }

}