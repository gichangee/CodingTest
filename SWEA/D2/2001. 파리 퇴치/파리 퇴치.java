import java.util.Scanner;

public class Solution {

	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {

			int size = sc.nextInt();
			int killsize = sc.nextInt();

			int[][] arr = new int[size][size];

			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			int max = 0;

			for (int i = 0; i < size-killsize+1; i++) {
				for (int j = 0; j < size-killsize+1; j++) {

					int sum = 0;
					int x = 0;

					for (int k = 0; k < killsize; k++) {
						for (int z = 0; z < killsize; z++) {
							sum += arr[i + x][j + z];
						}
						x++;
					}

					if (sum >= max) {
						max = sum;
					}
				}

			}
			System.out.println("#" + test_case + " " + max);
		}

		

	}
}