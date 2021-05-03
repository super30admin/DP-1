// Time Complexity : O(mn) m -> len(coins)+1 and m -> amount+1
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach


class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        rows = len(coins)+1
        columns = amount+1
        dp = [None]*columns
        dp = rows*[dp]
        # Extra row filled with amount+1
        for i in range(len(dp[0])):
            dp[0][i] = amount+1
        # Extra colum filled with 0
        for j in range(len(dp)):
            dp[j][0] = 0

        for i in range(len(dp)):
            for j in range(len(dp[0])):
                # Denominatination of coin greater than j(amount)
                if(coins[i-1]>j):
                    dp[i][j] = dp[i-1][j]
                else:
                    dp[i][j] = min(dp[i-1][j], dp[i][j-coins[i-1]]+1)
        if dp[len(dp)-1][len(dp[0])-1]>amount:
            return - 1
        return dp[len(dp)-1][len(dp[0])-1]
