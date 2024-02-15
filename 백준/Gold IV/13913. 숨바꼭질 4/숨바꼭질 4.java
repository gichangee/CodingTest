import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static class Node{
		int cnt;
		int value;
		List<Integer> list = new ArrayList<>();
		public Node(int cnt, int value, List list) {
			this.cnt = cnt;
			this.value =value;
			this.list = list;
		}
		
	}
	static int location1,location2;
	static int[] v= new int[] {1,-1,2};
	static Queue<Node> q = new ArrayDeque<>();
	static int cnt;
	static boolean[] visited;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		location1 = sc.nextInt();
		location2 = sc.nextInt();
		cnt = 0;
		visited = new boolean[100001];
		bfs();
	}
	private static void bfs() {

		List<Integer> li = new ArrayList<>();
		li.add(location1);
		q.add(new Node(0,location1,li));
		
		StringBuilder sb = new StringBuilder();
		
		//동생이 더 앞에 있다면 마이너스만 해주면 됨
		if(location2 < location1) {
			sb.append(location1-location2+"\n");
			
			for(int i=0;i<=location1-location2;i++) {
				sb.append(location1-i+" ");
			}
			System.out.println(sb);
			return;
		}
		
		//동생이 뒤에 있다면
		while(!q.isEmpty()) {
			Node n = q.poll();
			
			if(n.value == location2) {
				
				sb.append(n.cnt).append("\n");
				for(int i=0;i<n.list.size();i++) {
					sb.append(n.list.get(i)+" ");
				}

				System.out.println(sb);
				break;
			}
			
			if(n.value < 0 || n.value >100000) {
				continue;
			}
			
			if(visited[n.value]) {
				continue;
			}
			
			visited[n.value] = true;
			
			for(int i=0;i<3;i++) {
				if(i==2) {
					ArrayList<Integer> newlist = new ArrayList<Integer>(n.list);
					int x=n.value*v[i];
					newlist.add(x);
					q.add(new Node(n.cnt+1, x,newlist));
					continue;
				}
				ArrayList<Integer> newlist = new ArrayList<Integer>(n.list);
				int x=n.value+v[i];
				newlist.add(x);
				q.add(new Node(n.cnt+1, x,newlist));

			}
			
		}
	}

	

}