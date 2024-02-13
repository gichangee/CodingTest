import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	static int player1win;
	static int player2win;
	static int[] arr,arr2;
	static int[] temp;
	static boolean[] v;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			
			player1win = 0;
			player2win = 0;
			arr = new int[9];
			v= new boolean[9];
			boolean[] v = new boolean[19];
			for (int i = 0; i < 9; i++) {
				arr[i] = sc.nextInt();
				v[arr[i]] = true;
			}

			arr2 = new int[9];
			for (int i = 1, k = 0; i < 19; i++) {
				if (!v[i]) {
					arr2[k++] = i;
				}
			}

			temp = new int[arr2.length];
			loop(0);

			System.out.println("#" + test_case + " " + player1win + " " + player2win);

		}

	}

	private static void loop(int cnt) {
		if (cnt == 9) {

			int play1sum=0;
			int play2sum=0;
			for(int i=0;i<9;i++) {
				if(arr[i]>temp[i]) {
					play1sum+=arr[i]+temp[i];
				}else if(arr[i]<temp[i]) {
					play2sum+=arr[i]+temp[i];
				}else {
					continue;
				}
			}
			
			if(play1sum > play2sum) {
				player1win++;
			}else if(play1sum < play2sum){
				player2win++;
			}
			
			
		} else {

			for(int i=0;i<9;i++) {
				if(!v[i]) {
					v[i]=true;
					temp[cnt]=arr2[i];
					loop(cnt+1);
					v[i]=false;
				}
			}
		}
	}

}