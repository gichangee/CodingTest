import java.util.*;
import java.io.*;

public class Solution {

	static int[][] arr;
	static int starty, startx, endy, endx, count, N;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			StringTokenizer st = new StringTokenizer(br.readLine());

			starty = Integer.parseInt(st.nextToken());
			startx = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());

			endy = Integer.parseInt(st.nextToken());
			endx = Integer.parseInt(st.nextToken());

			
			count=-1;
			
			dfs();

			System.out.println("#" + test_case + " "+count);

		}
	}

	private static void dfs() {

		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] {starty,startx,0});
		
		boolean[][] v = new boolean[N][N];
		
		v[starty][startx] = true;
		int[] dy = {-1,1,0,0};
		int[] dx = {0,0,-1,1};
		
		Label: while(!q.isEmpty()) {
			int[] temp = q.poll();
			
			
			
			
			for(int i=0;i<4;i++) {
				int goY = dy[i] + temp[0];
				int goX = dx[i] + temp[1];
				int h = temp[2];
				
				if(goY == endy && goX==endx) {
					count = h+1;
					break Label;
				}
				
				if(goY>=0 && goY < N && goX >=0 && goX <N) {
					if(!v[goY][goX]) {
						//그냥 바다에 있을 때
						if(arr[temp[0]][temp[1]]==0) {
							//그냥 바다에 있을 때 그냥 바다로 갈 때
							if(arr[goY][goX]==0) {
								v[goY][goX]=true;
								q.add(new int[] {goY,goX,h+1});
							
							//그냥 바다에 있을 때 소용돌이로 갈 때	
							}else {
								if((h+1)%3 !=0) {
									q.add(new int[] {temp[0],temp[1],h+1});
								}else {
									v[goY][goX]=true;
									q.add(new int[] {goY,goX,h+1});
								}
							}
						//소용돌이 위에 있을 때
						}else if(arr[temp[0]][temp[1]]==2){
							
							
							if(arr[goY][goX]==0) {
								v[goY][goX]=true;
								q.add(new int[] {goY,goX,h+1});

							}else {
								if((h+1)%3 !=0) {
									q.add(new int[] {temp[0],temp[1],h+1});
								}else {
									v[goY][goX]=true;
									q.add(new int[] {goY,goX,h+1});
								}
							}
							

							
						}
					
						
					}
				}
			}
			
		}
	}

}