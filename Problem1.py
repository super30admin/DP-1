## Problem1 (https://leetcode.com/problems/coin-change/)

#Solution -> 

def coinChange(self, coins, amount):
		dp_matrix = [[None for i in range((amount + 1))] for j in range(len(coins) + 1)]
		for i in range(len(coins) + 1):
			dp_matrix[i][0] = 0
		for j in range(1, len(dp_matrix[0])):
			dp_matrix[0][j] = 9999
		for i in range(1, len(dp_matrix)):
			for j in range(1, len(dp_matrix[0])):
				if j < coins[i - 1]:
					dp_matrix[i][j] = dp_matrix[i - 1][j]
				else:
					dp_matrix[i][j] = min(dp_matrix[i - 1][j], dp_matrix[i][j - coins[i - 1]] + 1)
		if dp_matrix[-1][-1] >= 9999:
			return -1
		return dp_matrix[-1][-1]

# Time Complexity -> o(n)
# Space Complexity -> o(a*n) where a is the amount and n is the number of coins



