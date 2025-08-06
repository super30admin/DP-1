// Time Complexity :  O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
// line 14
class Solution {
    fun coinChange(coins: IntArray, amount: Int): Int {
        val dp = IntArray(amount + 1){amount + 1 }
        dp[0] = 0
        for(coin in coins){
            for(amt in 0..amount){
                if(amt >= coin){
                    val prevCalAmt = amt - coin
                    dp[amt] = min(dp[amt], dp[prevCalAmt] + 1)
                }
            }
        }
        return if(dp[amount] > amount) -1 else dp[amount]
    }
}