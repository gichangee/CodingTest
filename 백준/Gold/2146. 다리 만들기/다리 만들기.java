import java.io.*;
import java.util.*;

public class Main {

	static int min;
	static boolean[][] landv;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[][] arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int firsty = 0;
		int firstx = 0;
		
		landv = new boolean[N][N];
		min = Integer.MAX_VALUE;
		// 땅 찾기
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (arr[i][j] == 1) {
					if(!landv[i][j]) {
						firsty = i;
						firstx = j;
						
						List<int[]> list = new ArrayList<>();
						boolean[][] v = new boolean[arr.length][arr.length];
						//테두리 list에 넣기
						bfs(arr, firsty, firstx, list, v);
					 	
//						for(int z = 0 ; z<list.size();z++) {
//							System.out.println(list.get(z)[0]+" "+list.get(z)[1]);
//						}
						
						// 테두리에 있는 것들 루프 돌려서 가장 작은 길이 찾기
						
						bfs2(arr, list, v);
						break;
					}
				
				}
			}

		

		}

		System.out.println(min);

	}

	private static void bfs2(int[][] arr, List<int[]> list, boolean[][] v) {
		Queue<int[]> q = new ArrayDeque<>();
		for (int i = 0; i < list.size(); i++) {
			q.add(new int[] { list.get(i)[0], list.get(i)[1], 0 });
		}
		
		int[][] memo = new int[arr.length][arr.length];
		//모두 정수최댓값으로 설정
		for(int a=0;a<arr.length;a++) {
			Arrays.fill(memo[a], Integer.MAX_VALUE);
		}
		
		int[] dy = { -1, 1, 0, 0 };
		int[] dx = { 0, 0, -1, 1 };
		while (!q.isEmpty()) {
			int[] temp = q.poll();
			if (min <= temp[2]) {
				continue;
			}
			for (int i = 0; i < 4; i++) {
				int goY = temp[0] + dy[i];
				int goX = temp[1] + dx[i];
				if (goY >= 0 && goX >= 0 && goY < arr.length && goX < arr.length) {
					if (arr[goY][goX] == 1) {
						if (!v[goY][goX]) {
							if (min > temp[2]) {
								min = temp[2];
							}
						} else {
							continue;
						}
					} else {
						if(memo[goY][goX] > temp[2]+1) {
							memo[goY][goX]=temp[2]+1;
							q.add(new int[] { goY, goX, temp[2] + 1 });
						}
						
					}
				}
			}

		}
	}

	private static void bfs(int[][] arr, int firsty, int firstx, List<int[]> list, boolean[][] v) {

		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] { firsty, firstx });

		int[] dy = { -1, 1, 0, 0 };
		int[] dx = { 0, 0, -1, 1 };

		landv[firsty][firstx]=true;
		v[firsty][firstx] = true;
		while (!q.isEmpty()) {
			int[] temp = q.poll();

			for (int i = 0; i < 4; i++) {
				int goY = temp[0] + dy[i];
				int goX = temp[1] + dx[i];
				if (goY >= 0 && goX >= 0 && goY < arr.length && goX < arr.length) {
					if (arr[goY][goX] == 0) {
						list.add(new int[] { temp[0], temp[1] });
						break;
					}
				}
			}

			for (int i = 0; i < 4; i++) {
				int goY = temp[0] + dy[i];
				int goX = temp[1] + dx[i];
				if (goY >= 0 && goX >= 0 && goY < arr.length && goX < arr.length) {
					if (!v[goY][goX]) {
						if (arr[goY][goX] == 1) {
							v[goY][goX] = true;
							landv[goY][goX]=true;
							q.add(new int[] { goY, goX });
						}

					}
				}
			}

		}
	}
}