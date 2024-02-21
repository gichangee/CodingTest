import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	public static class Pair{
		int y;
		int x;
		int d;
		
		Pair(int y,int x, int d){
			this.y = y;
			this.x = x;
			this.d = d;
		}
	}

	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N,M;
		String str = br.readLine();
		StringTokenizer stz = new StringTokenizer(str);
		
		N = Integer.parseInt(stz.nextToken());
		M = Integer.parseInt(stz.nextToken());
		int[][] map = new int[N][M];
		Queue<Pair> que = new ArrayDeque<Pair>();
		int answer = 0;
		// 오, 아오,아,아왼,왼,왼위,위,위오
		int[] dy = {0,1,1,1,0,-1,-1,-1};
		int[] dx = {1,1,0,-1,-1,-1,0,1};
		
		for(int i=0;i<N;i++) {
			str = br.readLine();
			stz = new StringTokenizer(str);
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(stz.nextToken());
				if(map[i][j] == 1) {
					que.offer(new Pair(i, j, 0));
				}
			}
		}
		
		while(!que.isEmpty()) {
			Pair check = que.poll();
			
			for(int i=0;i<8;i++) {
				int fy = check.y + dy[i];
				int fx = check.x + dx[i];
				
				if(fy<0 || fx<0 || fy>=N || fx>=M || map[fy][fx]!=0) {
					continue;
				}
				map[fy][fx] = check.d+1;
				que.offer(new Pair(fy, fx, check.d+1));
			}
			if(check.d>answer)
				answer = check.d;
		}
		System.out.print(answer+"\n");
	}

}
