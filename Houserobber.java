
//sc-o(n)
//tc-o(n)
public class housserobberdp {
    public static void main(String args[])
    {
    
        int nums[] = {6,9,8,1,1,5};
        int amount =0;
        if(nums==null||nums.length==0)amount =0;
        int n = nums.length;
        int dp[] = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for(int i=2;i<n;i++)
        {
            dp[i] = Math.max(dp[i-1],dp[i-2]+nums[i]);
        }
       amount = dp[n-1];

       System.out.println(amount);

    }
    
}
