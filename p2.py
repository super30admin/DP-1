#TC = o(n)
#SC = O(n)
#successfully submitted on leetcode: yes

class Solution:
    def rob(self, nums: List[int]) -> int:
        #special case for len(nums) == 1 
        #so arr[1] = max(nums[1],nums[0]) don't go over limit
        if len(nums) == 1:
            return nums[0]
        
        #use 1d array 
        arr = [0 for i in range(len(nums))]
        arr[0] = nums[0]
        arr[1] = max(nums[1],nums[0])

        for i in range(2, len(nums)):
            arr[i] = max(arr[i-1], nums[i] + arr[i-2])
        return arr[-1]