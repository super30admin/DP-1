# // Time Complexity : O(n) where n: number of houses
# // Space Complexity : O(n)  or  O(1)
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : how to design the table. (cols and the cell values)

# // Your code here along with comments explaining your approach
class Solution:
    def rob(self, nums: List[int]) -> int:
        # there are two approaches to write 
        # sol for the problem
        # 1. use explicit matrix to maintain the choice at each hourse
        # whether to rob it or not
        
        dp = [[0 for _ in range(2)] for _ in nums]
        dp[0][1] = nums[0]
        for i in range(1,len(dp)):
            
            # don't rob me
            dp[i][0] = max(dp[i-1][0],dp[i-1][1])
            
            # can rob
            dp[i][1] = dp[i-1][0] + nums[i]
        
        return max(dp[-1][:])
#         # 2. use two vars to maintain a running decision for each house
        
#         skip = take = 0
        
#         for money in nums:
#             # print(skip,take)
#             temp = take
#             take = skip + money
#             skip = max(skip,temp)
        
#         return max(skip,take)