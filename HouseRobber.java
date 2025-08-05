// Time Complexity : O(n), where m is the length of the number of houses
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No major issues

// Your code here along with comments explaining your approach:
// - we use dp 1D array to store the max robberies which is max amount one can do
// - we iterate through all house where we leave the adjacent house and calculate the max amount
public class HouseRobber {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        if(nums.length==1){
            return nums[0];
        }
        // store first two values of dp as first and the max of first and second index
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        // we start the third index, and we compare the previous value and sum of current house amount with value previous to the adjacent house
        for(int i=2;i<nums.length;i++){
            dp[i] = Math.max(dp[i-1], nums[i] + dp[i-2]);
        }
        return dp[nums.length-1];
    }
    public static void main(String[] args) {
        HouseRobber obj = new HouseRobber();
        int[] nums = {1,2,3,1};
        int result = obj.rob(nums);
        System.out.println("maximum amount of money you can rob: " + result); // Output: 4

        int[] nums1 = {2,7,9,3,1};
        int result1 = obj.rob(nums1);
        System.out.println("maximum amount of money you can rob: " + result1); // output 12

    }
}
