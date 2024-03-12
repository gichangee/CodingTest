import java.io.*;
import java.util.*;

public class Main {

	static int M,N,H;
	static int count;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		int[][][] arr = new int[N][M][H];
		
		
		List<int[]> applelist = new ArrayList<>();
		
		for(int z=0;z<H;z++) {
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<M;j++) {
					arr[i][j][z]=Integer.parseInt(st.nextToken());
					if(arr[i][j][z]==1) {
						applelist.add(new int[] {i,j,z});
					}
				}
			}
		}
		
		count = 0;
		
		
		loop(applelist,arr);
		
		boolean a= true;
		
		
		
		Label: for(int z=0;z<H;z++) {
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					
					if(arr[i][j][z]==0) {
						a=false;
						break Label;
					}
				}
			}
		}
		
		if(!a) {
			System.out.println(-1);
		}else {
			System.out.println(count);
		}
	}

	private static void loop(List<int[]> applelist, int[][][] arr) {

		Queue<int[]> q = new ArrayDeque<>();
		for(int i=0;i<applelist.size();i++) {
			q.add(new int[] {applelist.get(i)[0],applelist.get(i)[1],applelist.get(i)[2],0});
		}
		
		//상하좌우 위 아래
		int[] dy= {-1,1,0,0,0,0};
		int[] dx = {0,0,-1,1,0,0};
		int[] dz= {0,0,0,0,-1,1};
		
		while(!q.isEmpty()) {
			int[] temp = q.poll();
			
			if(count < temp[3]) {
				count = temp[3];
			}
			for(int i=0;i<6;i++) {
				int y= dy[i]+temp[0];
				int x= dx[i]+temp[1];
				int z= dz[i]+temp[2];

				if(y>=0 && y<N && x>=0 && x<M && z>=0 && z<H) {
					if(arr[y][x][z] == 0 ) {
						arr[y][x][z]=1;
						q.add(new int[] {y,x,z,temp[3]+1});
					}
				}
			}
		}
	}

}