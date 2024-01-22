
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int t = Integer.parseInt(st.nextToken());
       
        System.out.println(fibo(t));
        
    }

	public static long fibo(int t) {
		if(t == 0 || t == 1) {
			return t;
		}else {
			return fibo(t-1)+fibo(t-2);
		}
	}

}