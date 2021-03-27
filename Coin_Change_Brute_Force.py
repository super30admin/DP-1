class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:

        if not coins:
            return -1
        else:
            return self.helper(coins, amount, 0, 0)

    def helper(self, coins, amount, index, count):
        if amount == 0:
            return count

        if amount < 0 or index == len(coins):
            return -1

        case1 = self.helper(coins, amount - coins[index], index, count + 1)
        case2 = self.helper(coins, amount, index + 1, count)
        if case1 == -1:
            return case2
        if case2 == -1:
            return case1
        return min(case1, case2)