# Time complexity: O(n) where n is the amount value
# Space complexity: O(n) where n is the amount value
# Did this run successfully on Leetcode: Yes
# Did you face any problem in solving this: No, I had solved this problem earlier
class Solution:
    def coinChange(self, coins, amount):
        memo = [float('inf')]*(amount+1)
        memo[0] = 0

        for amt in range(1, amount+1):
            for coin in coins:
                if amt >= coin:
                    memo[amt] = min(memo[amt], memo[amt-coin]+1)

        return memo[amount] if memo[amount] != float('inf') else -1


solution = Solution()
print(solution.coinChange([1, 2, 5], 11))
