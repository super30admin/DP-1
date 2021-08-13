//Time complexity: O(n), where n is the number of elements in the array
//Space complexity: O(1)
//running on leetcode: yes
class Solution {
    public int rob(int[] nums) {
        //base case
        if (nums==null || nums.length==0)
        {
            return -1;
        }
        int skip=0;
        int take=nums[0];//initially robbed house 1
        
        for(int i=1; i<nums.length; i++)
        {
            //store skip here coz it changes
            int temp= skip;
            skip=Math.max(skip,take);
            take=temp+nums[i];
        }
        return Math.max(skip,take);
        
    }
}
