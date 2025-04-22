class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        # res = 2^31 - 1

        # @lru_cache(None)
        # def helper(rem, curr_coins):
        #     nonlocal res
        #     if rem < 0:
        #         return
        #     if rem == 0:
        #         res = min(res, curr_coins)
        #         return


        #     for coin in coins:
        #         helper(rem - coin, curr_coins + 1)

            
        
        # helper(amount, 0)
        # return res if res !=  2^31 - 1 else -1

        #---- For caching to work, it should be only 1 variable not 2 (MLE error otherwise) -------
        @lru_cache(None)
        def recurs(remaining_amount):
            # nonlocal result
            if remaining_amount == 0:
                # result = min(result, coins_count)
                return 0
            
            if remaining_amount < 0:
                return -1

            min_count = float('inf')
            for i in coins:
                res = recurs(remaining_amount - i)
                if res != -1:
                    min_count = min(min_count, res + 1)
        
            return min_count if  min_count != float('inf') else -1

        return recurs(amount)

        # DP way 
        #time limit exceeded
        # dp = [amount+1 for i in range(amount+1)]
        # dp[0] = 0
        # for c in coins:
        #     if c < len(dp):
        #         dp[c] = 1
        # for i in range(1, amount+1):
        #     temp = amount + 1
        #     for j in range(i, 0, -1):
        #         temp = min(temp, (dp[j] + dp[i-j]), dp[i])
        #         # print(i, j, temp)
        #         # break
        #     dp[i] = temp
        #     # break
        # print(dp)
        # return dp[amount] if dp[amount] != amount + 1 else -1

        #dp - works.
        dp = [amount+1 for i in range(amount+1)]
        dp[0] = 0
        for c in coins:
            for i in range(c, amount+1):
                dp[i] = min(dp[i], dp[i-c]+1)
                # break
        
        return dp[amount] if dp[amount] != amount + 1 else -1
    
