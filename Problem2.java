package DP1;
/**
 * 
 * Using bottom up DP approach
 * 
 * Time Complexity :
 * O(n) where n is the length of the input array
 * 
 * Space Complexity :
 * O(1)
 * 
 * Did this code successfully run on Leetcode : yes
 * 
 * Any problem you faced while coding this : No
 */
public class Problem2 {
    public int rob(int[] nums) {

        if(nums.length==1)
            return nums[0];
        else if(nums.length==2)
            return Math.max(nums[0],nums[1]);


        int prev=nums[0];
        int curr=Math.max(nums[0],nums[1]);



        for(int i=2;i<nums.length;i++){
                int temp=curr;
                curr=Math.max(curr, prev+nums[i]);
                prev=temp;
        }

        return curr;
        
    }
}
