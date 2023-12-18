class Solution {
      public static int solution(int a, int b, int n) {
        int i=1;
        if(a>n){
            return 0;
        }else {
            while(true){

                if(a*i>n){
                    i--;
                    break;
                }
                i++;
            }
            return i*b+solution(a,b,n-(a*i)+(i*b));
        }

    }
}