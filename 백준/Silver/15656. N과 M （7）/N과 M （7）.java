import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	
	static int N,R;
	static int[] arr;
	static int[] temp;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		StringTokenizer st =new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		R= Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		 st =new StringTokenizer(br.readLine());
			
		for(int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		
		temp = new int[R];
		Arrays.sort(arr);
		
		loop(0);
		System.out.println(sb.toString());
		
	}

	private static void loop(int cnt) {
		if(cnt == R) {
			for(int i=0;i<R;i++) {
				sb.append(temp[i]+" ");
			}
			sb.append("\n");
			return;
		}else {
			for(int i=0;i<N;i++) {
				temp[cnt]=arr[i];
				loop(cnt+1);
			}
			
			
		}
		
	}
}