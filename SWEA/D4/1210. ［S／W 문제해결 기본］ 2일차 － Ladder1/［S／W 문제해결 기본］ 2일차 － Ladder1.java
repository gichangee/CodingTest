
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

class Solution {

	static int[][] arr;
	static int[] dx;
	static int[] dy;
	static StringBuilder sb;

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();

		for (int test_case = 1; test_case <= 10; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr = new int[100][100];

			for (int i = 0; i < 100; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 100; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			dx = new int[] { 0, 0, 1 };
			dy = new int[] { 1, -1, 0 };

			for (int i = 0; i < 100; i++) {
				if (arr[0][i] == 1) {
					for (int d = 0; d < 3; d++) {
						int gox = 0 + dx[d];
						int goy = i + dy[d];
						if (gox >= 100 || goy >= 100 || gox < 0 || goy < 0 || arr[gox][goy] == 0) {
							continue;
						}
						dfs(0, i, test_case, i, d);
						break;
					}

				}
			}

		}

		System.out.println(sb.toString());
	}

	private static void dfs(int i, int j, int test_case, int originalx, int direction) {

		for (int d = 0; d < 3; d++) {
			int gox = i + dx[d];
			int goy = j + dy[d];

			// 방향이 반대인 경우
			if (direction == 0 && d == 1) {
				continue;
			}

			// 방향이 반대인 경우
			if (direction == 1 && d == 0) {
				continue;
			}

			if (gox >= 100 || goy >= 100 || gox < 0 || goy < 0 || arr[gox][goy] == 0) {
				continue;
			}

			if (arr[gox][goy] == 2) {
				sb.append("#" + test_case + " " + originalx + "\n");
				return;
			}

			if (arr[gox][goy] == 1) {
				dfs(gox, goy, test_case, originalx, d);
				return;
			}

		}
	}
}