# Time Complexity: O(n) where n = length of nums
# Space Complexity: O(n) where n = length of nums
# Did this code successfully run on Leetcode : Yes
# DP with 1D space as only 1 variable determines the output.
# We intiate, dp[0]=nums[0] and dp[1]=max(nums[0],nums[1])
# Then, loop over 2nd element to end of nums array, and assign dp[i] with maximum between robbing current house (nums[i]) and robbing i-2 house and robbing previous house.

class Solution:
    def rob(self, nums: List[int]) -> int:
        if len(nums)==0:
            return 0
        elif len(nums)==1:
            return nums[0]

        dp=[0 for _ in range(len(nums))]
        dp[0]=nums[0]
        dp[1]=max(nums[0],nums[1])
        for i in range(2,len(nums)):
            dp[i]=max(dp[i-1],nums[i]+dp[i-2])
        return dp[-1]
