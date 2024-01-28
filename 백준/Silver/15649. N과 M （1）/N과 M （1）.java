
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

	static int N;
	static int K;
	static int[] arr;
	static boolean[] v;
	static BufferedWriter bw;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
		
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		arr = new int[K];
		v= new boolean[N];
		dfs(0);
		bw.flush();
		bw.close();
	}
	private static void dfs(int index) throws IOException {
		
		if(index==K) {
			for(int i=0;i<index;i++) {
				bw.write(arr[i]+"");
				bw.write(" ");
			}
			bw.write("\n");
			return;
		}
		
		
		for(int i=0;i<N;i++) {
			if(!v[i]) {
				v[i]=true;
				arr[index]=i+1;
				dfs(index+1);
				v[i]=false;
			}
		}
			
		
	}

}
