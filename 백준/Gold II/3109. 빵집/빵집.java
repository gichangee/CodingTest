import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[] dx;
	static int[] dy;
	static int R, C;
	static char[][] map;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];

		for(int i=0;i<R;i++) {
			map[i]=br.readLine().toCharArray();
			
		}

		dx = new int[]{-1,0,1};
		dy = new int[]{1,1,1};
		
		int count =0;
		for(int i=0;i<R;i++) {
			boolean result = loop(i,0);
			if(result) {
				count++;
			}
		}
		
		System.out.println(count);
		
		
		
		
	}

	private static boolean loop(int r, int c) {

		if (C-1 == c) {
			return true;
		}

		else {
			for (int i = 0; i < 3; i++) {
				int x = r + dx[i];
				int y = c + dy[i];

				if (x >= 0 && y >= 0 && x < R && y < C && map[x][y] == '.') {
					map[x][y] = 'X';
					boolean result = loop(x, y);
					if (result) {
						return true;
					}
				}

			}
		}

		return false;

	}

}