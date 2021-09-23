
/*

You are given an m * n matrix containing 0, 1 or 2 , where 0 represents an empty cell,
1 represents a fresh orange, 2 represents rotten orange. Every hour, any fresh orange that is 4-directionally
adjacent to a rotten orange becomes rotten.
Print the minimum number of hours that must elapse until no cell has a fresh orange.

input format = First line contains two integers m and n.
Each of next m line contains n integers 0,1 or 2.

output format = Print minimum hours

input-:
3 3
2 1 1
1 1 0
0 1 1

output-:
4

qs - https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/graphs/rotting-oranges-official/ojquestion#!

*/


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class RottenTomatoes {

  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] st = br.readLine().split(" ");
    int n = Integer.parseInt(st[0]);
    int m = Integer.parseInt(st[1]);

    int[][] arr = new int[n][m];

    for (int i = 0; i < n; i++) {
      st = br.readLine().split(" ");
      for (int j = 0; j < m; j++) {
        arr[i][j] = Integer.parseInt(st[j]);
      }
    }

    System.out.println(orangesRotting(arr));

  }

  public static class Pair {
    int row;
    int col;

    Pair(int row, int col) {
      this.row = row;
      this.col = col;
    }

  }

  public static int orangesRotting(int[][] grid) {
    
    int fresh = 0;
    LinkedList<Pair> q = new LinkedList<>();
    
    for(int i=0; i<grid.length; i++){
        for(int j=0; j<grid[0].length; j++){
            if(grid[i][j]==2){
                q.add(new Pair(i, j));    
            }else if(grid[i][j]==1){
                fresh++;
            }
        }
    }
    int [][] dir = {{-1,0}, {0,1}, {1,0}, {0,-1}};
    int time = -1;
    while(q.size()>0){
        int size = q.size();
        time++;
        while(size>0){
            size--;
            Pair p = q.removeFirst();
            for(int i=0; i<dir.length; i++){
                int r = p.row+dir[i][0];
                int c = p.col+dir[i][1];
                
                if(r>-1 && c>-1 && r<grid.length && c<grid[0].length){
                    if(grid[r][c]==1){
                        grid[r][c] = 2;
                        q.addFirst(new Pair(r, c));
                        fresh--;
                    }
                }
            }
        }
    }
    if(fresh==0)
        return time;
    else
        return -1;
  }
}