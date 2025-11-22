class Solution:
    '''
    Here first we take the length of the nums.
    side note we check if n == 1 we return nums[0].
    second we make the dp list of n elements with 0.
    third we assign nums[0] to dp[0].
    fourth we assign max(nums[0], nums[1]) to dp[1].
    fifth we do a for loop from 2 to n. as 0 and 1 are already computed.
    sixth we assign in dp[i] the max of dp[i - 1] and nums[i] + dp[i - 2].
    now once the loop ends, we return dp[-1].
    time complexity: O(2n).
    space complexity: O(n).
    '''
    def rob(self, nums):
        n = len(nums)
        if n == 0:
            return 0
        if n == 1:
            return nums[0]
        dp = [0] * n
        dp[0] = nums[0]
        dp[1] = max(nums[0],nums[1])
        for i in range(2, n):
            dp[i] = max(dp[i - 1], nums[i] + dp[i - 2])
        
        return dp[-1]

    def helper(self, nums, idx):
        # base
        if idx >= len(nums):
            return 0

        # logic
        case0 = self.helper(nums, idx + 1)

        case1 = nums[idx] + self.helper(nums, idx + 2)

        return max(case0, case1)

    def rob_rec(self, nums):
        '''
        first we will check if the list has only 1 element, return that element.
        now call helper function.
        in base case check if the idx is greater than or equal to the n, if true return 0.
        for case0 call helper with same nums, and idx + 1
        for case1 add nums[idx] and helper with params nums, idx + 2.
        in end return max of case0 and case1.
        TC: O(2^n).
        SC: O(1)
        '''
        if len(nums) == 1:
            return nums[0]
        
        return self.helper(nums, 0)



s = Solution()
nums = [1,2,3,1]
print(s.rob(nums))
print(s.rob_rec(nums))
nums = [2,7,9,3,1]
print(s.rob(nums))
print(s.rob_rec(nums))

