class Solution(object):
    # Using exhaustive, recursive solution
    # TC: O(2^m+n) i.e exponential where m=# of coins and n = amount
    # SC: based on recursion depth

    # def coinChange(self, coins, amount):
    #     """
    #     :type coins: List[int]
    #     :type amount: int
    #     :rtype: int
    #     """
    #     if len(coins) == 0:
    #         return -1

    #     temp=self.helper(coins, amount, 0, 0)
    #     if temp == float('inf'):
    #         return -1
    #     else:
    #         return temp

    # def helper(self, coins, amount, idx, coinsUsed):
    #     # base case
    #     if amount == 0:
    #         return  coinsUsed
    #     if amount < 0 or idx == len(coins):
    #         return float('inf') # a very high number or infinity
    #     # choose
    #     case1 = self.helper(coins, amount-coins[idx],idx, coinsUsed+1 )
    #     # not choose
    #     case2 = self.helper(coins, amount,idx +1, coinsUsed   )

    #     if case1 == float('inf'):
    #       return case2
    #     if case2 == float('inf'):
    #       return case1

    #     return min(case1, case2)

    # DP
    # TC: O(mxn)
    # SC: O(mxn)
    def coinChange(self, coins, amount):
        m = len(coins)
        n = amount

        dp = [(n+1) * [0]] * (m+1)  # create 2D matrix of m+1*n+1
        # fill first row will dummy values
        dp[0][0] = 0
        for j in range(1, n+1):
            dp[0][j] = float('inf')

        for i in range(1, m+1):
            for j in range(1, n+1):
                if j < coins[i-1]:
                    # until i,j element is < curr amount, just copy the element from previous row for the same amount
                    dp[i][j] = dp[i-1][j]
                else:
                    # else - take min of (previous row same amt, element at (current i,j - denomination) + 1 )
                    dp[i][j] = min(dp[i-1][j], (dp[i][j-coins[i-1]]) + 1)

        # if the last m*n block of mtrix is infinity, no solution possible return -1
        if dp[m][n] >= float('inf'):
            return -1
        else:
            return dp[m][n]  # else: return last block
