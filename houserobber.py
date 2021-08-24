# Time Complexity : O(N) as it is single pass
# Space Complexity : O(1) 
# Did this code successfully run on Leetcode : No, only partially
# Any problem you faced while coding this : I am not getting the logic for all test cases`~

class Solution:
    def rob(self, nums) -> int:
        pEven, pOdd = 0, 0
        for i in range(len(nums)):
            if i % 2 == 0:
                pEven += nums[i]
            else:
                pOdd += nums[i]
        return max(pEven, pOdd)
            