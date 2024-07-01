import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class Main {

	static StringBuilder sb;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		sb = new StringBuilder("");

		BigInteger bg = new BigInteger("2");

		if (N <= 20) {
			hanoi(N, 1, 3, 2);

		}

		System.out.println(bg.pow(N).subtract(new BigInteger("1")));

		System.out.println(sb.toString());
	}

	private static void hanoi(int n, int from, int to, int mid) {
		// TODO Auto-generated method stub
		if (n == 1) {
			sb.append(from+" "+to+"\n");
		} else {
			hanoi(n - 1, from, mid, to);
			sb.append(from+" "+to+"\n");
			hanoi(n - 1, mid, to, from);
		}

	}

}