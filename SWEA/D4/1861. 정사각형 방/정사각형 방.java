import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;


/**
 * @author 박기창
 * dfs를 사용하면 쉽게 풀릴 것 이라고 생각
 */
public class Solution {


	static int[][] arr;
	static boolean[][] v;
	static int[] dx, dy;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());

		// 상하좌우
		dx = new int[] { -1, 1, 0, 0 };
		dy = new int[] { 0, 0, -1, 1 };

		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			
			//배열의 크기 입력받기
			int size = Integer.parseInt(st.nextToken());

			//배열 생성 및 dfs 니까 방문 배열도 생성
			arr = new int[size][size];
			v = new boolean[size][size];
			
			//배열 데이터 입력받기
			for (int i = 0; i < size; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < size; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			//최대 움직일 수 있는 거리
			int len = 0;
			
			//최대 움직일 수 있는 거리 비교 값
			int max = 0;
			
			//만약 길이가 같은 경우 좀 더 작은 값을 넣기 위한 값
			int value = Integer.MAX_VALUE;
			
			//모든 배열에 있는 값 들리기
			for (int i = 0; i < size; i++) {

				for (int j = 0; j < size; j++) {
					
					//시작 배열에서 가장 많이 갈 수 있는 거리 리턴
					len = dfs(i, j, 1);
					
					//만약 max보다 크면 max 대체 및 value 값 업데이트
					if (len > max) {
						value = arr[i][j];
						max = len;
						//만약 max값과 같다면 value 값만 업데이트
					} else if (len == max) {
						if (value >= arr[i][j]) {
							value = arr[i][j];
						}
					}
					
					//방문 배열 초기화
					v = new boolean[size][size];
				}
			}

			System.out.println("#" + test_case + " " + value + " " + max);

		}

	}

	private static int dfs(int x, int y, int cnt) {

		//시작 할 때 방문 배열 체크
		v[x][y] = true;
		int c = 0;
		
		//상하좌우 들리기
		for (int i = 0; i < 4; i++) {

			int gox = x + dx[i];
			int goy = y + dy[i];

			
			//범위를 벗어나거나 조건이 충족되는지 확인
			if (gox >= 0 && goy >= 0 && gox < arr.length && goy < arr.length && !v[gox][goy]
					&& arr[x][y] + 1 == arr[gox][goy]) {

				
				//확인 되면 방문배열 체크
				v[gox][goy] = true;
				
				//길이 늘리기
				cnt++;

				//재귀
				c = dfs(gox, goy, cnt);
			} else {
				
				//조건이 안맞으면 continue
				continue;
			}

		}

		return Math.max(c,cnt);
	}

}