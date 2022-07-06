"""
Runtime Complexity: O(n) - because we have 'n' houses and we perform a exhaustive search on every house.
Space Complexity: O(1)- no new data structure was used to compute the solution.
Yes, the code worked on leetcode.
The idea behind the algorithm is, we progress through each house by choosing or not choosing. Let's assume 'skip' is not to rob the house whereas take 
is to rob the house. skip maintains the total number of earnings so far except the current house by taking the max of previous take and skip. Whereas take just updates by adding the current house with last skip value because if we are
robbing the current house we can't rob the previous one.
"""


class Solution:
    def rob(self, nums: List[int]) -> int:
        if len(nums)==0:
            return 0
        skip = 0
        take = nums[0]
        for i in range(1, len(nums)):
            temp = skip
            skip = max(skip,take)
            take = temp+nums[i]
        return max(skip,take)
    