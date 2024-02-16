import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	
	static int[] dx = { -1, 1, 0, 0, -1, -1, 1, 1 };
	static int[] dy = { 0, 0, -1, 1, -1, 1, 1, -1 };
	static int[][] arr;
	static boolean[][] v;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			if (x == 0 && y == 0) {
				break;
			}

			arr = new int[y][x];
			v = new boolean[y][x];

			for (int i = 0; i < y; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < x; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int count=0;
			for(int i=0;i<y;i++) {
				for(int j=0;j<x;j++) {
					if(arr[i][j]==1 && !v[i][j]) {
						loop(i, j);
						count++;
					}
				}
			}

			System.out.println(count);
			
			
		}

	}

	private static void loop(int x, int y) {
		// TODO Auto-generated method stub
		Queue<int[]> q = new ArrayDeque<>();
		
		q.offer(new int[] {x,y});
		v[x][y]=true;
		while(!q.isEmpty()) {
			
			int[] temp = q.poll();
			for (int k = 0; k < 8; k++) {
				int goX = temp[0] + dx[k];
				int goY = temp[1] + dy[k];
				if (goX >= 0 && goY >= 0 && goX < arr.length && goY < arr[0].length && !v[goX][goY] && arr[goX][goY]==1 ) {
					v[goX][goY]=true;
					q.add(new int[] {goX,goY});
				}
			}
		}
	}

}