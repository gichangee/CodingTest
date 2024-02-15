import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= t; test_case++) {

			StringTokenizer st = new StringTokenizer(br.readLine());

			int H = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());

			String[][] arr = new String[H][W];

			int x = 0;
			int y = 0;

			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine());
				String s = st.nextToken();
				String[] split = s.split("");
				for (int j = 0; j < W; j++) {
					arr[i][j] = split[j];

					switch (arr[i][j]) {
					case "<":
						x = i;
						y = j;
						break;
					case ">":
						x = i;
						y = j;
						break;
					case "^":
						x = i;
						y = j;
						break;
					case "v":
						x = i;
						y = j;
						break;
					default:
						break;
					}
				}
			}

			int cnt = Integer.parseInt(br.readLine());

			String[] command = new String[cnt];

			String s = br.readLine();
			String[] split = s.split("");

			for (int i = 0; i < cnt; i++) {
				command[i] = split[i];
			}

			for (int i = 0; i < cnt; i++) {
				switch (command[i]) {
				case "U":
					if ((x - 1) >= 0 && arr[x - 1][y].equals(".")) {
						arr[x - 1][y] = "^";
						arr[x][y] = ".";
						x = x - 1;
					} else {
						arr[x][y] = "^";
					}
					break;
				case "D":

					if ((x + 1) < H && arr[x + 1][y].equals(".")) {
						arr[x + 1][y] = "v";
						arr[x][y] = ".";
						x = x + 1;
					} else {
						arr[x][y] = "v";
					}
					break;
				case "L":
					if ((y - 1) >= 0 && arr[x][y - 1].equals(".")) {
						arr[x][y - 1] = "<";
						arr[x][y] = ".";
						y = y - 1;
					} else {
						arr[x][y] = "<";
					}

					break;
				case "R":
					if ((y + 1) < W && arr[x][y + 1].equals(".")) {
						arr[x][y + 1] = ">";
						arr[x][y] = ".";
						y = y + 1;
					} else {
						arr[x][y] = ">";
					}
					break;
				case "S":
					if (arr[x][y].equals("<")) {
						for (int j = y; j >= 0; j--) {
							if (arr[x][j].equals("#")) {
								break;
							} else if (arr[x][j].equals("*")) {
								arr[x][j] = ".";
								break;
							}
						}
					} else if (arr[x][y].equals(">")) {
						for (int j = y; j < W; j++) {
							if (arr[x][j].equals("#")) {
								break;
							} else if (arr[x][j].equals("*")) {
								arr[x][j] = ".";
								break;
							}
						}

					} else if (arr[x][y].equals("^")) {

						for (int j = x; j >= 0; j--) {
							if (arr[j][y].equals("#")) {
								break;
							} else if (arr[j][y].equals("*")) {
								arr[j][y] = ".";
								break;
							}
						}

					} else if (arr[x][y].equals("v")) {
						for (int j = x + 1; j < H; j++) {
							if (arr[j][y].equals("#")) {
								break;
							} else if (arr[j][y].equals("*")) {
								arr[j][y] = ".";
								break;
							}
						}
					}

				}
			}

			System.out.print("#" + test_case + " ");
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					System.out.print(arr[i][j]);
				}
				System.out.println();
			}
		}
	}

}