import java.util.*;
class Solution {
    public int solution(int n) {
        int answer = 0;
        
        /*
        for(int i=2;i<=n;i++){
            boolean a=true;
           for(int j=2;j<i;j++){
               if(i%j==0){
                   a=false;
               }
           }
            
            if(a){
                answer++;
            }
        }
        
        */
        
        
        
        boolean[] an = new boolean[n+1];
        
        for(int i=0;i<an.length;i++){ 
            an[i]=true;
        }
        
        an[0]=false;
        an[1]=false;
        
        for(int i=2;i<=Math.sqrt(n);i++){
            if(an[i]){
                for(int j=i*i;j<=n;j+=i){
                    an[j]=false;
                }
            }
        }
        
        for(int i=0;i<an.length;i++){
            if(an[i]){
                answer++;
            }
        }
                
        return answer;
    }
}