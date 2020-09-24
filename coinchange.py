class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        dp = [0]*(amount+1)
        for i in range(1,amount+1):
            dp[i] = amount+1
            for coinx in coins:
                if coinx <= i:
                    dp[i] = min(1+dp[i-coinx],dp[i])
        return -1 if dp[-1] > amount else dp[-1]
            
 #time Complexity O(nc),n->total amount,c->number og coins
 #Space Complexity is O(n), n->total amount