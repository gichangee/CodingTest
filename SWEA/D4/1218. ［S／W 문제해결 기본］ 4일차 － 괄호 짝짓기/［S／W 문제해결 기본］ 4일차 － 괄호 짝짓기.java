import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

public class Solution {

	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		

		for (int test_case = 1; test_case <= 10; test_case++) {
			int len = Integer.parseInt(br.readLine());
			String s = br.readLine();
			Stack<String> stack = new Stack<>();

			String[] split = s.split("");

			int result =1;
			
			Loop: for (int i = 0; i < split.length; i++) {
				switch (split[i]) {
				case "(":
					stack.add("(");
					break;
				case "{":
					stack.add("{");
					break;
				case "[":
					stack.add("[");
					break;
				case "<":
					stack.add("<");
					break;
				case ">":
					String st= stack.pop();
					if(!st.equals("<")) {
						result=0;
						break Loop;
					}
					break;
				case "}":
					st= stack.pop();
					if(!st.equals("{")) {
						result=0;
						break Loop;
					}
					break;
				case "]":
					st= stack.pop();
					if(!st.equals("[")) {
						result=0;
						break Loop;
					}
					break;
				case ")":
					st= stack.pop();
					if(!st.equals("(")) {
						result=0;
						break Loop;
					}
					break;
				
				}
			}
			
			System.out.println("#"+test_case+" "+result);

		}
	}

}