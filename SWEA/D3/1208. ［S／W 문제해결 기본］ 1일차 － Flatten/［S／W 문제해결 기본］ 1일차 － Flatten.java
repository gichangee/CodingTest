import java.util.Arrays;
import java.util.Scanner;



class Solution
{
    public static void main(String args[]) throws Exception
    {

        Scanner sc = new Scanner(System.in);

        for(int test_case = 1; test_case <= 10; test_case++)
        {

        	// 모든 숫자 배열에 넣기
            int x= sc.nextInt();
            int[] ans = new int[100];
            for (int i = 0; i < 100; i++) {
                ans[i]=sc.nextInt();
            }



            //배열을 정렬하면 맨 앞에 가장 낮은 수가 오고 맨 뒤에 가장 높은 수가 오기에
            //맨 뒤 값을 하나 빼서 맨 앞에 넣어주면 된다.
            for (int k = 0; k < x; k++) {
                Arrays.sort(ans);
                ans[0]++;
                ans[ans.length-1]--;
            }
            // 맨 뒤의 값과 맨 앞의 값을 빼주면 최고점과 최저점의 높이 차가 나온다.
            Arrays.sort(ans);
            System.out.println("#"+test_case+" "+(ans[ans.length-1]-ans[0]));


        }
    }
}