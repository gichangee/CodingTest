import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		for(int test_case = 1; test_case <= 10; test_case++)
		{
			int num = Integer.parseInt(br.readLine());
			int[] arr= new int[num+1];
			int right=0;
			StringTokenizer st;
			
			int heigth =0;
			int test =1;
			
			for(int i=0;i<num;i++) {
				if(right < num) {
					st= new StringTokenizer(br.readLine());
					int n = Integer.parseInt(st.nextToken());
					
					if(n==test) {
						heigth++;
						test=test*2;
					}
					
					
					String giho = st.nextToken();
					int left = Integer.parseInt(st.nextToken());
					if(left == num) {
						try{
							arr[n]= Integer.parseInt(giho); 
						}catch (NumberFormatException e) {
							arr[n]=-1;
						}
						right=num;
						continue;
					}
					right = Integer.parseInt(st.nextToken());
					try{
						arr[n]= Integer.parseInt(giho); 
					}catch (NumberFormatException e) {
						arr[n]=-1;
					}
					
				}else {
					st= new StringTokenizer(br.readLine());
					int n = Integer.parseInt(st.nextToken());
					String value =st.nextToken();
					try{
						arr[n]= Integer.parseInt(value); 
					}catch (NumberFormatException e) {
						arr[n]=-1;
					}
				}
				
				
			}
			
			int fullnodelastindex = (int) (Math.pow(2, heigth-1)-1);
			int fullnodelastindex2 = (int) (Math.pow(2, heigth)-1);
			
			
			boolean a = false;
			
			for(int i=1;i<=fullnodelastindex;i++) {
				if(arr[i] != -1) {
					a=true;
					break;
				}
			}
			
			for(int i=fullnodelastindex+1;i<=fullnodelastindex2;i++) {
				if(i*2 <=num) {
					if(arr[i] != -1) {
						a=true;
						break;
					}
				}
				
				if(i*2+1<=num) {
					if(arr[i] != -1) {
						a=true;
						break;
					}
				}
			}
			
			
			for(int i=fullnodelastindex2+1;i<=num;i++) {
				if(arr[i]<0) {
					a=true;
					break;
				}
			}
			
			if(a) {
				System.out.println("#"+test_case+" "+0);
			}else {
				System.out.println("#"+test_case+" "+1);
			}
			


		}

	}

}