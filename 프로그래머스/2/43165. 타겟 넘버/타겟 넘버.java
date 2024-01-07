class Solution {
    
    int[] num;
    int target;
    int answer;
    
    public int solution(int[] numbers, int target) {
    
        answer=0;
        this.target=target;
        this.num=numbers;
        
        dfs(0,0);
        
        return answer;
    }
    
    public void dfs(int index,int sum){
        if(index == num.length){
            if(sum==target){
                answer++;
               
            } return;
        }
        dfs(index+1,sum+num[index]);
        dfs(index+1,sum-num[index]);
    }
    
    
 
}