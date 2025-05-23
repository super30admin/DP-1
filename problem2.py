"""
Approach: Try all possible ways. if current house is robbed then skip the next index and go to the index
house after that. else go to the next index. since it has overlapping subproblems - save and return when
reaching the same index.
"""
class Solution:
    def rob(self, nums: List[int]) -> int:
        n = len(nums)
        dp = [-1 for i in range(n)]
        def recurse(index):
            if index < 0:
                return 0
            if dp[index] != -1:
                return dp[index]
            rob = nums[index] + recurse(index - 2)
            norob = recurse(index - 1)
            dp[index] = max(rob, norob)
            return dp[index]
        return recurse(n - 1)