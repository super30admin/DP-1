#Time Complexity: O(n)
#Space Complexity: O(n)
#Did it run on Leetcode: Yes

class Solution:
    def rob(self, nums: List[int]) -> int:
        dp = {}
        dp[-1] = 0
        dp[0] = nums[0]
        for i in range(1,len(nums)) :
            dp[i] = max(dp[i-2]+nums[i],dp[i-1])
            
        return dp[len(nums)-1]