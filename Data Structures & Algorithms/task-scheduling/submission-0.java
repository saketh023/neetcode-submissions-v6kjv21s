class Solution {
    public int leastInterval(char[] tasks, int n) {
        int freqMap[] = new int[26];

        for(char task : tasks){
            freqMap[task - 'A']++;
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b)-> b-a);

        for(int freq : freqMap){
            if(freq > 0){
                maxHeap.offer(freq);
            }
        }

        Queue<int[]> q = new LinkedList<>();

        int time = 0;

        while(!maxHeap.isEmpty() || !q.isEmpty()){
            time++;

            if(maxHeap.isEmpty()){
                time = q.peek()[1];
            }else{
                int count=0;
                count = maxHeap.poll()-1;
                if(count>0) q.offer(new int[]{count, time+n});
            }

            if(!q.isEmpty() && q.peek()[1] == time){
                maxHeap.offer(q.poll()[0]);
            }
        }

        return time;
    }
}
