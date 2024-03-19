import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int min;
	static char[][] firstw, firstb;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		char[][] arr = new char[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i] = st.nextToken().toCharArray();
		}

		String s = "WBWBWBWB";
		String s2 = "BWBWBWBW";

		firstw = new char[8][8];
		firstw[0] = s.toCharArray();
		firstw[1] = s2.toCharArray();
		firstw[2] = s.toCharArray();
		firstw[3] = s2.toCharArray();
		firstw[4] = s.toCharArray();
		firstw[5] = s2.toCharArray();
		firstw[6] = s.toCharArray();
		firstw[7] = s2.toCharArray();

		firstb = new char[8][8];
		firstb[0] = s2.toCharArray();
		firstb[1] = s.toCharArray();
		firstb[2] = s2.toCharArray();
		firstb[3] = s.toCharArray();
		firstb[4] = s2.toCharArray();
		firstb[5] = s.toCharArray();
		firstb[6] = s2.toCharArray();
		firstb[7] = s.toCharArray();

		min = Integer.MAX_VALUE;

		for (int i = 0; i < N - 7; i++) {
			for (int j = 0; j < M - 7; j++) {
				loop(i, j, arr);
			}
		}
		
		System.out.println(min);

	}

	private static void loop(int y, int x, char[][] arr) {

		int yy=y+8;
		int xx=x+8;
		
		int cnt=0;
		for(int a=y,i=0;a<yy;a++,i++) {
			for(int b=x,j=0;b<xx;b++,j++) {
				if(firstw[i][j] != arr[a][b]) {
					cnt++;
				}
			}
		}
		
		if(cnt < min) {
			min = cnt;
		}
		
		cnt =0;
		
		for(int a=y,i=0;a<yy;a++,i++) {
			for(int b=x,j=0;b<xx;b++,j++) {
				if(firstb[i][j] != arr[a][b]) {
					cnt++;
				}
			}
		}
		
		if(cnt < min) {
			min = cnt;
		}
		
		
	}

}