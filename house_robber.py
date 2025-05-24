# Time Complexity : 0(n)
# Space Complexity : O(n) 

def house_robber(nums) -> int:
    dp = [0, 0, 0, 0, 0]
    dp[0] = nums[0]
    dp[1] = max(dp[0], nums[1]+0)

    for i in range(2, len(nums)):
        dp[i] = max(dp[i-1], nums[i] + dp[i-2])
    return dp[len(nums)-1]
    

if __name__ == "__main__":
    nums = [1,2,3,1]
    print(house_robber(nums))