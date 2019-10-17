# accepted in leetcode
# optimal solutio using dynamic programming which uses memoization in recurrsion tree.
# time complexity - O(N), space -  O(N) as we are using a new dp array.
# check two conditions if the house is choosen or not based on that we will iterate and at the end return maximum amount in the last row.
def rob(nums):
    # checking edge case
    if len(nums) == 0 or nums is None: return 0
    # creating a dp array
    dp = [[0 for i in range(2)] for j in range(len(nums))]
    dp[0][1] = nums[0] # assigning default values for 1st row.
    n = len(nums) # calculating length of array
    for i in range(1,n):
        for j in range(2):
            # if house not choosen, then take the max of previous row data and put in next row first column else if choosen(j=1), consider the value in the previous row where the house was not choosen and add current amount to it.
            if j == 0:
                dp[i][j] = max(dp[i-1][0], dp[i-1][1])
            else:
                dp[i][j] = dp[i-1][0] + nums[i]
    # return max amount of last row
    return max(dp[n-1][0],dp[n-1][1])


print(rob([2,1,1,2]))