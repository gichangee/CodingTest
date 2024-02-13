import java.util.Arrays;
import java.util.Scanner;

/**
 * @author 박기창
 * 정렬사용하기
 */
public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int initlen = sc.nextInt();
		
		
		int[] arr= new int[num];
		for(int i=0;i<num;i++) {
			arr[i]=sc.nextInt();
		}
		
		
		//과일을 올림차순으로 정렬
		Arrays.sort(arr);
		
		
		//과일이 길이보다 작거나 같으면 먹고 먹었을 때 길이 +1 해주기
		for(int i=0;i<arr.length;i++) {
			if(initlen >= arr[i]) {
				initlen++;
			}
		}
		
		System.out.println(initlen);
		
		
	}

}