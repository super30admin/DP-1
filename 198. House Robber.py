# // Time Complexity : O(n)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No


# // Your code here along with comments explaining your approach
# // Find the subproblem, create a DP matrix and return the max element at the end of the iteration

class Solution:
    def rob(self, nums: List[int]) -> int:
        if not nums:
            return 0
        
        skip = 0
        take = nums[0]
        
        for i in range(1,len(nums)):
            temp = skip
            skip = max(skip,take)
            take = nums[i] + temp
            
        return max(skip,take)
        