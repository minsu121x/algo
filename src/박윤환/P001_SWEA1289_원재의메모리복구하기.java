package 박윤환;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class P001_SWEA1289_원재의메모리복구하기 {

	public static void main(String[] args) throws FileNotFoundException {
//		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			String m = sc.next();
			char[] ch = m.toCharArray();
			char cur = '0';
			int count = 0;
			for (char c : ch) {
				if(cur == '0') {
					if(c == '1') {
						count++;
						cur = '1';
					}
				} else if(cur == '1') {
					if(c == '0') {
						count++;
						cur = '0';
					}
				}
			}
			System.out.print("#" + tc + " " + count);
			System.out.println();
		}
		sc.close();
	}

}
