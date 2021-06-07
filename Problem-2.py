"""
Approach would be same as the coin change problem.
the difference here is that your decision pattern would change a little
instead of a target you try to minimize the result.
"""

class Solution:
    def rob(self, nums: List[int]) -> int:
        # Top Down, no memo
        """
        if not nums:
            return 0
        return self.helper(nums, 0, 0)

    def helper (self, nums, index, total_robbed):
        #base
        if index >= len(nums):
            return total_robbed

        # choose to rob index house
        case0 = self.helper(nums, index + 2, total_robbed + nums[index])


        # Do not choose to rob index house
        case1 = self.helper(nums, index + 1, total_robbed)

        return max(case0,case1)
    """
        # Approach 2: Top Down - with memo

        if not nums:
            return 0

        dp = [[0] * 2 for _ in nums]

        dp[0][0], dp[0][1] = 0, nums[0]

        for i in range(1, len(dp)):
            dp[i][0] = max(dp[i - 1])
            dp[i][1] = dp[i - 1][0] + nums[i]
        return max(dp[-1])


"""
Approach 1:
TC: O(2^n) 
SC: O(n)
Approach 2:
TC: O(n)
SC: O(n)
"""