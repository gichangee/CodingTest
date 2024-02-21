import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	public static int cctvcnt;
	public static int N, M;
	public static int[][] map;
	public static ArrayList<Pair> list;
	public static int[] dfsChoice;
	public static int answer;
	
	//오, 아, 왼, 위
	public static int[] dy = {0,1,0,-1};
	public static int[] dx = {1,0,-1,0};
	public static int[][][] ddd = {//카메라번호,선택 방향, 봐야되는값
			{{0}},
			{{0},{1},{2},{3}},
			{{0,2},{1,3}},
			{{0,3},{0,1},{1,2},{2,3}},
			{{0,2,3},{0,1,3},{0,1,2},{1,2,3}},
			{{0,1,2,3}}};

	public static class Pair {
		int y;
		int x;
		int d; // 현재방향
		int num; // cctv 번호

		Pair(int y, int x, int d, int num) {
			this.y = y;
			this.x = x;
			this.d = d;
			this.num = num;
		}
	}

	public static void watch() {
		// 원본 맵 카피
		int[][] copymap = new int[N][M];
		for (int i = 0; i < N; i++) {
			copymap[i] = map[i].clone();
		}

		//CCTV 탐색
		for (int cctv = 0; cctv < cctvcnt; cctv++) {
			//선택방향
			int direct = dfsChoice[cctv];
			int fy = list.get(cctv).y;
			int fx = list.get(cctv).x;
			int fnum = list.get(cctv).num;
			// 해당 방향때 봐야되는 방향 탐색
			for(int k = 0;k<ddd[fnum][direct].length;k++) {
				int ffy = fy + dy[ddd[fnum][direct][k]];
				int ffx = fx + dx[ddd[fnum][direct][k]];
				
				while(true) {
					if(ffy<0 || ffx<0 || ffy>=N || ffx>=M ||
							map[ffy][ffx]==6)
						break;
					
					if(copymap[ffy][ffx] == 0) {
						copymap[ffy][ffx] = -1;
					}
					ffy = ffy + dy[ddd[fnum][direct][k]];
					ffx = ffx + dx[ddd[fnum][direct][k]];
				}
			}
		}
		
		int cnt = 0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(copymap[i][j]==0)
					cnt++;
			}
		}
		
		//사각지대 체크
		if(cnt<answer)
			answer = cnt;

	}

	public static void dfs(int depth) {

		if (depth >= cctvcnt) {
			// 검사 함수로 이동
			watch();
			return;
		}

		for (int i = 0; i < 4; i++) {
			
			if(list.get(depth).num == 2 && i>1)
				continue;
			if(list.get(depth).num == 5 && i>0)
				continue;
			
			dfsChoice[depth] = i;
			dfs(depth + 1);
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		StringTokenizer stz = new StringTokenizer(str);
		N = Integer.parseInt(stz.nextToken());
		M = Integer.parseInt(stz.nextToken());
		list = new ArrayList<>();
		map = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			str = br.readLine();
			stz = new StringTokenizer(str);
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(stz.nextToken());
				if (map[i][j] >= 1 && map[i][j] <= 5) {
					list.add(new Pair(i, j, 0, map[i][j]));
				}
			}
		}
		answer = 64;
		cctvcnt = list.size();
		dfsChoice = new int[cctvcnt];
		dfs(0);
		System.out.println(answer);
	}
}
