import java.util.*;
class Solution {
    public int solution(int[] nums) {
        int answer = -1;

        List<Integer> set = new ArrayList();
        
        
        for(int i=0;i<nums.length-2;i++){
            for(int j=i+1;j<nums.length-1;j++){
                for(int z=j+1;z<nums.length;z++){
                    set.add(nums[i]+nums[j]+nums[z]);
                }
            }
        }
        
        Integer[] arr = set.toArray(new Integer[0]);
        
        List<Integer> list = new ArrayList();
        
 
        
        
        for(int i=0;i<arr.length;i++){
    
            boolean a = true;
            for(int j=2;j<arr[i];j++){
    
                if(arr[i]%j==0){
                    a=false;
                    break;
                    
                }
            }
            if(a){
                 list.add(arr[i]);
            }
            
           
       
        }
        
        
        answer=list.size();

        return answer;
    }
}