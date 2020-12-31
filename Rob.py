'''
    Time Complexity:
        O(n) (where n is the length of the given array)

    Space Complexity:
        O(n) (where n is the length of the given array)

    Did this code successfully run on LeetCode?:
        Yes

    Problems faced while coding this:
        None

    Approach:
        Top Down Memoized DP approach.
        Traverse the array.
        In each traversal, either choose this and skip the next.
        Or choose next.
        Return the max of those two.
'''
class Solution:
    def __init__(self):
        self.dp = {}
        self.nums = []

    def rob(self, nums: List[int]) -> int:
        self.nums = nums
        return self.find_max(0)

    def find_max(self, idx):
        if idx in self.dp:
            return self.dp[idx]

        if idx >= len(self.nums):
            return 0

        select = self.nums[idx] + self.find_max(idx + 2)
        ignore = self.find_max(idx + 1)
        self.dp[idx] = max(select, ignore)
        return self.dp[idx]
