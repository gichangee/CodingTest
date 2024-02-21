import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static int moum = 0;
	public static int L,C;
	public static char[] cmap;
	public static StringBuilder sb = new StringBuilder();
	
	public static void dfs(int depth, int i,int secreat, String strsecreat) {
		
		if(depth == L) {
			//모음 1개이상 포함되었는지 
			if((secreat&moum) == 0) {
				return;
			}
			
			//자음 2개이상 포함되어있는지 체크
			int cnt = 0;
			for(int j=0;j<26;j++) {
				if( j == ('a' - 'a') || j == ('e' - 'a') 
						|| j ==  ('i' - 'a') || j == ('o' - 'a') 
						|| j == ('u' - 'a')) {
					continue;
				}
				if((secreat&(1<<j))!=0) {
					cnt++;
				}
				if(cnt>=2)
					break;
			}
			
			if(cnt>=2)
				sb.append(strsecreat).append("\n");
			
			
			return;
		}
		
		for(;i<C;i++) {
			String stringtotal  = strsecreat + cmap[i];
			int total = (secreat | (1<<(cmap[i] - 'a')));
			dfs(depth+1,i+1,total,stringtotal);
		}
	}

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		StringTokenizer stz = new StringTokenizer(str);
		
		L = Integer.parseInt(stz.nextToken());
		C = Integer.parseInt(stz.nextToken());
		cmap = new char[C];
		str = br.readLine();
		str = str.replaceAll("\\s", "");
		
		for(int i=0;i<C;i++) {
			cmap[i] = str.charAt(i);	
		}
		//정렬
		Arrays.sort(cmap);
		
		for(int i=0;i<26;i++) {
			if( i == ('a' - 'a') || i == ('e' - 'a') 
					|| i ==  ('i' - 'a') || i == ('o' - 'a') 
					|| i == ('u' - 'a')) {
				moum = moum|(1<<i);
			}
		}
		dfs(0,0,0,"");
		System.out.print(sb);

	}

}
