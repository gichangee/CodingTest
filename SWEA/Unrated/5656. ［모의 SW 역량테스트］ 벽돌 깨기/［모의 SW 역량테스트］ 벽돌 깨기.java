import java.io.*;
import java.util.*;

public class Solution {

	static int N, H, W;

	static int[][] arr,copy;
	
	static int min;

	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());

			arr = new int[H][W];
			copy = new int[H][W];
			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine());

				for (int j = 0; j < W; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					copy[i][j]=arr[i][j];
				}
			}
			
			min = Integer.MAX_VALUE;

			// 구슬 떨어뜨릴 순서 0 이면 0번째 세로줄 1이면 1번째 세로줄
			int[] temp = new int[N];
			loop(temp, 0);
			System.out.println("#"+tc+" "+min);

		}
	}

	private static void loop(int[] temp, int depth) {

		if (depth == temp.length) {

			
			for(int i=0;i<H;i++) {
				for(int j=0;j<W;j++) {
					arr[i][j]=copy[i][j];
				}
			}
			
			Queue<int[]> brisk = new ArrayDeque<>();

			// 구슬 떨어뜨리기
			for (int i = 0; i < temp.length; i++) {

				// 위에서부터 해당 세로줄에 0이 아닌값 찾기
				for (int j = 0; j < H; j++) {
					if (arr[j][temp[i]] != 0) {
						// 만약 찾았을 때
						brisk.add(new int[] { j, temp[i], arr[j][temp[i]] });
						break;
					}
				}

				// 벽돌 부셔버리기
				while (!brisk.isEmpty()) {
					int[] position = brisk.poll();
					int power = position[2];
					arr[position[0]][position[1]] = 0;
					for (int j = 0; j < 4; j++) {
						for (int z = 1; z < power; z++) {
							int goY = position[0] + dy[j] * z;
							int goX = position[1] + dx[j] * z;
							if (goY >= 0 && goX >= 0 && goY < H && goX < W) {
								if (arr[goY][goX] != 0) {
									brisk.add(new int[] { goY, goX, arr[goY][goX] });
									arr[goY][goX] = 0;
								}
							}
						}
					}
				}

				// 벽돌 내리기
				for (int j = 0; j < W; j++) {
					Queue<Integer> q = new ArrayDeque<>();
					for (int z = H - 1; z >= 0; z--) {
						if (arr[z][j] != 0) {
							q.add(arr[z][j]);
							arr[z][j] = 0;
						}

					}
					int count = H - 1;
					while (!q.isEmpty()) {
						arr[count--][j] = q.poll();
					}

				}
			}
			
			int c = 0;
			for(int i=0;i<H;i++) {
				for(int j=0;j<W;j++) {
					if(arr[i][j]>0) {
						c++;
					}
				}
			}
			
			if(min > c) {
				min = c;
			}
		} else {
			for (int i = 0; i < W; i++) {
				temp[depth] = i;
				loop(temp, depth + 1);
			}
		}
	}

}