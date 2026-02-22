#Coin Change

import math
class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        prevArr = [math.inf] * (amount+1)
        length = len(prevArr)
        for coin in coins:
            for i in range(0,length):
                if i == 0:
                    prevArr[i] = 0
                    continue
                if coin > i:
                    #noChose, do nothing, already should have min in that index on array, if there is a possible path
                    continue
                else:
                    #compare between choose and no choose option, in case the possible ways will be 1(for choosing) + min possible ways for achieving remaining value
                    minPossible = min(prevArr[i], (1+prevArr[i-coin]))
                    prevArr[i] = minPossible
        if prevArr[length-1] == math.inf:
            return -1
        else:
            return prevArr[length-1]