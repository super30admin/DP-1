class Solution {
    public int rob(int[] nums) {
       return helper(0, 0,nums);
    }
    private int helper(int index, int amount, int[] arr)
    {
        if(index>arr.length-1)return amount;
        //chosen
        int case1 = helper(index+2,amount+arr[index],arr);
        //not chosen
        int case2 = helper(index+1,amount,arr);
        return Math.max(case1,case2);
    }
}