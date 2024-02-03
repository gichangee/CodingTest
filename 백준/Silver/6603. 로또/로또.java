import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	static int N, R;
	static int[] arr;
	static int[] temp;
	static StringBuilder sb;
	static boolean[] v;
	static Set<String> s;

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		while(true) {
			sb = new StringBuilder();
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			R = 6;
	
			if(N==0) {
				break;
			}
			arr = new int[N];

			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			temp = new int[R];
			v = new boolean[N];
			Arrays.sort(arr);

			loop(0,0);
			System.out.println(sb.toString());
		}

		
		

	}

	private static void loop(int cnt,int a) {
		if (cnt == R) {

			for (int i = 0; i < R; i++) {
				sb.append(temp[i] + " ");

			}
			sb.append("\n");
			return;

		} else {

			for (int i = a; i < N; i++) {

					temp[cnt] = arr[i];
					loop(cnt + 1,i+1);
				}

			}

		}

}