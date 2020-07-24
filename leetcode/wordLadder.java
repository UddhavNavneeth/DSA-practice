// Link to the question:
// https://leetcode.com/problems/word-ladder/

class Solution {
    public boolean isLinked(String a, String b) {
        int count = 0;
        for (int i=0; i<a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                count++;
            }
        }
        
        if (count == 1) {
                return true;
        }else {
                return false;
        }
    }
    
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<String, ArrayList<String>> adjList = new HashMap<String, ArrayList<String>>();
        
        wordList.add(beginWord);
        
        for (String word : wordList) {
            ArrayList<String> adj = new ArrayList<String>();
            adjList.put(word, adj);
        }
        
        for (int i=0; i<wordList.size(); i++) {
            for (int j=i+1; j<wordList.size(); j++) {
                if (isLinked(wordList.get(i), wordList.get(j))) {
                    
                    ArrayList<String> adj = adjList.get(wordList.get(i));
                    adj.add(wordList.get(j));
                    adjList.put(wordList.get(i), adj);
                    
                    adj = adjList.get(wordList.get(j));
                    adj.add(wordList.get(i));
                    adjList.put(wordList.get(j), adj);
                }
            }
        }
        
        Map<String, Integer> dist = new HashMap<String, Integer>();
        
        for (String word : wordList) {
            dist.put(word, Integer.MAX_VALUE);
        }
        dist.put(beginWord, 0);
        
        Queue<String> q = new LinkedList<String>();
        Set<String> visited = new HashSet<String>();
        
        q.add(beginWord);
        
        while (q.size() != 0) {
            String node = q.poll();
            visited.add(node);
            
            for (int i=0; i<adjList.get(node).size(); i++) {
                if (!visited.contains(adjList.get(node).get(i))) {
                    dist.put(adjList.get(node).get(i), dist.get(node)+1);
                    q.add(adjList.get(node).get(i));
                    visited.add(adjList.get(node).get(i));
                    
                    if (adjList.get(node).get(i).equals(endWord)) {
                        return dist.get(adjList.get(node).get(i))+1;
                    }
                }
            }
        }
        
        return 0;
    }
}