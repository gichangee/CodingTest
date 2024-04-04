import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {

			int N = Integer.parseInt(br.readLine());
			int[][] arr= new int[N][N];
			
			for(int i=0;i<N;i++) {
				String s = br.readLine();
				String[] split = s.split("");
				for(int j=0;j<N;j++) {
					arr[i][j] = Integer.parseInt(split[j]);
				}
			}
			
			
			
			System.out.println("#" + tc + " "+bfs(arr));

		}
	}

	private static int bfs(int[][] arr) {

		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] {0,0});
		
		int[][] memo = new int[arr.length][arr.length];
		
		for(int i=0;i<arr.length;i++) {
			Arrays.fill(memo[i], Integer.MAX_VALUE);
		}
		memo[0][0]=0;
		
		int[] dy = {-1,1,0,0};
		int[] dx = {0,0,-1,1};
		
		while(!q.isEmpty()) {
			int[] temp = q.poll();
			
			for(int i=0;i<4;i++) {
				int goY = temp[0]+dy[i];
				int goX = temp[1]+dx[i];
				
				if(goY>=0 && goX >=0 && goY < arr.length && goX< arr.length) {
					int min = memo[temp[0]][temp[1]]+ arr[goY][goX];
					if(min < memo[goY][goX]) {
						memo[goY][goX] = min;
						q.add(new int[] {goY,goX});
					}
					
				}
			}
			
			
		}
		return memo[arr.length-1][arr.length-1];
		
		
		
	}

}