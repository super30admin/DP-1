#Space: O(n)
#Time: O(n)
class Solution:
    def rob(self, nums: List[int]) -> int:
        if len(nums)==0:
            return 0
        if len(nums)==1:
            return nums[0]
        if len(nums)==2:
            return max(nums[1],nums[0])
        
        dp=[nums[0],max(nums[1],nums[0])]
        
        for i in range(2,len(nums)):
            print(dp)
            dp.append(max((dp[i-2]+nums[i]),dp[i-1]))
        print(dp)
        return dp[-1]
