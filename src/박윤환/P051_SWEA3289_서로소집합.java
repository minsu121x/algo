package 박윤환;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class P051_SWEA3289_서로소집합 {

    // 해당 수가 속한 집합의 대표자를 찾는 메소드
    static int find(int[] parent, int a) {
        if(parent[a] == a) {
            return a;
        } else {
            return parent[a] = find(parent, parent[a]);
        }
    }

    // 대표자가 다를 경우 하나의 집합으로 합치는 메소드
    static void union(int[] parent, int a, int b) {
        int rootA = find(parent, a);
        int rootB = find(parent, b);

        parent[rootB] = rootA;
    }

    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());    // 테스트케이스 입력
        for(int tc=1; tc<=T; tc++) {    // 테스트케이스만큼 반복
            String[] st = br.readLine().split(" ");
            int n = Integer.parseInt(st[0]);    // 주어지는 수는 n이하의 자연수
            int m = Integer.parseInt(st[1]);    // 연산의 개수

            int[] parent = new int[n+1];    // 인덱스 1부터 사용
            for(int i=0; i<=n; i++) {
                parent[i] = i;      // 초기 대표자는 자기 자신
            }
            sb.append("#").append(tc).append(" ");  // 연산결과 앞의 출력

            for(int i=0; i<m; i++) {
                st = br.readLine().split(" ");
                int opt = Integer.parseInt(st[0]);  // 현재 연산
                int a = Integer.parseInt(st[1]);    // 피연산자 a
                int b = Integer.parseInt(st[2]);    // 피연산자 b

                switch (opt) {  // 연산자가 뭐냐에 따라 다른 결과
                    case 0: // 0일 경우
                        union(parent, a, b);    // 두 집합을 합침
                        break;
                    case 1: // 1일 경우
                        if(find(parent, a) == find(parent, b)) {    // 두 집합의 대표자가 같으면
                            sb.append(1);   // 같은 집합이므로 1출력
                        } else {    // 다를 경우
                            sb.append(0);   // 다른 집합이므로 0출력
                        }
                        break;
                }
            }
            sb.append("\n");    // 테스트 케이스가 끝날때 줄바꿈
        }
        System.out.println(sb); // 최종 출력
    }
}
