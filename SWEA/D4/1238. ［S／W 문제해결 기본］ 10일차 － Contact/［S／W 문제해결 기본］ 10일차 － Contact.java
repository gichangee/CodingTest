

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	
	static int max;
	static List<Integer>[] list;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int test_case=1;test_case<=10;test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int R = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());
			
			max = Integer.MIN_VALUE;
			int[][] arr = new int[101][101];
			boolean[] v = new boolean[101];
			list = new ArrayList[101];
			for(int i=1;i<101;i++) {
				list[i] = new ArrayList<>();
			}
			
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<R/2;i++) {
				int y = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken());
				arr[y][x] = 1;
			}
			
			bfs(arr,v,start,0);
			System.out.println("#"+test_case+" "+max);
			
		}
		
	}

	private static void bfs(int[][] arr, boolean[] v, int start, int depth) {
		
		Queue<int []> q = new ArrayDeque<>();
		int d =0;
		q.add(new int[] {start,depth});
		v[start]=true;	
		while(!q.isEmpty()) {
			int[] x = q.poll();
			for(int i=1;i<101;i++) {
				if(arr[x[0]][i]==1 && !v[i]){
					v[i]=true;
					q.add(new int[] {i,x[1]+1});
					list[x[1]+1].add(i);
					d=x[1]+1;
				}
			}
		
		}
		for(int i=0;i<list[d].size();i++) {
			if(max<=list[d].get(i)) {
				max=list[d].get(i);
			}
		}
	
		
		
		
	}

}
