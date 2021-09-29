
/*
Used to fing MST
*/

import java.util.*;
import java.io.*;

public class Kruskal {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int v = Integer.parseInt(br.readLine());
    int e = Integer.parseInt(br.readLine());

    int[][] edges = new int[e][3];
    for (int i = 0; i < e; i++) {
      String[] st = br.readLine().split(" ");
      edges[i][0] = Integer.parseInt(st[0]);
      edges[i][1] = Integer.parseInt(st[1]);
      edges[i][2] = Integer.parseInt(st[2]);
    }

    System.out.println(minCostToSupplyWater(v, edges));
  }

  static int[] parent;
  static int[] rank;

  public static class Pair implements Comparable<Pair> {
    int u;
    int v;
    int wt;

    Pair(int u, int v, int wt) {
      this.u = u;
      this.v = v;
      this.wt = wt;
    }

    @Override
    public int compareTo(Pair o) {
      return this.wt - o.wt;
    }
    
    public String toString(){
        return this.u+" "+this.v+" "+this.wt;
    }
  }
  
  public static void initDSU(){
    for(int i=0; i<parent.length; i++){
        parent[i] = i;
        rank[i] = 1;
    } 
  }
  
  public static int find(int x){
      if(parent[x]==x){
          return x;
      }
      
      int temp = find(parent[x]);
      parent[x] = temp;
      return temp;
  }

  public static void union(int x, int y){
      int px = find(x);
      int py = find(y);
      
      if(px!=py){
          if(rank[px]>rank[py]){
            parent[py] = px;
          }else if(rank[py]>rank[px]){
            parent[px] = py;  
          }else{
            parent[px] = py;
            rank[py]++;
          }
      }
  }

  public static int minCostToSupplyWater(int n, int[][] pipes) {
    
    parent = new int[n];
    rank = new int[n];
    
    initDSU();
    
    Pair [] graph = new Pair[pipes.length];
    
    for(int i=0; i<pipes.length; i++){
        graph[i] = new Pair(pipes[i][0], pipes[i][1], pipes[i][2]);
    }
    
    Arrays.sort(graph);

    int ans = 0;

    for(int i=0; i<graph.length; i++){
        int pu = find(graph[i].u);
        int pv = find(graph[i].v);
        
        if(pu!=pv){
            union(graph[i].u, graph[i].v);
            ans+=graph[i].wt;
        }
    }

    return ans;
  }
}










