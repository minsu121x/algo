package 박윤환;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashSet;

public class P053_SWEA7465_창용마을무리의개수 {

    // 부모를 찾는 메소드
    static int find(int[] parent, int a) {
        if(parent[a] == a) {
            return a;
        }
        return parent[a] = find(parent, parent[a]);
    }

    // 부모가 다를 경우 합치는 메소드
    static void union(int[] parent, int a, int b) {
        int parentA = find(parent, a);
        int parentB = find(parent, b);

        parent[parentB] = parentA;
    }

    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("s_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());    // 테스트케이스 개수
        for(int tc=1; tc<=T; tc++) {    // 테스트케이스만큼 반복
            HashSet<Integer> set = new HashSet<>();     // 집단 번호를 중복 안되게 넣을 HashSet
            String[] st = br.readLine().split(" ");
            int N = Integer.parseInt(st[0]);    // 인원 수
            int M = Integer.parseInt(st[1]);    // 간선 수
            int[] parent = new int[N+1];    // 부모를 저장하는 배열 (인덱스 1부터)

            for(int i=1; i<=N; i++) {
                parent[i] = i;  // 처음 부모는 자기 자신
            }

            int[][] edge = new int[M][2];   // 간선 정보를 담을 2차원 배열

            for(int i=0; i<M; i++) {
                st = br.readLine().split(" ");
                edge[i][0] = Integer.parseInt(st[0]);   // from
                edge[i][1] = Integer.parseInt(st[1]);   // to
            }

            for (int[] e :
                    edge) {
                int a = e[0];
                int b = e[1];
                union(parent, a, b);    // 간선이 연결된 노드는 전부 union
            }
            for (int i=1; i<=N; i++) {
                set.add(find(parent, i));   // union이 끝난 후 각 노드들의 부모를 HashSet에 저장
            }

            sb.append("#").append(tc).append(" ").append(set.size()).append("\n");  // HashSet의 크기가 집단의 개수
        }
        System.out.println(sb);
    }
}
