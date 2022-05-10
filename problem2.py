# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach
class Solution:
    def rob(self, nums: List[int]) -> int:
        self.dp = [None for i in range(len(nums))]
        return self.robHouse(nums,0)
    def robHouse(self,nums,index):
        if index >= len(nums):
            return 0
        
        if self.dp[index] == None:
            rob = nums[index]+self.robHouse(nums,index+2)
            notRob = self.robHouse(nums,index+1)

            self.dp[index] = max(rob,notRob)
        return self.dp[index]