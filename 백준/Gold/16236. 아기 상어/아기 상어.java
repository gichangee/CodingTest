import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	// 상하좌우
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };
	static int[][] arr;
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];

		int locationy = 0;
		int locationx = 0;

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 9) {
					locationy = i;
					locationx = j;
					arr[i][j] = 0;
				}
			}
		}
		


		int time = solve(locationy, locationx);

		System.out.println(time);

	}

	static class Point {
		int y;
		int x;
		int d;

		public Point(int y, int x, int d) {
			this.y = y;
			this.x = x;
			this.d = d;
		}

	}

	private static int solve(int locationy, int locationx) {

		int time = 0;
		int size = 2;
		int cnt = 2;

		Point minPt = new Point(locationy, locationx, 0);
		do {
			boolean[][] v = new boolean[N][N];

			Queue<Point> q = new ArrayDeque<>();

			q.add(new Point(minPt.y, minPt.x, 0));
			minPt.d = Integer.MAX_VALUE;
			v[minPt.y][minPt.x]=true;

			while (!q.isEmpty()) {

				Point p = q.poll();

				if (p.d > minPt.d) {
					break;
				}

				if (arr[p.y][p.x] > size) {
					continue;
				}
				if (arr[p.y][p.x] < size && arr[p.y][p.x] != 0) {
					if (minPt.d > p.d) {
						minPt = p;
					} else if (minPt.d == p.d) {
						if (p.y < minPt.y) {
							minPt = p;
						} else if (p.y == minPt.y) {
							if (p.x < minPt.x) {
								minPt = p;
							}
						}
					}
					continue;
				}
				for (int i = 0; i < 4; i++) {
					int goY = p.y + dy[i];
					int goX = p.x + dx[i];
					if (goY >= 0 && goY < N && goX >= 0 && goX < N) {
						if(!v[goY][goX]) {
							v[goY][goX]=true;
							q.add(new Point(goY, goX, p.d + 1));
						}
						
					}
				}
			}

			if (minPt.d != Integer.MAX_VALUE) {
				time += minPt.d;
				cnt--;
				if (cnt == 0) {
					size++;
					cnt = size;
				}
				arr[minPt.y][minPt.x] = 0;
			}


		} while (minPt.d != Integer.MAX_VALUE);

		return time;
	}

}