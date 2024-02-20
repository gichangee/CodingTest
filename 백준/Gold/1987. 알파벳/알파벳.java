import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,-1,1};
	static int max;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int y = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());

		char[][] arr = new char[y][x];

		for (int i = 0; i < y; i++) {

			arr[i] = br.readLine().toCharArray();

		}
		
		int count=1;
		
		boolean[] v = new boolean[26];
		
		max = Integer.MIN_VALUE;
		loop(v,arr,0,0,count);
		
		System.out.println(max);
		
		
	}

	private static void loop(boolean[] v, char[][] arr, int y, int x, int cnt) {
		v[arr[y][x]-'A']=true;
		for(int i=0;i<4;i++) {
			int goY = dy[i]+y;
			int goX = dx[i]+x;
			if(goY >=0 && goX >=0 && goX<arr[0].length && goY<arr.length && !v[arr[goY][goX]-'A']) {
				v[arr[goY][goX]-'A']=true;
				loop(v, arr, goY, goX, cnt+1);
				v[arr[goY][goX]-'A']=false;
			}
		}
		
		if(cnt >= max) {
			max= cnt;
		}
	
	}

}