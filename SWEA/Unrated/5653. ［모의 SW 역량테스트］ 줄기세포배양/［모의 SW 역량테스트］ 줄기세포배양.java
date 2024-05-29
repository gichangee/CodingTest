import java.util.*;
import java.io.*;

public class Solution {

	static class cell {
		int y;
		int x;
		int status;
		cell next;

		public cell(int y, int x, int status, cell next) {
			this.y = y;
			this.x = x;
			this.status = status;
			this.next = next;
		}
	}

	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };

	static cell[] cells;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int TC = 1; TC <= T; TC++) {

			int cnt = 0;
			cells = new cell[11];
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());

			int[][] arr = new int[N + K][M + K];

			int start = K / 2;

			for (int i = start; i < N + start; i++) {
				st = new StringTokenizer(br.readLine());

				for (int j = start; j < M + start; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());

					if (arr[i][j] != 0) {
						cells[arr[i][j]] = new cell(i, j, arr[i][j] * 2, cells[arr[i][j]]);
						cnt++;
					}
				}

			}

			for (int i = 0; i < K; i++) {

				for (int z = 10; z >= 1; z--) {

					for (cell c = cells[z]; c != null; c = c.next) {

						c.status--;

						if (c.status >= z) {
							continue;
						}

						if (c.status == 0) {
							cnt--;
						}

						for (int j = 0; j < 4; j++) {
							int y = c.y + dy[j];
							int x = c.x + dx[j];
							if (arr[y][x] == 0 ) {
								arr[y][x] = z;
								cells[z]= new cell(y, x, z*2, cells[z]);
								cnt++;
							}

						}
					}

				}
			}

			System.out.println("#" + TC + " " + cnt);
		}

	}

}