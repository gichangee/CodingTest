import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
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

			
			
			
			// 가로줄 검사
			for (int i = 0; i < N; i++) {

				boolean[][] v = new boolean[N][N];
				// 왼쪽 -> 오른쪽
				// 가로줄 첫번째 값
				int temp = arr[i][0];
				Lable: for (int j = 1; j < N; j++) {
					// 만약 비교값과 진행값이 같으면 그대로 넘어가기
					if (temp == arr[i][j]) {
						// 비교값 업데이트
						temp = arr[i][j];
						if (j == N - 1) {
							count++;
						}
						continue;
						// 만약 비교값보다 진행값이 더 크다면 현재 비교값 위치부터
						// 뒤로 경사로가 설치되는지 확인해보기
						// 설치 안되면 그대로 해당줄은 탈락!
					} else if (arr[i][j] - temp == 1) {
						int len = 0;
						
						for (int z = j - 1; z >= 0; z--) {
							
							if (temp == arr[i][z] && !v[i][z]) {
								v[i][z]=true;
								len++;
							}
							// 경사로가 만들어지면 반복문 빠져나가기 temp값 업데이트
							if (len == X) {
								temp = arr[i][j];
								break;
							}
							// 만약 경사로가 다 만들어지기전에 끝나면 해당 줄은 탈락
							if (temp != arr[i][z]) {
								break Lable;
							}
						}
						if (len < X) {
							break Lable;
						}

						// 만약 비교값보다 진행값이 더 작다면 현재 진행값 위치부터
						// 앞으로 경사로가 설치되는지 확인하기
						// 설치 안되면 그대로 해당줄은 탈락!
					} else if (temp - arr[i][j] == 1) {
						int len = 1;
						v[i][j]=true;
						for (int z = j + 1; z < N; z++) {
							if (arr[i][j] == arr[i][z] && !v[i][z]) {
								v[i][z]=true;
								len++;
							}

							if (len == X) {
								temp = arr[i][j];
								break;
							}
							if (arr[i][j] != arr[i][z]) {
								break Lable;
							}
						}
						if (len < X) {
							break Lable;
						}
					} else {
						break Lable;
					}
					
					if (j == N - 1) {
						count++;
					}

				}

			}

			// 세로줄 검사
			for (int i = 0; i < N; i++) {
				boolean[][] v = new boolean[N][N];
				// 위 -> 아래
				// 세로줄 첫번째 값
				int temp = arr[0][i];
				Lable: for (int j = 1; j < N; j++) {
					
					// 만약 비교값과 진행값이 같으면 그대로 넘어가기
					if (temp == arr[j][i]) {
						// 비교값 업데이트
						temp = arr[j][i];
						if (j == N - 1) {
							count++;
						}
						continue;
						// 만약 비교값보다 진행값이 더 크다면 현재 비교값 위치부터
						// 뒤로 경사로가 설치되는지 확인해보기
						// 설치 안되면 그대로 해당줄은 탈락!
					} else if (arr[j][i] - temp == 1) {
						int len = 0;
						for (int z = j - 1; z >= 0; z--) {

							if (temp == arr[z][i]  && !v[z][i]) {
								v[z][i] = true;
								len++;
							}
							// 경사로가 만들어지면 반복문 빠져나가기 temp값 업데이트
							if (len == X) {
								temp = arr[j][i];
								break;
							}
							// 만약 경사로가 다 만들어지기전에 끝나면 해당 줄은 탈락
							if (temp != arr[z][i]) {
								break Lable;
							}
						}
						if (len < X) {
							break Lable;
						}

						// 만약 비교값보다 진행값이 더 작다면 현재 진행값 위치부터
						// 앞으로 경사로가 설치되는지 확인하기
						// 설치 안되면 그대로 해당줄은 탈락!
					} else if (temp - arr[j][i] == 1) {
						int len = 1;
						v[j][i] = true;
						for (int z = j + 1; z < N; z++) {
							if (arr[j][i] == arr[z][i] && !v[z][i]) {
								v[z][i]=true;
								len++;
							}

							if (len == X) {
								temp = arr[j][i];
								break;
							}
							if (arr[j][i] != arr[z][i]) {
								break Lable;
							}
						}
						if (len < X) {
							break Lable;
						}
					} else {
						break Lable;
					}

					if (j == N - 1) {
						count++;
					}

				}

			}

			System.out.println("#" + tc + " " + count);
		}

	}

}