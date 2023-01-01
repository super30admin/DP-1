// Time Complexity : O(mn)
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//Approach: In this approach since the greedy doesnt work and we have same repeated problems we take a dp matrix because we have 2 input variables.
//For the first row we add a greater value in all the columns. Then we check if the denomination is greater than the columns index,
//we just take the previous entry. Otherwise we take minimum of the previous and the entry at whatever at denomination steps back +1.
//We add 1 for that coin taken. Finally we return the last entry as answer.

class Solution {
    public int coinChange(int[] coins, int amount) {
        int m = coins.length;
        int n = amount;
        int [][] dp = new int[m+1][n+1];
        dp[0][0] = 0;
        for(int i=1;i<n+1;i++){
            dp[0][i] = amount+1;
        }

        for(int i =1;i<m+1;i++){
            for(int j=1;j<n+1;j++){
                if(coins[i-1]>j){
                    dp[i][j] = dp[i-1][j];
                } else{
                    dp[i][j] = Math.min(dp[i-1][j],dp[i][j-coins[i-1]] + 1);
                }
            }
        }

        if(dp[m][n]>= amount+1)return -1;
        return dp[m][n];
    }  
}
//Recursive solution
public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        return helper(coins,amount,0,0);
    }

    private int helper(int[] coins, int amount, int idx , int coinsUsed){
        //base
        if(amount < 0 || idx == coins.length)return -1;
        if(amount == 0)return coinsUsed;
        //logic
        //choose
        int case1 = helper(coins, amount - coins[idx],idx,coinsUsed+1);
        //not choose
        int case2 = helper(coins, amount, idx+1 , coinsUsed);
        if(case1 == -1)return case2;
        if(case2 == -1)return case1;
        return Math.min(case1,case2);
    }
}

