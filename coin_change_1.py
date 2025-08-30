def coinChange(self, coins: List[int], amount: int) -> int:
        d=[amount+1]*(amount+1)
        d[0]=0
        for a in range(1,amount+1):
            for c in coins:
                if a-c>=0:
                    d[a]=min(d[a], 1+d[a-c])
        return d[amount] if d[amount]!= amount+1 else -1     