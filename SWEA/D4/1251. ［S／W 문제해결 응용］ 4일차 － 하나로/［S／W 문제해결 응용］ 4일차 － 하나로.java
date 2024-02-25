import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	static class Node{
		int x;
		int y;
		public Node(int x) {
			this.x = x;
		}
		
		
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int test_case=1;test_case<=t;test_case++) {
			int N = sc.nextInt();
			
			Node[] land = new Node[N];
			boolean[] visited = new boolean[N];
			double[] minEdge = new double[N];
			
			for(int i=0;i<N;i++) {
				land[i] = new Node(sc.nextInt());
			}
			
			for(int i=0;i<N;i++) {
				land[i].y = sc.nextInt();
			}
			
			double E = sc.nextDouble();
			
			Arrays.fill(minEdge, Integer.MAX_VALUE);
			minEdge[0] = 0;
			double result = 0;
			int c;
			for(c= 0;c<N;c++) {
				
				
				//step1 : 비트리 정점 중 최소간선비용의 정점 찾기
				double min = Double.MAX_VALUE;
				int minVertex = -1;
				for(int i=0;i<N;i++) {
					if(!visited[i] && minEdge[i]<min) {
						min = minEdge[i];
						minVertex=i;
					}
				}
				
				if(minVertex == -1) {
					break;
				}
				
				result+= min*min*E;
				visited[minVertex] = true;
				
				
				//step 2  : 새롭게 트리 정점에 확장된 정점 기준으로 비트리 정점들과의 간선비용 고려 최적 업데이트
				for(int i=0;i<N;i++) {
					double distance = Math.sqrt(Math.pow(land[minVertex].x-land[i].x,2)+Math.pow(land[minVertex].y-land[i].y,2));
					if(!visited[i] && distance < minEdge[i]) {
						minEdge[i]=distance;
					}
				}
			}
			
			System.out.println("#"+test_case+" "+(c==N?(long)Math.round(result) : -1));
		}
	}

}