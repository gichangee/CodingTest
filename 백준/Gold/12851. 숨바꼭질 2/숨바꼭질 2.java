import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();

		int count = 0;
		int result = 100001;

		boolean[] v = new boolean[100001];

		if (n >= k) {
			System.out.println(n - k);
			System.out.println(1);
			return;
		}

		Queue<int[]> q = new ArrayDeque<>();

		q.add(new int[] { n, 0 });

		v[n]=true;
		while (!q.isEmpty()) {
			int[] temp = q.poll();

			v[temp[0]]=true;
			if (temp[0] == k) {
				if(result>=temp[1]) {
					result = temp[1];
					count++;
				}
				
			}

			for (int i = 0; i < 3; i++) {
				if (i == 0) {
					int x = temp[0]-1;
					if (x>=0 && x<=100000 && !v[x]) {
						q.add(new int[] { x, temp[1] + 1 });
						if(x == k) {
							v[x]=false;
						}
					}

				} else if (i == 1) {
					int x = temp[0]+1;
					if (x>=0 && x<=100000 && !v[x]) {
						q.add(new int[] { x, temp[1] + 1 });
						if(x == k) {
							v[x]=false;
						}
					}
				} else if (i == 2) {
					int x = temp[0]*2;
					if (x>=0 && x<=100000 && !v[x]) {
						q.add(new int[] { x, temp[1] + 1 });
						if(x == k) {
							v[x]=false;
						}
					}
				}
			}
		}
		System.out.println(result);
		System.out.println(count);

	}

}