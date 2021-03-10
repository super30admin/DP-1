class Solution {
    public int rob(int[] nums) {
        if(nums==null || nums.length==0) return 0;
        int m=2;
        int n=nums.length;
        int [][] ans = new int[n][m];
        ans[0][0]=nums[0];
        ans[0][1]=0;
        
        for(int i=1;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(j==0)
                {
                    ans[i][j] = nums[i] + ans[i-1][1];
                 }
                else
                {
                    ans[i][j] = Math.max(ans[i-1][0],ans[i-1][1]);
                }
            }
            
         
        }
        return Math.max(ans[n-1][0],ans[n-1][1]);
    }
}