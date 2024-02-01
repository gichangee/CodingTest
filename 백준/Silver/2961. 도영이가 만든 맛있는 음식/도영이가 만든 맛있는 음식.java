

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{

	static int[] arr1, arr2;
	static int t;
	static boolean[] isSelected;

	static int[] sum1, sum2;
	
	static int count;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		t = Integer.parseInt(st.nextToken());

		arr1 = new int[t];
		arr2 = new int[t];
		isSelected = new boolean[t];
		
		count=0;

		sum1 = new int[(int) Math.pow(2, t)];
		sum2 = new int[(int) Math.pow(2, t)];

		for (int i = 0; i < t; i++) {
			st = new StringTokenizer(br.readLine());
			arr1[i] = Integer.parseInt(st.nextToken());
			arr2[i] = Integer.parseInt(st.nextToken());
		}

		loop(0);

		
		long small=Long.MAX_VALUE;
		for(int i=0;i<sum1.length-1;i++) {
			if(sum1[i]>=sum2[i]) {
				int x = sum1[i]-sum2[i];
				if(small > x) {
					small=x;
				}
			}else {
				int x = sum2[i]-sum1[i];
				if(small > x) {
					small=x;
				}
			}
		}
		
		System.out.println(small);
	}

	private static void loop(int cnt) {

		if (cnt == t) {
			int one = 1;
			int two = 0;
			for (int i = 0; i < t; i++) {
				if (isSelected[i]) {
					one*=arr1[i];
					two+=arr2[i];
				}
			}
			sum1[count]=one;
			sum2[count]=two;
			count=count+1;
			return;

		} else {

			isSelected[cnt] = true;
			loop(cnt + 1);
			isSelected[cnt] = false;
			loop(cnt + 1);
		}

	}

}
