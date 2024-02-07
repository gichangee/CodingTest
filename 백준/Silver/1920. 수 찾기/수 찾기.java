import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int cnt = sc.nextInt();
		
		int[] arr= new int[cnt];
		for(int i=0;i<cnt;i++) {
			arr[i]=sc.nextInt();
		}
		
		Arrays.sort(arr);
		int r = sc.nextInt();
		
		for(int i=0;i<r;i++) {
			
			boolean result = false;
			
			int k = sc.nextInt();
			
			int first = 0;
			int end = arr.length-1;
			
			while(first<=end) {
				
				int mid = (first+end)/2;
				
				if(arr[mid] < k) {
					first = mid+1;
				}else if(arr[mid] > k) {
					end = mid-1;
				}else if(arr[mid] == k) {
					
					result=true;
					break;
				}
				
			}
			
			
			
			
			if(!result) {
				System.out.println("0");
			}else {
				System.out.println("1");
			}
		}
	}

}