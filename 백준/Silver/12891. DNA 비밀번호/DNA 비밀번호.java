
import java.io.*;
import java.util.*;
public class Main{
	static int[] arr;
	static int[] test;
	static char[] carr;
	static int count;
	
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a= Integer.parseInt(st.nextToken());
        int b=Integer.parseInt(st.nextToken());
        
        arr = new int[4]; // 비밀번호 조건 개수를 담을 배열
        test = new int[4]; // 슬라이딩 윈도우에 있는 개수를 담을 배열
        carr = br.readLine().toCharArray(); // 문자열을 담을 문자배열
        count=0; // count가 4가 되면 조건에 충족되는 부분문자열
        int sum=0;
        
        st = new StringTokenizer(br.readLine());
        
        for(int i=0;i<4;i++) {
        	arr[i]=Integer.parseInt(st.nextToken());
        	if(arr[i]==0) {
        		count++;
        	}
        }
        
        
        for(int i=0;i<b;i++) {
        	add(carr[i]);
        }

        
        if(count==4) {
        	sum++;
        }
        
        for(int i=b;i<a;i++) {
        	int j=i-b;
        	remove(carr[j]);
        	add(carr[i]);
        	if(count==4) {
        		sum++;
        	}
        }
        System.out.println(sum);
        
    }

	private static void remove(char c) {
		switch(c) {
		case 'A':
			
			if(test[0]==arr[0]) {
				count--;
			}
			test[0]--;
			break;
		case 'C':
			
			if(test[1]==arr[1]) {
				count--;
			}test[1]--;
			break;
		case 'G':
			
			if(test[2]==arr[2]) {
				count--;
			}test[2]--;
			break;
		case 'T':
			
			if(test[3]==arr[3]) {
				count--;
			}test[3]--;
			break;
	}
		
	}

	private static void add(char c) {
		switch(c) {
			case 'A':
				test[0]++;
				if(test[0]==arr[0]) {
					count++;
				}
				break;
			case 'C':
				test[1]++;
				if(test[1]==arr[1]) {
					count++;
				}
				break;
			case 'G':
				test[2]++;
				if(test[2]==arr[2]) {
					count++;
				}
				break;
			case 'T':
				test[3]++;
				if(test[3]==arr[3]) {
					count++;
				}
				break;
		}
		
	}
}
