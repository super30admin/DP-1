# Brute Force solution using Recursion.
#  Time complexity is exponential O(2^n). Since we have 2 decisions to make at every point and there are n such possibilites
# Space Complexity is O(n)
# The solution will fail on some cases due to Max. Recursive length reached
class Solution:
    def rob(self, nums: List[int]) -> int:
        if not nums: return 0
        return self.helper(nums,idx=0,amt=0)
    def helper(self,nums,idx,amt):
        # Base Case
        if idx >= len(nums): return amt
        # Recursive Case
        pick = self.helper(nums,idx+2,amt+nums[idx])
        skip = self.helper(nums,idx+1,amt)
        return max(pick,skip)
