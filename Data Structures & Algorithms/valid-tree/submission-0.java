class Solution {
    int[] vis;
    Map<Integer, Set<Integer>> adj = new HashMap<>();
    public boolean validTree(int n, int[][] edges) {
        vis = new int[n];

        for (int[] edge : edges) {
            adj.computeIfAbsent(edge[0], k -> new HashSet<>()).add(edge[1]);
            adj.computeIfAbsent(edge[1], k -> new HashSet<>()).add(edge[0]);
        }

        if (!dfs(0, -1)) {
            return false;
        }

        for(int v : vis){
            if(v==0) return false;
        }
        return true;
    }

    private boolean dfs(int node, int parent) {
        if(vis[node] == 1) return false;
        if(vis[node] == 2) return true;
        vis[node]=1;

        if (adj.get(node) != null) {
            for (int nei : adj.get(node)) {
                if(nei == parent) continue;
                if(!dfs(nei, node)){
                    return false;
                }
            }
        }
        vis[node] = 2;
        return true;
    }
}
