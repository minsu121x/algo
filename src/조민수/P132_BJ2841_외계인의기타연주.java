package 조민수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class P132_BJ2841_외계인의기타연주 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] st=br.readLine().split(" ");
        int N=Integer.parseInt(st[0]);
        int P=Integer.parseInt(st[1]);
        int answer=0;
        Stack<Integer>[] fretStack=new Stack[7];
        for(int i=1;i<=6;i++){
            fretStack[i]=new Stack<>();
        }
        for(int i=0;i<N;i++){
            st=br.readLine().split(" ");
            int line=Integer.parseInt(st[0]);
            int fret=Integer.parseInt(st[1]);
            while(!fretStack[line].isEmpty()&&fretStack[line].peek()>fret){//현재 스택이 비어있지않고, 현재 플랫보다 숫자가 큰 플랫이 있으면 전부 제거
                fretStack[line].pop();//제거
                answer++;//제거할 때 마다 카운트 ++
            }
            if(fretStack[line].isEmpty()){//해당 라인이 비어있다면
                fretStack[line].add(fret);//바로 추가
                answer++;//카운트 ++
            }
            else if(fretStack[line].peek()<fret){//지금 누를 플랫보다 작은 숫자면
                    fretStack[line].add(fret);//현재 플랫 추가하고
                    answer++;//카운트 ++
                }
                //같으면 동작할 필요 X
            }
        System.out.println(answer);

    }
}
