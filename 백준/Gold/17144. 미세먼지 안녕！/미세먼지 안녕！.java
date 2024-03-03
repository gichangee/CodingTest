import java.util.*;
import java.io.*;

public class Main {

	// 상 우 하 좌
	static int[] dy = { -1, 0, 1, 0 };
	static int[] dx = { 0, 1, 0, -1 };

	// 하 우 상 좌
	static int[] dy2 = { 1, 0, -1, 0 };
	static int[] dx2 = { 0, 1, 0, -1 };
	static int[][] machine, arr, copy;
	static int R, C;

	static int sum;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());

		arr = new int[R][C];
		copy = new int[R][C];

		machine = new int[2][2];

		boolean[][] v = new boolean[R][C];

		int k = 0;

		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				copy[i][j] = arr[i][j];
				if (arr[i][j] == -1) {
					machine[k][0] = i;
					machine[k][1] = j;
					k++;
				}

				if (arr[i][j] > 0) {
					v[i][j] = true;
				}
			}
		}

		for (int t = 0; t < T; t++) {

			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					//미세먼지가 퍼지기 전 원본 미세먼지만 퍼져야함
					if (arr[i][j] != 0 && arr[i][j] != -1 && v[i][j]) {
						if (arr[i][j] / 5 > 0) {
							int d = 0;
							for (int z = 0; z < 4; z++) {
								int goY = dy[z] + i;
								int goX = dx[z] + j;
								if (goY >= 0 && goY < R && goX >= 0 && goX < C) {
									if (arr[goY][goX] == -1) {
										continue;
									}
									//미세먼지가 퍼지고 합쳐져도 원래 미세먼지 값만 퍼져야함
									
									arr[goY][goX] = arr[goY][goX] + copy[i][j] / 5;
									d++;
								}
							}
							arr[i][j] -= (copy[i][j] / 5) * d;
						}
					}
				}
			}
	
			loop();
			loop2();

	

			sum = 0;
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if (arr[i][j] != -1 && arr[i][j] > 0) {
						sum += arr[i][j];
					}
				}
			}

			

			v = new boolean[R][C];
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if (arr[i][j] > 0) {
						v[i][j] = true;
					}
				}
			}
			
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					copy[i][j]=arr[i][j];
				}
			}

		}
		
		System.out.println(sum);

	}

	private static void loop2() {
		int idx = 0;
		int y = machine[1][0] + 1;
		int x = machine[1][1];
		while (idx < 4) {
			int goY = dy2[idx] + y;
			int goX = dx2[idx] + x;
			if (goY >= machine[1][0] && goX >= 0 && goY < R && goX < C) {
				arr[y][x] = arr[goY][goX];
				y = goY;
				x = goX;
			} else {
				idx++;
			}
		}
		arr[machine[1][0]][machine[1][1]+1] = 0;

	}

	private static void loop() {
		int idx = 0;
		int y = machine[0][0] - 1;
		int x = machine[0][1];
		while (idx < 4) {
			int goY = dy[idx] + y;
			int goX = dx[idx] + x;
			if (goY >= 0 && goX >= 0 && goY < machine[0][0] + 1 && goX < C) {
				arr[y][x] = arr[goY][goX];
				y = goY;
				x = goX;
			} else {
				idx++;
			}
		}
		arr[machine[0][0]][machine[0][1] + 1] = 0;
	}

}