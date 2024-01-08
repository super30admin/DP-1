'''
Time complexity: O(n) where n = number of houses
Space complexity: O(1) because input isn't considered while calculating complexity
'''
class Solution:
    def rob(self, nums: List[int]) -> int:
        temp = [nums[0], 0]
        
        for i in range(1,len(nums)):
            if i == 1:
                temp = [temp[0], nums[i]]
            else:
                temp = [max(temp), nums[i]+temp[0]]

        return max(temp)