package 박윤환;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P046_SWEA3234_준환이의양팔저울 {
    static int N, cnt;
    static int[] weight;

    static void subset(int index, int sumL, int sumR) {
        if(sumL < sumR) return;
        if(index == N) {
            cnt++;
            return;
        }

        subset(index+1, sumL+weight[index], sumR);
        subset(index+1, sumL, sumR+weight[index]);
    }

    static boolean np(int[] arr) {
        int n = arr.length;

        // 1. 꼭대기 찾기
        int i = n-1;
        while(i>0 && arr[i-1] >= arr[i]) {
            i--;
        }

        if(i==0) return false;  // 이미 가장 큰 순열의 상태

        // 2. 꼭대기의 바로 앞자리(i-1)의 값을 크게 만들 교환 값 뒤쪽에서 찾기
        int j = n-1;
        while(arr[i-1] >= arr[j]) {
            j--;
        }

        // 3. i-1 위치값과 j 위치값 교환
        swap(arr, i-1, j);

        // 4. i위치부터 맨뒤까지의 수열을 가장 작은 형태의 오름차순으로 변경
        int k = n-1;
        while(i < k) {
            swap(arr, i++, k--);
        }

        return true;

    }

    // 배열 원소 위치 교환 메소드
    static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());    // 테스트케이스 개수
        for(int tc=1; tc<=T; tc++) {    // 테스트케이스만큼 반복
            N = Integer.parseInt(br.readLine());    // 무게추 개수
            String[] st = br.readLine().split(" ");
            weight = new int[N];    // 무게추 무게를 담는 배열
            cnt = 0;    // 경우의 수 카운트

            for(int i=0; i<N; i++) {
                weight[i] = Integer.parseInt(st[i]);
            }

            Arrays.sort(weight);    // NextPermutation을 위해 무게에 따라 오름차순 정렬

            do {    // NextPermutation의 각 순열마다 경우의 수 계산
                subset(0, 0, 0);
            } while(np(weight));

            sb.append("#").append(tc).append(" ").append(cnt).append("\n");

        }

        System.out.println(sb);
    }
}
