'''
PROBLEM 1

TIME COMPLEXITY: O(N)
SPACE COMPLEXITY: O(N)

- traverse the array building a result array containing anwer upto that point
- At an index i, there are two possible answers, 1. answer upto index i-1 OR 2. answer upto index i-2 + answer at index i
- the answer at index i will be maximum of the two possible answers mentioned above

'''

class Solution:
    def rob(self, nums: List[int]) -> int:
        if len(nums)==0:
            return len(nums)
        if len(nums)==1:
            return nums[0]
        
        dp=[0]* len(nums)
        
        dp[0]=nums[0]
        dp[1]= max(nums[0], nums[1])
        
        for i in range(2, len(nums)):
            dp[i]= max(dp[i-1], dp[i-2] + nums[i])
            
        return dp[len(nums)-1]
            



'''
PROBLEM 2

TIME COMPLEXITY: O(N*amount)
SPACE COMPLEXITY: O(N)

- start with a bottom up approach and build answer for 'amount' by calculating answer from amount=0
- iterate over the coins array and calculate the minimum number of coins required to get a sum of all amounts from that denomination to amount
- the final answer would be the last element of array we built

'''

class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        dp = [float('inf')] * (amount + 1)
        dp[0] = 0
        
        for coin in coins:
            for x in range(coin, amount + 1):

                dp[x] = min(dp[x], dp[x - coin] + 1)
        
        if dp[amount]==float('inf'):
            return -1
        else:
            return dp[amount]