

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

	static class Edge implements Comparable<Edge> {
		int from;
		int to;
		double weigth;

		public Edge(int from, int to, double d) {
			this.from = from;
			this.to = to;
			this.weigth = d;
		}

		@Override
		public int compareTo(Edge o) {

			return Double.compare(this.weigth, o.weigth);
		}

	}

	static int[] parents;
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int i = 1; i <= T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken());

			int[][] island = new int[N][2];
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				island[j][0] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				island[j][1] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			double e = Double.parseDouble(st.nextToken());
			List<Edge> list = new ArrayList<>();
			for (int j = 0; j < N-1; j++) {
				for (int z = j+1; z < N; z++) {
					list.add(new Edge(j, z, distance(island[j], island[z])));
				}
			}

			Collections.sort(list);
			
			

			parents = new int[N];
			
			for(int j=0;j<parents.length;j++) {
				parents[j]=j;
			}

			int cnt = 0;
			double weigth = 0;
			for (Edge e2 : list) {
				if (!union(e2.from, e2.to)) {
					continue;
				} else {
					weigth += e2.weigth * e2.weigth * e;
					cnt++;
					if (cnt == N - 1) {
						break;
					}
				}
			}
			
			System.out.println("#"+i+" "+Math.round(weigth));

		}

	}

	private static boolean union(int from, int to) {
		int a = find(from);
		int b = find(to);
		if(a !=b ) {
			parents[b] =a;
			return true;
		}
		return false;
	}

	private static int find(int from) {
		if(parents[from] == from) {
			return from;
		}else {
			return parents[from] = find(parents[from]);
		}
	}

	private static double distance(int[] island1, int[] island2) {

		return Math
				.sqrt(Math.pow(Math.abs(island1[0] - island2[0]), 2) + Math.pow(Math.abs(island1[1] - island2[1]), 2));
	}

}
