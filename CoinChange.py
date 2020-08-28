// Time Complexity : O(mn)
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        dp=[[0 for i in range(amount+1)] for i in range(len(coins)+1)] # assinging dp array

        for i in range(len(coins)+1):
            dp[i][0]=0 # assinging 0 coins with 0 as as total sum
        for i in range(1,amount+1):
            dp[0][i]=sys.maxsize # assinging maxsize so that it doesnt throw error for infinite, because infinite +1 is error
            
        for i in range(1,len(coins)+1):
            for j in range(1,amount+1):
                if j<coins[i-1]:
                    dp[i][j]=dp[i-1][j] # if total sum is greater than the coin considered, choose the dont choose option (i.e only present)
                else:
                    dp[i][j]=min(dp[i-1][j],1+dp[i][j-coins[i-1]]) # if choose and dont choose are available , choose the current one (+1)and go back
                                                                   # number of coins in rows in order to find the remaining coins, compare it with previous to get minimum
        if dp[len(coins)][amount]==sys.maxsize:
            return -1
        return dp[len(coins)][amount] # return final answer
         