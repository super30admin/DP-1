// Time Complexity : The time complexity is O(n) where n is the length of the array since we are traversing through the array once.
// Space Complexity : The space complexity is O(n) since we are using an array of length n.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public int rob(int[] nums) {

        if(nums.length == 0){
            return 0;
        }

        // Array which stores the previously robbed money
        int[] dp = new int[nums.length+1];
        dp[0] = 0;
        dp[1] = nums[0];

        for(int i=1;i<nums.length;i++){

            // If we want to rob the current house, do not rob the previous house
            int yes = dp[i-1] + nums[i];
            // If we want to do not want to rob the current house, then rob the previous house
            int no = dp[i];

            // Decide whether robbing the current house or not fetches maximum money
            dp[i+1] = Math.max(yes,no);

        }

        return dp[nums.length];
    }
}

// Time Complexity : The time complexity is O(n2)
// Space Complexity : The space complexity is O(1) since we are using an extra space.
// Did this code successfully run on Leetcode : No(Time Limit Exceeded)
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public int rob(int[] nums) {

        return recursive(nums,0);

    }

    public int recursive(int[] nums,int index){

        //Base case
        if(index >= nums.length){
            return 0;
        }

        // If we want to rob the current house, do not rob the next house
        int left = nums[index] + recursive(nums,index+2);
        // If we want to do not want to rob the current house, then rob the next house
        int right = recursive(nums,index+1);

        // Decide whether robbing the current house or not fetches the maximum money
        return Math.max(left,right);

    }
}
