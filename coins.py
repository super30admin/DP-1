# // Time Complexity : O(N * K)
# // Space Complexity : O (N)
# // Did this code successfully run on Leetcode : 0(n)
# // Any problem you faced while coding this : yes, could not get the logic right


def coinChange(self, coins: List[int], amount: int) -> int:
        dp = [amount + 1]*(amount+1)
        for i in range(1, amount+1):
            for coin in coins:
                if(i > coin):
                    dp[i] = min(dp[i-coin] + 1, dp[i])
            dp[i] = dp[i-1] + 1
        
        return dp[-1]