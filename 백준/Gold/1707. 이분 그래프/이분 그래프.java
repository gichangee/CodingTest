import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	static ArrayList<Integer>[] list;
	static boolean[] v;
	static boolean iseven;
	static int[] count;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			list = new ArrayList[N + 1];
			v = new boolean[N + 1];
			count = new int[N+1];
			for (int j = 1; j <= N; j++) {
				list[j] = new ArrayList<>();
			}

			for (int j = 0; j < R; j++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				list[a].add(b);
				list[b].add(a);
			}
			iseven = true;
			for (int j = 1; j <= N; j++) {
				if (iseven) {
					dfs(j);
				} else {
					break;
				}
			}
			
			if(iseven) {
				System.out.println("YES");
			}else {
				System.out.println("NO");
			}

		}

	}

	private static void dfs(int j) {
		v[j]=true;
		for(int i : list[j]) {
			if(!v[i]) {
				count[i]= (count[j]+1)%2;
				dfs(i);
			}else {
				if(count[i]==count[j]) {
					iseven=false;
					break;
				}
			}
		}

	}

}