// Time Complexity : O(H) where H = no of houses 
// Space Complexity : O(H) H =  no of houses
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
//1. We have two choices to make when we go to a particular house either we CHOOSE or NOT CHOOSE to rob the house.
//2  If we choose to rob then we go and add it our choose variable.
//3. If not then we go and compare the previous houses choose and dont choose variable and store in dont chose variable.
//4. Then finally we return the maximum of the dont care or care variable.

public class HoueRobber {
    public int rob(int[] nums) {
        int c = 0, dc = 0;

        for (int i = 0; i < nums.length; i++) {
            int temp = dc;
            dc = Math.max(c, dc);
            c = temp + nums[i];

        }

        return Math.max(c, dc);

    }

    public static void main(String args[]) {
        HoueRobber obj = new HoueRobber();
        int[] nums = { 3, 2, 3, 8 };

        System.out.println("Maximum amount robbed = " + obj.rob(nums));
    }
}