import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @author 박기창 인접리스트 사용하기
 */
public class Main {

	static int N;
	static boolean a;
	static boolean[] v;
	static List<Integer>[] list;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());

		list = new ArrayList[N];

		// 리스트 초기화 하기
		for (int i = 0; i < N; i++) {
			list[i] = new ArrayList<>();
		}

		// 인접리스트에 값 넣기
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			list[x].add(y);
			list[y].add(x);
		}

		a = false;
		for (int i = 0; i < N; i++) {
			v = new boolean[N];
			v[i] = true;
			dfs(i, 0);
			if (a) {
				System.out.println("1");
				break;
			}

		}

		if (!a) {
			System.out.println("0");

		}

	}

	private static void dfs(int cnt, int depth) {

		if (depth == 4) {
			a = true;
			return;
		}
		for (int i = 0; i < list[cnt].size(); i++) {
			if (!v[list[cnt].get(i)]) {
				v[list[cnt].get(i)] = true;
				dfs(list[cnt].get(i), depth + 1);
				v[list[cnt].get(i)] = false;
			}
		}
	}

}