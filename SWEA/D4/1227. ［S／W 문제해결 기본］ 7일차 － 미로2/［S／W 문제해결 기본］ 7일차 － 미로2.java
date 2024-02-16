import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {

	static char[][] arr;

	static int[] dx = {-1,1,0,0};
	static int[] dy= {0,0,-1,1};
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 10; i++) {

			int num = Integer.parseInt(br.readLine());

			arr = new char[100][100];

			for (int j = 0; j < 100; j++) {
				arr[j] = br.readLine().toCharArray();
			}

			boolean result = loop(1, 1);

			if(result) {
				System.out.println("#" + num + " "+1);
			}else {
				System.out.println("#" + num + " "+0);
			}
			
		}
	}

	private static boolean loop(int x, int y) {

		
		
		Queue<int[]> q = new ArrayDeque<>();
		
		q.add(new int[] {x,y});
		arr[x][y] = '4';
		
		while(!q.isEmpty()) {
			int[] temp = q.poll();
			
			for(int i=0;i<4;i++) {
				int goX = temp[0]+dx[i];
				int goY = temp[1]+dy[i];
				if(goX >= 0 && goY >=0  && goX <100 && goY < 100 && arr[goX][goY] != '1' && arr[goX][goY] != '4') {
					if(arr[goX][goY] == '3') {
						return true;
					}
					arr[goX][goY] ='4';
					q.add(new int[] {goX,goY});
				}
			}
		}
		
		return false;
	}

}