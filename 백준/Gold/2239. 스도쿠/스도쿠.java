import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int[][] arr;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		arr = new int[9][9];

		for (int i = 0; i < 9; i++) {
			String s = br.readLine();
			String[] split = s.split("");
			for (int j = 0; j < 9; j++) {
				arr[i][j] = Integer.parseInt(split[j]);
			}
		}

		loop(0, 0);

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}

	}

	private static boolean loop(int x, int y) {
		if (x == 9) {
			return true;
		}
		if (y == 9) {
			return loop(x + 1, 0);

		}

		if (arr[x][y] != 0) {
			return loop(x, y + 1);
		}

		else {
			
			 for (int result = 1; result <= 9; result++) {
		            if (!checkbox(x, y, result) && !checkrow(x, y, result) && !checkcol(x, y, result)) {
		                arr[x][y] = result;
		                if (loop(x, y + 1)) {
		                    return true;
		                }
		                arr[x][y] = 0; // Backtrack
		            }
		        }

			
			 return false;

		}

	}

	// 0,1,2 는 첫 줄 삼각형 0,0
	// 3,4,5 는 두줄 삼각형 3,0
	// 6,7,8 은 셋줄 삼각형 6,0
	private static boolean checkbox(int x, int y, int result) {
		int dx = (x / 3) * 3;
		int dy = (y / 3) * 3;

		for (int i = dx; i < dx + 3; i++) {
			for (int j = dy; j < dy + 3; j++) {
				if (result == arr[i][j]) {
					return true;
				}
			}
		}

		return false;
	}

	private static boolean checkrow(int x, int y, int result) {

		for (int i = 0; i < 9; i++) {
			if (arr[x][i] == result) {
				return true;
			}
		}
		return false;
	}

	private static boolean checkcol(int x, int y, int result) {
		for (int i = 0; i < 9; i++) {
			if (arr[i][y] == result) {
				return true;
			}
		}
		return false;
	}

}