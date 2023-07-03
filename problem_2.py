#Time Complexity : O(n) ... where n is the number of houses
#Space Complexity : O(n) ... where n is the number of houses
#Any problem you faced while coding this : faced some difficulty in understanding the constraints

# Used the bottom up tabulation method of dynamic programming programming. Referenced a table where the previously solved sub-problem values were used to iteratively build the soltuion.

class Solution:
    def rob(self, nums: List[int]) -> int:
        if len(nums) >= 2:
            dp = [0 for _ in range(len(nums))]
            dp[0] = nums[0]
            dp[1] = max(nums[0], nums[1])
            for i in range(2, len(nums)):
                dp[i] = max(dp[i-1], nums[i] + dp[i-2])
            return dp[len(nums)-1]
        return nums[0]