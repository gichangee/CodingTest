import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		
		for(int i=0;i<N;i++) {
			 st= new StringTokenizer(br.readLine());
			 arr[i]=Integer.parseInt(st.nextToken());
		}
		
		int count =0;
		
		for(int i=arr.length-1;i>=0;i--) {
			if(arr[i]<=K) {
				K=K-arr[i];
				i++;
				count++;
			}else {
				continue;
			}
		}
		
		
		System.out.println(count);
	}
}