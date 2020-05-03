// Link to the question:
// https://www.interviewbit.com/problems/lru-cache/
// I have used an arrayList for random access and random delete
// My random access delete/remove is not optimised
// This can be optimised by using an doubly linked list and another list which stores the pointers to each 
// node in the linked list
// when we want to remove a random item we remove it by changing previous and next pointers

// It still passes on interviewBit though

public class Solution {
    Map<Integer,Integer> map;
    ArrayList<Integer> q;
    int size;
    public Solution(int capacity) {
        map = new HashMap<Integer,Integer>();
        q = new ArrayList<Integer>();
        size=capacity;
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
            q.remove(new Integer(key));
            q.add(key);
            int item = map.get(key);
            return item;
        }else {
            return -1;
        }
    }
    
    public void set(int key, int value) {
        if (map.containsKey(key)) {
            map.put(key,value);
            q.remove(new Integer(key));
            q.add(key);
            return;
        }
        
        if (map.size()>=size) {
            int rem = q.get(0);
            map.remove(rem);
            q.remove(0);
            
            map.put(key,value);
            q.add(key);
        }else {
            map.put(key,value);
            q.add(key);
        }
    }
}