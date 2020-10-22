#Recursive Solution
class Solution:
    def rob(self, nums: List[int]) -> int:

        if nums is None or len(nums)==0:
            return 0

        def findSum(nums,total,index):
            #base case
            if index>=len(nums):
                return total

            case1 = findSum(nums,total+nums[index],index+2)
            case2 = findSum(nums,total,index+1)


            return max(case1,case2)

        return findSum(nums,0,0)


#DP Solution
class Solution:
    def rob(self, nums: List[int]) -> int:

        if nums is None or len(nums)==0:
            return 0
        if len(nums)==1:
            return nums[0]

        dp = [0 for _ in range(len(nums))]
        n=len(dp)
        dp[0] = nums[0]
        dp[1] = max(nums[0],nums[1])

        for i in range(2,len(dp)):
            dp[i] = max(nums[i]+dp[i-2],dp[i-1])

        return  dp[n-1]
