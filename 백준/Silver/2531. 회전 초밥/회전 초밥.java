import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
/**
 * 
 * 
 * @author park
 *
 */
public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		int[] v = new int[d + 1];
		int[] arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		int start = 0;
		int end = 0;

		int count = 0;

		int max = Integer.MIN_VALUE;

		while (Math.abs(start - end) != (k - 1)) {
			end++;
		}
		if (Math.abs(start - end) == (k - 1)) {

			for (int i = start; i <= end; i++) {
				v[arr[i]]++;
			}
		}

		for (int i = 1; i <= d; i++) {
			if (v[i] > 0) {
				count++;
			}
		}
		boolean coupon =false;
		if (v[c] == 0) {
			count++;
			coupon=true;
		}

		if (max <= count) {
			max = count;
		}

		
		
		while (start != N-1) {

			v[arr[start % N]]--;
			if (v[arr[start % N]] == 0) {
				count--;
				if(arr[start % N]==c) {
					coupon=false;
				}
			}
			start++;
			end++;

			v[arr[end % N]]++;
			if (v[arr[end % N]] == 1 ) {
				if(arr[end % N]==c && !coupon) {
					count++;
				}else if(arr[end % N]!=c){
					count++;
				}
				
			}

			if (v[c] == 0 && !coupon) {
				count++;
				coupon=true;
			}

			if (max <= count) {
				max = count;
			}
		}

		System.out.println(max);

	}

}