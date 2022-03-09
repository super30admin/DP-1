// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/* APPROACH:
we maintain an array of length of the houses:
for 1 house, we return nums[0]
for 2 houses, we return max(nums[0], nums[1])
starting from 3 house, we check the maximum between robbing the prev house as adjacent can't be robbed or robbing the current house with the earnings from robbing the i-2nd house.
 */

public class houseRobber {
    public static int rob(int[] nums) {
        if(null == nums || nums.length == 0) return 0;

        int[] dp = new int[nums.length];
        if(nums.length == 1){
            return nums[0];
        }
        if(nums.length == 2){
            return Math.max(nums[0],nums[1]);
        }
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for(int i=2; i<nums.length; i++){
            dp[i] = Math.max(nums[i] + dp[i-2], dp[i-1]);
        }
        return dp[nums.length-1];
    }

    public static void main(String[] args){
        int[] nums = {1,2,3,1};
        System.out.println(rob(nums)); // 4

        int[] nums2 = {2,7,9,3,1};
        System.out.println(rob(nums2)); // 12
    }
}
