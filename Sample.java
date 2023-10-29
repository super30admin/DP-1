House Robber
// Time Complexity : O(n)
// Space Complexity : O(n) 

class Solution:
    def rob(self, nums: List[int]) -> int:
        n = len(nums)
        dp = [0 for i in range(n)]
        if n==1 : return nums[0]
        if n==2 : return max(nums[0],nums[1])
        dp[0] = nums[0]
        dp[1] = max(nums[0],nums[1])
        for i in range(2,n):
            dp[i] = max(dp[i-1], nums[i]+dp[i-2])
        return dp[n-1]

Coin Change:
// Time Complexity : O(mn)
// Space Complexity : O(mn) 

class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        m = amount
        n = len(coins)
        res = 0
        dp = [[99999 for _ in range(m+1)] for _ in range(n+1)]
        for i in range(n+1):
            dp[i][0] = 0
        for i in range(1,n+1):
            for j in range(1,m+1):
                if j < coins[i-1]:
                    dp[i][j]=dp[i-1][j]
                else:
                    dp[i][j]=min(dp[i-1][j],1+dp[i][j-coins[i-1]])
        if(dp[n][m]==99999):
            return -1
        else:
            return dp[n][m]

