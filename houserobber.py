class Solution():

    def rob(self,nums):
        if not nums:
            return 0
    
        if len(nums)==1:
            return nums[0]
    
        second_last=nums[0]
        last=max(nums[0],nums[1])

        for i in range(2,len(nums)):
            current=max(last,second_last+nums[i])
            second_last,last=last,current
    
        return last

sol= Solution()
print(sol.rob([1,2,3,1]))
print(sol.rob([2,7,9,3,1]))