class Solution:
    def rob(self, nums: List[int]) -> int:
        if(len(nums) == 0):
            return 0
    
        n = len(nums) 
        skip = 0
        take = nums[0]

        for i in nums[1:]:
            print(i)
            temp = skip
            print("temp:", temp)
            skip = max(skip,take)
            print('skip :', skip)
            take = temp + i
            print('take :',take)
    
        return max(skip,take)
    
        