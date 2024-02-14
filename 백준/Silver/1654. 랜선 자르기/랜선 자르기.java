import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static long[] arr;
	static long max;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int cnt = Integer.parseInt(st.nextToken());
		long maxcnt = Long.parseLong(st.nextToken());

		arr = new long[cnt];
		max = Long.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(arr);

		long mid = arr[arr.length - 1];
		long result = binarySearch(arr, maxcnt);
		System.out.println(max);

	}

	private static long binarySearch(long[] arr, long maxcnt) {

		long count=0;
		
		for(int i=0;i<arr.length;i++) {
			count += arr[i]/arr[arr.length-1];
		}
		
		if(count >= maxcnt) {
			if(max < arr[arr.length-1]) {
				max = arr[arr.length-1];
			}
			return arr[arr.length-1];
		}
		
		long start =1;
		long end = arr[arr.length-1];
		
		while(start <= end) {
			count =0;
			long mid = (start+end)/2;
			for(int i=0;i<arr.length;i++) {
				count += arr[i]/mid;
			}
			
			if(count == maxcnt) {
				if(max <= mid) {
					max=mid;
				}
				start = mid+1;
			}else if(count < maxcnt) {
				end = mid -1;
			}else {
				start = mid+1;
				if(max <= mid) {
					max=mid;
				}
			}
			
			
		}
		return -1;
	
		
	}
}