import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * @author 박기창
 * 인접리스트 사용하기
 */
public class Main {

	static int N;
	static boolean a;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());

		ArrayList<ArrayList<Integer>> list = new ArrayList<>();

		//리스트 초기화 하기
		for (int i = 0; i < N; i++) {
			list.add(new ArrayList<>());
		}

		
		//인접리스트에 값 넣기
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			list.get(x).add(y);
			list.get(y).add(x);
		}
		
		
		boolean[] v = new boolean[N];
		a = false;
		for(int i=0;i<N;i++) {
			v = new boolean[N];
            v[i]=true;
			if(dfs(list, v, i, 0)>=4){
                a=true;
                break;
            }
			
		}
		if (a) {
			System.out.println("1");
		} else {
			System.out.println("0");

		}
		

		

	}

	private static int dfs(ArrayList<ArrayList<Integer>> list, boolean[] v, int cnt, int depth) {

		if (depth >= 4) {
			return depth;
		}
	    int d=0;
		for (int i = 0; i < list.get(cnt).size(); i++) {
			if (!v[list.get(cnt).get(i)]) {
				v[list.get(cnt).get(i)] = true;
				d=Math.max(d,dfs(list, v, list.get(cnt).get(i), depth + 1));
				v[list.get(cnt).get(i)] = false;
			}
		}
        return d;
	}

}