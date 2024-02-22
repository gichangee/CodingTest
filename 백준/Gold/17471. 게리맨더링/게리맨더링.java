import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int[] temp;
	static int N;
	static int min;
	static ArrayList<Integer> list[];
	static boolean[] v;
	static boolean left, right;
	static int[] human;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		String s = br.readLine();
		String[] split = s.split(" ");
		human = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			human[i] = Integer.parseInt(split[i - 1]);
		}

		list = new ArrayList[N + 1];

		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int r = Integer.parseInt(st.nextToken());
			for (int j = 0; j < r; j++) {
				int x = Integer.parseInt(st.nextToken());
				list[i].add(x);
				list[x].add(i);
			}

		}

		// 6일때
		// 조합 1개부터 5개 까지
		min = Integer.MAX_VALUE;
		for (int i = 1; i < N; i++) {
			temp = new int[i];
			combine(0, 0, i);
		}
		
		if(min ==Integer.MAX_VALUE ) {
			min=-1;
		}
		System.out.println(min);

	}

	private static void combine(int cnt, int start, int len) {

		if (cnt == len) {
			if (len > N / 2) {
				return;
			}
			v = new boolean[N + 1];
			for (int i = 0; i < len; i++) {
				v[temp[i]] = true;
			}

			int[] temp2 = new int[N - len];
			for (int i = 1, j = 0; i <= N; i++) {
				if (!v[i]) {
					temp2[j++] = i;
				}
			}
			
//			System.out.print(Arrays.toString(temp) + "   ");
//			System.out.println(Arrays.toString(temp2));

			left = false;
			right = false;
			// 왼쪽 배열이 알맞은 구역인지 확인
			if(temp.length ==1) {
				left = true;
			}
			
			if (temp.length != 1) {
				v = new boolean[N + 1];

				for (int i = 0; i < temp2.length; i++) {
					v[temp2[i]] = true;
				}
				dfs(temp[0], temp, temp2);
			}

			// 오른쪽 구역이 알맞은 구역인지 확인
			v = new boolean[N + 1];
			for (int i = 0; i < temp.length; i++) {
				v[temp[i]] = true;
			}
			//System.out.println(Arrays.toString(v));
			dfs2(temp2[0], temp2, temp);
			//System.out.println(left + " " + right);


			if (left) {
				if (right) {
//					System.out.print(Arrays.toString(temp) + "   ");
//					System.out.println(Arrays.toString(temp2));
					
					int sum=0;
					int sum2=0;
					for(int i=0;i<temp.length;i++) {
						sum+=human[temp[i]];
					}
					
					for(int i=0;i<temp2.length;i++) {
						sum2+=human[temp2[i]];
					}
					int result = Math.abs(sum-sum2);
					if(min > result) {
						min= result;
					}
				}
			}

			return;
		} else {
			for (int i = start; i < N; i++) {
				temp[cnt] = i + 1;
				combine(cnt + 1, i + 1, len);

			}
		}
	}

	private static void dfs(int cnt, int[] temp2, int[] temp22) {
		v[cnt] = true;
		int result = 0;
		for (int i = 1; i < v.length; i++) {
			if (v[i]) {
				result++;
			}
		}
		if (result == v.length - 1) {
			left =true;
		}
		for (int i = 0; i < list[cnt].size(); i++) {
			//System.out.println(list[cnt].get(i));
			if (!v[list[cnt].get(i)]) {
				v[list[cnt].get(i)] = true;
				dfs(list[cnt].get(i), temp2, temp22);
			}
		}

	}
	
	private static void dfs2(int cnt, int[] temp2, int[] temp22) {
		v[cnt] = true;
		int result = 0;
		for (int i = 1; i < v.length; i++) {
			if (v[i]) {
				result++;
			}
		}
		if (result == v.length - 1) {
			right=true;
		}
		for (int i = 0; i < list[cnt].size(); i++) {
			if (!v[list[cnt].get(i)]) {
				//System.out.println(list[cnt].get(i));
				v[list[cnt].get(i)] = true;
				dfs2(list[cnt].get(i), temp2, temp22);
			}
		}

	}

}