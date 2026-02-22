#House Robber

#keep on calculating the max possible sum till current house by comparing 2 options, if we choose current then add that with the max till the house
# 2 before and comapre it with just no choose category, in which you are just comparing max till prev house. For current house the max will become the
# max of these 2 choices
class Solution:
    def rob(self, nums: List[int]) -> int:
        totalHouses = len(nums)
        if totalHouses == 1:
            return nums[0]

        if totalHouses == 2:
            return max(nums[0], nums[1])
        
        # we just need max possible count for last 2 houses
        prevHouseMaxCount = max(nums[0], nums[1])
        prevPrev = nums[0]

        for i in range(2,totalHouses):
            choseCurrentMaxCount = nums[i] + prevPrev
            prevPrev = prevHouseMaxCount
            prevHouseMaxCount = max(choseCurrentMaxCount, prevHouseMaxCount)

        return prevHouseMaxCount