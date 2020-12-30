# Time Complexity : O(N)
# Space Complexity : O(1) not using any extra space
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach


class Solution:
    def rob(self, nums: List[int]) -> int:
        """
        classic dp problem. 
        When we visit the house we add the previous Max or take current max and compare/update
        the max val at the current house.
        """
        if not nums:
            return 0
        
        prev = 0 
        curr = nums[0]
        
        for i in range(1, len(nums)):
            tempMax = max(prev + nums[i], curr)
            prev = curr
            curr = tempMax
            
        return curr