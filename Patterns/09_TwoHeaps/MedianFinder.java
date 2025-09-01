/*
LeetCode (Hard) : 295. Find Median from Data Stream
*/
class MedianFinder {
    private PriorityQueue<Integer> maxH; 
    private PriorityQueue<Integer> minH; 
    public MedianFinder() {
        maxH = new PriorityQueue<>((a,b) -> b-a);
        minH =new PriorityQueue<>();
    }
    
    void addNum(int num) {
        if(maxH.isEmpty()||num<=maxH.peek()){
            maxH.offer(num);
        }else {
            minH.offer(num);
        }
        if(maxH.size()>minH.size()+1){
            minH.offer(maxH.poll());
        }else if(minH.size()>maxH.size()){
            maxH.offer(minH.poll());
        }
    }
    double findMedian() {
        if(maxH.size()==minH.size()){    
            return (maxH.peek()+minH.peek())/2.0;
        } else{
            return maxH.peek();
        }
    }
}
