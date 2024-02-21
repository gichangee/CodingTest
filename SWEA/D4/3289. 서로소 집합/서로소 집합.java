import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	static int[] arr;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int test_case = 1; test_case <= t; test_case++) {
			int N = sc.nextInt();
			int R = sc.nextInt();
			StringBuilder sb = new StringBuilder();
			arr = new int[N + 1];

			for (int i = 1; i <=N; i++) {
				arr[i] = i;
			}

			for (int i = 0; i < R; i++) {
				int h = sc.nextInt();
				int x = sc.nextInt();
				int y = sc.nextInt();

				if (h == 0) {
					union(x, y);
				} else if (h == 1) {
					int a = find(x);
					int b = find(y);
					if (a == b) {
						sb.append("1");
					} else {
						sb.append("0");
					}
				}
			}

			System.out.println("#" + test_case + " " + sb.toString());

		}
	}

	private static int find(int x) {

		if (arr[x] == x) {
			return x;
		} else {
			return arr[x] = find(arr[x]);
		}

	}

	private static void union(int x, int y) {

		int a = find(x);
		int b = find(y);
		if (a != b) {
			arr[b] = a;
		}

	}

}