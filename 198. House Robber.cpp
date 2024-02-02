class Solution {
public:
    /*
    Time complexity: O(N)
    Space complexity: O(1)  (modifying the input array)
    */
    int rob(vector<int>& a) {
      int n = a.size();

      //we can actually use 'a' as the dp array

      for(int i=1;i<n;i++){
        //2 options (pick bigger of these 2): 
        //1. take the maximum till last index (= dp[i-1]) (can't add a[i] since it will be taking adjacent cell)
        //2. take the maximum till last's previous (= dp[i-2]) and add current value a[i]
        if(i>1)  a[i] = max(a[i-2]+a[i], a[i-1]);
        else  a[i] = max(a[i], a[i-1]);
      }

      return a[n-1];
    }
};
