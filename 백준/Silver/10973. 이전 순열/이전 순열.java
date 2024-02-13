import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		
		int arr[] = new int[num];
		for (int i = 0; i < num; i++) {
			arr[i]=sc.nextInt();
		}
		
		
		
		boolean a = np(arr);
		
		if(a) {
			for(int i=0;i<arr.length;i++) {
				System.out.print(arr[i]+" ");
			}
			
		}else {
			System.out.println(-1);
		}
	}

	private static boolean np(int[] arr) {
		
		int N = arr.length;
		int i = N-1;
		
		while(i>0 && arr[i-1] < arr[i]) {
			--i;
		}
		
		
		if(i==0) {
			return false;
		}
		
		int j = N-1;
		while(arr[i-1] < arr[j]) {
			--j;
		}
		
		
		int temp = arr[i-1];
		arr[i-1] = arr[j];
		arr[j]= temp;
		
		
		int k= N-1;
		while(i<k) {
			temp = arr[i];
			arr[i]=arr[k];
			arr[k]=temp;
			i++;
			k--;
		}
		
		
		
		
		
		return true;
	}

}