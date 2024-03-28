import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();

		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] {n,0});

		
		boolean[] v = new boolean[100001];
		
		int[] t = {1,2,-1};
		
		if(n==k) {
			System.out.println(0);
			System.exit(0);
		}
		
		if(n>k) {
			System.out.println(n-k);
			System.exit(0);
		}
		
		
		while (!q.isEmpty()) {
			int[] temp = q.poll();
			v[temp[0]]=true;
			
			if(temp[0]==k) {
				System.out.println(temp[1]);
				System.exit(0);
			}
			
			
			for(int i=0;i<3;i++) {
	
				if(i==0 && temp[0]+1 <=100000 &&!v[temp[0]+1]) {
					v[temp[0]+1]=true;
					q.add(new int[] {temp[0]+1,temp[1]+1});
				}
				if(i==1 && temp[0]*2 <=100000 &&!v[temp[0]*2]) {
					v[temp[0]*2]=true;
					q.add(new int[] {temp[0]*2,temp[1]+1});
				}
				if(i==2 && temp[0]-1 >=0 &&!v[temp[0]-1]) {
					v[temp[0]-1]=true;
					q.add(new int[] {temp[0]-1,temp[1]+1});
				}
			}
			
		}
	}

}