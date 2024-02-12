import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		
		String[] minus = s.split("-");
		int[] arr = new int[minus.length];
		for(int i=0;i<minus.length;i++) {
			String[] split = minus[i].split("[+]");
			for(int j=0;j<split.length;j++) {
				arr[i]+=Integer.parseInt(split[j]);
			}
		}
		

		
		int sum=arr[0];
		for(int i=1;i<minus.length;i++) {
			sum-=arr[i];
		}
		System.out.println(sum);
		
		
	
		
		
	}

}