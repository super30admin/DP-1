# Time Complexity : O(mn)
# Space Complexity : O(mn)
# Did this code successfully run on Leetcode : YES
# Any problem you faced while coding this : NO


# Your code here along with comments explaining your approach
class Solution:
    def rob(self, nums: List[int]) -> int:
        dp = [-1 for _ in range(len(nums))]

        def helper(i):
            if i >= len(nums):
                return 0
            if dp[i] != -1:
                return dp[i]
                
            include = nums[i] + helper(i+2)
            exclude = helper(i+1)

            dp[i] = max(include, exclude)
            return dp[i]
        
        return (helper(0))