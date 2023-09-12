# Time Complexity: O(amount * numberOfCoins)
# Space Complexity: O(amount) #  O(amount * numberOfCoins) for 2D
#  Did this code successfully run on Leetcode : Yes
#  Any problem you faced while coding this : No
class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        dp = [[0 for _ in range(amount+1)] for _ in range(len(coins)+1) ]
        for i in range(1, amount+1):
            dp[0][i] = float("inf")
        for i in range(1, len(dp)):
            for j in range(1, len(dp[0])):
                if j < coins[i-1]:
                    dp[i][j] = dp[i-1][j]
                else:
                    dp[i][j] = min(dp[i-1][j], dp[i][j - coins[i-1]] + 1)
        if dp[-1][-1] == float("inf"):
            return -1
        return dp[-1][-1]

    #     return self.helper(coins, 0, amount, 0)
    # def helper(self, coins, index, remainingAmount, count):
    #     #base
    #     if remainingAmount == 0:
    #         return count
    #     if index == len(coins) or remainingAmount < 0:
    #         return -1

    #     #action
    #     choose = self.helper(coins, index, remainingAmount - coins[index], count +1)
    #     notChoose = self.helper(coins, index + 1, remainingAmount,  count )

    #     if choose == -1:
    #         return notChoose
    #     if notChoose == -1:
    #         return choose
    #     return min(choose, notChoose)
