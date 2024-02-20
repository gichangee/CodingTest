import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @author 박기창
 * 위상정렬 사용하기
 */
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		//어레이리스트 만들고 그 안에 또 어레이 리스트 만들기
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		for(int i=0;i<=N;i++) {
			//어레이리스트 초기화하기
			list.add(new ArrayList<>());
		}
		
		
		//진입차수를 기록할 배열 생성
		int[] degree = new int[N+1];
		for(int i=0;i<R;i++) {
			st= new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			//리스트에 값 넣기
			list.get(s).add(e);
			//진입차수가 있다면 증가
			degree[e]++;
		}
		
		//진입차수가 0을 큐에 일단 넣기
		Queue<Integer> q = new ArrayDeque<>(); 
		for(int i=1;i<degree.length;i++) {
			if(degree[i]==0) {
				q.add(i);
			}
		}
		
		
		//큐가 빌때까지 반복
		//어레이리스트에 하나씩 꺼내면서 하나씩 해당 리스트에 있는거 하나씩 자르기
		while(!q.isEmpty()) {
			int x = q.poll();
			System.out.print(x+" ");
			for(int now : list.get(x)) {
				degree[now]--;
				if(degree[now]==0) {
					q.add(now);
				}
			}
			
			
		}
		
		
		
		
	}

}