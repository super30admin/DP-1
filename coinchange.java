/*
Did it run leetcode: Yes
Time Complexity: 0(N*M)
Space Complexity: 0(N)

Problems Faced: Adding 1 to Integer.MAX_VALUE creates an overflow which
gave wrong answers


Algorithm:
The idea behind the algorithm is if suppose we have coins {1,2,3} and minimum number
of coins to make `4` is 2. Then to make 5 using the above coins can only be acheived through
 -> adding `1` to 4
 -> adding 2 to `3'
 -> adding 3 to '2'.

 So minimum number of coins needed to make 5 will be:
    minimum(change[5-1]+1, change[5-2]+1, change[5-3]+1)
    where 5 denotes the amount we want to make.
    and 1,2,3 denotes the coin we have.



1.We create an array `change` with size of (amount+1). Where:
change[i] denotes minimum number of change required to acheive ith amount.

2.We initialize change[0]=0
3. For every index at `i` of change. 
    for every coin in coins
    we calculate the minimum required change
    and then return the last index value of `change` array. 

*/

class Solution {
    public int coinChange(int[] coins, int amount) {
        
        int[] change = new int[amount+1];
        for(int k=0;k<amount+1;++k){
            change[k]=Integer.MAX_VALUE-1;
        }
        change[0] = 0;
        for(int i=1;i<amount+1;++i){
            int min = Integer.MAX_VALUE-1;
            for(int j=0;j<coins.length;++j){
                if(i-coins[j]>=0){
                    min = Math.min(min,change[i-coins[j]]+1);
                }
            }
            if(min!=Integer.MAX_VALUE){
                change[i]=min;
            }
        }
        return change[amount]==Integer.MAX_VALUE-1 ? -1:change[amount];
    }
}