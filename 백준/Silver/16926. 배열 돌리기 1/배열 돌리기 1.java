import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int arr[][];
	//static int temp[][];
	static int N, M;
	static int[] dx, dy;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		int re = Integer.parseInt(st.nextToken());

		arr = new int[N][M];
		//temp = new int[N][M];

		// 하,우,상,좌
		dx = new int[] { 1, 0, -1, 0 };
		dy = new int[] { 0, 1, 0, -1 };

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				//temp[i][j] = arr[i][j];
			}
		}

		for (int i = 0; i < re; i++) {

			for (int j = 0; j < Math.min(N,M) / 2; j++) {

	
				loop(j, j, j, j, 0,arr[j][j]);
				
			}
			
//			for(int i2=0;i2<arr.length;i2++) {
//				for(int j2=0;j2<arr[0].length;j2++) {
//					temp[i2][j2]=arr[i2][j2];
//				}
//			}

		}
		
		for(int i2=0;i2<arr.length;i2++) {
			for(int j2=0;j2<arr[0].length;j2++) {
				System.out.print(arr[i2][j2]+" ");
			}
			System.out.println();
		}

	}

	private static void loop(int x, int y, int endx, int endy, int direction,int temp) {

		int temp2 = 0;
		if (x == endx && y == endy + 1) {
			int gox = x + dx[direction];
			int goy = y + dy[direction];
			
			if (gox >= endx && goy >= endy && gox < N - endx && goy < M - endy ) {
			}else {
				direction = direction + 1;
				direction = direction % 4;
				loop(x, y, endx, endy, direction,temp);
				return;
			}
			arr[gox][goy] = temp;
			return;
		} else {

			int gox = x + dx[direction];
			int goy = y + dy[direction];

			if (gox >= endx && goy >= endy && gox < N - endx && goy < M - endy ) {

				//arr[gox][goy] = temp[x][y];
				temp2 = arr[gox][goy];
				arr[gox][goy] = temp;
  
				loop(gox, goy, endx, endy, direction,temp2);

			} else {
				direction = direction + 1;
				direction = direction % 4;
				loop(x, y, endx, endy, direction,temp);
			}
		}

	}

}