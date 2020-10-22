# Time Complexity:- O(n)
# Space Complexity:- O(n)
# Approach:- At every point we have two choices rob the first house and then we can get the max-profit from the 
# rest of i+2 houses, or rob the next house and get the max profit you can make from there.
class Solution:
    def rob(self, nums: List[int]) -> int:
        @lru_cache(maxsize=None)
        def max_rob(i):
            if i>=len(nums):
                return 0
            return max(nums[i]+max_rob(i+2),max_rob(i+1))
        return max_rob(0)