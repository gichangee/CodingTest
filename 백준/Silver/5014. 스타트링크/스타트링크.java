import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		int F = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int G = Integer.parseInt(st.nextToken());
		int U = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		
		boolean[] v= new boolean[1000001];
		
		Queue<int[]> q= new ArrayDeque<>();
		
		q.add(new int[] {S,0});
		
		while(!q.isEmpty()) {
			int[] temp = q.poll();
			
			if(temp[0]==G) {
				System.out.println(temp[1]);
				System.exit(0);
			}
			
			for(int i=0;i<2;i++) {
				if(i==0 && temp[0]+U <=F &&!v[temp[0]+U]) {
					v[temp[0]+U]=true;
					q.add(new int[] {temp[0]+U,temp[1]+1});
				}else if(i==1 && temp[0]-D >0 && !v[temp[0]-D]){
					v[temp[0]-D]=true;
					q.add(new int[] {temp[0]-D,temp[1]+1});
				}
			}
			
		}
		
		System.out.println("use the stairs");
		
	}

}