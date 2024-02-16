import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	
	static int count;
	static int[][] arr;
	//상하좌우
	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,-1,1};
	static Queue<int[]> q;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		
		arr= new int[y][x];
		q = new ArrayDeque<>();
		
		for(int i=0;i<y;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<x;j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
				if(arr[i][j]==1) {
					q.add(new int[] {i,j,0});
				}
			}
		}
		
		count=0;
		loop();
		boolean result = true;
		Label: for(int i=0;i<y;i++) {
			for(int j=0;j<x;j++) {
				if(arr[i][j]==0) {
					result =false;
					break Label;
				}
			}
		}
		if(result) {
			System.out.println(count);
		}else {
			System.out.println(-1);
		}
		
		
		
	}

	private static void loop() {
		while(!q.isEmpty()) {
			int[] temp = q.poll();
			count = temp[2];
			for(int i=0;i<4;i++) {
				int y = temp[0] + dy[i];
				int x = temp[1] + dx[i];
				
				if(y>=0 && x >=0 && y < arr.length && x < arr[0].length && arr[y][x] == 0) {
					arr[y][x]=1;
					q.add(new int[] {y,x,temp[2]+1});
				}
			}
			
		}
		
		
		
	}

}