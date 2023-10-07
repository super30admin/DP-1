class Solution(object):

    ###
    # Recursion
    ####

    # TC: O(2^n) where n = num of elements in nums
    # SC: Scales with depth of recursion stack again based on number of elements in nums

    def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        return self.helper(nums, 0, 0)

    def helper(self, nums, amt, idx):
        # base
        if idx >= len(nums):
            return amt

        # choose
        case1 = self.helper(nums, amt+nums[idx], idx+2)
        # not choose
        case2 = self.helper(nums, amt, idx+1)

        return max(case1, case2)

    ####
    # DP - using 1D array
    ####

    # TC: O(n)
    # SC: O(n)
    def rob(self, nums):
        n = len(nums)
        # initiating a 1D array since there is only one input nums - SC: O(n)
        dp = [0] * (n)

        if n == 0:  # if no element in the nums array, return 0
            return 0

        if n == 1:  # if there is only one element, return just that element
            return nums[0]

        dp[0] = nums[0]
        dp[1] = max(nums[0], nums[1])

        for i in range(2, n):  # TC: O(n)
            # dp at any idx = max of previous idx in dp & curr value + value of idx-2 in dp
            dp[i] = max(nums[i] + dp[i-2], dp[i-1])

        return dp[n-1]  # last element in the dp array is the ans

    ####
    # DP - using prev, curr
    ####
    # TC: O(n)
    # SC: O(1)

    def rob(self, nums):
        n = len(nums)

        if n == 0:  # if no element in the nums array, return 0
            return 0

        if n == 1:  # if there is only one element, return just that element
            return nums[0]

        prev = nums[0]
        curr = max(nums[0], nums[1])

        for i in range(2, n):  # TC: O(n)
            temp = curr
            curr = max(nums[i] + prev, curr)
            prev = temp

        return curr  # last element in the dp array is the ans


obj = Solution()
print(obj.rob([2, 1, 0, 3, 5, 4]))
