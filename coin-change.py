# convert to 1-d space optimized
# time: O(n+m)
# space(O(n))
# overwrite previous row compared to 2d
# for making amt 5 with coins [1,2,5] I require 1 coin
class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:

        rows = [0]*(amount+1)
        dp =[float('inf')]*(amount+1)
        dp[0]=0

        for col in range(1,len(dp)):
            dp[col]=float('inf')
        # i = row, j=col

        for i in range(1,len(coins)+1):
            for j in range(amount+1):
                # this coin is larger than the current amount
                if j < coins[i-1]:
                    dp[j]=dp[j]
                else:
                    dp[j] = min(dp[j], 1+dp[j-coins[i-1]])
 
        if dp[-1] == float('inf'):
            return -1
        return dp[-1]


# recursive - time limit exceeded
# greedy solution to this problem would always pick the largest coin that is less or equal to remaining amount. Fails for [1,3,4] target=6

# exhaustive solution - try every possible combination of coins to see which one works best 
# Approach build a tree and at each branch we choose or don't choose the coin at i
# Repeated subproblem - using coins [t,r] make amount X with min number of coins
# time: O(S^n) - exponential in the number of coins n, S is amount - every coin could have at most S/ci values 
# space: O(n) - max depth of recursion is O(n)
class Solution:
	def coinChange(self,coins: List[int], amount: int):
		re = self.helper(coins, 0, amount, 0)
		memo = [[0] * (amount+1) for _ in range(len(coins)+1)]
		if (re == float('inf')):
			return -1 

		return re 

	def helper(self, coins, i, amount, coinsUsed):
		# base case
		# i == len(coins) - we've exceeded number of coins we can use without getting to amount 0
		if amount < 0 or i == len(coins):
			return float('inf')

		if amount == 0:
			return coinsUsed 

		if(memo[i][amount] != 0):
			return memo[i][amount]

		# don't choose this coin, so increment i to next coin
		case0 = self.helper(coins, i+1, amount, coinsUsed)
		# choose this coin, so subtract coin at i from amount and increment coinsUsed
		case1 = self.helper(coins, i, amount - coins[i], coinsUsed+1)
		re = min(case0, case1)
		memo[i][amount] = res 
		return min(case0, case1)

# dp 2d:
# O(n+m) time, O(n+m) space
class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:

        rows = [0]*(amount+1)
        dp = []
        dp =[[0]*(amount+1) for _ in range(len(coins)+1)]

        for col in range(1,len(dp[0])):
            dp[0][col]=float('inf')
        # i = row, j=col

        for i in range(1,len(dp)):
            for j in range(len(dp[0])):
            	# this coin is larger than the current amount
                if j < coins[i-1]:
                    dp[i][j]=dp[i-1][j]
                else:
                    dp[i][j] = min(dp[i-1][j], 1+dp[i][j-coins[i-1]])
 
        posC = len(rows)-1
        posR = len(coins)
        if dp[posR][posC] == float('inf'):
            return -1
        return dp[posR][posC]


### to find the coins used:
# check if value came from row above;
# Backtracking to find coins
        # used_coins = []
        # i, j = len(coins), amount
        
        # while i > 0 and j > 0:
        #     # Check if the value came from the row above
        #     if dp[i][j] == dp[i-1][j]:
        #         i -= 1
        #     else:
        #         # This coin was used
        #         used_coins.append(coins[i-1])
        #         j -= coins[i-1]
        
        # print(f"Coins used: {used_coins}")


