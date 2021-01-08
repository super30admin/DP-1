class Solution:
    def rob(self, nums: List[int]) -> int:
        if(len(nums)==0):
            return 0
        result=[]
        for i in range(len(nums)):
            if i==0:
                arr=[0,nums[i]]
            else:
                prev=result[i-1]
                arr=[max(prev),prev[0]+nums[i]]
            result.append(arr)
        return max(arr)