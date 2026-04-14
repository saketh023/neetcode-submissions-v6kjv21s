class Solution {
    public int lastStoneWeight(int[] stones) {
        if(stones.length == 0) return 0;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b)-> b-a);

        for(int stone : stones){
            maxHeap.add(stone);
        }

        while(maxHeap.size()>=2){
            int y = maxHeap.poll();
            int x = maxHeap.poll();
            maxHeap.add(y-x);
        }
        return maxHeap.peek();
    }
}
