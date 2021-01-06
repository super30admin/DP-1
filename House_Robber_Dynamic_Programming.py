# Created by Aashish Adhikari at 6:44 PM 1/5/2021

'''
Time Complexity:
O ( no of houses)

Space Complexity:
O ( 2 * no of houses) ~ O(no of houses)

'''

class Solution(object):
    def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """

        if len(nums) == 0:
            return 0

        dp = [[0, 0] for idx in range(0,len(nums))]


        dp[0][0] = 0
        dp[0][1] = nums[0]



        for idx in range(1, len(nums)):



            # if dont take this house

            dp[idx][0] = max(dp[idx-1][0], dp[idx-1][1])

            # if take this house

            dp[idx][1] = dp[idx-1][0] + nums[idx]


        return max(dp[-1][0], dp[-1][1])
