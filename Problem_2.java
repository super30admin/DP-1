/*Time complexity-O(n)
Space Complexity-O(1)
Didnt get this intution at all, had to refer to class*/
class Solution {
    public int rob(int[] nums) {
     int dc=0;
     int c=0;
        int t=0;
        for(int i=0;i<nums.length;i++)
        {
            t=dc;
            dc=Math.max(c,dc);
            c=nums[i]+t;
        }
        return Math.max(c,dc);
        
    }
}
