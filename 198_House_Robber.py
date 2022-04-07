class Solution:
    def rob(self, nums: List[int]) -> int:               
        robsum = [0]*len(nums)  

        if len(nums)==1: return nums[0]
        if len(nums)==2: return  max(nums[0], nums[1])

        robsum[0] = nums[0]
        robsum[1] = max(nums[0], nums[1])
        
        for i in range(2, len(robsum)):
            robsum[i] = max(robsum[i-1] , nums[i] + robsum[i-2]) # greedy solution ultimately
            
        return robsum[-1]