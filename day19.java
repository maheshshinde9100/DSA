class Solution{
public int maxOfSubarray(int nums[]){
int max = nums[0];
int min = nums[0];
int maxAtIndex = nums[0];
for(int i=0;i<nums.length;i++){
    int  current = nums[i];
    if(current < 0){
        int temp = maxAtIndex;
        maxAtIndex = min;
        min = temp;
    }
    maxAtIndex = Math.max(current,current*maxAtIndex);
    min = Math.min(current,current*min);
    max = Math.max(max,maxAtIndex);
}
return max;
}