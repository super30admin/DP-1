# Time: O(S*n)
# Space: O(S)
# Where S is the Amount and n is number of coins
class Solution:
    def coinChange(self, coins, amount):
        nums = [float("inf")] * (amount+1)
        nums[0] = 0

        for coin in coins:
            for i in range(1, len(nums)):
                if coin <= i:
                    nums[i] = min(nums[i], nums[i-coin] + 1)
        print(nums)
        return nums[-1] if nums[-1] != float("inf") else -1
