# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach
from typing import List
class Solution:
    def rob(self, nums: List[int]) -> int:
        if (nums is None or len(nums)==0):
            return 0
        if (len(nums)<2): return nums[0]
        prev = nums[0]
        curr = max(nums[0], nums[1])

        for i in range(2, len(nums)):
            temp = curr
            curr = max(curr, prev+nums[i])
            prev = temp
        return curr

sc = Solution()
nums = [1,2,3,1]
print(sc.rob(nums))