import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };
	static char[][] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int size = Integer.parseInt(br.readLine());

		arr = new char[size][size];
		for (int i = 0; i < size; i++) {
			arr[i] = br.readLine().toCharArray();
		}
		boolean[][] v = new boolean[size][size];

		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if (!v[i][j]) {
					nojang(v, i, j, arr[i][j]);
					count++;
				}
			}
		}

		System.out.print(count + " ");

		v = new boolean[size][size];
		count = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if (!v[i][j]) {
					yesjang(v, i, j, arr[i][j]);
					count++;
				}
			}
		}
		System.out.print(count);
	}

	private static void nojang(boolean[][] v, int y, int x, char c) {
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] { y, x });
		while (!q.isEmpty()) {
			int[] temp = q.poll();
			for (int i = 0; i < 4; i++) {
				int goY = temp[0] + dy[i];
				int goX = temp[1] + dx[i];

				if (goX >= 0 && goY >= 0 && goX < v.length && goY < v.length) {
					if (!v[goY][goX] && arr[goY][goX] == c) {
						v[goY][goX] = true;
						q.add(new int[] { goY, goX });
					}
				}
			}

		}

	}

	private static void yesjang(boolean[][] v, int y, int x, char c) {
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] { y, x });
		while (!q.isEmpty()) {
			int[] temp = q.poll();
			for (int i = 0; i < 4; i++) {
				int goY = temp[0] + dy[i];
				int goX = temp[1] + dx[i];

				if (goX >= 0 && goY >= 0 && goX < v.length && goY < v.length) {
					if(!v[goY][goX] && c != arr[goY][goX]) {
						if(c=='R' && arr[goY][goX] =='G' || c=='G' && arr[goY][goX] =='R') {
							v[goY][goX] = true;
							q.add(new int[] { goY, goX });
						}
					}
					else if (!v[goY][goX] && arr[goY][goX] == c) {
						v[goY][goX] = true;
						q.add(new int[] { goY, goX });
					}
				}
			}

		}

	}

}