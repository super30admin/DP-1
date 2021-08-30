# Time COmplexity : O(n)
# Space Complexity: O(1)
# Is the problem on the leetcode: Yes
# Approach to solve the problem:
class Solution:
    def rob(self, nums: List[int]) -> int:
        n = len(nums)                        # n is length of an array
        if n == 0:                           # Edge cases
            return 0
        if n == 1:
            return nums[0]
        v1 = nums[0]                         
        v2 = max(nums[0],nums[1])            # Getting the max from the previous value
        for i in range(2,n):
            tmp = v2
            v2 = max(v2, v1+nums[i])         # Getting the max from the previous to previous value
            v1 = tmp
        return v2                            # Return the max value v2
        