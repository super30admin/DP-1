# Time complexity : O(n)
# Space complexity : O(n)
#The code ran on Leetcode

# Initiate an array, arr which stores the number of ways a particular total (which is the value at the index) can be obtained.
# Iterate over all the coins, select first coin and check how many ways a total of the current target - value of the coin can be obtained. 
# Repeat it for all the coins and store the least number of coins required to get the sum in the new array 

class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        
        arr = [0]*(amount + 1)
        if amount == 0: return 0
        for i in range(1, len(arr)):
            if i in coins:
                arr[i] = 1
            else:
                for c in coins:
                    if i - c > 0 and arr[i-c] > 0:
                        if arr[i] == 0:
                            arr[i] = 1 + arr[i-c]
                        else:
                            arr[i] = min(arr[i], 1 + arr[i-c])

        return arr[-1] if arr[-1] > 0 else -1