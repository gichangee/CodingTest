import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static int N, rgbcnt, rgcnt;
	public static char[][] map;
	public static boolean[][] rgbmap;
	public static boolean[][] rgmap;
	// 위, 오, 아, 왼
	public static int dy[] = {-1,0,1,0};
	public static int dx[] = {0,1,0,-1};
	
	public static class Node{
		int y;
		int x;
		
		Node(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
	
	public static void RGBCheck(int y, int x, char c) {
		Queue<Node> que = new ArrayDeque<Node>();
		que.offer(new Node(y,x));
		rgbmap[y][x] = true;
		
		while(!que.isEmpty()) {
			Node NewNode = que.poll();
			
			for(int i=0;i<4;i++) {
				int fy = NewNode.y + dy[i];
				int fx = NewNode.x + dx[i];
				
				if(fy<0 || fx<0 || fy>=N || fx>=N || map[fy][fx]!=c || rgbmap[fy][fx]) {
					continue;
				}
				que.offer(new Node(fy,fx));
				rgbmap[fy][fx] = true;			
			}
		}
	}
	
	public static void RGCheck(int y, int x, char c) {
		Queue<Node> que = new ArrayDeque<Node>();
		que.offer(new Node(y,x));
		rgmap[y][x] = true;
		
		while(!que.isEmpty()) {
			Node NewNode = que.poll();
			
			for(int i=0;i<4;i++) {
				int fy = NewNode.y + dy[i];
				int fx = NewNode.x + dx[i];
				
				if(fy<0 || fx<0 || fy>=N || fx>=N || rgmap[fy][fx]) {
					continue;
				}
				else if(c == 'B' && map[fy][fx]!='B') {
					continue;
				}
				else if(c == 'R' || c == 'G') {
					if(map[fy][fx]=='B')
						continue;
				}
				
				que.offer(new Node(fy,fx));
				rgmap[fy][fx] = true;			
			}
		}
	}

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		rgbmap = new boolean[N][N];
		rgmap = new boolean[N][N];
		
		for(int i=0;i<N;i++) {
			String str = br.readLine();
			for(int j=0;j<N;j++) {
				map[i][j] = str.charAt(j);
			}
		}
		rgbcnt = 0;
		rgcnt = 0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(!rgbmap[i][j]) {
					RGBCheck(i,j,map[i][j]);
					rgbcnt++;
				}
				
				if(!rgmap[i][j]) {
					RGCheck(i,j,map[i][j]);
					rgcnt++;
				}
			}
		}
		sb.append(rgbcnt).append("\n");
		sb.append(rgcnt).append("\n");
		System.out.print(sb);

	}

}
