import java.io.*;
import java.util.*;

public class Solution {

	static int B;
	static int min;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());

			int[] arr = new int[N];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < arr.length; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			min = Integer.MAX_VALUE;
			for (int i = 0; i < arr.length; i++) {
				int temp[] = new int[i + 1];
				comb(arr, 0, 0, temp);
			}
			
			System.out.println("#"+tc+" "+(min-B));
		}

	}

	private static void comb(int[] arr, int depth, int start, int[] temp) {
		if (depth == temp.length) {
			int sum = 0;
			for (int i = 0; i < temp.length; i++) {
				sum += temp[i];
			}

			if (B <= sum) {
				if(min > sum) {
					min = sum;
				}
			}

		} else {
			for (int i = start; i < arr.length; i++) {
				temp[depth] = arr[i];
				comb(arr, depth + 1, i + 1, temp);
			}
		}
	}

}