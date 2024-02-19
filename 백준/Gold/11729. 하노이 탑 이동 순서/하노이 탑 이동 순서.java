import java.util.Scanner;

public class Main {

	static int cnt=0;
	static StringBuilder sb;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		

		int n = sc.nextInt();

		sb = new StringBuilder();
		
		loop(n, 1, 2, 3);
		System.out.println(cnt);
		System.out.println(sb);
	}

	private static void loop(int n, int start, int mid, int end) {
		cnt++;
		if(n==1) {
			sb.append(start + " " + end+"\n");
			
			
			return;
		}
		
		loop(n-1,start,end,mid);
		sb.append(start + " " + end+"\n");
		loop(n-1, mid, start, end);
	}

}