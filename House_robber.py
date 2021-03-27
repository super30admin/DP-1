class Solution:
    def rob(self, nums: List[int]) -> int:
        skip, take = 0, 0
        for value in nums:
            temp = skip
            skip = max(skip, take)
            take = temp+value
        return max(skip, take)


#time complexity - O(n) as it iterates the list
#space complexity - O(1) as no auxillary data structure
#all test cases passed