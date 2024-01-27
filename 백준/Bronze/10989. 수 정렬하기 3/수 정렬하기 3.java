
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
		
		int t = Integer.parseInt(st.nextToken());
		int[] arr = new int[t];
		for(int i=0;i<t;i++) {
			arr[i]=Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);
		for(int i=0;i<arr.length;i++) {
			bw.write(arr[i]+"\n");
		}
		bw.flush();
		bw.close();
		
	}

}
