import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;
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

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		boolean isout = false;
		int W,H;
		
		//위, 위오, 오, 오아, 아, 왼아, 왼, 왼위
		int[] dy = {-1,-1,0,1,1,1,0,-1};
		int[] dx = {0,1,1,1,0,-1,-1,-1};
		
		while(!isout) {
			String str = br.readLine();
			StringTokenizer stz = new StringTokenizer(str);
			W = Integer.parseInt(stz.nextToken());
			H = Integer.parseInt(stz.nextToken());
			int[][] map = new int[H][W];
			
			if(W == 0 && H == 0) {
				isout = true;
				continue;
			}
			
			for(int i=0;i<H;i++) {
				str = br.readLine();
				stz = new StringTokenizer(str);
				for (int j=0;j<W;j++) {
					map[i][j] = Integer.parseInt(stz.nextToken());
				}
			}
			int answer =0;
			boolean[][] bmap = new boolean[H][W]; 
			//섬의 갯수 체크
			for(int i=0;i<H;i++) {
				for(int j=0;j<W;j++) {
					if(map[i][j]==1 && !bmap[i][j]) {
						bmap[i][j] = true;
						answer++;
						Queue<Node> que = new ArrayDeque<>();
						que.offer(new Node(i,j));
						
						while(!que.isEmpty()) {
							Node CheckNode = que.peek();
							que.poll();
							for(int k=0;k<8;k++) {
								int wy = CheckNode.y + dy[k];
								int wx = CheckNode.x + dx[k];
								
								if(wy<0 || wx<0 || wy>=H || wx>=W
										|| bmap[wy][wx] || map[wy][wx]!=1) {
									continue;
								}
								bmap[wy][wx] = true;
								que.offer(new Node(wy,wx));
							}
						}
					}
				}
			}
			sb.append(answer).append("\n");
		}
		System.out.print(sb);
	}

}
