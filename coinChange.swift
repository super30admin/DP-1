// Time Complexity : 0(m*n)
// Space Complexity : 0(n)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

     func coinChange(_ coins: [Int], _ amount: Int) -> Int {
         if amount < 1 {
             return 0
         }
        var dp = Array(repeating: amount+1, count: amount+1)
         dp[0] = 0
        for j in 1...amount {
            for i in 0...coins.count-1 {
                    if j >= coins[i] {
                    dp[j] = min(dp[j], 1 + dp[j - coins[i]])
                }  
            }
        }
        return dp[amount] >= amount + 1 ? -1 : dp[amount] 
    }