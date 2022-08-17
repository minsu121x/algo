package 박윤환;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class P038_SWEA5644_무선충전 {

    // int[]타입의 객체를 리스트 내에 있는지 판별하는 메소드
    static boolean contains(ArrayList<int[]> list, int[] array) {
        return list.stream()
                .anyMatch(x -> Arrays.equals(x, array));
    }

    public static void main(String[] args) throws Exception{
//        System.setIn(new FileInputStream("sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());    // 테스트케이스 개수
        for(int tc=1; tc<=T; tc++) {    // 테스트케이스 반복
            String[] st = br.readLine().split(" ");
            int M = Integer.parseInt(st[0]);    // 이동 시간
            int A = Integer.parseInt(st[1]);    // BC의 개수
            int result = 0;
            int[][] info = new int[2][M];   // 사용자의 이동정보를 담을 배열
            int[][] BC = new int[A][4];     // BC의 정보를 담을 배열
            int[][] user = new int[2][2];   // 사용자의 현재 위치를 담을 배열
            ArrayList<ArrayList<int[]>> list = new ArrayList<>();   // BC별로 범위 정보를 담을 2차원 리스트
            for(int i=0; i<A; i++) {
                list.add(new ArrayList<>());    // BC의 개수만큼 리스트 내에 리스트 초기화
            }
            // 사용자A의 위치
            user[0][0] = 1;
            user[0][1] = 1;
            // 사용자B의 위치
            user[1][0] = 10;
            user[1][1] = 10;

            for(int i=0; i<2; i++) {
                st = br.readLine().split(" ");
                for(int j=0; j<M; j++) {
                    info[i][j] = Integer.parseInt(st[j]);
                }
            }

            for(int i=0; i<A; i++) {
                st = br.readLine().split(" ");
                for(int j=0; j<4; j++) {
                    BC[i][j] = Integer.parseInt(st[j]);
                }
            }

            for (int k=0; k<A; k++) {   // BC의 개수만큼 반복
                int x = BC[k][0];
                int y = BC[k][1];
                int c = BC[k][2];

                // 모든 좌표 탐색
                for(int i=1; i<=10; i++) {
                    for(int j=1; j<=10; j++) {
                        if(Math.abs(x - i) + Math.abs(y - j) <= c) {    // BC의 범위 내에 있는 좌표이면
                            list.get(k).add(new int[] {i, j});  // 리스트에 추가
                        }
                    }
                }
            }

            // 이동정보만큼 이동
            for(int i=-1; i<M; i++) {   // 처음에는 이동하지 않기 위해 -1부터
                int max = 0;
                if(i != -1) {   // 처음에는 이동하지 않는다
                    switch (info[0][i]) {
                        case 1:
                            user[0][1]--;
                            break;
                        case 2:
                            user[0][0]++;
                            break;
                        case 3:
                            user[0][1]++;
                            break;
                        case 4:
                            user[0][0]--;
                            break;
                    }
                    switch (info[1][i]) {
                        case 1:
                            user[1][1]--;
                            break;
                        case 2:
                            user[1][0]++;
                            break;
                        case 3:
                            user[1][1]++;
                            break;
                        case 4:
                            user[1][0]--;
                            break;
                    }
                }
                boolean[][] cnt = new boolean[2][A];    // 사용자별로 어떤 BC 범위내에 포함되는지 저장할 배열
                int[] a = {user[0][0], user[0][1]}; // 사용자A의 위치
                int[] b = {user[1][0], user[1][1]}; // 사용자B의 위치
                for(int j=0; j<A; j++) {    // 모든 BC 탐색
                    cnt[0][j] = contains(list.get(j), a);   // 사용자A가 해당 BC 범위에 포함되면 true, 아니면 false
                    cnt[1][j] = contains(list.get(j), b);   // 사용자B가 해당 BC 범위에 포함되면 true, 아니면 false
                }

                for(int j=0; j<A; j++) {    // BC 개수만큼 반복
                    for(int k=0; k<A; k++) {    // BC 개수만큼 또 반복
                        if(cnt[0][j]) {     // 사용자A가 어떤 BC 범위내에 있다면
                            if(cnt[1][k]) { // 사용자B도 어떤 BC 범위 내에 있다면
                                if(j == k) {    // 둘이 같은 BC 범위 내라면
                                    max = Math.max(max, BC[j][3]);  // max값과 해당 BC의 성능 비교
                                } else {    // 사용자B는 다른 BC라면
                                    max = Math.max(max, BC[j][3] + BC[k][3]);   // 두 BC의 성능합과 max 비교
                                }
                            } else {    // 사용자B가 어떤 BC에도 속하지 않다면
                                max= Math.max(max, BC[j][3]);   // 사용자A가 포함된 BC의 성능만 max와 비교
                            }
                        } else {    // 사용자A가 어떤 BC 범위 내에도 없다면
                            if(cnt[1][k]) { // 사용자B가 어떤 BC 범위 내에 있다면
                                max = Math.max(max, BC[k][3]);  // 사용자B가 포함된 BC의 성능만 max와 비교
                            }
                            // 둘다 어떤 BC 범위에도 없다면 넘어간다
                        }
                    }
                }

                result += max;  // max값을 최종 결과에 더한다
            }

            sb.append("#").append(tc).append(" ").append(result).append("\n");  // 결과 출력
        }

        System.out.println(sb);
    }
}
