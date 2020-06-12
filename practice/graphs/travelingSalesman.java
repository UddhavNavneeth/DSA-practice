/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class Index {
    int currentVertex;
    Set<Integer> vertexSet;
    
    Index(int vertex, Set<Integer> set) {
        currentVertex = vertex;
        vertexSet = set;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Index index = (Index) o;

        if (currentVertex != index.currentVertex) return false;
        return !(vertexSet != null ? !vertexSet.equals(index.vertexSet) : index.vertexSet != null);
    }
    
    @Override
    public int hashCode() {
        int result = currentVertex;
        result = 31 * result + (vertexSet != null ? vertexSet.hashCode() : 0);
        return result;
    }
    
    public String toString() {
        return ""+currentVertex+" "+vertexSet;
    }
}

class AllSetsOrder implements Comparator<Set<Integer>> {
    public int compare(Set<Integer> a, Set<Integer> b) {
        return a.size()-b.size();
    }
}


class GFG {
    public static int minCost(int[][] adj) {
        Map<Index, Integer> minCostDP = new HashMap<Index, Integer>();
        Map<Index, Integer> parent = new HashMap<Index, Integer>();
        
        ArrayList<Set<Integer>> allSets = genComb(adj.length);
        
        // System.out.println(allSets);
        
        for (Set<Integer> set:allSets) {
            for (int i=1;i<adj.length;i++) {
                if (set.contains(i)) continue;
                
                Index index = new Index(i,set);
                
                int minCost = Integer.MAX_VALUE;
                int minParent = 0;
                
                Set<Integer> copySet = new HashSet<>(set);
                for (Integer prevVertex:set) {
                    int cost = adj[prevVertex][i] + getCost(prevVertex,copySet,minCostDP);
                    // System.out.println(i+" "+prevVertex+" "+adj[i][prevVertex]+" "+getCost(prevVertex,copySet,minCostDP));
                    if (cost < minCost) {
                        minCost = cost;
                        minParent = prevVertex;
                    }
                }
                if (set.size()==0) {
                    minCost = adj[0][i];
                }
                
                // System.out.println(index+" "+minCost);
                
                minCostDP.put(index,minCost);
                parent.put(index,minParent);
                
            }
        }
        
        // System.out.println(minCostDP);
        
        Set<Integer> finalSet = new HashSet<Integer>();
        for (int i=1;i<adj.length;i++) {
            finalSet.add(i);
        }
        
        Set<Integer> copySet = new HashSet<>(finalSet);
        int ans = Integer.MAX_VALUE;
        for (Integer prevVertex:finalSet) {
            int cost = adj[prevVertex][0] + getCost(prevVertex,copySet,minCostDP);
            ans = Math.min(cost,ans);
        }
        
        return ans;
    }
    
    public static int getCost(int prevVertex, Set<Integer> set, Map<Index,Integer> minCostDP) {
        set.remove(prevVertex);
        Index index = new Index(prevVertex,set);
        int cost = minCostDP.get(index);
        set.add(prevVertex);
        return cost;
    }
    
    public static ArrayList<Set<Integer>> genComb(int size) {
        ArrayList<Integer> input = new ArrayList<Integer>();
        for (int i=1;i<size;i++) {
            input.add(i);
        }
        ArrayList<Set<Integer>> allSets = new ArrayList<Set<Integer>>();
        Set<Integer> emptySet = new HashSet<Integer>();
        allSets.add(emptySet);
        allComb(input,allSets,0,emptySet);
        Collections.sort(allSets, new AllSetsOrder());
        return allSets;
    } 
    
    public static void allComb(ArrayList<Integer> input, ArrayList<Set<Integer>> allSets, int start, Set<Integer> currSet) {
        if (start==input.size()) {
            return;
        }
        
        for (int i=start;i<input.size();i++) {
            int val = input.get(i);
            Set<Integer> newSet = new HashSet<Integer>(currSet);
            newSet.add(val);
            allSets.add(newSet);
            allComb(input,allSets,i+1,newSet);
            // currSet.remove(val);
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
// 		System.out.println(genComb(4));
	}
}