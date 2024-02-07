'''
TC: O(n)
SC: O(1)
'''
from typing import List

class Solution:
    def rob(self, nums: List[int]) -> int:
        if len(nums)<=2:
            return max(nums)
        max1, max2 = 0,0
        for i in range(len(nums)):
            temp = max(max1+nums[i], max2)
            max1, max2 = max2, temp
        return max(max1, max2)
s = Solution()
print(s.rob([1,2,3,1]))
print(s.rob([2,7,9,3,1]))
