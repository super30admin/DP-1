class Solution:
    def coinChange(self,coins,amount):
        memo={}

        def dfs(remaining):
            #print(f"Checking minimum coins for:{remaining}")

            if remaining==0:
                #print(f"Amount is 0,so return 0")
                return 0
            if remaining<0:
                #print(f"Amount is negative({remaining}),so return inf")
                return float('inf')
            if remaining in memo:
                #print(f"Found in memo:memo[{remaining}]={memo[remaining]}")
                return memo[remaining]
            
            min_coins=float('inf')
            #print(f"Trying coins {coins} for amount {remaining}")
            for coin in coins:
                #print(f"Using coin:{coin}")
                res=dfs(remaining-coin)
                #print(f"Result after using {coin}:{res}")
                if res!=float('inf'):
                    min_coins=min(min_coins,res+1)
                    #print(f"updated min_coins for{remaining}:{min_coins}")
            memo[remaining]=min_coins
            #print(f"Memoizing:memo[{remaining}]={min_coins}")
            return min_coins
        result=dfs(amount)
        #print(f"Final Result:{result if result!=float('inf')else-1}")
        
        return -1 if result==float('inf') else result
    
sol=Solution()
print(sol.coinChange([1,2,5],11))
print(sol.coinChange([2],3))
print(sol.coinChange([1],0))