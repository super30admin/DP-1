from typing import List
from math import inf


class Solution:
    def rob(self, nums: List[int]) -> int:
        """
            // Time Complexity : O(n)
            // Space Complexity : O(n)
                    Where 'n' is the number of homes in nums
            // Did this code successfully run on Leetcode :
                    Yes
            // Any problem you faced while coding this :
                    Took time to come up with the Bellman equation
            // Your code here along with comments explaining your approach
                    The idea is not to choose the adjacent houses. When we
                    are the ith house, we need to make a choice, should I rob
                    the previous house or the house adjacent to me.
                    Bellman Equation:
                    OPT[i] = {                                  if
                                nums[i]                         i == 0
                                max(nums[0],nums[1])            i == 1
                                max(dp[i-1],nums[i]+dp[i-2]     else     }
                    Each sub-problem has the answer to the question, IF I ROB THE iTH HOUSE, What is the
                    maximum amount I can get?
        """
        if not nums:
            return 0
        if len(nums) == 1:
            return nums[0]
        dp = [-inf for i in range(len(nums))]
        dp[0] = nums[0]
        dp[1] = max(nums[0], nums[1])
        for i in range(2, len(dp)):
            dp[i] = max(dp[i - 1], nums[i] + dp[i - 2])
        return dp[-1]


if __name__ == '__main__':
    h = Solution()
    print(h.rob([1, 2, 3, 1]))
