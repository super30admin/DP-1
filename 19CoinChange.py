"""
// Time Complexity :O(n2) where n is denominations and money.
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :No
// Any problem you faced while coding this :Failed when coins=[2]
and amount=[3] /UNHAPPY CASE

//Explanation:
create array of length amount+1
Store arr[0]
for each denomination,update the amount by

"""
from typing import List
class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
       money = [0]*(amount+1)

       for d in coins:
         for m in range(len(money)):

          if d <= m:
            diff = m-d
            #print("*",m,d,diff,"coinsfor[d]=",money[d],"coinsfor[diff]=",money[diff+1],"Ideal=",money[d]+money[diff] if diff>0 else 1)
            money[m]=money[d]+money[diff] if diff>0 else 1 #(m-d)+1
         print(d,"->",money)
       return money[amount]


if __name__ == "__main__":
  coins =[1 ,2,5]
  amount=11
  s=Solution()
  print("Required coins=",s.coinChange(coins,amount))
