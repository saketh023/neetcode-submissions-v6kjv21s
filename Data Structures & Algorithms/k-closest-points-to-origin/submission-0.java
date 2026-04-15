class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int[][] result = new int[k][2];
        int count = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> distance(b)-distance(a));
        for(int[] point : points){
            pq.add(point);
            if(pq.size()>k) pq.poll();
        }

        while(!pq.isEmpty()){
            result[count] = pq.poll();
            count++;
        }

        return result;
        
    }

    public int distance(int[] point){
        int x = point[0];
        int y = point[1];
        return (x*x)+(y*y);
    }
}