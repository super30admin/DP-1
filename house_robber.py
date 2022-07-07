# Space Complexity: O(1)
# Time Complexity: O(n)
# Choose Not choose approach
from typing import List
class Solution:
    def rob(self, nums: List[int]) -> int:
        n = len(nums)
        skip = 0
        choose = nums[0]
        for i in range(1,n):
            temp = skip
            skip = max(choose, skip)
            choose = temp + nums[i]
              
        return max(skip, choose)