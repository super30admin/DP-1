# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

from typing import List


class Solution:
    def rob(self, nums: List[int]) -> int:
        no_of_houses = len(nums)
        if no_of_houses == 1:
            return nums[0]
        prev = nums[0]
        cur = max(nums[1], nums[0])
        for i in range(2, no_of_houses):
            temp = cur
            cur = max(cur, nums[i] + prev)
            prev = temp
        return cur


if __name__ == '__main__':
    arr = [2, 7, 9, 3, 1]
    print(Solution().rob(arr))
