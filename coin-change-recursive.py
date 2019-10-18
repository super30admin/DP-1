class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        def helper(coins, amount, i, mini):
            #Base case
            if amount == 0:
                return mini
            if amount < 0 or i > (len(coins)-1):
                return -1
            #Case1- Choose a coin
            case1 = helper(coins, amount - coins[i], i, mini+1)
            #Case2- Don't choose a coin
            case2 = helper(coins, amount, i+1, mini)
            if case1 == -1:
                return case2
            elif case2 == -1:
                return case1
            else:
                return min(case1,case2)
        return helper(coins, amount, 0, 0)