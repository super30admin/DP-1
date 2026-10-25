"""
LeetCode 198: House Robber

Approach:
At each house you either skip it, keeping the best total up to the previous
house, or rob it, adding its money to the best total from two houses back
(since the adjacent house is off limits). This gives the recurrence
best(i) = max(best(i-1), nums[i] + best(i-2)). Because each step only needs
the previous two results, you can keep two variables (prev and current)
instead of a full DP array and slide them forward as you loop. This runs in
O(n) time and O(1) space.
"""


# ---------------------------------------------------------------------------
# Version 1: Plain recursion (brute force)
# Time: O(2^n), Space: O(n)
# ---------------------------------------------------------------------------
from __future__ import annotations
class SolutionRecursive:
    def rob(self, nums: list[int]) -> int:
        if nums is None or len(nums) == 0:
            return 0
        return self.helper(nums, 0)

    def helper(self, nums: list[int], idx: int) -> int:
        # Ran past the last house: nothing left to rob
        if idx >= len(nums):
            return 0

        # Choice 1: don't rob this house, move to the next one
        dont_choose = self.helper(nums, idx + 1)

        # Choice 2: rob this house, skip the adjacent one
        choose = nums[idx] + self.helper(nums, idx + 2)

        return max(dont_choose, choose)


# ---------------------------------------------------------------------------
# Version 2: Bottom-up DP array
# Time: O(n), Space: O(n)
# ---------------------------------------------------------------------------
class SolutionDP:
    def rob(self, nums: list[int]) -> int:
        if nums is None or len(nums) == 0:
            return 0
        if len(nums) == 1:
            return nums[0]

        dp = [0] * len(nums)
        dp[0] = nums[0]                    # only one house available
        dp[1] = max(nums[0], nums[1])      # take the larger of the first two

        for i in range(2, len(nums)):
            # skip house i (dp[i-1]) or rob it (dp[i-2] + nums[i])
            dp[i] = max(dp[i - 1], dp[i - 2] + nums[i])

        return dp[-1]


# ---------------------------------------------------------------------------
# Version 3: Two variables (OPTIMAL) -> submit this one on LeetCode
# Time: O(n), Space: O(1)
# ---------------------------------------------------------------------------
class Solution:
    def rob(self, nums: list[int]) -> int:
        if nums is None or len(nums) == 0:
            return 0
        if len(nums) == 1:
            return nums[0]

        prev = nums[0]                       # best through house i-2
        current = max(nums[0], nums[1])      # best through house i-1

        for i in range(2, len(nums)):
            temp = current
            current = max(prev + nums[i], current)   # rob house i, or skip it
            prev = temp                              # slide the window forward

        return current


# ---------------------------------------------------------------------------
# Test cases
# ---------------------------------------------------------------------------
if __name__ == "__main__":
    # (input, expected, description)
    test_cases = [
        ([1, 2, 3, 1],       4,  "Rob houses 0 and 2 (1 + 3)"),
        ([2, 7, 9, 3, 1],    12, "Rob houses 0, 2, 4 (2 + 9 + 1)"),
        ([5],                5,  "Single house"),
        ([2, 1],             2,  "Two houses, take the larger"),
        ([1, 2],             2,  "Two houses, larger is second"),
        ([2, 1, 1, 2],       4,  "Rob both ends; greedy 'biggest first' fails"),
        ([0, 0],             0,  "All zeros"),
        ([],                 0,  "Empty input (safe guard)"),
        ([5, 5, 5, 5, 5],    15, "All equal: rob every other house"),
        ([1, 3, 1, 3, 100],  103, "Big value at the end"),
        ([100, 1, 1, 100],   200, "Big values at both ends"),
        ([10, 9, 8, 7, 6],   24, "Decreasing values (10 + 8 + 6)"),
    ]

    solutions = [
        ("Recursive", SolutionRecursive()),
        ("DP array",  SolutionDP()),
        ("Optimal",   Solution()),
    ]

    all_passed = True
    for name, sol in solutions:
        print(f"--- {name} ---")
        for nums, expected, desc in test_cases:
            result = sol.rob(nums)
            status = "PASS" if result == expected else "FAIL"
            if result != expected:
                all_passed = False
            print(f"[{status}] nums={nums} expected={expected} got={result} | {desc}")
        print()

    print("ALL TESTS PASSED" if all_passed else "SOME TESTS FAILED")