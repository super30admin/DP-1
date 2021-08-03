class Solution:
    """
    Recursion exhasutive brute force approach
    TC - O(n^2)
    SC -
    """

    def rec(self, coins, amount, mincoins, index) -> int:
        if amount == 0:
            return mincoins
        if index >= len(coins) or amount < 0:
            return -1
        nothing = self.rec(coins, amount, mincoins, index + 1)
        picking = self.rec(coins, amount - coins[index], mincoins + 1, index)
        if nothing == -1:
            return picking
        if picking == -1:
            return nothing
        return min(nothing, picking)

    """
        DP matrix approach
        TC - O(nxm)
        SC - O(nxm)
    """

    def approach2(self, coins: List[int], amount: int) -> int:
        dp = [[0 for i in range(amount + 1)] for j in range(len(coins) + 1)]

        for k in range(1, amount + 1):
            dp[0][k] = amount + 1

        for i in range(1, len(dp)):
            for j in range(1, len(dp[0])):
                if j < coins[i - 1]:
                    dp[i][j] = dp[i - 1][j]
                else:
                    dp[i][j] = min(dp[i - 1][j], dp[i][j - coins[i - 1]] + 1)
        result = dp[len(dp) - 1][len(dp[0]) - 1]
        if result == amount + 1:
            return -1
        return result

    def coinChange(self, coins: List[int], amount: int) -> int:
        if coins is None or len(coins) == 0:
            return -1
        count = 0
        # return self.rec2(coins,amount,0,0)
        return self.approach2(coins, amount)