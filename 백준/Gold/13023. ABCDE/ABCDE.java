import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	
	public static class Node{
		ArrayList<Integer> list;
		
		Node(){
			this.list = new ArrayList<>();
		}
	}
	
	public static int N,M;
	public static Node[] map;
	public static ArrayList<Integer> maplist = new ArrayList<>();
	public static boolean[] bmap;
	public static boolean isout = false;
	public static void dfs(int depth,int vertex) {
		if(isout)
			return;
		
		if(depth>=5) {
			isout = true;
			return;
		}
		
		for(int i=0;i<map[vertex].list.size();i++) {
			if(bmap[map[vertex].list.get(i)])
				continue;
			bmap[map[vertex].list.get(i)] = true;
			dfs(depth+1,map[vertex].list.get(i));
			bmap[map[vertex].list.get(i)] = false;
		}
		
	}
	
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String str = br.readLine();
		StringTokenizer stz = new StringTokenizer(str);
		
		N = Integer.parseInt(stz.nextToken());
		M = Integer.parseInt(stz.nextToken());
		map = new Node[N];
		bmap = new boolean[N];
		
		for(int i=0;i<N;i++) {
			map[i] = new Node();
		}
		
		for(int i=0;i<M;i++) {
			str = br.readLine();
			stz = new StringTokenizer(str);
			int a = Integer.parseInt(stz.nextToken());
			int b = Integer.parseInt(stz.nextToken());
			map[a].list.add(b);
			map[b].list.add(a);
		}
		for(int i=0;i<N;i++) {
			bmap[i] = true;
			dfs(1,i);
			bmap[i] = false;
			if(isout) {
				break;
			}
		}
		
		if(isout)
			sb.append("1\n");
		else 
			sb.append("0\n");
		
		System.out.print(sb);
	}

}
