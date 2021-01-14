/* Time Complexity : O(n)
Space Complexity : Maybe O(1).
Did this code run successfully on LeetCode : Yes.

Any problems :
 It is a very basic solution that I have implemented. I don't know the Dynamic Programming Approach for this problem.
 */
 

int max(int a,int b)
{
    if(a>b)
        return a;
    else
        return b;
}
int rob(int num[], int n) {
    int a = 0;
    int b = 0;
    
    for (int i=0; i<n; i++)
    {
        if (i%2==0)
        {
            a = max(a+num[i], b);
        }
        else
        {
            b = max(a, b+num[i]);
        }
    }
    
    return max(a, b);
}