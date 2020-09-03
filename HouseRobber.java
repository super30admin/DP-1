// Time Complexity : O(n), n is the number of houses
// Space Complexity : o(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

class HouseRobber {
    public int rob(int[] nums) {
    	//keep track of values at each house by choosing or not choosing the house
        int C = 0;
        int DC = 0;
        for(int i=0;i<nums.length;i++){
            int temp = DC; 
            //not chosing the house means we have the max of values of choosing or not choosing the previous house 
            DC = Math.max(C,DC);
            //choosing the house means not choosing the previous house. So add the previous house not DC(Don't Choose) value with the current house value.
            C = nums[i] + temp;
            
        }
        //return max values of choosing or not choosing the last house.
        return Math.max(C,DC);

    }
}