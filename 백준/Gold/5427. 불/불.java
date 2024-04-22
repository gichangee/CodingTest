import java.io.*;
import java.util.*;

public class Main {

	static int min;
	static boolean a;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			char[][] arr = new char[h][w];
			for (int i = 0; i < h; i++) {
				arr[i] = br.readLine().toCharArray();
			}
			int starty = 0;
			int startx = 0;

			List<int[]> list = new ArrayList<>();

			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (arr[i][j] == '@') {
						starty = i;
						startx = j;
					}
					if (arr[i][j] == '*') {
						list.add(new int[] { i, j });
					}
				}
			}

			min = Integer.MAX_VALUE;
			a = false;
			bfs(arr, list, starty, startx);

			if (!a) {
				System.out.println("IMPOSSIBLE");
			} else {
				System.out.println(min);
			}
		}

	}

	private static void bfs(char[][] arr, List<int[]> list, int starty, int startx) {

		Queue<int[]> fire = new ArrayDeque<int[]>();
		Queue<int[]> q = new ArrayDeque<int[]>();
		q.add(new int[] { starty, startx, 1});
		boolean[][] v = new boolean[arr.length][arr[0].length];
		v[starty][startx] = true;

		int[] dy = new int[] { -1, 1, 0, 0 };
		int[] dx = new int[] { 0, 0, -1, 1 };

		for (int i = 0; i < list.size(); i++) {
			fire.add(new int[] { list.get(i)[0], list.get(i)[1], 1 });
		}

		while (!q.isEmpty()) {
			int[] temp = q.poll();
			int count = fire.size();

			if (temp[0] == 0 || temp[0] == arr.length - 1 || temp[1] == 0 || temp[1] == arr[0].length - 1) {
				a = true;
				min = temp[2];
				break;
			}

			int[] check = fire.peek();
			if(!fire.isEmpty()) {
				if(check[2]<=temp[2]) {
					for (int fc = 0; fc < count; fc++) {
						int[] tempfire = fire.poll();
						for (int i = 0; i < 4; i++) {
							int goY = dy[i] + tempfire[0];
							int goX = dx[i] + tempfire[1];
							if (goY >= 0 && goX >= 0 && goY < arr.length && goX < arr[0].length) {
								if (arr[goY][goX] == '.' ||arr[goY][goX] == '@' ) {
									arr[goY][goX] = '*';
									fire.add(new int[] { goY, goX ,tempfire[2]+1});
								}
							}
						}
					}
				}
				
			}
			

			for (int i = 0; i < 4; i++) {
				int goY = dy[i] + temp[0];
				int goX = dx[i] + temp[1];
				if (goY >= 0 && goX >= 0 && goY < arr.length && goX < arr[0].length) {
					if (arr[goY][goX] == '.') {
						if (!v[goY][goX]) {
							v[goY][goX] = true;
							q.add(new int[] { goY, goX,temp[2]+1});
						}
					}

				}
			}
		}
	}

}