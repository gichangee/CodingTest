import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static class Node{
		int y;
		int x;
		Node(int y, int x){
			this.y = y;
			this.x = x;
		}
	}
	
	public static int N,M;
	public static int[][] map;
	public static boolean[][] bmap;
	public static int answer;
	public static Node[] nodes;
	//우, 하, 좌, 상
	public static int[] dy = {0,1,0,-1};
	public static int[] dx = {1,0,-1,0};
	
	public static void Running() {
		int cnt = 0;
		//BFS 해줄 큐 생성
		Queue<Node> que = new ArrayDeque<Node>();
		
		//복사배열 선언
		int[][] copymap = new int[N][M];
		boolean[][] bcopymap = new boolean[N][M];
		
		//벽세워주기
		for(int i=0;i<3;i++) {
			copymap[nodes[i].y][nodes[i].x] = 1;
		}
		
		// 맵복사
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(copymap[i][j]!=0)
					continue;
				
				copymap[i][j] = map[i][j];
				
				if(copymap[i][j] == 2) {
					que.offer(new Node(i, j));
					bcopymap[i][j] = true;
				}
			}
		}
		
		//동작
		while(!que.isEmpty()) {
			Node node = que.poll();
			
			for(int i=0;i<4;i++) {
				int fy = node.y + dy[i];
				int fx = node.x + dx[i];
				
				if(fy<0 || fx<0 || fy>=N || fx>=M || 
						bcopymap[fy][fx] || copymap[fy][fx]!=0 )
					continue;
				
				copymap[fy][fx] = 2;
				bcopymap[fy][fx] = true;
				que.offer(new Node(fy, fx));
				
			}
			
		}
		
		
		//카운트 체크
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(copymap[i][j] == 0)
					cnt++;
			}
		}
		
		if(cnt>answer)
			answer = cnt;
	}
	
	public static void dfs(int depth,int i,int j) {
		
		if(depth >=3) {
			Running();
			return; 
		}
		
		for(;i<N;i++) {
			for(;j<M;j++) {
				if(map[i][j]!=0 || bmap[i][j])
					continue;
				bmap[i][j] = true;
				nodes[depth] = new Node(i, j);
				dfs(depth+1,i,j+1);
				bmap[i][j] = false;
			}
			j=0;
		}
		
	}
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(stz.nextToken());
		M = Integer.parseInt(stz.nextToken());
		map = new int[N][M];
		bmap = new boolean[N][M];
		nodes = new Node[3];
		
		for(int i=0;i<N;i++) {
			stz = new StringTokenizer(br.readLine()," ");
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(stz.nextToken());
			}
		}
		answer = 0;
		dfs(0,0,0);
		System.out.println(answer);
	}

}
