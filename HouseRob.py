# Time Complexity: O(n)
# Space Complexity: O(1)
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this: No

from ast import List


class HouseRob:
    def rob(self, nums: List[int]) -> int:
        pre1 = 0
        pre2 = 0
        for i in nums:
            dp = max(pre1, (pre2 + i))
            pre2 = pre1
            pre1 = dp
        return pre1