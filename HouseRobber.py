# Time Complexity : O(n), where n is the number of houses
# Space Complexity : O(n), this solution uses O(n) space to store dp[] all values
# Did this code successfully run on Leetcode : yes

# Your code here along with comments explaining your approach
# main idea is dp[i] = max(dp[i-2]+nums[i], dp[i-1]) #either to rob current house or not

class Solution:
    def rob(self, nums: List[int]) -> int:
        if(len(nums)==0 or not nums):
            return 0
        
        if(len(nums)==1):
            return nums[0]
        
        if(len(nums)==2):
            return max(nums[0], nums[1])
        
        dp = [0]*len(nums)
        dp[0] = nums[0]
        dp[1] = max(nums[0], nums[1])
        
        for i in range(2,len(nums)):
            dp[i] = max(nums[i]+dp[i-2], dp[i-1])
        
        return dp[-1]