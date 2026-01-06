''' Time Complexity : O(n) 
    Space Complexity : O(n) 
    Did this code successfully run on Leetcode : Yes
    Any problem you faced while coding this :  No

   Your code here along with comments explaining your approach
'''

class Solution:
    def rob(self, nums: List[int]) -> int:
        n = len(nums)
        if n == 1:
            return nums[0]
        if n == 2:
            return max(nums)
        dp = [0] * (n)
        for i in range(n):
            dp[i] = max(dp[i-1],dp[i-2]+nums[i])
        return dp[n-1]
