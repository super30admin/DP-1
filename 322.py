// Time Complexity : O(n * k)) where n is amount and k is length of coins array
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach


class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        arr = [float(inf)] * (amount + 1)
        coins.sort()
        arr[0] = 0
        for i in range(1,amount+1):
            for j in coins:
                if j > i:
                    break
                arr[i] = min(1+arr[i-j],arr[i]) 
        return arr[-1] if arr[-1] != float('inf') else -1
            
                