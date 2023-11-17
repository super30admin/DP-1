class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        a = [amount+1]*(amount+1)
        a[0]=0
        
        for i in range(1,amount+1):
            for c in coins:
                if i-c>=0:
                    a[i] = min(a[i],1+a[i-c])
                    
        if a[amount]!=amount+1:
            return a[amount]
        else:
            return -1
        