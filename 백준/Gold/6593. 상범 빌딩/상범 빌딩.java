import java.io.*;
import java.util.*;

public class Main {

	static int L, R, C;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			L = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());

			int starty = 0;
			int startx = 0;
			int startz = 0;
			int endy = 0;
			int endx = 0;
			int endz = 0;

			if (L == 0 && R == 0 && C == 0) {
				break;
			} else {

				char[][][] arr = new char[L][R][C];
				for (int i = 0; i < L; i++) {

					for (int j = 0; j < R; j++) {
						arr[i][j] = br.readLine().toCharArray();
					}
					br.readLine();
				}

				for (int i = 0; i < L; i++) {

					for (int j = 0; j < R; j++) {
						for (int z = 0; z < C; z++) {
							if (arr[i][j][z] == 'S') {
								startz = i;
								starty = j;
								startx = z;
							}

							if (arr[i][j][z] == 'E') {
								endz = i;
								endy = j;
								endx = z;
							}
						}
					}
				}

				bfs(arr, startz, starty, startx, endz, endy, endx);

			}

		}
	}

	private static void bfs(char[][][] arr, int startz, int starty, int startx, int endz, int endy, int endx) {

		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] { startz, starty, startx, 1 });
		int[] dz = { 0, 0, 0, 0, -1, 1 };
		int[] dy = { -1, 1, 0, 0, 0, 0 };
		int[] dx = { 0, 0, -1, 1, 0, 0 };

		boolean[][][] v = new boolean[L][R][C];
		v[startz][starty][startx] = true;

		while (!q.isEmpty()) {
			int[] temp = q.poll();
			for (int i = 0; i < 6; i++) {
				int z = temp[0] + dz[i];
				int y = temp[1] + dy[i];
				int x = temp[2] + dx[i];

				if (z == endz && y == endy && x == endx) {
					System.out.println("Escaped in " + temp[3] + " minute(s).");
					return;
				}

				if (z >= 0 && y >= 0 && x >= 0 && z < L && y < R && x < C) {
					if (!v[z][y][x]) {
						if (arr[z][y][x] == '.') {
							v[z][y][x] = true;
							q.add(new int[] { z, y, x, temp[3] + 1 });
						}
					}
				}
			}
		}
		System.out.println("Trapped!");

	}

}