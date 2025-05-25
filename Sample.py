# Time Complexity : O(N)
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : YES
# Any problem you faced while coding this : NO
# Any problem you faced while coding this : NO
# use the recurrence pattern either rob currrent house and add it to the sum 2 poistions previous to that , or take the sum from i-1 poistions ago 

    def rob(self, nums: List[int]) -> int:
        if len(nums) == 1:
            return nums[0]
        nums[1] = max(nums[0],nums[1])
        for i in range(2, len(nums)):
            nums[i] = max(nums[i-1], nums[i] + nums[i-2])
        return nums[-1]


# Time Complexity : O(N^2)
# Space Complexity : O(N^2)
# Did this code successfully run on Leetcode : YES
# Any problem you faced while coding this : NO
# made a 2d array with rows as the coins available anD COL AS AMOUNT AND use recurrence relation to fill up the matrix and return the last element  

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




