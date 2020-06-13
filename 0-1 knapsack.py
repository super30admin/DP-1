def knapsack(W,i,costarr,items):
    if W==0 or len(items)==i:
        return 0
    if W-items[i]<0 :
        return 0
        
    return (max(knapsack(W-items[i],i+1,costarr,items)+costarr[i],knapsack(W,i+1,costarr,items)))   
print(knapsack(50,0,[60, 100, 120],[10,20,30]))
