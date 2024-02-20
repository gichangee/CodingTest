import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[] arr;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		arr = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			arr[i] = i;
		}

		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());

			int h = Integer.parseInt(st.nextToken());

			if (h == 0) {
				union(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			} else {
				int a = find(Integer.parseInt(st.nextToken()));
				int b = find(Integer.parseInt(st.nextToken()));
				if (a == b) {
					System.out.println("YES");
				} else {
					System.out.println("NO");
				}

			}
		}
	}

	private static int find(int parseInt) {
		if (arr[parseInt] != parseInt) {

			return arr[parseInt] = find(arr[parseInt]);
		}
		return parseInt;
	}

	private static void union(int parseInt, int parseInt2) {
		int a = find(parseInt);
		int b = find(parseInt2);
		if (a != b) {
			arr[b] = a;
		}
	}

}