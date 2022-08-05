class Solution:#time O(n) #space O(1)
    def rob(self, nums: List[int]) -> int:
        c=0
        nc=0
        for i in range(len(nums)):
            t=c
            c=nums[i]+nc
            nc=max(t,nc)
        return max(c,nc)
