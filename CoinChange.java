//This problem was asked at Facebook
//
//        You are given coins of different denominations and a total amount of money. Write a code to compute the minimum number of coins that you need to use to make up the amount. If that amount of money cannot be made up, return -1.
//
//        Example 1:
//        Input: coins = [1, 2, 5], amount = 11      Output: 3
//        Explanation: 11 = 5 + 5 + 1

//LeetCode: 322
// Time Complexity : O(N * M)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach

class Solution {
    public int coinChange(int[] coins, int amount) {

        //edge
        if(amount==0 || coins.length==0)
            return 0;

        int dp[] = new int[amount+1];
        Arrays.fill(dp,amount+1);
        dp[0]= 0;


        for(int i=0; i<coins.length;i++){
            for(int j=coins[i]; j<=amount;j++){

                dp[j] = Math.min(dp[j],dp[j - coins[i]] + 1);

            }

        }

        return dp[amount] == amount+1? -1: dp[amount];

    }
}
