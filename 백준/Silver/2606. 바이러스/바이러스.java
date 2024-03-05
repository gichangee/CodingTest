import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int R = Integer.parseInt(br.readLine());

		List<Integer>[] list = new ArrayList[N + 1];

		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < R; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a= Integer.parseInt(st.nextToken());
			int b= Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}
		
		boolean[] v = new boolean[N+1];
		dfs(list, v,1);
		
		int sum=0;
		for(int i=1;i<=N;i++) {
			if(v[i]) {
				sum++;
			}
		}
		
		System.out.println(sum-1);
	}

	private static void dfs(List<Integer>[] list, boolean[] v, int start) {

		v[start]= true;
		for(int i=0;i<list[start].size();i++) {
			if(!v[list[start].get(i)])
			{
				v[list[start].get(i)]=true;
				dfs(list, v, list[start].get(i));
			}
			
		}
	}

}