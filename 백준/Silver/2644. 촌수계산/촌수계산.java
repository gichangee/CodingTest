import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @author 박기창
 * bfs 사용하기
 */
public class Main {

	static int[][] arr;
	static boolean[] v;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());

		int first = Integer.parseInt(st.nextToken());
		int second = Integer.parseInt(st.nextToken());

		int R = Integer.parseInt(br.readLine());

		arr = new int[N+1][N+1];
		v = new boolean[N+1];
		
		
		//인접행렬 사용하기
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			arr[x][y] = 1;
			arr[y][x] = 1;
		}
		

		//만약 트루값으로 나오면 카운값 출력 없으면 -1 출력
		boolean a = loop(first, second);
		if(a) {
		}else {
			System.out.println(-1);
		}
	}

	private static boolean loop(int first, int second) {
		
		//큐 사용
		Queue<int []> q = new ArrayDeque<>();
		q.add(new int[] {first,0});
		//방문 체크하기
		v[first]=true;
		
		//큐가 빌때까지 돌기
		while(!q.isEmpty()) {
			int[] temp = q.poll();
			if(temp[0] == second) {
				System.out.println(temp[1]);
				return true;
			}
			for(int i =1;i<arr.length;i++) {
				if(arr[temp[0]][i] !=0 && !v[i]) {
					q.add(new int[] {i,temp[1]+1});
					v[i]=true;
				}
			}
		}
		
		return false;
		
	}

}