"""
https://leetcode.com/problems/house-robber/



Ran on leetcode=yes
Approach- we fil initial values of matrix not chose to be 0 and chose to nums[0]
for chosing from row 1 to n, we take max of the previos row whether chosing or not chosing
for not chosing from row 1 to n, we add previous not chosen value with the cost of the current house

Tc: O(n)
SC:O(n)
"""
class Solution:
    ###dp solution below
    def rob(self, nums):
        if len(nums)==0:
            return 0

        ###dp matrix initialization
        dpMatrix=[[0 for _ in range(2)] for i in range(len(nums))]
        dpMatrix[0][0]=0
        dpMatrix[0][1]=nums[0]

        for i in range(1,len(nums)):
            dpMatrix[i][0]=max(dpMatrix[i-1][0], dpMatrix[i-1][1] )
            dpMatrix[i][1]=dpMatrix[i-1][0]+nums[i]
        return max(dpMatrix[len(dpMatrix)-1])


    ###recursive solution below
    #     return self.helper(nums, 0, 0)
    #
    # def helper(self, nums, index, maxrobAmount):
    #     ###base case
    #     if index >=len(nums):
    #         return maxrobAmount
    #
    #     ###chose
    #     case1=self.helper(nums, index+2, maxrobAmount+nums[index])
    #
    #     ###not chose
    #     case2=self.helper(nums, index+1, maxrobAmount)
    #
    #     return max(case1,case2)


nums = [2, 7, 9, 3, 1]
solve=Solution()
print(solve.rob(nums))