import java.io.*;
import java.util.*;

public class Solution {

	static int N, W, H;
	static int min;
	static int dy[] = { -1, 1, 0, 0 };
	static int dx[] = { 0, 0, -1, 1 };
	static int[][] copy;
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= t; test_case++) {

			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());

			min = Integer.MAX_VALUE;

			int[][] arr = new int[H][W];
			copy = new int[H][W];

			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					copy[i][j]=arr[i][j];
				}
			}

			// 중복순열
			int[] temp = new int[N];

			permutation(arr, temp, 0);

			System.out.println("#" + test_case + " " + min);
		}
	}

	private static void permutation(int[][] arr, int[] temp, int depth) {

		if (temp.length == depth) {

			boolean[][] v = new boolean[arr.length][arr[0].length];
			
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					arr[i][j]=copy[i][j];
				}
			}
			

			for (int i = 0; i < temp.length; i++) {

				Queue<int[]> blockList = new ArrayDeque<>();
				Queue<int[]> q = new ArrayDeque<>();
				for (int j = 0; j < H; j++) {
					if (arr[j][temp[i]] > 0) {
						blockList.add(new int[] {j, temp[i],arr[j][temp[i]]});
						q.add(new int[] {j, temp[i]});
						v[j][temp[i]]=true;
						break;
					}
				}
				
				if(blockList.size()==0) {
					continue;
				}
				
				if (!blockList.isEmpty()) {
					boom(blockList, arr,v,q);
				}
				
				while(!q.isEmpty()) {
					int[] temp1 = q.poll();
					arr[temp1[0]][temp1[1]] = 0;
				}
				
				for (int k = 0; k < W; k++) {
					Queue<Integer> sort = new ArrayDeque<>();
					for (int j = H - 1; j >= 0; j--) {
						if (arr[j][k] != 0) {
							sort.offer(arr[j][k]);
							arr[j][k] = 0;
						}
					}
					for (int j = H - 1; !sort.isEmpty(); j--) {
						v[j][k]=false;
						arr[j][k] = sort.poll();
					}

				}


			}

			int count = 0;
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					if (arr[i][j] > 0) {
						count++;
					}
				}
			}

			if (min > count) {
				min = count;
			}

		} else {
			for (int i = 0; i < W; i++) {
				temp[depth] = i;
				permutation(arr, temp, depth + 1);
			}
		}
	}

	private static void boom(Queue<int[]> blockList, int[][] arr, boolean[][] v, Queue<int[]> q) {
		// 터질 블록이 있으면
				while (!blockList.isEmpty()) {
					int[] temp = blockList.poll();
					// 터질 블록 레벨만큼 4방의 블록을 큐에 넣음
					for (int i = 1; i < temp[2]; i++) {
						for (int j = 0; j < 4; j++) {
							int ny = temp[0] + dy[j] * i;
							int nx = temp[1] + dx[j] * i;
							if (ny >= 0 && nx >= 0 && nx < W && ny < H && arr[ny][nx] != 0) {
								if(!v[ny][nx]) {
									blockList.add(new int[] {ny,nx,arr[ny][nx]});
									q.add(new int[] {ny,nx,arr[ny][nx]});
									v[ny][nx] = true;
								}

							}
						}
					}
				}
			

	}

}