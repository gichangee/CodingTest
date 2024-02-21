import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static class Node {
		int y;
		int x;
		int value;
		int[] direction;

		public Node(int y, int x, int value, int[] direction) {
			
			this.y = y;
			this.x = x;
			this.value = value;
			this.direction = direction;
		}

	}

	static int[][] arr;
	static int[][] copy;
	static int min;
	static List<Node> list;
	static int[] temp;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int y = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());

		arr = new int[y][x];
		copy = new int[y][x];

		list = new ArrayList<>();

		for (int i = 0; i < y; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < x; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				copy[i][j] = arr[i][j];
				if (arr[i][j] != 0 && arr[i][j] != 6) {
					if (arr[i][j] == 2) {
						list.add(new Node(i, j, arr[i][j], new int[] { 1, 2 }));
					} else if (arr[i][j] == 5) {
						list.add(new Node(i, j, arr[i][j], new int[] { 1 }));
					} else {
						list.add(new Node(i, j, arr[i][j], new int[] { 1, 2, 3, 4 }));
					}

				}
			}
		}

		min = Integer.MAX_VALUE;
		temp = new int[list.size()];

		combine(0, 0);

		System.out.println(min);

	}

	private static void combine(int cnt, int start) {

		if (cnt == list.size()) {

			
			int sum = 0;
			for (int i = 0; i < temp.length; i++) {

				if (list.get(i).value == 1) {
					int x = list.get(i).x;
					int y = list.get(i).y;
					// 상
					if (temp[i] == 1) {
						for (int j = y - 1; j >= 0; j--) {
							if (arr[j][x] == 6) {
								break;
							} else if (arr[j][x] != 0) {
								continue;
							}
							arr[j][x] = 7;
						}
						// 하
					} else if (temp[i] == 2) {

						for (int j = y + 1; j < arr.length; j++) {

							if (arr[j][x] == 6) {
								break;
							} else if (arr[j][x] != 0) {
								continue;
							}
							arr[j][x] = 7;
						}
						// 좌
					} else if (temp[i] == 3) {

						for (int j = x - 1; j >= 0; j--) {

							if (arr[y][j] == 6) {
								break;
							} else if (arr[y][j] != 0) {
								continue;
							}
							arr[y][j] = 7;
						}

						// 우
					} else if (temp[i] == 4) {

						for (int j = x + 1; j < arr[0].length; j++) {
							if (arr[y][j] == 6) {
								break;
							} else if (arr[y][j] != 0) {
								continue;
							}
							arr[y][j] = 7;
						}

					}

				} else if (list.get(i).value == 2) {
					int x = list.get(i).x;
					int y = list.get(i).y;
					// 좌우
					if (temp[i] == 1) {

						for (int j = x - 1; j >= 0; j--) {
							if (arr[y][j] == 6) {
								break;
							} else if (arr[y][j] != 0) {
								continue;
							}
							arr[y][j] = 7;
						}

						for (int j = x + 1; j < arr[0].length; j++) {
							if (arr[y][j] == 6) {
								break;
							} else if (arr[y][j] != 0) {
								continue;
							}
							arr[y][j] = 7;
						}
						// 상하
					} else if (temp[i] == 2) {
						for (int j = y - 1; j >= 0; j--) {
							if (arr[j][x] == 6) {
								break;
							} else if (arr[j][x] != 0) {
								continue;
							}
							arr[j][x] = 7;
						}

						for (int j = y + 1; j < arr.length; j++) {

							if (arr[j][x] == 6) {
								break;
							} else if (arr[j][x] != 0) {
								continue;
							}
							arr[j][x] = 7;
						}
					}

				} else if (list.get(i).value == 3) {
					int x = list.get(i).x;
					int y = list.get(i).y;
					// 상우
					if (temp[i] == 1) {
						for (int j = y - 1; j >= 0; j--) {
							if (arr[j][x] == 6) {
								break;
							} else if (arr[j][x] != 0) {
								continue;
							}
							arr[j][x] = 7;
						}

						for (int j = x + 1; j < arr[0].length; j++) {
							if (arr[y][j] == 6) {
								break;
							} else if (arr[y][j] != 0) {
								continue;
							}
							arr[y][j] = 7;
						}

						// 우하
					} else if (temp[i] == 2) {
						for (int j = x + 1; j < arr[0].length; j++) {
							if (arr[y][j] == 6) {
								break;
							} else if (arr[y][j] != 0) {
								continue;
							}
							arr[y][j] = 7;
						}

						for (int j = y + 1; j < arr.length; j++) {

							if (arr[j][x] == 6) {
								break;
							} else if (arr[j][x] != 0) {
								continue;
							}
							arr[j][x] = 7;
						}

						// 하좌
					} else if (temp[i] == 3) {

						for (int j = y + 1; j < arr.length; j++) {

							if (arr[j][x] == 6) {
								break;
							} else if (arr[j][x] != 0) {
								continue;
							}
							arr[j][x] = 7;
						}

						for (int j = x - 1; j >= 0; j--) {
							if (arr[y][j] == 6) {
								break;
							} else if (arr[y][j] != 0) {
								continue;
							}
							arr[y][j] = 7;
						}

						// 좌상
					} else if (temp[i] == 4) {

						for (int j = x - 1; j >= 0; j--) {
							if (arr[y][j] == 6) {
								break;
							} else if (arr[y][j] != 0) {
								continue;
							}
							arr[y][j] = 7;
						}

						for (int j = y - 1; j >= 0; j--) {
							if (arr[j][x] == 6) {
								break;
							} else if (arr[j][x] != 0) {
								continue;
							}
							arr[j][x] = 7;
						}

					}

				} else if (list.get(i).value == 4) {
					int x = list.get(i).x;
					int y = list.get(i).y;
					// 좌상우
					if (temp[i] == 1) {
						for (int j = x - 1; j >= 0; j--) {
							if (arr[y][j] == 6) {
								break;
							} else if (arr[y][j] != 0) {
								continue;
							}
							arr[y][j] = 7;
						}

						for (int j = y - 1; j >= 0; j--) {
							if (arr[j][x] == 6) {
								break;
							} else if (arr[j][x] != 0) {
								continue;
							}
							arr[j][x] = 7;
						}
						for (int j = x + 1; j < arr[0].length; j++) {
							if (arr[y][j] == 6) {
								break;
							} else if (arr[y][j] != 0) {
								continue;
							}
							arr[y][j] = 7;
						}

						// 상우하
					} else if (temp[i] == 2) {
						for (int j = y - 1; j >= 0; j--) {
							if (arr[j][x] == 6) {
								break;
							} else if (arr[j][x] != 0) {
								continue;
							}
							arr[j][x] = 7;
						}
						
						for (int j = x + 1; j < arr[0].length; j++) {
							if (arr[y][j] == 6) {
								break;
							} else if (arr[y][j] != 0) {
								continue;
							}
							arr[y][j] = 7;
						}
						
						for (int j = y + 1; j < arr.length; j++) {

							if (arr[j][x] == 6) {
								break;
							} else if (arr[j][x] != 0) {
								continue;
							}
							arr[j][x] = 7;
						}

						// 우하좌
					} else if (temp[i] == 3) {
						
						for (int j = x + 1; j < arr[0].length; j++) {
							if (arr[y][j] == 6) {
								break;
							} else if (arr[y][j] != 0) {
								continue;
							}
							arr[y][j] = 7;
						}
						
						for (int j = y + 1; j < arr.length; j++) {

							if (arr[j][x] == 6) {
								break;
							} else if (arr[j][x] != 0) {
								continue;
							}
							arr[j][x] = 7;
						}
						
						for (int j = x - 1; j >= 0; j--) {
							if (arr[y][j] == 6) {
								break;
							} else if (arr[y][j] != 0) {
								continue;
							}
							arr[y][j] = 7;
						}


						// 하좌상
					} else if (temp[i] == 4) {
						
						for (int j = y + 1; j < arr.length; j++) {

							if (arr[j][x] == 6) {
								break;
							} else if (arr[j][x] != 0) {
								continue;
							}
							arr[j][x] = 7;
						}
						
						for (int j = x - 1; j >= 0; j--) {
							if (arr[y][j] == 6) {
								break;
							} else if (arr[y][j] != 0) {
								continue;
							}
							arr[y][j] = 7;
						}
						
						for (int j = y - 1; j >= 0; j--) {
							if (arr[j][x] == 6) {
								break;
							} else if (arr[j][x] != 0) {
								continue;
							}
							arr[j][x] = 7;
						}

					}

				} else if (list.get(i).value == 5) {
					int x = list.get(i).x;
					int y = list.get(i).y;
					// 상하좌우
					if (temp[i] == 1) {

						for (int j = x; j >= 0; j--) {
							if (arr[y][j] == 6) {
								break;
							} else if (arr[y][j] != 0) {
								continue;
							}
							arr[y][j] = 7;
						}

						for (int j = x; j < arr[0].length; j++) {
							if (arr[y][j] == 6) {
								break;
							} else if (arr[y][j] != 0) {
								continue;
							}
							arr[y][j] = 7;
						}

						for (int j = y; j >= 0; j--) {
							if (arr[j][x] == 6) {
								break;
							} else if (arr[j][x] != 0) {
								continue;
							}
							arr[j][x] = 7;
						}

						for (int j = y; j < arr.length; j++) {

							if (arr[j][x] == 6) {
								break;
							} else if (arr[j][x] != 0) {
								continue;
							}
							arr[j][x] = 7;
						}
					}
				}
			}
			

			
			for(int i=0;i<arr.length;i++) {
				for(int j=0;j<arr[0].length;j++) {
					if(arr[i][j]==0) {
						sum++;
					}
				}
			}
			if (sum <= min) {
				min = sum;
			}

			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr[0].length; j++) {
					arr[i][j] = copy[i][j];
				}
			}

		} else {

			for (int i = start; i < list.size(); i++) {
				if (list.get(cnt).value == 2) {
					for (int i2 = 0; i2 < 2; i2++) {
						temp[cnt] = list.get(cnt).direction[i2];
						combine(cnt + 1, i + 1);
					}
				} else if (list.get(cnt).value == 5) {
					temp[cnt] = list.get(i).direction[0];
					combine(cnt + 1, i + 1);
				} else {
					for (int i2 = 0; i2 < 4; i2++) {
						temp[cnt] = list.get(cnt).direction[i2];
						combine(cnt + 1, i + 1);
					}
				}
			}

		}
	}

}