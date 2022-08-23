package 박윤환;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P052_SWEA3124_최소스패닝트리 {

    // 간선리스트 클래스
    static class Edge implements Comparable<Edge> {
        int from, to, weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {  // 가중치 기준 오름차순 정렬하기 위한 Comparable.compareTo
            return this.weight - o.weight;
        }
    }

    // 부모노드를 찾는 메소드
    static int find(int[] parent, int a) {
        if(parent[a] == a) {
            return a;
        } else {
            return parent[a] = find(parent, parent[a]);
        }
    }

    // 부모노드를 합치는 메소드
    static boolean union(int[] parent, int a, int b) {
        int rootA = find(parent, a);
        int rootB = find(parent, b);

        if(rootA == rootB) {
            return false;
        } else {
            parent[rootB] = rootA;
            return true;
        }
    }

    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());    // 테스트케이스 개수 입력
        for(int tc=1; tc<=T; tc++) {    // 테스트케이스만큼 반복
            String[] st = br.readLine().split(" ");
            int V = Integer.parseInt(st[0]);    // 정점의 개수
            int E = Integer.parseInt(st[1]);    // 간선의 개수
            Edge[] edgeList = new Edge[E];  // 간선의 개수만큼 간선클래스 배열 생성

            int[] parent = new int[V+1];    // 각 정점의 부모를 담는 배열 (인덱스 1부터)
            for(int i=1; i<=V; i++) {
                parent[i] = i;  // 초기 부모는 자기자신
            }

            for(int i=0; i<E; i++) {    // 간선의 개수만큼 반복
                st = br.readLine().split(" ");
                int from = Integer.parseInt(st[0]);     // 하나의 정점
                int to = Integer.parseInt(st[1]);   // 이어진 다른 정점
                int weight = Integer.parseInt(st[2]);   // 가중치
                edgeList[i] = new Edge(from, to, weight);   // 간선리스트에 간선정보 추가
            }

            Arrays.sort(edgeList);  // 가중치기준 오름차순으로 정렬

            long result = 0; // 가중치합을 저장하는 변수
            int count = 0;  // 간선 개수를 저장하는 변수
            for (Edge edge : edgeList) {    // 간선리스트내의 간선정보 반복
                if(union(parent, edge.from, edge.to)) { // 두 정점이 다른 집합이라면 합치고
                    result += edge.weight;  // 현재 간선의 가중치를 합한다
                    if(++count == V-1) {    // 간선의 개수가 정점의개수-1이면 종료 그떄의 가중치합이 최소
                        break;
                    }
                }
            }
            sb.append("#").append(tc).append(" ").append(result).append("\n");   // 결과물 저장
        }
        System.out.println(sb); // 결과물 출력
    }
}
