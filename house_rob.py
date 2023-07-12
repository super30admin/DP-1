class Solution:
    def helper(self,nums, i, prize):
        #base
        if(i>=len(nums)):
            return prize
        #logic
        #not choose
        case1=self.helper(nums, i+1, prize)
        # choose
        case2=self.helper(nums, i+2, prize+nums[i])
        #return condition
        return max(case1, case2)


        return max(case1,case2)

    def rob(self, nums: List[int]) -> int:
        #exhaustive Solution
        # return self.helper(nums, 0, 0)

        #dp Solution
        if(len(nums)<2):
            return nums[-1]
        dp_arrray=[None for i in range(len(nums))]
        dp_arrray[0]=nums[0]
        dp_arrray[1]=max(dp_arrray[0],nums[1])
        i=2
        while(i<len(dp_arrray)):
            dp_arrray[i]=max(dp_arrray[i-1],nums[i]+dp_arrray[i-2])
            i+=1            

        return dp_arrray[-1]

