# Time Complexity : O(amount * len(coins))
# Space Complexity: O(amount * len(coins))
#  Did this code successfully run on Leetcode : Yes

class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        arr = [[0] * (amount + 1)] * (len(coins) + 1)

        for i in range(0, amount + 1):
            arr[0][i] = amount + 1

        for i in range(0, len(coins)):
            arr[i][0] = 0

        for i in range(1, len(coins) + 1):
            for j in range(1, amount + 1):
                if j < coins[i - 1]:
                    arr[i][j] = arr[i - 1][j]
                else:
                    arr[i][j] = min(arr[i - 1][j], arr[i][j - coins[i - 1]] + 1)

        return arr[len(coins)][amount] if arr[len(coins)][amount] <= amount else -1


