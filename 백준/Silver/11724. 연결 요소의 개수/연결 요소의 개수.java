import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;



public class Main {

	
	static boolean[] v;
	static int count;
	static ArrayList<Integer>[] list;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[n+1];
		
		for(int i=1;i<=n;i++) {
			list[i] = new ArrayList<>();
		}
		
		v = new boolean[n+1];
		
		
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			list[x].add(y);
			list[y].add(x);
		}
		
		count=0;
		
		for(int i=1;i<=n;i++) {
			if(!v[i]) {
				count++;
				loop(i);
			}
		}
		
		System.out.println(count);
	}
	private static void loop(int index) {
		
		if(v[index]) {
			return;
		}else {
			v[index]=true;
			for(int i=0;i<list[index].size();i++) {
				if(!v[list[index].get(i)]) {
					
					loop(list[index].get(i));
				}
			}
		}
		
		
	}
}