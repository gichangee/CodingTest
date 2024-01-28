

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
		dfs(1,0);
		bw.flush();
		bw.close();
	}
	private static void dfs(int a,int index) throws IOException {
		
		if(index==K) {
			for(int i=0;i<index;i++) {
				bw.write(arr[i]+" ");
			}
			bw.write("\n");
			return;
		}
		
		
		for(int i=a;i<=N;i++) {
		
			arr[index]=i;
			dfs(i,index+1);

		}
			
		
	}

}
