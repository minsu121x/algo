package 박윤환;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class P058_SWEA1251_하나로_프림인접리스트 {

    static class Node {
        int vertex;
        double weight;
        Node next;

        public Node(int vertex, double weight) {
            this.vertex = vertex;
            this.weight = weight;
        }

        public Node(int vertex, double weight, Node next) {
            this.vertex = vertex;
            this.weight = weight;
            this.next = next;
        }
    }

    static double E;

    static double distance(int x1, int y1, int x2, int y2) {
        return E * Math.abs(Math.pow(x2-x1, 2) + Math.pow(y2-y1, 2));
    }

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());
            int[] X = new int[N];
            int[] Y = new int[N];
            String[] st1 = br.readLine().split(" ");
            String[] st2 = br.readLine().split(" ");
            for(int i=0; i<N; i++) {
                X[i] = Integer.parseInt(st1[i]);
                Y[i] = Integer.parseInt(st2[i]);
            }
            E = Double.parseDouble(br.readLine());

            Node[] adjList = new Node[N];
            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    if(i == j) continue;
                    adjList[i] = new Node(j, distance(X[i], Y[i], X[j], Y[j]), adjList[i]);
                }
            }

            double[] minEdge = new double[N];     // 각 정점 입장에서 신장트리에 포함된 정점과의 간선 비용중 최소비용
            boolean[] visited = new boolean[N]; // 신장트리에 포함 여부

            Arrays.fill(minEdge, Integer.MAX_VALUE);

            minEdge[0] = 0;
            double result = 0;

            PriorityQueue<Node> pQueue = new PriorityQueue<>((v1, v2) -> Double.compare(v1.weight, v2.weight));
            pQueue.offer(new Node(0, minEdge[0]));

            int cnt = 0;
            while(!pQueue.isEmpty()) {
                Node minVertex = pQueue.poll();

                if(visited[minVertex.vertex]) continue;
                visited[minVertex.vertex] = true;
                result += minVertex.weight;
                if(++cnt == N) break;

                for(Node tmp = adjList[minVertex.vertex]; tmp != null; tmp = tmp.next) {
                    if(!visited[tmp.vertex] && minEdge[tmp.vertex] > tmp.weight) {
                        minEdge[tmp.vertex] = tmp.weight;
                        pQueue.offer(new Node(tmp.vertex, minEdge[tmp.vertex]));
                    }
                }
            }
            sb.append("#").append(tc).append(" ").append(result).append("\n");
        }

        System.out.println(sb);
    }
}
