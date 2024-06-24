import java.io.*;
import java.util.*;

public class Main {

	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };

	static int W, H;

	static int starty, startx, endy, endx;

	static char[][] map;

	static class Node implements Comparable<Node> {
		int y, x, cost, dir;

		public Node(int y, int x, int cost) {
			this.y = y;
			this.x = x;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}

		@Override
		public String toString() {
			return y + ", " + x + ", " + cost;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		map = new char[H][W];

		starty = 0;
		startx = 0;
		endy = 0;
		endx = 0;

		for (int i = 0; i < H; i++) {
			String s = br.readLine();
			map[i] = s.toCharArray();
			for (int j = 0; j < W; j++) {
				if (map[i][j] == 'T') {
					starty = i;
					startx = j;
				} else if (map[i][j] == 'E') {
					endy = i;
					endx = j;
				}
			}
		}

		int result = dijkstra(starty, startx);

		if (result == Integer.MAX_VALUE) {
			System.out.println(-1);
			return;
		}
		System.out.println(result);
	}

	private static int dijkstra(int starty, int startx) {
		PriorityQueue<Node> q = new PriorityQueue<>();
		q.add(new Node(starty, startx, 0));
		int[][] memo = new int[H][W];
		for (int i = 0; i < H; i++) {
			Arrays.fill(memo[i], Integer.MAX_VALUE);
		}

		memo[starty][startx] = 0;

		while (!q.isEmpty()) {
			Node temp = q.poll();

			for (int i = 0; i < 4; i++) {

				int a = 1;
				// 해당 방향으로 미끄러져서 범위에 벗어나지 않고 도달할 수 있는지 확인
				// 미끄러졌을 때 구멍에 빠지거나 범위에 벗어나는 경우는 해당 방향 continue
				while (true) {
					int goY = (dy[i] * a) + temp.y;
					int goX = (dx[i] * a) + temp.x;

					if (goY >= 0 && goX >= 0 && goY < H && goX < W) {
						if (map[goY][goX] == 'H') {
							a = -1;
							break;
						} else if (map[goY][goX] == 'R') {
							a -= 1;
							break;
						} else if (map[goY][goX] == 'E') {
							break;
						}
					} else {
						a = -1;
						break;
					}
					a++;
				}

				if (a == -1) {
					continue;
				}

				int size = 0;
				for (int j = 1; j <= a; j++) {
					if (map[temp.y + dy[i] * j][temp.x + dx[i] * j] == 'E')
						continue;
					else
						size += (map[temp.y + dy[i] * j][temp.x + dx[i] * j] - '0');
				}

				int ny = temp.y + dy[i] * a;
				int nx = temp.x + dx[i] * a;

				if (memo[ny][nx] > size + temp.cost) {
					memo[ny][nx] = size + temp.cost;
					q.offer(new Node(ny, nx, memo[ny][nx]));
				}
			}
			
		}
		return memo[endy][endx];
	}
}