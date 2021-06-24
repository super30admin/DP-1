Time Complexity  O( mXn)
Space Complexity ( m X n)

class Solution {
    public int coinChange(int[] coins, int amount) {
        
       
        int m = coins.length +1  ; 
        
        int n = amount +1 ;        
        int [] [] dp  = new int [m][n] ; 
        
        
        
        for ( int i = 0 ; i < m ; i++)
        {
            dp [i][0] = 0;
        }
        
        for ( int j =1 ; j < n  ; j++)
        {
            dp [ 0][j] = 99999; 
            
        }
        
        for (int  i = 1 ; i < m ; i++)
        {
            for ( int j = 1 ; j < n ; j++)
                
            {   
                if (  j < coins[i-1] ) { dp [i] [j] = dp [i-1] [j];}
                
                
                else 
                {
                    dp[i][j] = Math.min ( 1 +  dp [i] [j - coins[i-1] ] , dp [i-1] [j] );
                    // System.out.println( dp[i] [j]);
                }
            
            
            }
        }
        
        if ( dp[m-1][n-1] > 10000  || dp[m-1][n-1] <0  ) { return -1;}
        return dp [ m-1] [n-1];
    }
    
    
    
}