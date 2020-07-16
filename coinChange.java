// Time Complexity : O(m *n )
// Space Complexity = O(m *n)
//Did it run on leet code = yess







class Solution {
    public int coinChange(int[] coins, int amount) {
        
       
       
        if( coins == null || coins.length == 0)
            return 0;
        
        
         
        int count = 0;
        int m = coins.length+1;
        int n = amount+1;
        int[][] dp = new int[m][n];
            
         
        for(int i = 0 ; i < m; i++){
            dp[i][0] = 0;
        }
        
        for(int i = 0; i < n ; i++  ){
            
            dp[0][i] = 99999;
        }
     
            
        for(int i = 1 ;i < m ;i++ ){
            
            for( int j = 1 ; j < n ; j ++){
                
                
                if(j < coins[i-1])
                    dp[i][j] = dp[i-1][j];  
                else{
                    
                    dp[i][j] = Math.min( dp[i-1][j],dp[i][j - coins[i-1]]+1);
                    
                }
                
            }
        }
        count = dp[m-1][n-1];
    
        if(count >= 99999)
            return -1;
        return count;
    }
}