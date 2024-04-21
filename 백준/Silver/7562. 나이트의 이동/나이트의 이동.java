import java.io.*;
import java.util.*;


public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for(int T=1;T<=tc;T++) {
			int size = Integer.parseInt(br.readLine());
			
			int[][] arr = new int[size][size];
			StringTokenizer st = new StringTokenizer(br.readLine());
			int starty = Integer.parseInt(st.nextToken());
			int startx = Integer.parseInt(st.nextToken());


			st = new StringTokenizer(br.readLine());
			int endy = Integer.parseInt(st.nextToken());
			int endx = Integer.parseInt(st.nextToken());
			
		
			
			bfs(arr,starty,startx,endy,endx);
			
			
		}
	}

	private static void bfs(int[][] arr, int starty, int startx, int endy, int endx) {

		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] {starty,startx,0});
		
		boolean[][] v = new boolean[arr.length][arr.length];
		
		v[starty][startx] = true;
		int[] dy = {-1,-2,-2,-1,1,2,2,1};
		int[] dx = {-2,-1,1,2,2,1,-1,-2};
		
		while(!q.isEmpty()) {
			int[] temp = q.poll();
			
			if(temp[0] == endy && temp[1]== endx) {
				System.out.println(temp[2]);
				return;
			}
			
			for(int i=0;i<8;i++) {
				int goY = dy[i]+temp[0];
				int goX = dx[i]+temp[1];
				if(goY >=0 && goX >=0 && goY <arr.length && goX <arr.length) {
					if(!v[goY][goX]) {
						v[goY][goX]= true;
						q.add(new int[] {goY,goX,temp[2]+1});
					}
				}
			}
		}
	}

}