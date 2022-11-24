"""
    Problem Statement: House Robber

    Approach: Follow the zero-one recursion approach and save the choice made in the previous
              step in the dp matrix to avoid recomputing the subproblems.

    Time complexity: O(n)

    Space complexity: O(n) avg 

    Accepted on LeetCode? Yes! 

    LeetCode Link: https://leetcode.com/problems/house-robber

    Date: 23 November 2022
"""

from typing import List

class Solution:
    def rob(self, nums: List[int]) -> int:
        n = len(nums)
        skip, take = 0, nums[0]

        for i in range(1, n):
            temp = max(skip, take)
            take = skip + nums[i]
            skip = temp

        return max(skip, take) 

if __name__ == "__main__":
    sol = Solution()
    nums = [2, 7, 9, 3, 1]
    ret = sol.rob(nums)
    print(ret)

    assert ret == 12