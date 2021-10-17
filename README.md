# DP-1

## Problem1 (https://leetcode.com/problems/coin-change/)
#Time & Space Complexity=O(len(coins)*amount)
class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        a=[[0]*(amount+1) for _ in range(len(coins)+1)]
        for i in range(1,amount+1):
            a[0][i]=amount+1
        for j in range(1,len(coins)+1):
            a[j][0]=0
        for i in range(1,len(coins)+1):
            for j in range(1,amount+1):
                if coins[i-1]>j:
                    a[i][j]=a[i-1][j]
                else:
                    a[i][j]=min(a[i-1][j],(a[i][j-a[i][j-coins[i-1]]])+1)
        return a[len(coins)][amount]
                    
            

## Problem2 (https://leetcode.com/problems/house-robber/)
#Time & Space Complexity=O(n)
class Solution:
    def rob(self, nums: List[int]) -> int:
        a=[[0]*2 for _ in range(len(nums)+1)]
        a[0][0],a[0][1]=0,0
        m=float('-inf')
        for i in range(1,len(nums)+1):
            nt=max(a[i-1][0],a[i-1][1])
            t=a[i-1][0]+nums[i-1]
            a[i][0]=nt
            a[i][1]=t
            m=max(m,max(t,nt))
        return m
        

