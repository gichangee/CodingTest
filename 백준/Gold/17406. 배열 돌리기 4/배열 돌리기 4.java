import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int[][] arr;
	static int[][] copyarr;
	static int[] dx, dy;
	static boolean[] v;
	static int R;
	static int[][] temp;
	static int[][] comarr;
	static int min;
	static int N, M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		arr = new int[N + 1][M + 1];
		copyarr = new int[N + 1][M + 1];

		// 우 하 좌 상
		dx = new int[] { 0, 1, 0, -1 };
		dy = new int[] { 1, 0, -1, 0 };

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				copyarr[i][j] = arr[i][j];
			}
		}

		comarr = new int[R][3];

		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			comarr[i][0] = Integer.parseInt(st.nextToken());
			comarr[i][1] = Integer.parseInt(st.nextToken());
			comarr[i][2] = Integer.parseInt(st.nextToken());
		}
		temp = new int[R][3];
		v = new boolean[R];
		min = Integer.MAX_VALUE;
		
		dfs(0);

		System.out.println(min);

	}

	private static void extracted(int[][] temp) {

		for (int i = 0; i < R; i++) {

			int x = temp[i][0];
			int y = temp[i][1];
			int size = temp[i][2];

			int startx = x - size;
			int starty = y - size;

			int endx = x + size;
			int endy = y + size;

			// 겉에 있는 배열부터 안쪽 배열까지 돌리기
			// 왼쪽 위부터
			for (int j = startx; j < x; j++) {
				loop(j, starty, j, starty, endx, endy, arr[j][starty], 0);
				starty = starty + 1;
				endx = endx - 1;
				endy = endy - 1;

			}

		}

		for (int i2 = 1; i2 <= N; i2++) {
			int sum = 0;
			for (int j2 = 1; j2 <= M; j2++) {
				sum += arr[i2][j2];
			}
			if (sum <= min) {
				min = sum;

			}

		}
	}

	private static void dfs(int cnt) {
		if (cnt == R) {

			extracted(temp);
			for(int i=0;i<arr.length;i++) {
				for(int j=0;j<arr[0].length;j++) {
					arr[i][j]=copyarr[i][j];
				}
			}
			return;
		} else {
			for (int i = 0; i < v.length; i++) {
				if (!v[i]) {
					v[i] = true;
					for (int j = 0; j < 3; j++) {
						temp[cnt][j] = comarr[i][j];
					}
					dfs(cnt + 1);

					v[i] = false;
				}
			}
		}

	}

	private static void loop(int x, int y, int startx, int starty, int endx, int endy, int temp, int direction) {

		int temp2 = 0;

		int goX = x + dx[direction];
		int goY = y + dy[direction];

		if (goX == startx && goY == starty) {
			arr[goX][goY] = temp;
			return;
		}

		if (goX < startx || goY > endy || goX > endx || goY < starty) {
			direction = direction + 1;
			direction = direction % 4;
			loop(x, y, startx, starty, endx, endy, temp, direction);
		} else {
			temp2 = arr[goX][goY];
			arr[goX][goY] = temp;
			loop(goX, goY, startx, starty, endx, endy, temp2, direction);
		}

	}
}