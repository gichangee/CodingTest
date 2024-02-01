

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author 박기창
 * 부분집합 사용
 * 단, 마지막 공집합은 제외해야되는 사실을 까먹으면 안됨
 */
public class Main {

	static int[] arr1, arr2;
	static int t;
	static boolean[] isSelected;
	static int[] sum1, sum2;
	static int count;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		//재료의 개수를 입력받는다.
		t = Integer.parseInt(st.nextToken());

		arr1 = new int[t];
		arr2 = new int[t];
		isSelected = new boolean[t];

		count = 0;

		// 부분집합의 개수는 2^n이기에 Math 라이브러리의 함수를 사용 부분집합의 개수만큼 배열의 크기 선언
		sum1 = new int[(int) Math.pow(2, t)];
		sum2 = new int[(int) Math.pow(2, t)];

		
		// 각 재료의 신맛과 쓴맛의 데이터를 받는다.
		for (int i = 0; i < t; i++) {
			st = new StringTokenizer(br.readLine());
			arr1[i] = Integer.parseInt(st.nextToken());
			arr2[i] = Integer.parseInt(st.nextToken());
		}

		loop(0);

		//재료를 사용했을 때 최솟값을 찾는 것 이기 때문에 제일 큰값을 일단 설정해 놓는다.
		int small = Integer.MAX_VALUE;
		
		//같은 인덱스 위치에 있는 것 끼리 비교해서 가장 작은 차이를 찾는다.
		//이때 공집합이 맨 뒤에 있으므로 해당 값을 제외한다.
		for (int i = 0; i < sum1.length - 1; i++) {
			if (sum1[i] >= sum2[i]) {
				int x = sum1[i] - sum2[i];
				if (small > x) {
					small = x;
				}
			} else {
				int x = sum2[i] - sum1[i];
				if (small > x) {
					small = x;
				}
			}
		}

		System.out.println(small);
	}

	private static void loop(int cnt) {

		//종료조건 
		//만약 cnt가 재료의 개수만큼 도달하면 해당 배열에있는 신맛은 모두 곱하고 쓴맛은 모두 더한 값을 
		//부분집합의 개수만큼 배열의 크기를 선언한 배열에 차례로 넣는다.
		if (cnt == t) {
			int one = 1;
			int two = 0;
			for (int i = 0; i < t; i++) {
				if (isSelected[i]) {
					one *= arr1[i];
					two += arr2[i];
				}
			}
			sum1[count] = one;
			sum2[count] = two;
			count = count + 1;
			return;

		} else {
			//값을 사용한다고 표시
			isSelected[cnt] = true;
			//해당 값을 사용했을 때 루프 돌기
			loop(cnt + 1);
			//값을 사용안한다고 표시
			isSelected[cnt] = false;
			//해당 값을 사용 안했을 떄 루프 돌기
			loop(cnt + 1);
		}

	}

}
