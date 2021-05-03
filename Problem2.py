// Time Complexity : O(n) n -> len(nums)
// Space Complexity : O(n) n -> len(nums)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach



class Solution:
    def rob(self, nums: List[int]) -> int:
        dp = [[None for i in range(2)] for j in range(len(nums))]
        dp[0][0] = 0
        dp[0][1] = nums[0]
        for i in range(1,len(nums)):
            # Take the coin
            dp[i][0] = max(dp[i-1][0],dp[i-1][1])
            # Do not take the coin
            dp[i][1] = dp[i-1][0] + nums[i]
        return max(dp[len(dp)-1][0],dp[len(dp)-1][1])
