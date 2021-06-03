class Solution {
    public int rob(int[] nums) {
        int[] a=new int[nums.length+1];
        a[0]=0;
        a[1]=nums[0];
        
        for(int i=1;i<nums.length;i++)
        {
            a[i+1]=Math.max(a[i-1]+nums[i], a[i]);
        }
        return a[nums.length];
    }
}
