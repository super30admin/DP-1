# Time Complexity: O(n) where n is the length of nums
# Space Complexity: O(n) where n is the length of nums
#  Did this code successfully run on Leetcode : Yes
#  Any problem you faced while coding this : No

class Solution:
    def rob(self, nums: List[int]) -> int:
        dp = [[0 for _ in range(2)]for _ in range(len(nums))]
        dp[0][1] = nums[0]
        for i in range(1, len(nums)):
            dp[i][0] = max(dp[i-1][0], dp[i-1][1]) # not choose
            dp[i][1] = dp[i-1][0] + nums[i] # choose
        return max(dp[-1])
        
    #     return self.helper(nums,0,0)
    # def helper(self, nums, index, amount):
    #     # base
    #     if index >= len(nums):
    #         return amount

    #     #logic
    #     #choose
    #     choose = self.helper(nums, index+2, amount + nums[index])
    #     notChoose = self.helper(nums, index+1, amount)
    #     return max(choose, notChoose)
