class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        int [] result = new int [nums.length];
        result[n-1]=nums[n-1];
        int choose=result[n-1],dnc=0;
        for(int i=n-2;i>=0;i--)
        {
            result[i] = Math.max(choose,nums[i]+dnc);
            dnc=choose;
            choose=result[i];
            
        }
    int maxmoney=result[0];
        for(int i=1;i<n;i++){
            if(maxmoney<result[i]){
                maxmoney=result[i];
            }
        }
        return maxmoney;
            
            
            
            }
}