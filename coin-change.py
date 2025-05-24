# Time Complexity : O(n*m)
# Space Complexity : O(n*m)
# Did this code successfully run on Leetcode :yes
# Any problem you faced while coding this :no


# Your code here along with comments explaining your approach

#using DP and tabulation


def coinChange(self, coins, amount):

	dp_matrix = [[None for i in range((amount + 1))] for j in range(len(coins) + 1)]

	for i in range(len(coins) + 1):

		dp_matrix[i][0] = 0 # populate coins to be used

	for j in range(1, len(dp_matrix[0])):

		dp_matrix[0][j] = 99999 #populate each column of first row with infinity

	for i in range(1, len(dp_matrix)):

		for j in range(1, len(dp_matrix[0])):

			if j < coins[i - 1]:

				dp_matrix[i][j] = dp_matrix[i - 1][j]

			else:

				dp_matrix[i][j] = min(dp_matrix[i - 1][j], 1 + dp_matrix[i][j - coins[i - 1]])

                # current_val = min(previous_row_val, 1 + min_coins_for_remaining )

	if dp_matrix[-1][-1] >= 99999:
		return -1

	return dp_matrix[-1][-1]