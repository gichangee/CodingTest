import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

	
	static List<Integer> list;
	static int[] temp;
	static int count;
	static int[] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
	

		for(int test_case = 1; test_case <= T; test_case++)
		{
			count = sc.nextInt();
			int kg = sc.nextInt();
			
			arr = new int[count];
			for(int i=0;i<count;i++) {
				arr[i]=sc.nextInt();
			}
			
			int sum=-1;
			temp = new int[2];
			list = new ArrayList<>();
			loop(0,0);
			
			for(int i=0;i<list.size();i++) {
				if(list.get(i)<=kg && sum<=list.get(i)) {
					sum=list.get(i);
				}
			}
			
			System.out.println("#"+test_case+" "+sum);
		

		}

	}

	private static void loop(int cnt, int a) {
		if(cnt == 2) {
			int s = 0;
			s=temp[0]+temp[1];
			list.add(s);
			return;
		}else {
			for(int i=a;i<count;i++) {
				temp[cnt]=arr[i];
				loop(cnt+1,i+1);
				
			}
		}
		
	}

}