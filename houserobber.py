class Solution(object):
    def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """

        if len(nums) == 0:
            return 0
        # def helper(nums,index,count):
        #     if index>=len(nums):
        #         return count
        #     case1=helper(nums,index+2,count+nums[index])
        #     case2=helper(nums,index+1,count)
        #     return max(case1,case2)
        # return helper(nums,0,0)

        dp = [[0 for i in range(2)] for i in range(len(nums))]
        # dp[0][0]=0
        dp[0][1] = nums[0]
        for i in range(1, len(nums)):
            dp[i][0] = max(dp[i - 1][1], dp[i - 1][0])
            # print(dp[i-1][0])
            dp[i][1] = nums[i] + dp[i - 1][0]
        return max(dp[len(nums) - 1][0], dp[len(nums) - 1][1])
    # time-O(n) space-O(n)