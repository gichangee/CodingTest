import java.util.Scanner;
import java.io.FileInputStream;
 
class Solution
{
    static int[][] an;
    static boolean[] v;
     
    public static void main(String args[]) throws Exception
    {
 
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
 
        for(int test_case = 1; test_case <= T; test_case++)
        {
            int x = sc.nextInt();
            int y = sc.nextInt();
             
            int answer=0;
             
            an = new int[x+1][x+1];
            v = new boolean[x+1];
             
            for(int i=0;i<y;i++){
                int n=sc.nextInt();
                int n2=sc.nextInt();
                an[n][n2]=1;
                an[n2][n]=1;
            }
             
            for(int i=1;i<v.length;i++){
                if(!v[i]){
                    answer+=dfs(i);
                }
            }
             
             
            System.out.println("#"+test_case+" "+answer);
             
             
             
        }
    }
     
    public static int dfs(int z){
        v[z]=true;
        for(int i=1;i<v.length;i++){
            if(an[z][i]==1 && !v[i]){
                dfs(i);
            }
        }
        return 1;
    }
}