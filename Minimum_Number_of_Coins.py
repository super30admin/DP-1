class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        n=len(coins)
        
        if len(coins)==0:
            return -1
        
        if amount==0:
            return 0
        
        t=[[0 for _ in range(amount+1)]for _ in range(n+1)]
        
        import math
        
        for i in range(n+1):
            for j in range(amount+1):
                if i==0: 
                    t[i][j]=math.inf
                if j==0:
                    t[i][j]=0
        
        i=1
        for j in range(1,amount+1):
            if j%coins[0]==0:
                t[i][j]=j//coins[0]
            else:
                t[i][j]=math.inf
                    
        for i in range(1,n+1):
            for j in range(1,amount+1):
                if coins[i-1]<=j:
                    t[i][j]=min(1+t[i][j-coins[i-1]],t[i-1][j])
                else:
                    t[i][j]=t[i-1][j]
                    
        if t[n][amount]==math.inf:
            return -1
        
        return t[n][amount]
                    
        
        
        