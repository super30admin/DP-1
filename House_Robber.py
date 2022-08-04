// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes



class Solution:
    def rob(self, nums: List[int]) -> int:
        
        prev = 0
        curr = 0
        for i in range(len(nums)):
            temp = curr
            curr = max(curr,prev+nums[i])
            prev = temp
            
        return curr
        