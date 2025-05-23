# // Time Complexity : o(n)
# // Space Complexity : O(n)
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this :
# did not check edge case where length of array could be 1 


# // Your code here along with comments explaining your approach
# 1) observe the robber can only rob every 2nd house . So if robber robs house 1 than he can rob house 3 and so on or he can rob house 2 , 4 and so on 
# 2) we have repeated subproblems where in order to compute max money he can rob from ith house can either be from i-1th house or money at ith and money he already got from robbing i-2th houses
# 3) we identify base case when there are only two houses so dp[i] is max money from house i.

from typing import List
class Solution:
    def rob(self, nums: List[int]) -> int:
        if len(nums) == 1: return nums[0]
        dp = [-1] * len(nums)
        dp[0], dp[1] = nums[0], max(nums[0], nums[1])
        for i in range(2, len(nums)):
            dp[i] = max(dp[i-1], nums[i] + dp[i-2])
        return dp[len(nums)-1]
        
