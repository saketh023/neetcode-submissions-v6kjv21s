class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int[] dist = new int[n+1];
        List<List<int[]>> adj = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);

        for(int i=0; i<n+1; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] edge : times){
            int ui = edge[0];
            int vi = edge[1];
            int ti = edge[2];
            adj.get(ui).add(new int[]{vi, ti});
        }

        pq.offer(new int[]{0,k});
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;

        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int dis = curr[0];
            int node = curr[1];

            if(dis > dist[node]) continue;

            for(int[] pair : adj.get(node)){
                int adjNode = pair[0];
                int weight = pair[1];

                if(dis + weight < dist[adjNode]){
                    dist[adjNode] = dis + weight;
                    pq.offer(new int[]{dist[adjNode], adjNode});
                }
            }
        }

        int ans = 0;

        for(int i=1; i<=n;i++){
            if(dist[i] == Integer.MAX_VALUE) return -1;
            ans = Math.max(dist[i], ans);
        }

        return ans;
    }
}
