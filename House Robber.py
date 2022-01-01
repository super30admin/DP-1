#House Robber
#T.C => O(n)
#S.C => O(n)
#Approach => We are creading a 2d array of size n. at every i we are checking the previous and current value whichever is the maximum we are storing that.
# It goes on thill the size of the nums. we are returning he max value of array that is present in DP. Its a pure DP problem. 
class Solution:
    def rob(self, nums: List[int]) -> int:
        # if len(nums) == 0: return 0
        if(len(nums) == 1): return nums[0]
        #How tomake rows and Columns (2d matrix) in python
        dp = [[0] * (2) for i in range(len(nums))]
        dp[0][1] = nums[0]
        for i in range(len(nums)):
            dp[i][0] = max(dp[i - 1][0], dp[i - 1][1])
            dp[i][1] = dp [i - 1][0] + nums[i]
        return max(dp[len(nums) - 1][0], dp[len(nums) - 1][1])

result = rob(self, [1,2,4,1])
print(result)