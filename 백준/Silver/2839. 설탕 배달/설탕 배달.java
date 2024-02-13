import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
	
		
		int num= sc.nextInt();
		int fivecount=0;
		int cnt=0;
		boolean c= false;
		int min=Integer.MAX_VALUE;
		
		boolean a = false;
		while(5*fivecount <= num) {
			cnt=0;
			int n = num-5*fivecount;
			
			
			cnt +=n/3;
			
			if(n%3 > 0) {
				a=false;
				fivecount++;
				continue;
			}
			
			if(n%3 == 0) {
				a=true;
			}
			
			
			if(a) {
				c=true;
			}
			
			cnt+=fivecount;
			
			if(min > cnt) {
				min = cnt;
			}
			
			fivecount++;
		}
		
		
		if(c) {
			System.out.println(min);
		}else {
			System.out.println(-1);
		}

		
		
	}

}