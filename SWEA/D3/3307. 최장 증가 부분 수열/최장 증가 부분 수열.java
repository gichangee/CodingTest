import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			
			int n = sc.nextInt();
			int[] arr = new int[n];
			
			for(int i=0;i<n;i++) {
				arr[i]=sc.nextInt();
			}
			
			int[] LIS = new int[n];
			for(int i=0;i<n;i++) {
				LIS[i]=1;
			}
			
			for(int i=0;i<n;i++) {
				for(int j=i;j>=0;j--) {
					if(arr[i]>arr[j] && LIS[i]<LIS[j]+1) {
						LIS[i]=LIS[j]+1;
					}
				}
			}
			
			int max = Integer.MIN_VALUE;
			for(int i=0;i<n;i++) {
				if(max<LIS[i]) {
					max=LIS[i];
				}
			}
			
			System.out.println("#"+test_case+" "+max);

		}
	}

}