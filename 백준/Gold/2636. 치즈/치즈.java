import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int count;
	// 방향 상하좌우
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };
	static boolean[][] v;
	static boolean[][] c;

	static int N, R;
	static int lastone;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][R];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < R; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		v = new boolean[N][R];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < R; j++) {
				if (!v[i][j] && arr[i][j] == 0) {
					boolean out = noairfind(arr, i, j);
					c = new boolean[N][R];
					if (!out) {// 공기가 안통하는 곳일 때
						change(arr, i, j, 3);
					} else { // 공기가 통하는 곳일 때
						change(arr, i, j, 0);
					}
				}
			}
		}

		count = 0;
		lastone = 0;
		while (loop(arr)) {
			count++;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < R; j++) {
					if (arr[i][j] == 3) {
						arr[i][j] = 0;
					}
					if (arr[i][j] == 1) {

					}
				}
			}

			v = new boolean[N][R];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < R; j++) {
					if (!v[i][j] && arr[i][j] == 0) {
						boolean out = noairfind(arr, i, j);
						c = new boolean[N][R];
						if (!out) {// 공기가 안통하는 곳일 때
							change(arr, i, j, 3);
						} else { // 공기가 통하는 곳일 때
							change(arr, i, j, 0);
						}
					}
				}
			}
		}

		System.out.println(count);
		System.out.println(lastone);

	}

	private static void change(int[][] arr, int y, int x, int k) {
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] { y, x });
		c[y][x] = true;
		arr[y][x] = k;
		while (!q.isEmpty()) {
			int[] temp = q.poll();
			for (int i = 0; i < 4; i++) {

				int goY = temp[0] + dy[i];
				int goX = temp[1] + dx[i];
				if (goY >= 0 && goX >= 0 && goX < arr[0].length && goY < arr.length && !c[goY][goX]
						&& arr[goY][goX] == 0) {
					c[goY][goX] = true;
					arr[goY][goX] = k;
					q.add(new int[] { goY, goX });
				}
			}
		}
	}

	private static boolean noairfind(int[][] arr, int y, int x) {
		boolean out = false;
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] { y, x });
		v[y][x] = true;
		while (!q.isEmpty()) {
			int[] temp = q.poll();
			for (int i = 0; i < 4; i++) {
				int goY = temp[0] + dy[i];
				int goX = temp[1] + dx[i];
				if (goY < 0 || goX < 0 && goX >= arr[0].length && goY >= arr.length) {
					out = true;
				}

				if (goY >= 0 && goX >= 0 && goX < arr[0].length && goY < arr.length && !v[goY][goX]
						&& arr[goY][goX] == 0) {
					v[goY][goX] = true;
					q.add(new int[] { goY, goX });
				}
			}
		}

		return out;

	}

	private static boolean loop(int[][] arr) {
		boolean result = false;
		ArrayList<int[]> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < R; j++) {
				if (arr[i][j] == 1) {
					result = true;
					for (int k = 0; k < 4; k++) {
						int goY = dy[k] + i;
						int goX = dx[k] + j;
						if (arr[goY][goX] == 0) {
							list.add(new int[] { i, j });
							break;
						}
					}
				}
			}
		}
		if (list.size() > 0) {
			lastone = 0;
		}

		for (int i = 0; i < list.size(); i++) {
			arr[list.get(i)[0]][list.get(i)[1]] = 0;
			lastone++;
		}

		return result;

	}

}