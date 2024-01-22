
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int t = Integer.parseInt(st.nextToken());
       
        System.out.println(fac(t));
        
    }

	public static long fac(int t) {
		if(t == 0 || t == 1) {
			return 1;
		}else {
			return t*fac(t-1);
		}
	}

}