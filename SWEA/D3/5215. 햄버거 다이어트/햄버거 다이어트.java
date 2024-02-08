import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

	static List<int[]> list;
	static int[][] temp;
	static int cnt;
	static int max;
	static int maxkal;
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();


		for(int test_case = 1; test_case <= T; test_case++)
		{
		
			cnt = sc.nextInt();
			maxkal = sc.nextInt();
			
			list = new ArrayList<>();		
			
			for(int i=0;i<cnt;i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				list.add(new int[] {a,b});
			}
			
			temp = new int[cnt][2];
			max = Integer.MIN_VALUE;
			for(int i=1;i<=cnt;i++) {
				loop(0,0,i);
			}
			System.out.println("#"+test_case+" "+max);

		}
	}

	private static void loop(int depth, int a,int c) {

		if(depth == c) {
			int sum = 0;
			int sum2 = 0;
			for(int i=0;i<cnt;i++) {
				
				sum+=temp[i][0];
				sum2+=temp[i][1];
			}
			if(sum2<=maxkal) {
				if(max<=sum) {
					max=sum;
				}
			}
			
			
			return;
		}else {
			for(int i = a; i<cnt;i++) {
				temp[depth][0]=list.get(i)[0];
				temp[depth][1]=list.get(i)[1];
				loop(depth+1,i+1,c);
			}
		}
	}

}