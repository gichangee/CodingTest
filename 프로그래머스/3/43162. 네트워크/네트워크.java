class Solution {
    static int answer;
    public int solution(int n, int[][] computers) {
        answer = 0;
        
        int[][] arr = new int[n][n];
        boolean[][] v = new boolean[n][n];
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(computers[i][j]==1){
                    arr[i][j]=1;
                    arr[j][i]=1;
                }
            }
        }
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(!v[i][j] && arr[i][j]==1){
                      dfs(v,arr,i,0);
                     answer++;
                }
            }
          
        }
        
        
        
        
        
        return answer;
    }
    
    static void dfs(boolean[][] v, int[][] arr,int y,int x){
         for(int i=0;i<arr[y].length;i++){
             if(!v[y][i] && arr[y][i]==1){
                 v[y][i]=true;
                 dfs(v,arr,i,0);
             }
         }
    }
}