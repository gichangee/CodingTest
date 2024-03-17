import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] arr = new int[N][M];
		int[][] copy = new int[N][M];

		List<int[]> list = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				copy[i][j] = arr[i][j];

				if (arr[i][j] != 0) {
					list.add(new int[] { i, j });
				}
			}
		}

		int count = 0;
		while (true) {

			int icebergCount = countIcebergGroups(arr, list);

			if (icebergCount == 0) {
				count = 0;
				break;
			} else if (icebergCount >= 2) {
				break;
			}

			loop(arr, copy, list);

			list = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					copy[i][j] = arr[i][j];

					if (arr[i][j] != 0) {
						list.add(new int[] { i, j });
					}
				}
			}

			count++;
		}

		System.out.println(count);

	}

	private static void loop2(int[][] arr,boolean[][] v,  int y, int x) {
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] { y, x });
		while (!q.isEmpty()) {
			int[] temp = q.poll();
			for (int i = 0; i < 4; i++) {
				int goY = temp[0] + dy[i];
				int goX = temp[1] + dx[i];
				if (goY >= 0 && goY < arr.length && goX >= 0 && goX < arr[0].length) {
					if (!v[goY][goX] && arr[goY][goX] > 0) {
						v[goY][goX] = true;
						q.add(new int[] { goY, goX });
					}
				}
			}
		}

	}

	static int countIcebergGroups(int[][] arr, List<int[]> iceberg) {
		boolean[][] visited = new boolean[arr.length][arr[0].length];
		int count = 0;

		for (int[] ice : iceberg) {
			int y = ice[0];
			int x = ice[1];
			if (!visited[y][x]) {
				loop2(arr, visited, y, x);
				count++;
			}
		}
		return count;
	}

	private static void loop(int[][] arr, int[][] copy, List<int[]> list) {
		int[][] melted = new int[arr.length][arr[0].length];
		for (int[] ice : list) {
			int y = ice[0];
			int x = ice[1];
			for (int d = 0; d < 4; d++) {
				int ny = y + dy[d];
				int nx = x + dx[d];
				if (arr[ny][nx] == 0) {
					melted[y][x]++;
				}
			}
		}

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				arr[i][j] = Math.max(arr[i][j] - melted[i][j], 0);
			}
		}
	}

}