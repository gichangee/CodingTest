import java.io.*;
import java.util.*;

public class Main {
	
	
	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,-1,1};
	
	static int[] hy = {-1,-2,-2,-1,1,2,2,1};
	static int[] hx = {-2,-1,1,2,2,1,-1,-2};
	
	static int[][] arr;
	static int[][][] v;
	
	static int H,W,K;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		K= Integer.parseInt(br.readLine());
		StringTokenizer st =new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		arr = new int[H][W];
		v = new int[H][W][K+1];
		
		for(int i=0;i<H;i++) {
			st =new StringTokenizer(br.readLine());
			for(int j=0;j<W;j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}

		
		for(int i=0;i<H;i++) {
			for(int j=0;j<W;j++) {
				for(int z = 0; z<=K;z++) {
					v[i][j][z] = Integer.MAX_VALUE;
				}
			}
		}
		
		dfs();


		
		
	}

	private static void dfs() {

		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] {0,0,K,0});
		for(int i=K;i>=0;i--) {
			v[0][0][i]=0;
		}
		
		while(!q.isEmpty()) {
			int[] temp = q.poll();
			
			if(temp[0] == H-1 && temp[1] == W-1) {
				int min = Integer.MAX_VALUE;
				for(int i=K;i>=0;i--) {
					if(min > v[H-1][W-1][i]) {
						min =  v[H-1][W-1][i];
					}
				}
				System.out.println(min);
				return;
			}
			
			int count = temp[2];
			//아직 말처럼 움직일 수 있을 때
			if(count >0) {
				for(int i=0;i<8;i++) {
					int goY = hy[i]+temp[0];
					int goX = hx[i]+temp[1];
					if(goY >=0 && goY <arr.length && goX >=0 && goX < arr[0].length) {
						if(arr[goY][goX] == 0 ) {
							if(temp[3]+1 < v[goY][goX][count-1]) {
								v[goY][goX][count-1] = temp[3]+1;
								q.add(new int[] {goY,goX,count-1,temp[3]+1});
							}
						}
					}
				}
				
				for(int i=0;i<4;i++) {
					int goY = dy[i]+temp[0];
					int goX = dx[i]+temp[1];
					if(goY >=0 && goY <arr.length && goX >=0 && goX < arr[0].length) {
						if(arr[goY][goX] == 0 ) {
							if(temp[3]+1 < v[goY][goX][count]) {
								v[goY][goX][count] = temp[3]+1;
								q.add(new int[] {goY,goX,count,temp[3]+1});
							}
						}
					}
				}
			}
			//말처럼 움직일 수 없을 때
			if(count ==0) {
				for(int i=0;i<4;i++) {
					int goY = dy[i]+temp[0];
					int goX = dx[i]+temp[1];
					if(goY >=0 && goY <arr.length && goX >=0 && goX < arr[0].length) {
						if(arr[goY][goX] == 0 ) {
							if(temp[3]+1 < v[goY][goX][0]) {
								v[goY][goX][0] = temp[3]+1;
								q.add(new int[] {goY,goX,0,temp[3]+1});
							}
						}
					}
				}
			}
		}
		
		System.out.println(-1);
	}
}