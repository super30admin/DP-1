// Time Complexity : O(n) //iterating over entire nums array : Optionation for previous exponential solutions
// Space Complexity : O(1) // Using just 2 variables
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Learning DP. Able to code post watching videos.

/*
At every step of house, we have 2 choice, whether to rob the house or not to rob the house.
Based on that it is maximum of that step of repeated subproblem to find out earning.
Towards the end find maximum earning by picking last element (Current).
*/

public class HouseRobberwith2Variables {

    public int rob(int[] nums) {
        int prev = nums[0];
        int curr = Math.max(nums[0], nums[1]);

        for(int i=2; i<nums.length; i++){
            int temp = curr;
            curr = Math.max(curr, nums[i] + prev);
            prev = temp;
        }
        return curr;
    }

    public static void main(String[] args) {
        HouseRobber hr= new HouseRobber();
        int[] nums = {1,3,2,1};
        int result = hr.rob(nums);

        System.out.println("Maximum earning at the end of nth house robbing = " + result);

    }
}