#Time: O(amount*len(coins))
#Space: O(amount)
#did the code run successfully: yes
#any issues faced: did not check if a possibility is valid or not.

#bottom-up approach with tabulation to avoid redundant computation
#at each step take possibilities given by choosing each coin denomination
#compute the min change for each possibility only when the possiblity is valid
#a possibility is invalid if total-coin<0 or coinchange of total-coin is -1

class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        dp = [-1 for _ in range(amount+1)]
        dp[0] = 0
        for total in range(1, amount+1):
            temp = float('inf')
            for coin in coins:
                if total-coin >= 0 and dp[total-coin] != -1:
                    temp = min(dp[total-coin]+1, temp)
            dp[total] = temp if temp != float('inf') else -1
        return dp[amount]