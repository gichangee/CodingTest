import java.util.*;
import java.io.*;

public class Main {

	static class Edge {
		int from;
		int to;
		int weigth;

		public Edge(int from, int to, int weigth) {
			this.from = from;
			this.to = to;
			this.weigth = weigth;
		}

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());

		int start = Integer.parseInt(br.readLine());

		List<Edge>[] list = new ArrayList[V + 1];

		for (int i = 1; i <= V; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weigth = Integer.parseInt(st.nextToken());
			list[from].add(new Edge(from, to, weigth));
		}

		boolean[] v = new boolean[V + 1];
		int[] minEdge = new int[V + 1];

		for (int i = 0; i < minEdge.length; i++) {
			minEdge[i] = Integer.MAX_VALUE;
		}

		minEdge[start] = 0;
		int min = 0;
		int stopIndex = -1;

		for (int i = 1; i <= V; i++) {

			min = Integer.MAX_VALUE;

			stopIndex = -1;
			for (int j = 0; j < minEdge.length; j++) {
				if (!v[j] && min > minEdge[j]) {
					min = minEdge[j];
					stopIndex = j;
				}

			}

			if (stopIndex == -1) {
				break;
			}

			v[stopIndex] = true;
			
			for(int j=0;j<list[stopIndex].size();j++) {
				if(minEdge[list[stopIndex].get(j).to] > min + list[stopIndex].get(j).weigth) {
					minEdge[list[stopIndex].get(j).to]=min + list[stopIndex].get(j).weigth;
				}
			}

		}
		
		
		for(int i=1;i<minEdge.length;i++) {
			if(minEdge[i]== Integer.MAX_VALUE) {
				System.out.println("INF");
			}else {
				System.out.println(minEdge[i]);
			}
			
		}

	}

}