// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : //thinking about space optimized solution at first place. but eventually got to it


// Your code here along with comments explaining your approach
class Solution {
    //exhaustive
    // public int rob(int[] nums) {
    //     return helper(nums,0, 0);
    // }

    // private int helper(int[] nums, int i, int robbings){
    //     //base
    //     if(i>=nums.length) return robbings;
    //     //logic
    //     //dont choose
    //     int case0= helper(nums, i+1, robbings);
    //     //choose
    //     int case1= helper(nums, i+2, robbings+nums[i]);

    //     return Math.max(case0,case1);
    // }

    //dp with extra array
    // public int rob(int[] nums) {
    //     if(nums.length<2) return nums[0];
    //     int n=nums.length;
    //     int[] dp= new int[n];
    //     dp[0]=nums[0];
    //     dp[1]=Math.max(nums[0],nums[1]);

    //     for(int i=2;i<n;i++){

    //         //max of case dont choose and case choose
    //         dp[i]=Math.max(dp[i-1],nums[i]+dp[i-2]);
    //     }
    //     return dp[n-1];
    // }

    //dp with space optimization
    // public int rob(int[] nums) {
    //     if(nums.length<2) return nums[0];
    //     int n=nums.length;
    //     //now prev=nums[0](basically nums[i-2] in loop) and curr is nums[1]
    //     int prev=nums[0];
    //     int curr=Math.max(nums[0],nums[1]);
    //     for(int i=2;i<n;i++){
    //         int temp=curr; //curr is going to be overwritten so store in temp variable
    //         //case0 dont choose
    //         curr=Math.max(curr,nums[i]+prev);
    //         prev=temp; //prev is now incremented to old current which is stored in temp
    //     }
    //     return curr;
    // }

    //dp with no extra variables
    public int rob(int[] nums) {
        if(nums.length<2) return nums[0]; //null and single house check
        int n=nums.length;
        
        nums[1]=Math.max(nums[0],nums[1]); // 1st index house(if nums[1]>nums[0] then robber will rob 2nd house first)
        for(int i=2;i<n;i++)
            nums[i]=Math.max(nums[i-1],nums[i]+nums[i-2]); // if rob house:(he cannot rob house with immediate behind index but 2 immediate index behind he has robbed)
                                                        //if not rob house:(means he robbed behind house)
        return nums[n-1]; //we store maximum robbings at each given index of array, so max robbings is last index element
    }
    
    //-------------------COIN CHANGE-------------------------------//
    // Time Complexity : O(n^2)
    // Space Complexity : O(1) (if we dont include array to be submitted as result)
    // Did this code successfully run on Leetcode : yes
    // Any problem you faced while coding this : //reduction in denomination to jth element. (we reduce with coins[j-1])

    
    //Exhaustive solution
    // public int coinChange(int[] coins, int amount) {
    //     //null
    //     return helper(coins, 0, amount, 0);
    // }

    // private int helper(int [] coins, int i, int amount, int coinsUsed){
    //     //base
    //     if(amount==0)
    //         return coinsUsed;
    //     if(amount<0 || i==coins.length)
    //         return -1;

    //     //logic
    //     //used coin
    //     int case1= helper(coins, i, amount-coins[i], coinsUsed +1);

    //     //unused coin
    //     int case2= helper(coins, i+1, amount, coinsUsed);
    //     if(case1 == -1) return case2;
    //     if(case2 == -1) return case1;
    //     return Math.min(case1, case2);
    // }

    // dp
    // public int coinChange(int[] coins, int amount) {
    //     int m=amount;
    //     int n=coins.length;
    //     int[][] dp=new int[n+1][m+1];
    //     for(int j=1;j<=amount;j++){
    //         dp[0][j]=amount+1;
    //     }

    //     for(int i=1;i<=n;i++){
    //         for(int j=1;j<=m;j++){
    //             //till amt is less than denomination zero
    //             if(j<coins[i-1])
    //                 dp[i][j]=dp[i-1][j];
    //             else
    //                 dp[i][j]= Math.min(dp[i-1][j],1 + dp[i][j-coins[i-1]]);
    //         }
    //     }
    //     if(dp[n][m]>amount) return -1;
    //     return dp[n][m];
    // }
    
    //dp with space optimization
    public int coinChange(int[] coins, int amount) {
        int m=amount;
        int n=coins.length;
        int[] dp=new int[m+1];
        for(int j=1;j<=amount;j++){
            dp[j]=amount+1;
        }

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                //till amt is less than denomination zero
                if(j<coins[i-1])
                    dp[j]=dp[j];
                else // if equal to or more than- means we have another coin and will at the end reduce total coins
                    dp[j]= Math.min(dp[j],1 + dp[j-coins[i-1]]);// take min of above element and 1+ element j - denomination of the coin.
            }
        }
        if(dp[m]>amount) return -1;
        return dp[m];//min coins are returned at the last index of matrix
    }
}