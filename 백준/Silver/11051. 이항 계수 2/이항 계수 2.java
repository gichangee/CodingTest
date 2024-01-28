

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

	static int count;
	static int a,b;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[][] D = new int[N+1][N+1];
		
		for(int i=0;i<D.length;i++) {
			D[i][0]=1;
			D[i][i]=1;
			D[i][1]=i;
		}
		
		for(int i=3;i<=N;i++) {
			for(int j=2;j<i;j++) {
				D[i][j]= D[i-1][j-1] +D[i-1][j];
                D[i][j]=D[i][j]%10007;
			}
		}
		
		System.out.println(D[N][K]);
		
		
	}

}
