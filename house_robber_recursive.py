# Time Complexity : O(2^n) where is n is number of houses
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : No (Time Limit Exceeded)
# Any problem you faced while coding this : No

class Solution:
    def rob(self, nums: List[int]) -> int:
        
        if len(nums) == 0: return nums
        
        return self.robber(nums, 0, 0)
    
    def robber(self, nums, i, money):
        #base
        if i >= len(nums):
            return money
        #logic
        choose = self.robber(nums, i+2, money + nums[i])
        
        notChoose = self.robber(nums, i+1, money)
        
        return max(choose, notChoose)