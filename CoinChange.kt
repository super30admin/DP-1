// In this problem of Coin Change, we use DP with bottom up approach. We create a dp array where each index represents the mininum coins needed to make that amount.
// We initialize dp[0] to 0 and all other indices to a large value. We then iterate through each coin and for each coin, we iterate through all amounts from 1 to the target amount.
// If the coin denomination is greater than the current amount, we use the previous value. Otherwise, we take the minimum of the current value and 1 plus the value at the index 
// Time complexity is O(m*n) where m is number of coins and n is the amount. Space complexity is O(n) for the dp array.

class Solution {
    fun coinChange(coins: IntArray, amount: Int): Int {
        val n = amount
        val m = coins.size

        val dp = IntArray(n + 1)

        dp[0] = 0
        for(j in 1..n){
            dp[j] = Int.MAX_VALUE - 10
        }
            for(i in 1 .. m) {
                for (j in 1 .. n) {
                    //check if coin denomination > the current amount use the one from abobe, j is amoount and i is the idx on the matrix
                    if(j < coins[i - 1]) {
                        dp[j] = dp[j]
                    } else {
                        dp[j] = Math.min(dp[j], 1 + dp[j - coins[i -1]])
                    }
                }
            }
            val result = dp[n]
            if (result >= Int.MAX_VALUE - 10) return -1
            return result
        } 
}