# Time Complexity : O (2n) where n is the number of coins, 2 is whether it is chosen or not
# Space Complexity : O (2n)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : No

class Solution:
    def rob(self, nums: List[int]) -> int:

        if len(nums) == 0:
            return 0

        homes = len(nums)

        #Here we initalize the Dynamic Structure to refer the previous values in each execution
        dpMatrix = [[None for j in range(2)] for i in range(homes)]

        #Here 0 will represent the house is not chosen
        dpMatrix[0][0] = 0

        # Here 1 will represent the house is  chosen
        dpMatrix[0][1] = nums[0]



        for i in range(1, homes):

            #if a house not chosen we will get the max value of previous home based on chosen or not
            dpMatrix[i][0] = max(dpMatrix[i - 1][0], dpMatrix[i - 1][1])

            #if the house is chosen we will add the current hous value with the value of previous home when not chosen.
            dpMatrix[i][1] = nums[i] + dpMatrix[i - 1][0]

        #finally we compare the last row and find the max value, which will be our max profit from the homes.
        return max(dpMatrix[-1][0], dpMatrix[-1][1])
