/*
Author: Akhilesh Borgaonkar
Problem: LC 322. Coin Change (DP-1)
Approach: I sort my input denominations array and then start iterating from the highest element. While iterating, I divide the element and then 
    take the mod and perform the same process for mod result till I find that my total is 0. 
Time Complexity: Exponential.  (Not the most optimal solution)
Space complexity: O(1) constant. (not sure about this)
Fails for some test cases on LC.
*/

class Solution {
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int total = amount, numCoins=0;
        
        for(int i=coins.length-1; i>=0; i--){
            if(total>=coins[i]){
                numCoins += total/coins[i];
                total = total%coins[i];
            }
        }
        if(total > 0)
            return -1;
        return numCoins;
    }
}