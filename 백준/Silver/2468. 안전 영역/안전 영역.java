import java.util.*;
import java.io.*;

public class Main {
	
	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,-1,1};
	static int area;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] arr = new int[N][N];
		
		int max = Integer.MIN_VALUE;
		
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(max < arr[i][j]) {
					max=arr[i][j];
				}
			}
		}
		
		area = 1;
		for(int i=0;i<max;i++) {
			boolean[][] v = new boolean[N][N];
			loop(arr,i,N,v);
			loop2(arr,v,N);
		}
		
		
		System.out.println(area);
		
		
		
		
	}

	//물에 잠기기
	private static void loop(int[][] arr, int water, int N, boolean[][] v) {

		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(water>=arr[i][j]) {
					v[i][j]=true;
					arr[i][j]=0;
				}
			}
		}
	}

	private static void loop2(int[][] arr, boolean[][] v, int N) {

		int count=0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(!v[i][j] && arr[i][j]>0) {
					dfs(arr,v,i,j);
					count++;
				}
				
			}
		}
		
		if(count > area) {
			area=count;
		}
	}

	private static void dfs(int[][] arr, boolean[][] v, int y, int x) {
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] {y,x});
		while(!q.isEmpty()) {
			int[] temp = q.poll();
			for(int i=0;i<4;i++) {
				int goY= dy[i]+temp[0];
				int goX=dx[i]+temp[1];
				if(goY >=0 && goY<arr.length && goX>=0 && goX <arr.length ) {
					if(!v[goY][goX]) {
						v[goY][goX]=true;
						q.add(new int[] {goY,goX});
					}
					
				}
			}
		}
	}


}