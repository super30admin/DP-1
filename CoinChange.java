//Problem - CoinChange 1
// Time Complexity : O(c*a), where c represents coins length and a represents amount
// Space Complexity : O(c*a), where c represents coins length and a represents amount
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/**  Steps 
 *  Initialise Dp row 1 with Infinity because, there are no coins(bag is empty) and we have to make some minimum amount, which is not possible 
 *  If our bag is not empty we have something means some coins, then minimum amount for making 0 will be 0
 * 
*/


class Solution20 {
    
    public int coinChange(int[] coins, int amount) {
        
        if(coins==null || coins.length==0){
            return -1;
        }
        
        //Bottom Up
        int[][] dp = new int[coins.length+1][amount+1];//Because amount to be included
        
        for(int j=0;j<dp[0].length;j++){
            dp[0][j] = Integer.MAX_VALUE-1;  //because it is infinity, if I have not subtracted one from Integer.MAX_VALUE, then there can be integer overflow when adding 1 to it in below logic.
        }
        
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                
                if(j>=coins[i-1]){
                                          //taking dp[i] below because it is unbounded knapsack, we can reuse the coin;
                    dp[i][j] = Math.min(1+dp[i][j-coins[i-1]],dp[i-1][j]);
                }else{
                    dp[i][j] = dp[i-1][j];
                }
                
            }
        }
        
        return dp[coins.length][amount]==Integer.MAX_VALUE-1 ? -1:dp[coins.length][amount] ;


    }
    
    /*
    TC & SC -> Same as above
    class SolutionTopDown {
    
        private int[][] dp;
        public int coinChange(int[] coins, int amount) {
            
            if(coins.length==0){
                return -1;
            }
            
            dp = new int[amount+1][coins.length+1];
            
            for(int i=0;i<dp.length;i++){
                Arrays.fill(dp[i],-1);
            }
            
            //System.out.println(Arrays.deepToString(dp));
            
            int minCoins = calcMin(coins,amount,coins.length-1);
            
            return minCoins==Integer.MAX_VALUE-1 ? -1:minCoins;
        }
        
        
        private int calcMin(int[] coins, int amount, int n){
            
            if(n<0){
                return Integer.MAX_VALUE-1;
            }
            
            if(amount==0){
                return 0;
            }
            
            if(dp[amount][n]!=-1){
                return dp[amount][n];
            }
            
            if(amount>=coins[n]){
                dp[amount][n] = Math.min(1+calcMin(coins,amount-coins[n],n),calcMin(coins,amount,n-1)); 
                return dp[amount][n];
                                              
            }else{
                dp[amount][n] = calcMin(coins,amount,n-1);
                return dp[amount][n];
            }
            
        }
    }   
    
    */