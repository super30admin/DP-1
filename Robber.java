// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Robber {
    public int rob(int[] nums) {
        int [] dp = new int[nums.length];
        if(nums.length==1) return nums[0];
        if(nums.length==2) return Math.max(nums[0], nums[1]);
        dp[0]=nums[0];
        dp[1]=Math.max(nums[0], nums[1]);
        for(int i=2;i<nums.length;i++){
            dp[i] = Math.max(dp[i-1], dp[i-2]+nums[i]);
            //System.out.println(dp[i]);
        }
        return dp[nums.length-1];
    }

    public static void main(String[] args){
        Robber r = new Robber();
        int [] houses = new int[]{1,2,3,1};
        System.out.println(r.rob(houses));
        houses = new int[]{2,7,9,3,1};
        System.out.println(r.rob(houses));
    }
}