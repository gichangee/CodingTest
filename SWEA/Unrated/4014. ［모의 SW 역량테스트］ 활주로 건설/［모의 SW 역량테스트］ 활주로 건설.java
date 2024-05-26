import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int TC = 1; TC <= T; TC++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int X = Integer.parseInt(st.nextToken());

			int[][] arr = new int[N][N];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int count = 0;

			// 가로
			// 값이 진행하다가 달라졌을 때만 진행
			boolean[][] v = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				int first = arr[i][0];
				boolean a = true;
				for (int j = 1; j < N; j++) {
					// 활주로 건설이 안되는 경우에는 그냥 다음 행으로 넘어가기
					if (!a) {
						break;
					}
					int k = X;
					int length = 0;
					// 같다면 넘어가기
					if (first == arr[i][j]) {
						continue;
					}
					// 앞에 값보다 크다면
					// 앞에가 경사로가 설치되는지 검사
					else if (first - arr[i][j] == -1) {
						int c = 0;
						for (int z = j - 1; z >= 0 && k > 0; z--, k--) {
							if (first != arr[i][z]) {
								a = false;
								break;
							} else if (v[i][z]) {
								a = false;
								break;
							} else {
								v[i][z] = true;
								c++;
							}
						}
						first = arr[i][j];
						if (c != X) {
							a = false;
							break;
						}
					}
					// 앞에 값보다 작다면
					// 뒤에게 경사로가 설치 되는지 검사
					else if (first - arr[i][j] == 1) {
						first = arr[i][j];
						int c = 0;
						// 그냥 x만큼 반복 돌리면 되는거 아님
						// x만큼 못 돌면 경사로 못만든거
						for (int z = 0; z < X && j < N; z++, j++) {
							if (first != arr[i][j]) {
								a = false;
								break;
							} else {
								v[i][j] = true;
								c++;
							}
						}
						j--;
						if (c != X) {
							a = false;
						}
					} else {
						a = false;
						break;
					}
				}
				if (a) {
					count++;
				}

			}

			// 세로
			v = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				int first = arr[0][i];
				boolean a = true;
				for (int j = 1; j < N; j++) {
					if (!a) {
						break;
					}
					int k = X;
					int length = 0;
					// 같다면 넘어가기
					if (first == arr[j][i]) {
						continue;
					}
					
					
					// 앞에 값보다 크다면
					// 앞에가 경사로가 설치되는지 검사
					else if (first - arr[j][i] == -1) {
						int c = 0;
						for (int z = j - 1; z >= 0 && k > 0; z--, k--) {
							if (first != arr[z][i]) {
								a = false;
								break;
							} else if (v[z][i]) {
								a = false;
								break;
							} else {
								v[z][i] = true;
								c++;
							}
						}
						first = arr[j][i];
						if (c != X) {
							a = false;
							break;
						}
					}
					// 앞에 값보다 작다면
					// 뒤에게 경사로가 설치 되는지 검사
					else if (first - arr[j][i] == 1) {
						first = arr[j][i];
						int c = 0;
						// 그냥 x만큼 반복 돌리면 되는거 아님
						// x만큼 못 돌면 경사로 못만든거
						for (int z = 0; z < X && j < N; z++, j++) {
							if (first != arr[j][i]) {
								a = false;
								break;
							} else {
								v[j][i] = true;
								c++;
							}
						}
						j--;
						if (c != X) {
							a = false;
						}
					} else {
						a = false;
						break;
					}
				}
				
				if (a) {
					count++;
				}
			}

			System.out.println("#" + TC + " " + count);
		}
	}

}