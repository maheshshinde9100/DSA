class Solution {
    public int search(int[] nums, int target) {
        int count=-1;
        for(int x: nums){
            count++;
            if(x==target){
                return count;
            }
        }
        return -1;
    }
}

// GFG
class Solution {
    public void sort012(int[] arr) {
        //bubble sort
        // for(int i=0;i<arr.length;i++){
        //     for(int j=i+1;j<arr.length;j++){
        //         if(arr[i]>arr[j]){
        //             int t = arr[i];
        //             arr[i] = arr[j];
        //             arr[j] = t;
        //         }
        //     }
        // }
        //selection sort
        // for(int i=0;i<arr.length;i++){
        //     int minI = i;
        //     for(int j=i+1;j<arr.length;j++){
        //         if(arr[j]<arr[minI]){
        //             minI = j;
        //         }
        //     }
        //     if(minI!=i){
        //         int t= arr[i];
        //         arr[i] = arr[minI];
        //         arr[minI] = t;
        //     }
        // }
        List<Integer> l = new ArrayList<Integer>();
        for(int i:arr){
            l.add(i);
        }
        Collections.sort(l);
        for(int i=0;i<arr.length;i++){
            arr[i] = l.get(i);
        }
    }
}