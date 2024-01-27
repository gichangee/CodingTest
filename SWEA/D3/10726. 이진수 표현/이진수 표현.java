
import java.util.Scanner;
import java.io.FileInputStream;

/*
   D3_10726_이진수 표현_박기창.java
 */
class Solution
{
	public static void main(String args[]) throws Exception
	{

		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int n=sc.nextInt();
            int m= sc.nextInt();
            int lastbit = (1 << n)-1; // 비교할 뒷자리 비트 수를 모두 1로 세팅한다.
            
            if(lastbit == (m & lastbit)){ // 만약 마지막 비트와 m과 1로 세팅된 비트를 &연산자로 비교해서 모두 1이면 on 아니면 off를 출력
            	System.out.println("#"+test_case+" ON");
            }else{
            	System.out.println("#"+test_case+" OFF");
            }
            
		}
	}
}