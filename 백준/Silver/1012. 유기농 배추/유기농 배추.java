import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static class Pair{
		int y;
		int x;
		
		Pair(int y, int x){
			this.y = y;
			this.x = x;
		}
	}
	
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int rtc = Integer.parseInt(br.readLine());
		//우, 하, 좌, 상
		int[] dy = {0,1,0,-1};
		int[] dx = {1,0,-1,0};
		
		
		for(int tc = 1;tc<=rtc;tc++) {
			String str = br.readLine();
			StringTokenizer stz = new StringTokenizer(str);
			int M = Integer.parseInt(stz.nextToken());
			int N = Integer.parseInt(stz.nextToken());
			int K = Integer.parseInt(stz.nextToken());
			Queue<Pair> que = new ArrayDeque<Pair>();
			boolean[][] map = new boolean[N+1][M+1];
			
			for(int k=0;k<K;k++) {
				str = br.readLine();
				stz = new StringTokenizer(str);
				int a = Integer.parseInt(stz.nextToken());
				int b = Integer.parseInt(stz.nextToken());
				map[b][a] = true;
			}
			int answer = 0;
			boolean[][] bmap = new boolean[N+1][M+1];
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					if(map[i][j] && !bmap[i][j]) {
						bmap[i][j] = true;
						answer++;
						// BFS
						que.offer(new Pair(i, j));
						
						while(!que.isEmpty()) {
							Pair nowp = que.poll();
							for(int k=0;k<4;k++) {
								int fy = nowp.y + dy[k];
								int fx = nowp.x + dx[k];
								
								if(fy<0 || fx<0 || fy>=N || fx>=M || bmap[fy][fx] || !map[fy][fx])
									continue;
								
								bmap[fy][fx] = true;
								que.offer(new Pair(fy, fx));
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
