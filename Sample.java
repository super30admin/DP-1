// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

//Coin Change
//Using Recursion
//Time complexity -> exp
//Space Complexity -> exp
class Solution {
    public int coinChange(int[] coins, int amount) {

        if(coins == null || coins.length == 0) return -1;

        return helper(coins,0,amount,0); //saying tell me how minimum number of coins will be used from the starting array
        
    }

    private int helper(int[] coins,int i,int amount,int coinsUsed){
        //base case
        if(amount == 0) return coinsUsed;

        if(amount < 0 || i == coins.length ) return -1; //basically coins have ben finished and the desired amount is not created and if amount <0 that means that amount also cannot be created

        //recursive case
        //Choosing case
        int case1 = helper(coins,i,amount - coins[i],coinsUsed + 1); 
        //Not choose
        int case2 = helper(coins,i+1,amount,coinsUsed);

        if(case1 == -1) return case2; //Means if there is no walid way of getting the coins, then we are returning case2;
        if (case2 == -1) return case1;

        return Math.min(case1,case2);
    }
}

//using 2D DP
//Time ->  n*m
//Space -> n*m
class Solution {
    //Using 2d DP
    public int coinChange(int[] coins, int amount) {

        if(coins == null || coins.length == 0) return -1;

        int n = coins.length;
        int m = amount;

        int[][]dp = new int[n+1][m+1];

        for(int i=1;i<=m;i++){
            dp[0][i] = 99999999;
        }   

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(j<coins[i-1]){
                    dp[i][j] = dp[i-1][j];
                }
                else{
                    dp[i][j] = Math.min(dp[i-1][j],1+ dp[i][j - coins[i-1]]);
                }
            }
        }

        if(dp[n][m]>=99999999) return -1;
        else return dp[n][m];  
    } 
}

//using 1D DP
//Time complexity -> O(n*m)
//Space Complexity -> O(m)
class Solution {
    //Using 1d DP for space optimization
    public int coinChange(int[] coins, int amount) {

        if(coins == null || coins.length == 0) return -1;

        int n = coins.length;
        int m = amount;

        int[]dp = new int[m+1];

        for(int i=1;i<=m;i++){
            dp[i] = 99999999;
        }   

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(j<coins[i-1]){
                    dp[j] = dp[j];
                }
                else{
                    dp[j] = Math.min(dp[j],1+ dp[j - coins[i-1]]);
                }
            }
        }

        if(dp[m]>=99999999) return -1;
        else return dp[m];  
    } 
}

//House Robber
//Using Recursion
class Solution {
    //Using Recursion
    public int rob(int[] nums) {

        return helper(nums,0,0);
        
    }

    private int helper(int[] nums,int i,int robbings){
        //base
        if(i>= nums.length) return robbings;

        //logic
        //dont choose
        int case1 = helper(nums,i+1,robbings); //I can rob the next house
        
        //choose
        int case2 = helper(nums,i+2,robbings + nums[i]) ; //I can not rob the next house that's why I did i+2 and add the cost of robbbery to the robbings

        return Math.max(case1,case2); //return the maximum robbings 
    }
}

//Using 1D Dp
class Solution {
    //Using Recursion
    public int rob(int[] nums) {

        if(nums == null || nums.length<2) return nums[0];

        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        for(int i=2;i<n;i++){
            dp[i] = Math.max(dp[i-1],nums[i] + dp[i-2]);
        }

        return dp[n-1];
        
    }

    
}

//Using No extra Space
class Solution {
    //Using no space
    public int rob(int[] nums) {

        if(nums == null || nums.length<2) return nums[0];

        int n = nums.length;
        int prev = nums[0];
        int curr = Math.max(nums[0],nums[1]);
        for(int i=2;i<n;i++){
            int temp = curr;
            curr = Math.max(curr,nums[i] + prev);
            prev= temp;
        }

        return curr;
        
    }

    
}


