// Time Complexity : O(MXN) M is the total number of coins and N is the lenght of Array
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :Initialise the Array with Max Value when looking for the Minimum


// Your code here along with comments explaining your approach
class Solution{
    int coinChange(int coins[], int amount){
        //Edge Case
        if(amount<1){
            return 0;
        }
        else{
            // Make an array starting from 0 to the Max amount in the array so that at each position we check the mimum coints to reach that particular value
            int minCoinsDP[]=new int[amount+1];
            for(int i=1; i<minCoinsDP.length;i++){
                minCoinsDP[i]=Integer.MAX_VALUE;
                for(int coin: coins){
                    // i Will run from start to the Coing value as with a coin value bigger then i we cannot make the amount. 
                    // If We are able to make a value with smaller denomation we add that and the previous answer of smaller denomation in the minimum
                    if(coin<=i && minCoinsDP[i-coin]!=Integer.MAX_VALUE){
                        minCoinsDP[i]=Math.min(minCoinsDP[i], minCoinsDP[i-coin]+1);
                    }
                }
            }
            // No Amount was able to make with the coin denomaitions. 
            if(minCoinsDP[amount]==Integer.MAX_VALUE){
                return -1;
            }
            return minCoinsDP[amount];
        }
    }
}