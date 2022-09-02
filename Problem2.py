class Solution:
    def rob(self, nums: List[int]) -> int:
        
        if not nums:
            return 0
        n = len(nums)
        
        nxt = nums[n-1]
        nxt1= 0
        
        for i in range(n-2,-1,-1):
            
            current= max(nxt, nxt1+nums[i])
            
            
            nxt1= nxt
            nxt = current
            
        return nxt
