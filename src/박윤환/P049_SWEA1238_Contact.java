package 박윤환;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class P049_SWEA1238_Contact {

    // 노드 클래스
    static class Node {
        int to;
        Node next;

        public Node(int to, Node next) {
            this.to = to;
            this.next = next;
        }
    }

    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for(int tc=1; tc<=10; tc++) {   // 테스트케이스 10번 반복
            String[] st = br.readLine().split(" ");
            int N = Integer.parseInt(st[0]);    // 관계 개수
            int start = Integer.parseInt(st[1]);    // 시작 노드
            Node[] adjList = new Node[101];     // 인접리스트, 최대인원 100명이므로 최대크기 101
            boolean[] visited = new boolean[101];   // 방문 기록
            Queue<int[]> q = new ArrayDeque<>();    // 방문할 노드를 저장할 큐

            st = br.readLine().split(" ");
            for(int i=0; i<N; i++) {
                int from = Integer.parseInt(st[i++]);   // 출발 노드
                int to = Integer.parseInt(st[i]);   // 도착 노드
                adjList[from] = new Node(to, adjList[from]);    // 인접리스트에 간선 정보 저장
            }

            visited[start] = true;  // 시작노드 방문 기록
            q.offer(new int[] {start, 0});  // 시작노드와 이동횟수(너비)를 큐에 저장

            int height = 0;    // 현재의 최대 너비(높이)
            int max = 0;    //  현재 너비(높이)에서의 최대 노드번호

            while(!q.isEmpty()) {
                int[] cur = q.poll();   // 현재 노드 정보 꺼냄
                int now = cur[0];   // 노드 번호
                int cnt = cur[1];   // 너비(높이)

                if(height < cnt) {  // 현재 높이가 최대가 아니라면
                    height = cnt;   // 최대 높이 갱신
                    max = now;  // 높이가 바뀌는 때의 노드를 최대 노드번호로 갱신
                } else if(height == cnt && max < now) { // 최대 높이와 같고 저장된 최대노드번호보다 크다면
                    max = now;  // 최대 노드번호 갱신
                }

                for(Node tmp = adjList[now]; tmp != null; tmp = tmp.next) { // 현재 노드부터 다음 노드가 null일때까지 인접리스트 반복
                    if(!visited[tmp.to]) {  // 다음 노드번호를 방문 안했으면
                        visited[tmp.to] = true;     // 방문처리
                        q.offer(new int[] {tmp.to, cnt+1}); // 방문 예정을 큐에 저장
                    }
                }
            }

            sb.append("#").append(tc).append(" ").append(max).append("\n");
        }

        System.out.println(sb);
    }
}
