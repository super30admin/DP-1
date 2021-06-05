class Solution:
    def rob(self, nums: List[int]) -> int:
        skip = 0
        take = nums[0]
        for i in range(1, len(nums)):
            prevskip = skip
            skip = max(skip, take)
            take = prevskip+nums[i]
        return max(skip, take)
        # arr = [[None for _ in range(0,2)] for _ in range(len(nums))]
        # arr[0][0]=0
        # arr[0][1] = nums[0]
        # for i in range(1,len(nums)):
        #     arr[i][0]=max(arr[i-1][0],arr[i-1][1])
        #     arr[i][1]=arr[i-1][0]+nums[i]
        # return max(arr[len(nums)-1][0],arr[len(nums)-1][1])
        
        
    #     return self.helper(nums, 0, 0)
    # def helper(self, nums: List[int], index : int, maxi: int):
    #     if index >= len(nums):
    #         return maxi
    #     case1 = self.helper(nums, index+2, maxi+nums[index])
    #     case2 = self.helper(nums, index+1, maxi)
    #     return max(case1, case2)
    
""" Time complexity - O(n) where n is the length of numbers given
# space complexity - O(1) as we are using variables that take constant space for dynamic programming.

For the code implemented using array, Time complexity and space complexity - O(n)

For the commented recursion code, the time complexity would be 2^n 
and space complexity O(n) where n is the length of numbers given"""
        