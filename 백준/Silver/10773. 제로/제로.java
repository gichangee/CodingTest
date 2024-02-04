import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		Stack<Integer> stack = new Stack<>();
		for(int i=0;i<n;i++) {
			int num=sc.nextInt();
			if(num == 0) {
				stack.pop();
			}else {
				stack.add(num);
			}
			
		}
		
		int sum=0;
		int size = stack.size();
		for(int i =0 ;i<size;i++) {
			sum+=stack.pop();
		}
		System.out.println(sum);
	}
}