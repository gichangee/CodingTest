

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * @author 박기창 SWEA_2805_D3_농작물 수확하기_박기창.java
 * 아이디어 : 배열의 길이을 2로 나눠서 나온 몫값을 이용해서 풀기
 */
class Solution {
	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());

		for (int test_case = 1; test_case <= T; test_case++) {
			int t = Integer.parseInt(br.readLine());

			int[][] arr = new int[t][t];
			for (int i = 0; i < t; i++) {
				st = new StringTokenizer(br.readLine());
				String s = st.nextToken();
				String[] split = s.split("");
				for (int j = 0; j < t; j++) {
					arr[i][j] = Integer.parseInt(split[j]);
				}
			}

			//농작물을 수확할 수 있는 곳에있는 값만 저장한 변수
			int sum = 0;

			//t를 2로 나눈 값을 이용해서 인덱스 중간까지 검색이 되도록 한다.
			int size = t / 2;
			// 가운데 줄을 기준으로 위에 있는 그룹에서 조건에 해당되는 값 더하는 반복문
			for (int i = 0; i < size; i++) {

				//size값을 이용해 중간까지 검색
				for (int j = 0; j <= size; j++) {
					if (i + j >= size) {
						sum += arr[i][j];
					}
				}

				//중간 이후에 값 중 i값이 계속 1씩 증가하는 것을 이용해서 값을 더한다.
				for (int j = size + 1; j < i + size + 1; j++) {
					sum += arr[i][j];

				}
			}

			//가운데 줄은 반드시 더해야하기에 그냥 size값을 이용하여 가운데 줄에 있는 값을 모두 더한다.
			for (int i = 0; i < t; i++) {
				sum += arr[size][i];
			}

			//변수를 하나 이용해서 중간 이후에 값을 탐색할 때 1씩 빼준다.
			int q = 1;
			for (int i = size + 1; i < t; i++) {

				//중간까지 값 탐색
				int k = i - size;
				for (int j = k; j <= size; j++) {
					sum += arr[i][j];
				}

				//중간 이후에 값 탐색
				for (int j = size + 1; j < t - q; j++) {
					sum += arr[i][j];
				}
				q++;

			}

			// 저장해놓은 값 출력
			System.out.println("#" + test_case + " " + sum);
		}

	}
}