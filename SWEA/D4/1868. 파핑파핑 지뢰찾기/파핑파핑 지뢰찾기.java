import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static char arr[][];
	static int N;
	static boolean visited[][];
	static int check[][];
	static int click; // 클릭 수

	// 8방 이동을 위함
	static int dy[] = { -1, -1, -1, 0, 1, 1, 1, 0 };
	static int dx[] = { -1, 0, 1, 1, 1, 0, -1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());

		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());

			click=0;
			arr = new char[N][N];
			visited = new boolean[N][N];
			check = new int[N][N];
			for (int i = 0; i < N; i++) {
				String str = br.readLine();
				for (int k = 0; k < N; k++) {
					arr[i][k] = str.charAt(k);
					if (arr[i][k] == '*') {
						visited[i][k] = true;
					}
				}
			}

			// 지뢰가 있으면 1 없으면 2
			for (int i = 0; i < N; i++) {
				for (int k = 0; k < N; k++) {
					if (arr[i][k] == '.') {
						check[i][k] = 2;
					} else {
						check[i][k] = 1;
					}
				}
			}
			for (int i = 0; i < N; i++) {
				for (int k = 0; k < N; k++) {
					// 주변에 지뢰가 하나도 없는 지뢰가 없는칸은 3
					// 주변에 지뢰가 하나라도 있는 지뢰가 없는칸은 4
					if (check[i][k] == 2) {
						boolean a = true;
						for (int j = 0; j < 8; j++) {
							int y = i + dy[j];
							int x = k + dx[j];
							if (y >= 0 && x >= 0 && y < N && x < N) {
								if (check[y][x] == 1) {
									a=false;
									break;
								}
							}
						}
						
						if(a) {
							check[i][k] = 3;
						}else {
							check[i][k] = 4;
						}
						
					}

				}
			}

		

			for (int i = 0; i < N; i++) {
				for (int k = 0; k < N; k++) {
					if (check[i][k] == 3 && !visited[i][k]) {
						Queue<int[]> q = new ArrayDeque<>();
						visited[i][k] = true;
						q.add(new int[] { i, k });
						click++;
						while (!q.isEmpty()) {
							int[] temp = q.poll();

							for (int j = 0; j < 8; j++) {
								int y = temp[0] + dy[j];
								int x = temp[1] + dx[j];
								if (x >= 0 && y >= 0 && x < N && y < N && !visited[y][x]) {
									visited[y][x] = true;
									if (check[y][x] == 3) {
										q.add(new int[] { y,x});
										
									} else if (check[y][x] == 4) {
									}
								}

							}
						}
					}
				}
			}

			for (int i = 0; i < N; i++) {
				for (int k = 0; k < N; k++) {
					if (check[i][k] == 4 && !visited[i][k]) {
						click++;
					}
				}
			}

			System.out.println("#" + t + " " + click);
		}
	}

}