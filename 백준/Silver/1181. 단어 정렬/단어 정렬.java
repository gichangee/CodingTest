import java.io.*;
import java.util.*;

public class Main {

	static class node implements Comparable<node> {
		String s = "";


		
		

		@Override
		public int compareTo(node o) {
			
			if(this.s.length() == o.s.length()) {
				return this.s.compareTo(o.s);
			}
			return this.s.length() - o.s.length();
		}



		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append(s);
			return builder.toString();
		}
		
	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Set<String> set = new HashSet<>();
		
		for(int i=0;i<N;i++) {
			set.add(br.readLine());
		}
		
		node[] n = new node[set.size()];
		int i=0;
		Iterator<String> it = set.iterator();
		while(it.hasNext()) {
			n[i] = new node();
			n[i].s=it.next();
			i++;
			
		}

		Arrays.sort(n);

		for (int i1 = 0; i1 < n.length; i1++) {
			System.out.println(n[i1]);
		}
	}

}