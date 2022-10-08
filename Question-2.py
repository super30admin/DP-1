#Time Complexity : O(n)
#Space Complexity : O(1)
#Did this code successfully run on Leetcode : Yes

class Solution:
    def rob(self, nums: List[int]) -> int:
        #edge case
        if len(nums) <= 2:
            return max(nums)
        
        #dp (less space)
        L = len(nums)
        a, b = nums[0], max(nums[0], nums[1])
        
        for i in range(2, L):
            a, b = b, max(a + nums[i], b)
        
        return b