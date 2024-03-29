import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int n;
	static boolean a;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int test_case = 1; test_case <= t; test_case++) {

			a = false;
			n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] home = { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0 };

			
			
			List<int[]> cu = new ArrayList<>();

			for (int i = 1; i <= n; i++) {
				st = new StringTokenizer(br.readLine());
				cu.add(new int[] { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), i });
			}

			st = new StringTokenizer(br.readLine());

			int[] fesitival = { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), n + 1 };

			

			
			boolean[] v = new boolean[n + 2];

			bfs(home, cu, fesitival, v);

			if (a) {
				sb.append("happy\n");

			} else {
				sb.append("sad\n");
			}

		}

		System.out.println(sb.toString());

	}

	private static void bfs(int[] home, List<int[]> cu, int[] fesitival, boolean[] v) {

		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] { home[0], home[1] });
		v[0] = true;

		while (!q.isEmpty()) {
			int[] temp = q.poll();

			int dis = Math.abs(fesitival[0] - temp[0]) + Math.abs(fesitival[1] - temp[1]);

			if (dis <= 1000) {
				a = true;
				break;
			}

			for (int i = 1; i <= n; i++) {
				int distance = Math.abs(temp[0] - cu.get(i - 1)[0]) + Math.abs(cu.get(i - 1)[1]- temp[1]);
				if (!v[cu.get(i-1)[2]] && distance <= 1000) {
					v[cu.get(i-1)[2]] = true;
					q.add(new int[] { cu.get(i - 1)[0], cu.get(i - 1)[1] });
				}
			}

		}
	}
}