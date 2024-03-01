import java.util.*;
import java.io.*;

public class Main {

	static int[] dy= {-1,1,0,0};
	static int[] dx= {0,0,-1,1};
	
	static int y,x;
	
	static List<int[]> virus;
	
	static int[][] arr,copy;
	
	static int max;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		y = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		arr = new int[y][x];
		copy = new int[y][x];

		List<int[]> wall = new ArrayList<>();
		virus = new ArrayList<>();

		for (int i = 0; i < y; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < x; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				copy[i][j] = arr[i][j];
				if (arr[i][j] == 0) {
					wall.add(new int[] { i, j });
				}
				
				if(arr[i][j]==2) {
					virus.add(new int[] {i,j});
				}
			}
		}
		
		max = Integer.MIN_VALUE;
		
		int[] temp = new int[wall.size()];
		boolean[] v = new boolean[wall.size()];
		loop(wall,temp,arr,v,0);
		System.out.println(max);
	}

	private static void loop(List<int[]> wall, int[] temp, int[][] arr, boolean[] v, int cnt) {
		if(cnt==3) {
			for(int i=0;i<temp.length;i++) {
				if(temp[i]==1) {
					arr[wall.get(i)[0]][wall.get(i)[1]]=1;
				}
			}
			
			bfs();
			int count=0;
			for(int i=0;i<y;i++) {
				for(int j=0;j<x;j++) {
					if(arr[i][j]==0) {
						count++;
					}
				}
			}
			
			if(max < count) {
				max = count;
			}
			
			for(int i=0;i<y;i++) {
				for(int j=0;j<x;j++) {
					arr[i][j] = copy[i][j];
				}
			}
			
			return;
		}else {
			for(int i=0;i<temp.length;i++) {
				if(!v[i]) {
					v[i]=true;
					temp[i]=1;
					loop(wall, temp, arr, v, cnt+1);
					temp[i]=0;
					v[i]=false;
				}
				
			}
		}
		
	}

	private static void bfs() {

		Queue<int []> q = new ArrayDeque<int[]>();
		for(int i=0;i<virus.size();i++) {
			q.add(new int[] {virus.get(i)[0],virus.get(i)[1]});
		}
		
		while(!q.isEmpty()) {
			int[] temp = q.poll();
			for(int i=0;i<4;i++) {
				int goY = temp[0]+ dy[i];
				int goX = temp[1]+ dx[i];
				if(goY>=0 && goY<y && goX>=0 && goX<x && arr[goY][goX]==0) {
					arr[goY][goX]=2;
					q.add(new int[] {goY,goX});
				}
			}
		}
		
	}

}