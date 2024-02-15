import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static class Node {
		int cnt;
		int value;

		public Node(int cnt, int value) {
			this.cnt = cnt;
			this.value = value;
		}

	}

	static int location1, location2;
	static int[] v = new int[] { 2,-1,1 };
	static Queue<Node> q = new ArrayDeque<>();
	static int cnt;
	static boolean[] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		location1 = sc.nextInt();
		location2 = sc.nextInt();
		cnt = 0;
		visited = new boolean[100001];
		bfs();
	}

	private static void bfs() {

		q.add(new Node(0, location1));

		StringBuilder sb = new StringBuilder();

		// 동생이 더 앞에 있다면 마이너스만 해주면 됨
		if (location2 < location1) {
			sb.append(location1 - location2);

			System.out.println(sb);
			return;
		}

		// 동생이 뒤에 있다면
		while (!q.isEmpty()) {
			Node n = q.poll();

			if (n.value == location2) {

				sb.append(n.cnt);

				System.out.println(sb);
				break;
			}

			if (n.value < 0 || n.value > 100000) {
				continue;
			}

			if (visited[n.value]) {
				continue;
			}

			visited[n.value] = true;

			for (int i = 0; i < 3; i++) {
				if (i == 0) {

					int x = n.value * v[i];

					q.add(new Node(n.cnt, x));
					continue;
				}

				int x = n.value + v[i];

				q.add(new Node(n.cnt + 1, x));

			}

		}
	}

}