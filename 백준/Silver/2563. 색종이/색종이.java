import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[][] arr =new int[100][100];
		
		for(int i=0;i<100;i++) {
			for(int j=0;j<100;j++) {
				arr[i][j]=0;
			}
		}
		
		int count= Integer.parseInt(br.readLine());
		
		
		
		for(int i=0;i<count;i++) {
			StringTokenizer st= new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			for(int k = a;k<a+10;k++) {
				for(int z = b;z<b+10;z++) {
					arr[k][z]++;
				}
			}
			
			
		}
		
		int sum=0;
		
		for(int i=0;i<100;i++) {
			for(int j=0;j<100;j++) {
				if(arr[i][j]>0) {
					sum++;
				}
			}
		}
		
		System.out.println(sum);
		
	}

}