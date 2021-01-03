// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

//time O(n)
//space O(n)

public class HouseRobber {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }

        int[] temp = new int[nums.length + 1];

        //put zero first
        temp[0] = 0;

        for(int i = 0; i < nums.length; i++){
            if(i == 0){
                //if first element in nums
                temp[i + 1] = nums[i];
            }
            else{
                //compare previous max or current num + 2 max before
                temp[i + 1] = Math.max(temp[i],nums[i] + temp[i - 1]);
            }
        }

        return temp[temp.length - 1];
    }
}
