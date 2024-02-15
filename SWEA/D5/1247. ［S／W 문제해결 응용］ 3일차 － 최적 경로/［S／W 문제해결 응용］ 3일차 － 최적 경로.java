import java.util.Scanner;

public class Solution {
	
	static class road{
		int x;
		int y;
		public road(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
	}
	
	static int min;
	static boolean[] v;
	static int customer;
	static road[] temp,r;
	static int officex,officey,housex,housey;
	public static void main(String args[]) throws Exception
	{
	
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++)
		{
			customer = sc.nextInt();
			officex = sc.nextInt();
			officey = sc.nextInt();
			housex = sc.nextInt();
			housey = sc.nextInt();
			r = new road[customer];
			v= new boolean[customer];
			for(int i=0;i<customer;i++) {
				r[i]= new road(sc.nextInt(), sc.nextInt());
			}
			
			
			min = Integer.MAX_VALUE;
			temp = new road[customer];
			loop(0);
			System.out.println("#"+test_case+" "+min);
		}
	}
	private static void loop(int cnt) {
		if(cnt == customer) {
			
			int len = Math.abs(officex-temp[0].x)+Math.abs(officey-temp[0].y);
			
			for(int i=0;i<customer-1;i++) {
				len += Math.abs(temp[i].x-temp[i+1].x)+Math.abs(temp[i].y-temp[i+1].y);
			}
			
			len+=Math.abs(housex-temp[customer-1].x)+Math.abs(housey-temp[customer-1].y);
			
			if(len <= min) {
				min = len;
			}
			
			return;
		}else {
			for(int i=0;i<customer;i++) {
				if(!v[i]) {
					v[i]=true;
					temp[cnt]=new road(r[i].x,r[i].y);
					loop(cnt+1);
					v[i]=false;
				}
			}
		}
		
	}
}