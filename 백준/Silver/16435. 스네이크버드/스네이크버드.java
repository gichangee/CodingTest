import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int initlen = sc.nextInt();
		
		
		int[] arr= new int[num];
		for(int i=0;i<num;i++) {
			arr[i]=sc.nextInt();
		}
		
		
		Arrays.sort(arr);
		
		
		
		for(int i=0;i<arr.length;i++) {
			if(initlen >= arr[i]) {
				initlen++;
			}
		}
		
		System.out.println(initlen);
		
		
	}

}