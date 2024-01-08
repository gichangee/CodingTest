import java.util.*;
class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        
        int[] a = new int[number];
        
        for(int i=1;i<=number;i++){
            int count=0;
            
           for(int j=1;j*j<=i;j++){
               if(j*j==i){
                   count++;
               }else if(i%j==0){
                   count=count+2;
               }
           }
            if(count>limit){
                count=power;
            }
            
            System.out.println(count);
            a[i-1]=count;
        }
        
        for(int i=0;i<a.length;i++){
            answer+=a[i];
        }
        
        return answer;
    }
}