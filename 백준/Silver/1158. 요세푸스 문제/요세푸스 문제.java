import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

/**
 * 
 * @author 박기창
 * 
 * 큐를 사용
 */
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		StringBuilder sb = new StringBuilder();

		// 7 3
		int N = sc.nextInt();
		int K = sc.nextInt();

		Queue<Integer> q = new ArrayDeque<>();
		
		//큐에 숫자 순서대로 삽입
		for(int i=1;i<=N;i++) {
			q.offer(i);
		}
		sb.append("<");

		
		//큐가 비어있을 때 까지 진행
		while(!q.isEmpty()) {
			
			//k번째 사람을 제거 하므로 k번째 전 사람은 큐의 뒤쪽에 삽입하기
			int count=1;
			while(count<K) {
				
				q.offer(q.poll());
				count++;
			}
			
			//마지막은 , 가 안 붙음
			if(q.size()==1) {
				sb.append(q.poll());
				break;
			}
			
			//맨앞이 k번째 사람
			sb.append(q.poll()+", ");
			
			
		}
		
		sb.append(">");
		System.out.println(sb.toString());

	}

}