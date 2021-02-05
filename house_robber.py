# O(N) TIME AND O(1) SPACE WHERE N IS LEN(NUMS)
class Solution:
    def rob(self, nums: List[int]) -> int:
        if len(nums) == 0:
            return 0
        if len(nums) == 1:
            return nums[0]
        
        nonAdjacentSum = nums[0]
        adjacentSum = max(nums[0],nums[1])
        for i in range(2,len(nums)):
            currentMax = max(adjacentSum,nums[i] + nonAdjacentSum)
            nonAdjacentSum = adjacentSum
            adjacentSum = currentMax
        return adjacentSum
        