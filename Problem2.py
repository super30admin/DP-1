# Problem2 (https://leetcode.com/problems/house-robber/)

class Solution:
    def rob(self, nums: List[int]) -> int:
        if not nums:
            return 0
        
        dp_arr = [0,nums[0]]
        for n in range(1,len(nums)):
            temp_0 = max(dp_arr)
            dp_arr[1] = nums[n] + dp_arr[0]
            dp_arr[0] = temp_0
        return(max(dp_arr))
