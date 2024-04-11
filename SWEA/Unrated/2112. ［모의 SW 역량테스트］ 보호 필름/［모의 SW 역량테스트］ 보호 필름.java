import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

	static int[][] arr, copy;

	static int D, W, K;

	static int min;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

		
			
			arr = new int[D][W];
			copy = new int[D][W];

			// a는 0 b는 1
			for (int i = 0; i < D; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					copy[i][j] = arr[i][j];
				}
			}

			if(K==1) {
				System.out.println("#" + tc + " " + 0);
				continue;
			}
			boolean[] v = new boolean[W];

			for (int i = 0; i < W; i++) {
				int first = arr[0][i];
				int count = 1;
				for (int j = 1; j < D; j++) {
					if (arr[j][i] == first) {
						count++;
						if (count == K) {
							v[i] = true;
							break;
						}
					} else {
						count = 1;
						first = arr[j][i];
					}
				}
			}

			boolean use = true;

			for (int i = 0; i < W; i++) {
				if (!v[i]) {
					use = false;
					break;
				}
			}

			if (use) {
				System.out.println("#" + tc + " " + 0);
			} else {
				int[] temp = new int[D];
				min = Integer.MAX_VALUE;
				loop(temp, 0);
				System.out.println("#" + tc + " " + min);
			}

		}
	}

	private static void loop(int[] temp, int depth) {
		if (depth == temp.length) {

			int count = 0;
			for (int i = 0; i < temp.length; i++) {
				if (temp[i] == 0 || temp[i] == 1) {
					count++;
				}
			}

			if (count >= min) {
				return;
			} else {

				for (int i = 0; i < D; i++) {
					for (int j = 0; j < W; j++) {
						arr[i][j] = copy[i][j];
					}
				}
			}

			for (int i = 0; i < temp.length; i++) {
				// 가로줄에 a형 약품을 넣었을 때
				if (temp[i] == 0) {
					for (int j = 0; j < W; j++) {
						arr[i][j] = 0;
					}
					// 가로줄에 b형 약품을 넣었을 때
				} else if (temp[i] == 1) {
					for (int j = 0; j < W; j++) {
						arr[i][j] = 1;
					}
				}
			}

			boolean[] v = new boolean[W];
			for (int i = 0; i < W; i++) {
				int first = arr[0][i];
				int c = 1;
				for (int j = 1; j < D; j++) {
					if (arr[j][i] == first) {
						c++;
						if (c == K) {
							v[i] = true;
							break;
						}
					} else {
						c = 1;
						first = arr[j][i];
					}
				}
			}

			boolean use = true;

			for (int i = 0; i < W; i++) {
				if (!v[i]) {
					use = false;
					break;
				}
			}

			// 해당 약품조합으로 성공했을 때
			if (use) {
				if (min > count) {
					min = count;
				}
			}

		} else {

			// 0 이면 a
			// 1 이면 b
			// 2 이면 약 안씀
			for (int i = 0; i < 3; i++) {
				temp[depth] = i;
				loop(temp, depth + 1);
			}
		}
	}

}