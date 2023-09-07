/* 

Problem1 (https://leetcode.com/problems/coin-change/) 

Time Complexity : O(nk)
Space Complexity : O(nk)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Approach : Initially used recursive to solve the problem. Due to exponential time complexity, it ran into time exceeded error.
To handle the repeated sub-problems without wasting time, use DP. Find out the terminating factors to assign the DP size. 
Here amount and Coins are the determining factors. Hence a 2D Dp is taken. Then figured out the approach to fill the DP in such a
way that we recive the final solution.

*/

// Approach using Recursive 


class Solution {
    public int coinChange(int[] coins, int amount) {
        if(coins.length == 0 || coins == null){
            return -1;
        }

        return recurse(coins, amount, 0, 0);
    }
    
    private int recurse(int[] coins, int amount, int index, int count){
        if(index >= coins.length){
            return -1;
        }
        
        if(amount < 0){
            return -1;
        }

        if(amount == 0){
            return count;
        }

        int case1 = recurse(coins, amount, index + 1, count);
        int case2 = recurse(coins, amount - coins[index], index, count + 1);

        if(case1 == -1){
            return case2;
        }
        if(case2 == -1){
            return case1;
        }

        return Math.min(case1,case2);
    }
}


// Approach using DP 

class Solution_1 {
    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length + 1][amount + 1];
        for(int i=0; i<amount+1; i++){
            dp[0][i] = amount + 1;
        }
        for(int i = 1; i < coins.length + 1; i++){
            for(int j = 1; j < amount + 1; j++){
                if(coins[i-1] > j){
                    dp[i][j] = dp[i-1][j];
                }
                else{
                    dp[i][j] = Math.min(dp[i-1][j], dp[i][j - coins[i-1]] + 1);
                }
            }
        }
        if(dp[coins.length][amount] != amount + 1){
            return dp[coins.length][amount];
        }
        return -1;
    }
}

