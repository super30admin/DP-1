// Time Complexity : O(M*N)
// Space Complexity : O(M*N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class CoinChange {
    int count;
    public int coinChange(int[] coins, int amount) {
       int m = coins.length;
       int n = amount;
        
       //We use m + 1 because we need to include a 0th row to represent the case where no coins are available.
       // We use n + 1 to include a 0th column which corresponds to making an amount of 0.
       int[][] dp = new int[m+1][n+1];

    //started from j=1 because minimum number of coins required to make amount=0 is 0 and not infinity.
       for(int j=1; j<=n; j++) {
        dp[0][j] = 99999; // We did not do infinity because at one point we might have to do 1 + infinity and it will go out of bounds.,
       }

       for(int i=1; i<=m; i++) { //i=1 as we already filled up first row in line 9)
        for(int j=0; j<=n; j++){
            // in some cases, we do not have an option to choose case. eg, when amount < demonition of the coin //[1,3,5] like, we are at 1 coin and amount is 5.
            // no choose case -- it is called so because in this case, choose (1 ) will never be used since it make the amount -ve hence ignored. like [1,2,5]3 ->  
            // no choose will be [1,2]3 and choose will be [1,2,5]-2. S, choose is invalid and [1,2]3 is the no choose case and its value comes from right above
           if(j < coins[i-1]) {
            // no choose case
            // represents the "no choose" case in the coin change dynamic programming solution. It means that we are not picking the current coin. Instead, we copy the value from the previous row (i.e., the solution when we only had the first i - 1 coins available).
            dp[i][j] = dp[i-1][j]; //the amount will be the one right above.
           } else {
            // Math.min of choose and no choose
            // In the same row, we are going those many number of steps back. We are choosing some denomination of the coin. from the amount we are subtracting that denomination
             dp[i][j] = Math.min(dp[i-1][j], 1+dp[i][j- coins[i-1]]);
           }
        }
       }
       if(dp[m][n] == 99999) return -1;
       return dp[m][n];

    }
}