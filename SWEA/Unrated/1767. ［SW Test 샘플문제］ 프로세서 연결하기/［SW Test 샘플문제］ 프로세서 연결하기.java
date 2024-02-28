import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

	// 상하좌우
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };
	static int[] temp;
	static int N;
	static int[][] arr;
	static int[][] copy;
	static int min;
	static int corecnt;
	static List<int[]> list;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			copy = new int[N][N];
			list = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					copy[i][j] = arr[i][j];
					if (arr[i][j] == 1 && i > 0 && j > 0 && j < N - 1 && i < N - 1) {
						list.add(new int[] { i, j });
					}
				}
			}
			corecnt = Integer.MIN_VALUE;
			min = Integer.MAX_VALUE;
			loop(0, 0, 0);

			System.out.println("#" + test_case + " " + min);

		}
	}

	private static void loop(int cnt, int maxcorecnt, int len) {

		if (cnt == list.size()) {

			
			if (maxcorecnt > corecnt) {
				
				corecnt = maxcorecnt;
				min = len;
			} else if (maxcorecnt == corecnt) {

				if (min > len) {
					min = len;
				}
			}

			return;
		} else {
			int y = list.get(cnt)[0];
			int x = list.get(cnt)[1];
			for (int i = 0; i < 4; i++) {
				int ny = y;
				int nx = x;
				int sy = y;
				int sx = x;
				int count = 0;
				while (true) {
					ny += dy[i];
					nx += dx[i];

					if (ny < 0 || nx < 0 || ny >= N || nx >= N) {
						break;
					}
					if (arr[ny][nx] == 1) {
						count = 0;
						break;
					}
					count++;

				}

				if (count == 0) {
					loop(cnt + 1, maxcorecnt, len);
				} else {

					for (int j = 0; j < count; j++) {
						sy += dy[i];
						sx += dx[i];
						arr[sy][sx] = 1;
					}

					loop(cnt + 1, maxcorecnt + 1, len + count);

					sy=y;
					sx =x;
					
					for(int j=0;j<count;j++) {
						sy+=dy[i];
						sx+=dx[i];
						arr[sy][sx]=0;
					}
				}

			}
		}
	}

}