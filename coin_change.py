class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        def subsetsum(n,amt,number):
            if amt==amount:
                return number
            if n==len(coins):
                if amt==amount:
                    return number
                return 99999999
            if coins[n]<=amount-amt:
                return min(subsetsum(n,amt+coins[n],number+1),subsetsum(n+1,amt,number))
            else:
                return subsetsum(n+1,amt,number)
        val = subsetsum(0,0,0)
        if val==99999999:
            return -1
        return val