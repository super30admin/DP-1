
# greedy - take every other and add them up. or try taking max, then next max etc. both fail
# we realize greedy fails so much go exhaustive

# exhaustive - choose or not to choose to rob this house 

class Solution:
	def rob(self, nums: List[int]):
		return helper()

	def helper(self, nums, i):
		# base
		if (i >= len(nums)):
			return 0 

		if(memo[i] != -1):
			return # fill in
		# no choose
		case1 = nums[i] + helper(nums, i+1)
		# choose
		case2 = nums[i] + helper(nums, i+2)

		memo[i] = max(case1,case2)


class Solution:
	def rob(self, nums: List[int]):
		n = len(nums)
		dp = []
		dp[0]=nums[0]
		dp[1]=max(nums[0],nums[1])
		for i in range(2, n):
			dp[i] = max(dp[i-1], nums[i]+dp[i-2])

		return dp[n-1]
		# try with prev and cur pointers too 

# also understand how to compute path 