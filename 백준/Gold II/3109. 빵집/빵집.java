import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 * @author park
 *
 * 깊이우선탐색 사용하기
 */
public class Main {

	static int[] dx;
	static int[] dy;
	static int R, C;
	static char[][] map;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		//행 열 값 입력받기
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];

		
		//띄어쓰기 안되어있는거 한 방에 입력받기
		for(int i=0;i<R;i++) {
			map[i]=br.readLine().toCharArray();
			
		}

		//오른쪽 대각선, 오른쪽, 오른쪽 대각선 아래 방향 순서
		dx = new int[]{-1,0,1};
		dy = new int[]{1,1,1};
		
		int count =0;
		for(int i=0;i<R;i++) {
			//불린값리턴 받는 dfs 만들기
			boolean result = loop(i,0);
			if(result) {
				count++;
			}
		}
		
		System.out.println(count);
		
		
		
		
	}

	private static boolean loop(int r, int c) {

		//만약 오른쪽 맨 끝 열에 도달하면 끝
		if (C-1 == c) {
			return true;
		}

		else {
			//3가지 방향 탐색하기
			for (int i = 0; i < 3; i++) {
				int x = r + dx[i];
				int y = c + dy[i];

				// 배열 범위 안벗어나고 .일떄 ㄱㄱ
				if (x >= 0 && y >= 0 && x < R && y < C && map[x][y] == '.') {
					//한번 방문한 배열 체크하기
					map[x][y] = 'X';
					//만약 재귀를 했는데 해당 값이 트루로 나오면 구지 다른 방향을 할 필요가 없기에 바로 종료해버리기
					boolean result = loop(x, y);
					if (result) {
						return true;
					}
				}

			}
		}

		//만약 파이프 못 찾으면 리턴 펄스
		return false;

	}

}