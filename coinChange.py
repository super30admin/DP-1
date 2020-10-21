# Easy brute force solution would be iterate over all combinations and then find which arrays give minimum sum. Then return the minimum length array
# Time Complexity: O(n^2)
# Space Complexity: O(n)
from itertools import combinations 
def coinChange(coins,amount):
    minLen = 999999
    for i in range(len(coins)):
        combo = list(combinations(coins,i))
        print(combo)
        for j in range(len(coins)-1):
            if sum(combo[j]) == amount and minLen > len(combo[j]):
                minLen = len(combo[j])
        del combo
    print(minLen)

coins = [1,2,5]
amount = 11
coinChange(coins,amount)
    