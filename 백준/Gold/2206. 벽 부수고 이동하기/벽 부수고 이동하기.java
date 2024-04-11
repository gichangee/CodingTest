import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[N][M];
		int[][][] v = new int[N][M][2];
		
		for(int i=0;i<N;i++) {
			String s =br.readLine();
			String[] split = s.split("");
			for(int j=0;j<M;j++) {
				arr[i][j]=Integer.parseInt(split[j]);
			}
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				v[i][j][0]= Integer.MAX_VALUE;
				v[i][j][1]= Integer.MAX_VALUE;
			}
		}
		
		
		
		bfs(arr,v);

	}

	private static void bfs(int[][] arr, int[][][] v) {

		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] {0,0,1,1});
		
		
		for(int i=1;i>=0;i--) {
			v[0][0][i]=1;
		}
		
		
		int[] dy = {-1,1,0,0};
		int[] dx = {0,0,-1,1};
		while(!q.isEmpty()) {
			int[] temp = q.poll();
			

			int min = Integer.MAX_VALUE;
			if(temp[0] == arr.length-1 && temp[1] == arr[0].length-1) {
				for(int i=0;i<2;i++) {
					if(min > v[temp[0]][temp[1]][i]) {
						min = v[temp[0]][temp[1]][i];
					}
				}
				
				System.out.println(min);
				return;
			}
			
			//벽을 부수기 가능
			if(temp[3]==1) {
				
				for(int i=0;i<4;i++) {
					int goY = temp[0]+dy[i];
					int goX = temp[1]+dx[i];
					if(goY >=0 && goX >=0 && goY <arr.length && goX <arr[0].length) {
						if(arr[goY][goX] == 1) {
							if(v[goY][goX][0] > temp[2]+1) {
								v[goY][goX][0] = temp[2]+1;
								q.add(new int[] {goY,goX,temp[2]+1,0});
							}
						}
						
					}
				}
				
				for(int i=0;i<4;i++) {
					int goY = temp[0]+dy[i];
					int goX = temp[1]+dx[i];
					if(goY >=0 && goX >=0 && goY <arr.length && goX <arr[0].length) {
						if(arr[goY][goX]==0) {
							if(v[goY][goX][1] > temp[2]+1) {
								v[goY][goX][1]= temp[2]+1;
								q.add(new int[] {goY,goX,temp[2]+1,1});
							}
						}
					}
				}
				
			}
			//벽 부시기 불가능
			else if(temp[3]==0) {
				for(int i=0;i<4;i++) {
					int goY = temp[0]+dy[i];
					int goX = temp[1]+dx[i];
					if(goY >=0 && goX >=0 && goY <arr.length && goX <arr[0].length) {
						if(arr[goY][goX]==0) {
							if(v[goY][goX][0] > temp[2]+1) {
								v[goY][goX][0]= temp[2]+1;
								q.add(new int[] {goY,goX,temp[2]+1,0});
							}
						}
					}
				}
			}
		
		}
		System.out.println(-1);
		
	}

}