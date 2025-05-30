
#Time Complexity : O(MN)
# Space Complexity: O(MN) 
# Did it run on Leetcode: Yes

#------------------------------------------------- MEMOIZATION -----------------------------------------------------
class Solution(object):
    def coinChange(self, coins, amount):
        """
        :type coins: List[int]
        :type amount: int
        :rtype: int
        """
        n = len(coins)
        # Fix: Only need n rows, not n+1
        self.memo = [[-1] * (amount + 1) for _ in range(n)]
        res = self.helper(coins, 0, amount)
        return -1 if res >= 99999 else res

    def helper(self, coins, idx, amount):
        # Base cases
        if amount == 0:
            return 0
        if idx >= len(coins) or amount < 0:
            return 99999

        # Check memo
        if self.memo[idx][amount] != -1:
            return self.memo[idx][amount]

        # Option 1: Not take the current coin
        not_choose = self.helper(coins, idx + 1, amount)

        # Option 2: Choose the current coin
        choose = 1 + self.helper(coins, idx, amount - coins[idx])

        # Memoize and return
        self.memo[idx][amount] = min(choose, not_choose)
        return self.memo[idx][amount]


#-----------------------------------------------TABULATION TECHNIQUE ----------------------------------------------
class Solution(object):
    def coinChange(self, coins, amount):
        """
        :type coins: List[int]
        :type amount: int
        :rtype: int
        """
        n = len(coins)
        m = amount
        # Fix: Only need n rows, not n+1
        self.dp = [[float('inf')] * (m + 1) for _ in range(n+1)]
        self.dp[0][0] = 0
        for j in range(1,m+1):
            self.dp[0][j] = float('inf') - 10
        
        for i in range(1,n+1):
            for j in range(0,m+1):
                if j < coins[i - 1]:
                    self.dp[i][j] = self.dp[i - 1][j]
                else:
                    self.dp[i][j] = min(self.dp[i - 1][j], 1 + self.dp[i][j - coins[i-1]])
        
        return self.dp[n][m] if self.dp[n][m] < float('inf') - 10 else -1


