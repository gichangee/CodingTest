import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int count=1;
		while(true) {
			int N = Integer.parseInt(br.readLine());
			if(N == 0) {
				break;
			}else {
				int[][] arr = new int[N][N];
				for(int i=0;i<N;i++) {
					StringTokenizer st = new StringTokenizer(br.readLine());
					for(int j=0;j<N;j++) {
						arr[i][j]=Integer.parseInt(st.nextToken());
					}
				}
				
				
				
				
				System.out.println("Problem "+count+": "+bfs(arr,0,0));
				count++;
				
			}
		}
	}

	private static int bfs(int[][] arr, int i, int j) {
		Queue<int[]> q = new ArrayDeque<>();
		int[][] memo = new int[arr.length][arr.length];
		for(int a=0;a<arr.length;a++) {
			Arrays.fill(memo[a], Integer.MAX_VALUE);
		}
		
		
		q.add(new int[] {i,j,arr[i][j]});
		memo[0][0] = arr[i][j];
		int[] dy = {-1,1,0,0};
		int[] dx = {0,0,-1,1};
		
		while(!q.isEmpty()) {
			int[] temp = q.poll();
			
//			if(temp[0] == arr.length-1 && temp[1] == arr.length-1) {
//				return memo[temp[0]][temp[1]];
//			}
			
			for(int a=0;a<4;a++) {
				int goY = dy[a]+temp[0];
				int goX = dx[a]+temp[1];
				
				if(goY>=0 && goY < arr.length && goX >=0 && goX< arr.length) {
					int size = arr[goY][goX];
					if(memo[goY][goX]> size+temp[2]) {
						memo[goY][goX]=size+temp[2];
						q.add(new int[] {goY,goX,memo[goY][goX]});
					}
				}
			}
		}
		return memo[arr.length - 1][arr.length - 1];
		
	}

}