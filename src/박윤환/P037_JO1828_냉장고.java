package 박윤환;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class P037_JO1828_냉장고 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());    // 화학물질 수
        int[][] chem = new int[N][2];       // 화학물질을 저장할 배열
        ArrayList<int[]> list = new ArrayList<>();  // 냉장고 개수에 넣을 기준이 되는 화학물질을 넣을 list

        for(int i=0; i<N; i++) {    // 화학물질을 배열에 저장
            String[] st = br.readLine().split(" ");
            chem[i][0] = Integer.parseInt(st[0]);
            chem[i][1] = Integer.parseInt(st[1]);
        }

        Arrays.sort(chem, (o1, o2) -> {
            return o1[1] != o2[1] ? o1[1] - o2[1] : o1[0] - o2[0];
        });   // 화학물질의 최고온도를 기준으로 오름차순 정렬, 만약 같으면 최저온도 기준으로 오름차순 정렬

        list.add(chem[0]);  // 가장 최고온도가 낮은 화학물질을 list에 넣는다

        for(int i=1, size=chem.length; i<size; i++) {   // 남은 화학물질 만큼 반복
            if(list.get(list.size()-1)[1] < chem[i][0]) {   // 다음 범위의 화학물질이 list의 가장 마지막 화학물질과 겹치지 않으면
                list.add(chem[i]);  // list에 추가
            }
        }

        System.out.println(list.size());    // list의 크기가 냉장고의 개수
    }
}
