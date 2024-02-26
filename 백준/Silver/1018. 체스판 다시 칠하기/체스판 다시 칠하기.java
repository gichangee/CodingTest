import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(stz.nextToken());
		int M = Integer.parseInt(stz.nextToken());
		char[][] map = new char[N][M];
		char[][] bwmap = new char[N][M];
		char[][] wbmap = new char[N][M];
		
		boolean b_bw = false;
		boolean b_wb = false;
		
		for(int i=0;i<N;i++) {
			String str = br.readLine();
			if(i>0 && i%2 == 0) {
				b_bw = false;
				b_wb = false;
			}
			else if(i == 0) {
				b_bw = false;
				b_wb = false;

			}
			else {
				b_bw = true;
				b_wb = true;
			}
			
			
			for(int j=0;j<M;j++) {
				map[i][j] = str.charAt(j);
				if(b_bw) {
					bwmap[i][j] = 'B';
					b_bw = false;
				}
				else if(!b_bw) {
					bwmap[i][j] = 'W';
					b_bw = true;
				}
				
				if(b_wb) {
					wbmap[i][j] = 'W';
					b_wb = false;
				}
				else if(!b_wb) {
					wbmap[i][j] = 'B';
					b_wb = true;
				}
			}
		}
		int minbw = 2550;
		int minwb = 2550;
		
		for(int n = 0;n<N;n++) {
			for(int m=0;m<M;m++) {
				if(n+8>N || m+8>M)
					break;
				
				int bwcnt = 0;
				int wbcnt = 0;
				for(int i=n,k=0 ;k<8 && i<N;i++,k++) {
					for(int j=m,l=0;l<8 && j<M;j++,l++) {
						if(map[i][j]!= bwmap[i][j])
							bwcnt++;
						if(map[i][j]!= wbmap[i][j])
							wbcnt++;
					}
				}
				
				if(bwcnt<minbw)
					minbw = bwcnt;
				
				if(wbcnt<minwb)
					minwb = wbcnt;
			}
		}
		int answer = (minbw>= minwb? minwb :minbw);
		System.out.println(answer);

	}

}
