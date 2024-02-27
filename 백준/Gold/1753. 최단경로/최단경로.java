import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static class Node {
		int from;
		int to;
		int weight;

		public Node(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());

		int start = Integer.parseInt(br.readLine());

		List<Node>[] list = new ArrayList[V + 1];

		for (int i = 1; i <= V; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			list[from].add(new Node(from, to, weight));
		}

		boolean[] v = new boolean[V + 1];
		int[] minedge = new int[V + 1];

		int INF = Integer.MAX_VALUE;

		for (int i = 0; i < minedge.length; i++) {
			minedge[i] = INF;
		}

		minedge[start] = 0;
		int min = 0;
		int stopOver = 0;

		for (int i = 1; i <=V; i++) {
			min = INF;
			stopOver = -1;
			for (int j = 1; j <= V; j++) {
				if (!v[j] && min > minedge[j]) {
					min = minedge[j];
					stopOver = j;
				}
			}

			if (stopOver == -1)
				break;
			v[stopOver] = true;

			for (int j = 0; j < list[stopOver].size(); j++) {
				if (!v[list[stopOver].get(j).to]
						&& minedge[list[stopOver].get(j).to] > min + list[stopOver].get(j).weight) {
					minedge[list[stopOver].get(j).to] = min + list[stopOver].get(j).weight;
				}
			}
		}

		for (int i = 1; i < minedge.length; i++) {
			if(minedge[i]== INF) {
				System.out.println("INF");
			}else {
				System.out.println(minedge[i]);
			}
			
		}
	}

}