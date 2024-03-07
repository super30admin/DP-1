// Time Complexity : O(nm) where n- no of coins, m - amount
// Space Complexity : O(nm) where n- no of coins, m - amount
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes, to figure our the indexes


/* Approach:
We use DP here. We create a 2d array to store previous occurances of subproblema and use it to optimize the 
current problem. 
Case 0: where amount < denomination, we update it to the value from index in upper row (if we do not choose the coin)
Case 1: where we compare prev row's val to the val at current row - denomination +1 (this +1 signifies we have chosen the coin)
*/ 

class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int m = amount;
        int [][] dp = new int[n+1][m+1];

        //null case
        if( coins == null || coins.length ==0 ) return -1;

        //first row
        for ( int j=1; j<=m;j++){
            dp[0][j] = 99999;
        }
        for (int i =1; i<dp.length;i++){
            for (int j = 1; j<dp[0].length; j++){
                //Case 0: where amount < denomination
                if( j< coins[i-1]){
                    dp[i][j] = dp[i-1][j];
                }
                //Case1: where we compare prev row's val to the val at current row - denomination +1'
                else{
                    dp[i][j] = Math.min( dp[i-1][j],dp[i][j-coins[i-1]]+1);           
                    }
            }
        }
        if(dp[n][m]>=99999) return -1;
        return dp[n][m];
    }

}
