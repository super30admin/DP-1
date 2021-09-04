time complexity: O(amount*number of coins)
space complexity: O(1)

class Solution { //dynamic programming
    public int coinChange(int[] coins, int amount) {
        if(amount==0){ //initial check 
        return 0;
    }
    int[] dp = new int[amount+1]; //creating an array with amount+1
 
    Arrays.fill(dp, Integer.MAX_VALUE); 
    dp[0]=0; //making first element 0
 
    for(int i=1; i<=amount; i++){ 
        for(int coin: coins){
            if(i==coin){ //if index is equal to coin
                dp[i]=1; //making that current index element to 1
            }else if(i>coin){ //else if i>coin
                if(dp[i-coin]==Integer.MAX_VALUE){ 
                    continue;
                }
                dp[i]=Math.min(dp[i-coin]+1, dp[i]); //returning that element
            }
        }
    }
 
    if(dp[amount]==Integer.MAX_VALUE){ 
        return -1; //else return -1
    }
 
    return dp[amount]; //return amount 
    }
}