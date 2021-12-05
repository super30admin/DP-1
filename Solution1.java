// Time Complexity :O(mn) m=length of coins array ,n=amount
// Space Complexity :O(mn) m=length of coins array ,n=amount
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution1 {
    public int coinChange(int[] coins, int amount) {
        if(coins==null || coins.length==0)
            return -1;
       
        int [][]dp= new int[coins.length+1][amount+1];
        // to get amount with 0 denomination there are infinite ways 
        //using amount+1 instead of infinity to avoid overflow
        for(int i=1;i<dp[0].length;i++){
            dp[0][i]=amount+1;
        }
 
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                //if amount is less than the coin denomination
                if(j<coins[i-1])
                    dp[i][j]= dp[i-1][j];
                else
                    dp[i][j]=Math.min(dp[i-1][j],1+dp[i][j-coins[i-1]]);
            }
        }
     // incase the amount is greater than possible denomaination   
    return dp[coins.length][amount]>amount?-1:dp[coins.length][amount];
    }
}
                
                
            