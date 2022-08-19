package 박윤환;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class P048_BJ1697_숨바꼭질 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] st = br.readLine().split(" ");

        int subin = Integer.parseInt(st[0]);    // 수빈이 위치
        int sister = Integer.parseInt(st[1]);   // 동생 위치
        int cnt = 0;    // 이동 횟수
        Queue<Integer> locQ = new ArrayDeque<>();    // bfs 탐색에 사용할 q
        Queue<Integer> moveQ = new ArrayDeque<>();  // 이동횟수를 저장할 q
        boolean[] visited = new boolean[100001];     // 방문 위치 기록

        // 수빈이 초기 위치와 이동 횟수를 큐에 삽입
        locQ.offer(subin);
        moveQ.offer(0);

        while(true) {   // 동생을 잡을떄까지 무한 반복
            int now = locQ.poll();   // 현재 위치를 꺼낸다
            int move = moveQ.poll();    // 현재 이동횟수를 꺼낸다
            visited[now] = true;   // 현재 위치 방문 기록
            if(now == sister) {  // 지금 위치가 동생과 같으면
                cnt = move;   // 그때까지의 이동횟수가 최소
                break;  // 무한루프 끝
            }

            if(2*now <= 100000) {  // *2이동이 효육적일때만 이동
                locQ.offer(now * 2);  // *2로 이동
                moveQ.offer(move + 1); // 증가된 이동횟수 기록
            }
            if(now > 0 && !visited[now-1]) {  // 이미 방문했던 위치가 아닐때만
                locQ.offer(now - 1);  // -1로 이동
                moveQ.offer(move + 1); // 증가된 이동횟수 기록
            }
            if(now < 100000 && !visited[now+1]) {  // 이미 방문했던 위치가 아닐때만
                locQ.offer(now + 1);  // +1로 이동
                moveQ.offer(move + 1); // 증가된 이동횟수 기록
            }
        }

        System.out.println(cnt);
    }
}
