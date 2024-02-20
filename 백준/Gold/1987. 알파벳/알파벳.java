import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @author 박기창
 * 알파벳 문자 방문 배열 사용
 * 깊이 우선 탐색 사용
 */
public class Main {

	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,-1,1};
	static int max;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int y = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());

		char[][] arr = new char[y][x];

		
		//데이터 입력받기ㅇ
		for (int i = 0; i < y; i++) {

			arr[i] = br.readLine().toCharArray();

		}
		
		int count=1;
		
		//알파벳 방문 배열
		boolean[] v = new boolean[26];
		
		
		//최댓값 생성
		max = Integer.MIN_VALUE;
		
		//길찾기 시작
		loop(v,arr,0,0,count);
		
		System.out.println(max);
		
		
	}

	private static void loop(boolean[] v, char[][] arr, int y, int x, int cnt) {
		//방문한곳 체크
		v[arr[y][x]-'A']=true;
		//네방향 돌리기
		for(int i=0;i<4;i++) {
			int goY = dy[i]+y;
			int goX = dx[i]+x;
			//범위도 안벗어나고 처음방문하는 거면 들어가기
			if(goY >=0 && goX >=0 && goX<arr[0].length && goY<arr.length && !v[arr[goY][goX]-'A']) {
				//방문 체크
				v[arr[goY][goX]-'A']=true;
				
				//++cnt 로 하면 틀림 왜냐하면 cnt값 자체가 변경이 되기 때문이다.
				//cnt+1 한 값으로 재귀 돌기
				loop(v, arr, goY, goX, cnt+1);
				
				//재귀 끝나고 나면 다시 false로 초기화
				v[arr[goY][goX]-'A']=false;
			}
		}
		
		//max값 비교하기
		
		if(cnt >= max) {
			max= cnt;
		}
	
	}

}