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
		int n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		Node2[] test = new Node2[n];
		for(int i=0;i<n-1;i++) {
			st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken());
			int no = Integer.parseInt(st.nextToken());
			
			if(test[v] == null) {
				test[v]= new  Node2(v);
			}
			
			if(test[no] == null) {
				test[no]= new Node2(no);
			}
			
			test[v].list.add(test[no]);
			
		
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			test[i].cnt = Integer.parseInt(st.nextToken());
		}
		
		sum=0;
		loop(0,test[0]);
		
		System.out.println(sum);
	}

	private static void loop(int cnt,Node2 n) {
		if(n == null) {
			return;
		}
		if(cnt == k) {
			sum+=n.cnt;
			return;
		}else{
			sum+=n.cnt;
			for(int i=0;i<n.list.size();i++) {
				loop(cnt+1,n.list.get(i));
			}
			
		}
		
	}

}

class Node2{
	int value;
	List<Node2> list = new ArrayList<>();
	int cnt;

	public Node2(int value) {
		this.value=value;
	}
	
	
}