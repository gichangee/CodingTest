import java.io.*;
import java.util.*;

public class Solution {

	static int D, W, K, r,no;
	static int[][] arr, copy;
	static boolean[] v;
	static List<Integer> list;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			
			
			// 0 == A
			// 1 == B
			arr = new int[D][W];
			copy = new int[D][W];
			for (int i = 0; i < D; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					copy[i][j] = arr[i][j];
				}
			}
			
			if(K==1) {
				System.out.println("#" + test_case + " " + 0);
				continue;
			}

			// 어떤 세로줄이 패스하지 못했는지 알려주는 배열
			v = new boolean[W];

			// 합격했는지 안했는지 확인해주는 반복문
			for (int i = 0; i < W; i++) {
				int count = 1;
				int same = arr[0][i];

				for (int j = 1; j < D; j++) {
					if (same == arr[j][i]) {
						count++;
					}

					if (count == K) {
						v[i] = true;
						break;
					}

					if (same != arr[j][i]) {
						same = arr[j][i];
						count = 1;
					}
				}
			}

			// 약품을 투여해야하는지 안해야하는지 확인
			boolean result = false;
			for (int i = 0; i < v.length; i++) {
				if (!v[i]) {
					result = true;
				}
			}

			// 투여해야한다면
			if (result) {
				// 어떤 가로줄에 약을 투여할지 저장할 배열들
				int[] temp = new int[D];
				boolean[] visited = new boolean[D];
				r = Integer.MAX_VALUE;
				no = Integer.MIN_VALUE;
				// 순열사용하기
				list = new ArrayList<>();
				loop(temp, 0, visited);
				System.out.println("#" + test_case + " " + r);
				// 투여안해도 된다면
			} else {
				System.out.println("#" + test_case + " " + 0);
			}

		}
	}

	// 순열
	private static void loop(int[] temp, int depth, boolean[] visited) {

		if (depth == temp.length) {

			
			int c = 0;
			int non = 0;
			for (int i = 0; i < temp.length; i++) {

				if (temp[i] == 0) {
					c++;
				} else if (temp[i] == 1) {
					c++;
				}else if(temp[i]==-1) {
					non++;
				}
				if (c >= r) {
					return;
				}
			}
			
			for(int i=0;i<list.size();i++) {
				for (int j = 0; j < W; j++) {
					arr[list.get(i)][j]=copy[list.get(i)][j];
				}
			}
			

			list = new ArrayList<>(); 
			for (int i = 0; i < temp.length; i++) {
				if (temp[i] == 0) {
					change(i, 0);
				} else if (temp[i] == 1) {
					change( i, 1);
				}
			}

			// 확인하는 반복문
			boolean[] test = new boolean[W];

			boolean a = true;
			for (int i = 0; i < W; i++) {
				int count = 1;
				int same = arr[0][i];

				for (int j = 1; j < D; j++) {
					if (same == arr[j][i]) {
						count++;
					}

					if (count == K) {
						test[i] = true;
						break;
					}

					if (same != arr[j][i]) {
						same = arr[j][i];
						count = 1;
					}
				}

				if (!test[i]) {
					a = false;
					return;
				}
			}

			if (a) {
				// 최솟값 넣기
				if (r > c ) {
					no=non;
					r = c;
				}
			}

		} else {
			// -1은 안넣기
			// 0 은 a
			// 1 은 b
			for (int i = -1; i < 2; i++) {
				if (!visited[depth]) {
					visited[depth] = true;
					temp[depth] = i;
					loop(temp, depth + 1, visited);
					visited[depth] = false;
				}
			}
		}
	}

	// v2에는 어떤 세로줄이 합격 못했는지가 담겨있다
	// 해당 세로줄에 index번째 가로줄을 바꾸면 됨
	private static void change(int index, int j) {
		for (int i = 0; i < W; i++) {
			arr[index][i] = j;
		}
		list.add(index);
			
	}

}