public class HouseRobber {

    //TC - O(n)
    //SC - O(1)

    //https://leetcode.com/problems/house-robber/
//Space Efficient Sol

    public int rob(int[] nums) {
        if(nums==null || nums.length ==0) return 0;
        int n = nums.length;
        int skip = 0, take;
        take = nums[0];
        for(int i= 1; i<n;i++){
            int temp = skip;
            skip = Math.max(skip,take);
            take = temp+nums[i];
        }
        return Math.max(skip,take);
    }
    /*public int rob(int[] nums) {
        if(nums==null || nums.length ==0) return 0;
        int n = nums.length;
        int[][] dp = new int[n][2];
        dp[0][1] = nums[0];
        for(int i= 1; i<n;i++){
            dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]);
            dp[i][1]=dp[i-1][0]+nums[i];
        }
        return Math.max(dp[n-1][0],dp[n-1][1]);
    }
*/

 //Exhaustive Approach
    /*
    public int rob(int[] nums) {
        if(nums==null || nums.length==0) return 0;

        return helper(nums,0,0);
    }
private int helper(int[]nums, int index, int amount){
if(index>=nums.length) return amount;
int case1 = helper(nums,index+1, amount);
int case2 = helper(nums,index+2,amount+nums[index]);
return Math.max(case1,case2);
}
    * */
}
