class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        if coins is None or len(coins)==0:
            return 0
        t = [[999999999 for i in range(amount+1)] for j in range(len(coins)+1)] 
        for i in range(len(t)):
            t[i][0]=0
        for j in range(1,len(t[0])):
            t[0][j]=amount+1
        for i in range(1,len(t)):
            
            for j in range(len(t[0])):
                
                if coins[i-1]>j:
                    
                    t[i][j]=t[i-1][j]
                else:
                    t[i][j]=min(t[i-1][j],1+t[i][j-coins[i-1]])
        
        result=t[len(t)-1][len(t[0])-1]
        if result > amount:
            return -1
        return result