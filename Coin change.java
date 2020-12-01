/*
# Recursive
class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        if coins is None or len(coins) == 0:
            return -1
        
        def helper(coins, amount, index, min_coins):
            if amount == 0:
                return min_coins
            
            if index == len(coins) or amount < 0:
                return -1
            
            case1 = helper(coins, amount - coins[index], index, min_coins+1)
            case2 = helper(coins, amount, index + 1, min_coins)
            
            if case1 == -1:
                return case2
            if case2 == -1:
                return case1
            
            return min(case1, case2)
        return helper(coins, amount, 0, 0)


# dp
class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        if coins is None or len(coins) == 0:
            return -1
        
        dp = [[0]*(amount + 1)]* (len(coins)+1)
        rows = len(dp)
        cols = len(dp[0])
        
        for i in range(1, cols):
            dp[0][i] = amount + 1
            
        
        
        for i in range(1, rows):
            for j in range(1, cols):
                if j < coins[i-1]:
                    dp[i][j] = dp[i-1][j]
                else:
                    dp[i][j] = min(dp[i-1][j], dp[i][j-coins[i-1]] + 1)
        
        if dp[rows-1][cols-1] == amount + 1:
            return -1
        
        return dp[rows-1][cols-1]        
*/

// Time Complexity : O(amount * coins)
// Space Complexity : O(amount * coins)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes


// Your code here along with comments explaining your approach: Just maintained a 2d array of results and computed them for each
// and every input
class Solution {
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0){
            return -1;
        }
        
        int[][] dp = new int[coins.length + 1][amount + 1];
        int rows = dp.length;
        int cols = dp[0].length;
        
        for (int i=0; i<cols; i++){
            dp[0][i] = amount + 1;
        }
        
        for (int i=1; i<rows; i++){
            for (int j=1; j<cols; j++){
                if (j < coins[i-1]){
                    dp[i][j] = dp[i-1][j];
                }
                else{
                    dp[i][j] = Math.min(dp[i-1][j], dp[i][j-coins[i-1]] + 1);
                }
            }
        }
        
        if (dp[rows-1][cols-1] == amount + 1){
            return -1;
        }
        return dp[rows-1][cols-1];
        
    }
}