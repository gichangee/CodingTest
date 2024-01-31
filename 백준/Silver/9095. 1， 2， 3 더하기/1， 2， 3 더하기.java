

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int sum;
	static int[] arr = { 1, 2, 3 };
	static int[] temp;
	static int count;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(st.nextToken());

		for (int i = 0; i < t; i++) {
			count = 0;
			sum = Integer.parseInt(br.readLine());
			for (int j = 1; j <= sum; j++) {
				temp = new int[j];
				//N = 3
				//temp.length 가 R
				loop(0);
			}
			sb.append(count+"\n");

		}
		
		System.out.println(sb.toString());
	}

	private static void loop(int cnt) {
		if (cnt == temp.length) {

			int tempsum = 0;
			for (int i = 0; i < temp.length; i++) {
				tempsum += temp[i];
			}

			if (tempsum == sum) {
				count++;
			}

		} else {
			for (int i = 1; i <= 3; i++) {
				temp[cnt] = i;
				loop(cnt+1);
			}
		}

	}
}
