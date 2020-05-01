// Link to the question:
// https://www.interviewbit.com/problems/shortest-unique-prefix/
// Learned from https://www.geeksforgeeks.org/find-all-shortest-unique-prefixes-to-represent-each-word-in-a-given-list/

public class Solution {
    public class TrieNode{
        Map<Character,TrieNode> next;
        boolean eow;
        int freq;
        TrieNode() {
            next = new HashMap<Character,TrieNode>();
            eow=false;
            freq=0;
        }
    }
    
    public void insert(TrieNode current, String word, int index) {
        if (index==word.length()) {
            current.eow=true;
            current.freq=1;
            return;
        }
        
        char letter = word.charAt(index);
        TrieNode node = current.next.get(letter);
        if (node==null) {
            node = new TrieNode();
            current.next.put(letter,node);
            current.freq++;
            insert(node,word,index+1);
        }else {
            current.freq++;
            insert(node,word,index+1);
        }
        
        return;
    }
    
    public int shortestUniquePrefixSearch(TrieNode current, String word, int index) {
        if (index>word.length()) {
            return -1;
        }
        if (current.freq==1) {
            return index;
        }
        
        char letter = word.charAt(index);
        TrieNode node = current.next.get(letter);
        
        if (node==null) {
            return -1;
        }
        
        return shortestUniquePrefixSearch(node,word,index+1);
    }
    
    
    public ArrayList<String> prefix(ArrayList<String> A) {
        ArrayList<String> ans = new ArrayList<String>();
        TrieNode root = new TrieNode();
        
        for (int i=0;i<A.size();i++) {
            insert(root,A.get(i),0);
        }
        
        for (int i=0;i<A.size();i++) {
            int ind = shortestUniquePrefixSearch(root,A.get(i),0);
            // System.out.println(A.get(i)+" "+ind);
            ans.add(A.get(i).substring(0,ind));
        }
        
        return ans;
    }
}