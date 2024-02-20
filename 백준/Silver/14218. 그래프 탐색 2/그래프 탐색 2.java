import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static boolean[] v;
	static StringBuilder sb;
	static Node[] adjList;

	static class Node {
		int to;
		Node next;

		public Node(int to, Node next) {
			this.to = to;
			this.next = next;
		}

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N1 = Integer.parseInt(st.nextToken());
		int M1 = Integer.parseInt(st.nextToken());
		sb = new StringBuilder();
		adjList = new Node[N1 + 1];

		for (int i = 0; i < M1; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			adjList[x] = new Node(y, adjList[x]);
			adjList[y] = new Node(x, adjList[y]);

		}
		
		

		int N2 = Integer.parseInt(br.readLine());
		for (int i = 0; i < N2; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			adjList[x] = new Node(y, adjList[x]);
			adjList[y] = new Node(x, adjList[y]);


			for(int num : loop(N1+1)) {
				sb.append(num+" ");
			}

			sb.append("\n");

		}
		System.out.println(sb);
	}

	private static int[] loop(int cnt) {

		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {0,1}); //카운트 와 도착 주소
		int[] answer = new int[cnt];
		Arrays.fill(answer, -1);
		answer[1]=0; //answer[1]은 어차피 0
		while(!q.isEmpty()) {
			int[] temp = q.poll();
			for(Node temp2 = adjList[temp[1]];temp2!=null;temp2 = temp2.next) {
				if(answer[temp2.to]==-1) {
					answer[temp2.to]=temp[0]+1;
					q.offer(new int[] {temp[0]+1,temp2.to});
				}
			}
		}
		
		return Arrays.copyOfRange(answer, 1, cnt);
		
		
	}

}