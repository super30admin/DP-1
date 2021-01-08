#Time Complexity:O(mn)
#Space Complexity:O(mn)
class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        if(amount==0 or len(coins)==0):
            return 0
        result=[]
        result.append([amount+1 for i in range(amount+2)])
        for i in range(len(coins)):
            arr=[]
            arr.append(amount+1)
            r=result[i]
            for j in range(1,amount+1):
                val=r[j]
                if coins[i]>j:
                    arr.append(val)
                else:
                    if(j%coins[i]==0):
                        if (j//coins[i]<val):
                            val=j//coins[i]
                    if(arr[j-coins[i]]+1<val):
                        val=arr[j-coins[i]]+1
                    arr.append(val)         
            result.append(arr)
        if(arr[-1]<amount+1):
            return arr[-1]
        else:
            return -1          