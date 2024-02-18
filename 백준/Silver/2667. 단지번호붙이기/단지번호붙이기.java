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

	static char[][] arr;
	static boolean[][] v;
	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,-1,1};
	static int c;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		arr = new char[N][N];
		v= new boolean[N][N];
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i]=st.nextToken().toCharArray();
		}
		
		
		int count=0;
		List<Integer> list = new ArrayList<>();
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(arr[i][j]!='0' && !v[i][j]) {
					c=1;
					loop(i,j,0);
					count++;
					list.add(c);
				}
			}
		}
		
		System.out.println(count);

		int[] k = new int[list.size()];
		for(int i=0;i<list.size();i++) {
			k[i]=list.get(i);
		}
		Arrays.sort(k);
		for(int i=0;i<list.size();i++) {
			System.out.println(k[i]);
		}
	
	}

	private static void loop(int y, int x, int cnt) {
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] {y,x,cnt});
		v[y][x]=true;
		while(!q.isEmpty()) {
			int[] temp = q.poll();
			for(int i=0;i<4;i++) {
				int goY = temp[0]+dy[i];
				int goX = temp[1]+dx[i];
				
				if(goX >=0 && goX < arr.length && goY >=0 && goY < arr.length && arr[goY][goX] !='0' && !v[goY][goX]) {
					v[goY][goX]=true;
					c++;
					q.add(new int[] {goY,goX,cnt+1});
				}
				
			}
		}

	}
}