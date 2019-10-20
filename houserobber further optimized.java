
// here time complexity is O(n) and space complexity is O(1)
class Solution {
    public int rob(int[] nums) {
        // edge case
        if(nums.length==0|| nums==null) return 0;
        //here instead of a 2d matrix we have used only 2 variables to store the values and hence optimizing space complexity since we need only previous 2 values for next calculations
         int chosen=nums[0];
        int notchosen=0;
        // the change is this only otherwise the algo remians the same as done in the 2nd method of this question
        for(int i=1;i<nums.length;i++)
        {
            int temp=chosen;
            chosen=notchosen+nums[i];
            notchosen=Math.max(temp,notchosen);
        }
        return Math.max(chosen,notchosen);
     }
}
   