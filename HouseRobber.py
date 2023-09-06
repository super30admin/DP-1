class Solution:
    def rob(self, nums: List[int]) -> int:
        n=len(nums)
        if n<2:
            return nums[0]
        sum=0
        dp =[0]*n
        prev=nums[0]
        curr=max(nums[0],nums[1])
        for i in range(2,n):
            temp = curr
            curr= max(curr,prev+nums[i])
            prev=temp
        
        return curr