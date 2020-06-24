// Link to the question:
// https://practice.geeksforgeeks.org/problems/travelling-salesman-problem/0
// Tbh I dont think Index data structure is required
// Using bitmask dp instead of sets

import java.util.*;
import java.lang.*;
import java.io.*;

class Index {
    int currentVertex;
    int vertexSet;
    
    Index(int vertex, int set) {
        currentVertex = vertex;
        vertexSet = set;
    }
    
    public String toString() {
        return ""+currentVertex+" "+vertexSet;
    }
}

class AllSetsOrder implements Comparator<Integer> {
    public int setBits(int a) {
        int count=0;
        while (a!=0) {
            a=a&(a-1);
            count++;
        }
        return count;
    }
    
    public int compare(Integer a, Integer b) {
        return setBits(a)-setBits(b);
    }
}


class GFG {
    public static int minCost(int[][] adj) {
        int maskSize = (int)Math.pow(2,adj.length)+1;
        int[][] dp = new int[adj.length][maskSize];
        Map<Index, Integer> parent = new HashMap<Index, Integer>();
        
        ArrayList<Integer> allSets = genComb(adj.length-1);
        
        for (int set:allSets) {
            for (int i=1;i<adj.length;i++) {
                if ((set & 1<<i) != 0) continue;
                
                Index index = new Index(i,set);
                
                int minCost = Integer.MAX_VALUE;
                int minParent = 0;
                
                int copySet = set;
                for (int prevVertex=1;prevVertex<adj.length;prevVertex++) {
                    if ((set & 1<<prevVertex) != 0) {
                        int cost = adj[prevVertex][i] + getCost(prevVertex,copySet,dp);
                        if (cost < minCost) {
                            minCost = cost;
                            minParent = prevVertex;
                        }
                    }
                }
                if (set==1) {
                    minCost = adj[0][i];
                }
                
                dp[i][set] = minCost;
                parent.put(index,minParent);
                
            }
        }
        
        int finalSet = (1<<(adj.length))-1;
        
        int copySet = finalSet;
        int ans = Integer.MAX_VALUE;
        for (int prevVertex=1;prevVertex<adj.length;prevVertex++) {
            if ((finalSet & 1<<prevVertex) != 0) {
                int cost = adj[prevVertex][0] + getCost(prevVertex,copySet,dp);
                ans = Math.min(cost,ans);
            }
        }
        
        return ans;
    }
    
    public static int getCost(int prevVertex, int set, int[][] dp) {
        set = set & ~(1<<prevVertex);
        Index index = new Index(prevVertex,set);
        int cost = dp[prevVertex][set];
        set = set | (1<<prevVertex);
        return cost;
    }
    
    public static ArrayList<Integer> genComb(int size) {
        ArrayList<Integer> input = new ArrayList<Integer>();
        for (int i=1;i<size;i++) {
            input.add(i);
        }
        ArrayList<Integer> allSets = new ArrayList<Integer>();
        allSets.add(1);
        allComb(allSets,1,size,1);
        Collections.sort(allSets, new AllSetsOrder());
        return allSets;
    } 
    
    public static void allComb(ArrayList<Integer> allSets, int set, int n, int pos) {
        // if ((1<<n & set)!=0) 
        if (pos>n) {
            return;
        }
        
        for (int i=pos;i<=n;i++) {
            int newSet = (set|1<<i);    
            allSets.add(newSet);
            allComb(allSets,newSet,n,i+1);
        }
    }
    
	public static void main (String[] args) {
		//code
		Scanner sc = new Scanner(System.in);
		int t = Integer.parseInt(sc.next());
		while (t>0) {
		    int n = Integer.parseInt(sc.next());
		    int[][] adj = new int[n][n];
		    for (int i=0;i<n;i++) {
		        for (int j=0;j<n;j++) {
		            int inp = Integer.parseInt(sc.next());
		            adj[i][j] = inp;
		        }
		    }
		    
		    System.out.println(minCost(adj));
		    
		    t--;
		}
// 		System.out.println(genComb(3));
	}
}