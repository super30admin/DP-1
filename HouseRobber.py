
#Time Complexity: O(N)
#Space Complexity: O(N) for the memo array + O(N) recursion stack → total = O(N).

#-----------------------------Memoization -------------------------

def rob_memoization(nums):
    memo = [-1] * len(nums)

    def dp(i):
        # Base Case: No houses left to rob
        if i >= len(nums):
            return 0
        
        # Return cached result
        if memo[i] != -1:
            return memo[i]
        
        # Choose to rob current house or skip
        rob = nums[i] + dp(i + 2)
        skip = dp(i + 1)
        
        memo[i] = max(rob, skip)
        return memo[i]
    
    return dp(0)


#-----------------------------TABULATION-------------------------
#Time Complexity: O(N)
#Space Complexity: O(N)

def rob_tabulation(nums):
    n = len(nums)
    if n == 0: return 0
    if n == 1: return nums[0]

    dp = [0] * n
    dp[0] = nums[0]
    dp[1] = max(nums[0], nums[1])

    for i in range(2, n):
        # Either rob current house and add dp[i-2], or skip and take dp[i-1]
        dp[i] = max(nums[i] + dp[i-2], dp[i-1])
    
    return dp[-1]



#---------------------SPACE OPTIMIZED--------------------------------
#Time Complexity: O(N)
#Space Complexity: O(1)

def rob_optimized(nums):
    prev2, prev1 = 0, 0
    for num in nums:
        current = max(prev1, prev2 + num)
        prev2 = prev1
        prev1 = current
    return prev1




