import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @author 박기창 dfs사용하기
 */
public class Solution {

	// 상하좌우
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };
	static int[] temp;
	static int N;
	static int[][] arr;
	static int min;
	static int corecnt;
	static List<int[]> list;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			list = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());

					// 가장자리에 있는 전원은 무시하기
					if (arr[i][j] == 1 && i > 0 && j > 0 && j < N - 1 && i < N - 1) {
						list.add(new int[] { i, j });
					}
				}
			}

			// 코어 개수 초기화
			corecnt = Integer.MIN_VALUE;

			// 최소 길이 초기화
			min = Integer.MAX_VALUE;
			loop(0, 0, 0);

			System.out.println("#" + test_case + " " + min);

		}
	}

	private static void loop(int cnt, int maxcorecnt, int len) {

		if (cnt == list.size()) {

			// 만약 최대 코어 개수가 원래 코어 개수보다 크다면 코어 개수 업데이트 + 길이 업데이트
			if (maxcorecnt > corecnt) {

				corecnt = maxcorecnt;
				min = len;

				// 만약 최대 코어 개수가 같을 때는 길이가 더 짧은 걸 선택
			} else if (maxcorecnt == corecnt) {

				if (min > len) {
					min = len;
				}
			}

			return;
		} else {
			
			//cnt번째 코어 위치
			int y = list.get(cnt)[0];
			int x = list.get(cnt)[1];
			
			//4가지 방향 탐색
			for (int i = 0; i < 4; i++) {
				
				//전선 길이을 위한 변수 선언
				int ny = y;
				int nx = x;
				
				//배열 업데이트를 위한 변수 선언
				int sy = y;
				int sx = x;
				
				//전선길이 변수
				int count = 0;
				
				//다른 코어를 만나거나 벽을 만날때까지 반복
				while (true) {
					ny += dy[i];
					nx += dx[i];

					//벽을 만나면 해당 길이 값 들고 종료
					if (ny < 0 || nx < 0 || ny >= N || nx >= N) {
						break;
					}
					
					//코어를 만나면 길이 값 0으로 초기화 하고 종료
					if (arr[ny][nx] == 1) {
						count = 0;
						break;
					}
					count++;

				}

				//만약 길이가 0이면 코어개수와 길이를 늘리지 않고 다음 코어로 넘어가기 
				if (count == 0) {
					loop(cnt + 1, maxcorecnt, len);
					
					//길이가 0이 아니라면 배열에 전선 업데이트 해주고 
					//코어개수 +1 과 길이+count만큼 해준다음 다음 코어로 넘어가기
				} else {

					for (int j = 0; j < count; j++) {
						sy += dy[i];
						sx += dx[i];
						arr[sy][sx] = 1;
					}

					loop(cnt + 1, maxcorecnt + 1, len + count);

					
					//dfs탐색이 끝나고 해당 코어에서 뻗혀나간 전선 다시 원상복귀 시키기
					sy = y;
					sx = x;

					for (int j = 0; j < count; j++) {
						sy += dy[i];
						sx += dx[i];
						arr[sy][sx] = 0;
					}
				}

			}
		}
	}

}