class DisjointSetUnion{
    int[] parent;
    int[] size;
    int comps;

    public DisjointSetUnion(int n){
        comps = n;
        parent = new int[n];
        size = new int[n];
        for(int i=0; i<n;i++){
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int findUParent(int node){
        if(node == parent[node]){
            return node;
        }
        int ulp = findUParent(parent[node]);
        parent[node] = ulp;
        return parent[node];
    }

    public boolean unionBySize(int u, int v){
        int ulp_u = findUParent(u);
        int ulp_v = findUParent(v);

        if(ulp_u == ulp_v){
            return false;
        }
        if(size[ulp_u]< size[ulp_v]){
            parent[ulp_u] = ulp_v;
            size[ulp_v]+=size[ulp_u];
        }
        else{
            parent[ulp_v] = ulp_u;
            size[ulp_u]+=size[ulp_v];
        }
        comps--;
        return true;
    }

    public int components(){
        return this.comps;
    }
}

class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(edges.length > n-1){
            return false;
        }

        DisjointSetUnion dsu = new DisjointSetUnion(n);
        for(int edge[] : edges){
            if(!dsu.unionBySize(edge[0], edge[1])){
                return false;
            }
        }
        return dsu.components() == 1;
    }
}
