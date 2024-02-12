import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int sum = sc.nextInt();
		
		int[] arr = new int[n];
		for(int i=n-1;i>=0;i--) {
			arr[i]=sc.nextInt();
		}
		
		int count=0;
		
		for(int i=0;i<n;i++) {
			count+=(sum/arr[i]);
			sum=sum%arr[i];
		}
		
		System.out.println(count);
	}
	
	
}