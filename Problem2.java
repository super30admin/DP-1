//Time complexity - O(n)
//Space complexity - O(1)
//All test cases passed
class Solution {
    public int rob(int[] nums) {
        if(nums==null||nums.length==0)
            return 0;

        int prevmax=0;
        int currmax=0;

        for(int x : nums)
        {
            int temp = currmax;
            currmax = Math.max(prevmax+x,currmax);
            prevmax=temp;
        }

        return currmax;
    }

}