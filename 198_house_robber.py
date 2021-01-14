from typing import List
from math import inf


class Solution:
    def rob(self, nums: List[int]) -> int:
        # """
        #     // Time Complexity : O(n)
        #     // Space Complexity : O(n)
        #             Where 'n' is the number of homes in nums
        #     // Did this code successfully run on Leetcode :
        #             Yes
        #     // Any problem you faced while coding this :
        #             Took time to come up with the Bellman equation
        #     // Your code here along with comments explaining your approach
        #             The idea is not to choose the adjacent houses. When we
        #             are the ith house, we need to make a choice, should I rob
        #             the previous house or the house adjacent to me.
        #             Bellman Equation:
        #             OPT[i] = {                                  if
        #                         nums[i]                         i == 0
        #                         max(nums[0],nums[1])            i == 1
        #                         max(dp[i-1],nums[i]+dp[i-2]     else     }
        #             Each sub-problem has the answer to the question, IF I ROB THE iTH HOUSE, What is the
        #             maximum amount I can get?
        # """
        # if not nums:
        #     return 0
        # if len(nums) == 1:
        #     return nums[0]
        # dp = [-inf for i in range(len(nums))]
        # dp[0] = nums[0]
        # dp[1] = max(nums[0], nums[1])
        # for i in range(2, len(dp)):
        #     dp[i] = max(dp[i - 1], nums[i] + dp[i - 2])
        # return dp[-1]

        # if not nums:
        #     return 0
        # # The second index represents if I don't rob the ith house
        # # what will be the amount and I rob the ith house what I will get
        # # Index 0 : Don't choose to rob house
        # # Index 1: Choose to rob the house
        # dp = [[0 for j in range(0, 2)] for i in range(0, len(nums))]
        # # don't rob the first house
        # dp[0][0] = 0
        # # rob the first house
        # # we get the value from that house
        # dp[0][1] = nums[0]
        # for i in range(1, len(nums)):
        #     # case1
        #     # don't rob the ith house
        #     # the maximum amount we can get if I
        #     # choose or not choose to rob the previous house
        #     dp[i][0] = max(dp[i - 1][0], dp[i - 1][1])
        #     # case 2
        #     # rob the ith house
        #     # I can't rob the previous house
        #     # But I can add the sum I would have gotten
        #     # if I don't rob the previous house
        #     dp[i][1] = nums[i] + dp[i - 1][0]
        #
        # return max(dp[len(nums) - 1][0], dp[len(nums) - 1][1])
        """
            // Time Complexity : O(n)
            // Space Complexity : O(1)
        """
        if not nums:
            return 0
        not_chosen = 0
        chosen = 0
        for i in range(0, len(nums)):
            # previous not chosen
            prev_not_chosen = not_chosen
            # don't choose ith house
            # these chosen and not_chosen are the previous values
            not_chosen = max(chosen, not_chosen)
            # choose ith house
            # the current house and the earnings of not_chosen
            chosen = nums[i] + prev_not_chosen
        return max(chosen, not_chosen)

    def rob_brute_force(self, nums: List[int]) -> int:
        """
            // Time Complexity : Exponential
            // Space Complexity : Height of tree
        """
        return self.helper(nums, 0, 0)

    def helper(self, nums: List[int], index: int, amount: int):
        # base case
        if index >= len(nums):
            return amount
        print(amount, nums[index:])
        # Logic
        # case 1
        # choose this house to rob
        case1 = self.helper(nums, index + 2, amount + nums[index])

        # case 2
        # don't choose this house to rob
        case2 = self.helper(nums, index + 1, amount)
        return max(case1, case2)


if __name__ == '__main__':
    h = Solution()
    print(h.rob([1, 2, 3, 1]))
    # print(h.rob_brute_force([1, 2, 3, 1]))
