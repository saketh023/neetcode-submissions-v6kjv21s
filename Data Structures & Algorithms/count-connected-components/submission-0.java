class Solution {
    int[] vis;
    Map<Integer, List<Integer>> adj = new HashMap<>();
    Set<Set<Integer>> mainSet = new HashSet<>();
    public int countComponents(int n, int[][] edges) {
        vis = new int[n];

        for(int[] edge : edges){
            adj.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
            adj.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
        }

        for(int node=0; node<n;node++){
            if(vis[node] == 0){
                Set<Integer> innerSet = new HashSet<>();
                dfs(node, innerSet);
                mainSet.add(innerSet);
            }
        }

        return mainSet.size() == 0 ? 1 : mainSet.size();
    }

    private void dfs(int node, Set<Integer> innerSet){
        if(vis[node] == 1) return;
        if(vis[node] == 2) return;

        vis[node] = 1;

        if(adj.get(node)!= null){
            for(int nei : adj.get(node)){
                dfs(nei, innerSet);
            }
        }
        vis[node] = 2;
        innerSet.add(node);
    }
}
