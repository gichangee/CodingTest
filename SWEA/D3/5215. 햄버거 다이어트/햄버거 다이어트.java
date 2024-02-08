import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author 박기창 조합을 이용해서 풀면 될 듯
 * 
 */
public class Solution {

	static List<int[]> list;
	static int[][] temp;
	static int cnt;
	static int max;
	static int maxkal;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		// 테스트케이스 입력받기
		for (int test_case = 1; test_case <= T; test_case++) {

			// 재료개수
			cnt = sc.nextInt();
			// 최대 칼로리
			maxkal = sc.nextInt();

			list = new ArrayList<>();

			// 모든 재료 입력 받기
			for (int i = 0; i < cnt; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				list.add(new int[] { a, b });
			}

			// 조합값 담을 배열 생성
			temp = new int[cnt][2];

			// 최댓값 담을 변수 생성
			max = Integer.MIN_VALUE;

			// i==r 5C1 5C2 5C3 5C4 5C5 모두 탐색
			for (int i = 1; i <= cnt; i++) {
				loop(0, 0, i);
			}
			System.out.println("#" + test_case + " " + max);

		}
	}

	private static void loop(int depth, int a, int c) {

		// 종료조건 만약 깊이가 해당 길이에 도달하면
		if (depth == c) {
			int sum = 0;
			int sum2 = 0;
			// 해당 조합으로 만들 수 있는 값 모두 더하기
			for (int i = 0; i < cnt; i++) {

				sum += temp[i][0];
				sum2 += temp[i][1];
			}

			// 모두 더한값이 최대 칼로리 보다 작고 max값보다 크면 max값 업데이트
			if (sum2 <= maxkal) {
				if (max <= sum) {
					max = sum;
				}
			}

			return;
			//아니라면 깊이가 될 때까지 값 모두 더하기
		} else {
			for (int i = a; i < cnt; i++) {
				temp[depth][0] = list.get(i)[0];
				temp[depth][1] = list.get(i)[1];
				loop(depth + 1, i + 1, c);
			}
		}
	}

}