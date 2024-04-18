import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		String s = "";
		for(int i=0;i<8;i++) {
			s+=st.nextToken();
		}
		
		String one ="12345678";
		String two ="87654321";
		
		if(s.equals(one)) {
			System.out.println("ascending");
		}else if(s.equals(two)) {
			System.out.println("descending");
		}else {
			System.out.println("mixed");
		}
	}

}