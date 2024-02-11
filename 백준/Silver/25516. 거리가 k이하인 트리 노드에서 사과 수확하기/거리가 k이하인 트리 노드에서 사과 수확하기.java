import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 
 * @author 박기창
 * 이진트리가 아닌 트리이다
 * dfs 사용해서 풀기
 *
 */
public class Main {

	
	static int k;
	static int sum;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 노드 개수
		int n = Integer.parseInt(st.nextToken());
		//최대 길이
		k = Integer.parseInt(st.nextToken());
		
		//노드 담을 배열 선언하기
		Node2[] test = new Node2[n];
		for(int i=0;i<n-1;i++) {
			st = new StringTokenizer(br.readLine());
			
			//중심 노드
			int v = Integer.parseInt(st.nextToken());
			
			//중심 노드 옆에 붙은 노드
			int no = Integer.parseInt(st.nextToken());
			
			//만약 중심노드가 없으면 만들기
			if(test[v] == null) {
				test[v]= new  Node2(v);
			}
			
			//주변 노드가 없으면 만들기
			if(test[no] == null) {
				test[no]= new Node2(no);
			}
			
			//중심노드 옆에 주변노드 붙이기
			test[v].list.add(test[no]);
			
		
		}
		
		//노드 사과 개수 붙이기
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			test[i].cnt = Integer.parseInt(st.nextToken());
		}
		
		sum=0;
		//dfs 탐색 시작
		loop(0,test[0]);
		
		System.out.println(sum);
	}

	private static void loop(int cnt,Node2 n) {
		//null이면 종료
		if(n == null) {
			return;
		}
		
		//최대길이에 도착하면 종료
		if(cnt == k) {
			sum+=n.cnt;
			return;
		}else{
			
			//그게 아니라면 노드 안에있는 사과를 더하고
			//해당 중심노드 옆에있는 주변노드 탐색 시작
			sum+=n.cnt;
			for(int i=0;i<n.list.size();i++) {
				loop(cnt+1,n.list.get(i));
			}
			
		}
		
	}

}

class Node2{
	//노드 번호
	int value;
	
	//노드 옆에 붙어있는 노드 
	List<Node2> list = new ArrayList<>();
	
	//노드 안에있는 사과 개수
	int cnt;

	public Node2(int value) {
		this.value=value;
	}
	
	
}