/**
 * @author 박기창
 * 크루스칼 알고리즘 사용하기
 * 간선리스트 사용하기
 * union find 사용하기
 */
import java.util.*;
import java.io.*;
public class Solution {

	static int V, E;
	static int[] parents;
	
	//간선정보 담을 클래스 만들기
	static class Edge implements Comparable<Edge> {

		int from;
		int to;
		int weigth;

		public Edge(int from, int to, int weigth) {
			this.from = from;
			this.to = to;
			this.weigth = weigth;
		}

		
		//클래스 정렬을 가중치 올림차순으로 만들기
		@Override
		public int compareTo(Edge o) {

			return this.weigth - o.weigth;
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= t; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			
			//노드 개수 간선 개수 입력받기
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());

			
			//간선 개수만큼 배열 만들기
			Edge[] edges = new Edge[E];
			
			//정보 입력받고 간선 배열에 넣기
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				int weight = Integer.parseInt(st.nextToken());
				edges[i] = new Edge(from, to, weight);
			}
			
			
			//가중치 기준으로 올림차순 정렬하기
			Arrays.sort(edges);
			
			
			//노드 자기 자신으로 초기화 하기
			parents = new int[V+1];
			for(int i=1;i<=V;i++) {
				parents[i]=i;
			}
			
			//가중치
			long weight =0;
			
			//간선 개수
			int cnt = 0;
			
			//엣지클래스 배열안에 있는 간선 정보 모두 탐색하기
			for(Edge e : edges) {
				
				//만약 합집합을 안해도 되는 상태면 넘어가기 이미 같은 대표값을 가르키고 있을 때
				if(!union(e.from,e.to)) {
					continue;
				}else {
					// 합치는거 성공하면 가중치 더해주기
					weight += e.weigth;
					
					//간선개수 늘리기
					cnt++;
					
					//간선개수가 v-1만큼 되면 종료하기
					if(cnt == V-1) {
						break;
					}
				}
			}
			
			System.out.println("#"+test_case+" "+weight);
			
		}

	}

	
	//union
	private static boolean union(int from, int to) {
		int x = find(from);
		int y = find(to);
		
		if(x==y) {
			return false;
		}else {
			parents[y]=x;
			return true;
		}
		
	}

	private static int find(int from) {
		if(from == parents[from]) {
			return from;
		}else {
			return parents[from] = find(parents[from]);
		}
	}
	

}