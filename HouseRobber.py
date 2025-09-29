class Solution:
    # Time Complexity : O(N) where is the N is th length of nums. Brute force without memoization, the time complexity would be O(2^n)
    # Space Complexity : O(n) recursion stack and memo hashmap
    # Did this code successfully run on Leetcode : Yes
    # Any problem you faced while coding this : No

    #The intuition is to use the 01 approach DFS top down approach. Choose one house and the not choose one house and maximize the profit

    def robDFS(self, nums: List[int]) -> int:
        memo = {}
        if len(nums) == 1: return nums[0]
        result = self.helper(nums, 0, memo)
        return result

    def helper(self, nums: List[int], idx: int, memo: map) -> int:

        # Base case
        if idx >= len(nums):
            return 0
        if idx in memo:
            return memo[idx]
        # Logic
        # 0
        case1 = self.helper(nums, idx + 1, memo)
        # 1
        case2 = nums[idx] + self.helper(nums, idx + 2, memo)
        memo[idx] = max(case1, case2)
        return memo[idx]

    # Time Complexity : O(N) where is the N is th length of nums.
    # Space Complexity : O(1) as we are only using variables
    # Did this code successfully run on Leetcode : Yes
    # Any problem you faced while coding this : No

    # This is a bottom up approach tabulation. Where we calculate at each index which is the max value and then reuse that later in the operation
    def robIterative(self, nums: List[int]) -> int:
        if len(nums) == 1: return nums[0]
        rob1 = nums[0]
        rob2 = max(nums[0], nums[1])

        for i in range(2, len(nums)):
            temp = rob2
            rob2 = max(rob2, nums[i] + rob1)
            rob1 = temp

        return rob2

