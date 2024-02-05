import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * 
 * @author park
 * 링크드리스트를 사용하면 간편하게 작성할 수 있을 것 이라고 생각
 */
public class Solution {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		for(int i=0;i<10;i++) {
			
			//원본 암호문 길이 받기
			int len = Integer.parseInt(br.readLine());
			//암호문을 링크드리스트로 선언
			List<Integer> list = new LinkedList<>();
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			//원본 암호문 받기
			for(int j=0;j<len;j++) {
				list.add(Integer.parseInt(st.nextToken()));
			}
			
			
			//명령어 개수 받기
			int command = Integer.parseInt(br.readLine());
			
			st = new StringTokenizer(br.readLine());
			int count=0;
			while(true) {
				if(st.nextToken().equals("I")) {
					count++;
				}
				
				//암호문 정보 받기
				int index = Integer.parseInt(st.nextToken());
				int r = Integer.parseInt(st.nextToken());
				
				for(int j=0;j<r;j++) {
					list.add(index, Integer.parseInt(st.nextToken()));
					index++;
				}
				
				if(count == command) {
					break;
				}
				
				
			}
			
			System.out.print("#"+(i+1)+ " ");
			
			for(int z=0;z<10;z++) {
				System.out.print(list.get(z)+" ");
			}
			System.out.println();
			
		}
	}

}