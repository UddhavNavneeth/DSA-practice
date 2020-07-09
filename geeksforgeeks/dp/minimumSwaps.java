// Link to the question:
// https://practice.geeksforgeeks.org/problems/minimum-swaps/1#:~:text=Your%20task%20is%20to%20complete,Space%3A%20O(N).
// Mine is in O(nlogn) time but still doesnt seem to pass

class GfG {
    // return the minimum number of swaps required to sort the arra
	public int minSwaps(int[] arr, int N) {
	    ArrayList<Integer> ar = new ArrayList<Integer>();
	    Map<Integer,Integer> arrMap = new HashMap<Integer, Integer>();
	    
	    for (int i=0;i<arr.length;i++) {
	        ar.add(arr[i]);
	        arrMap.put(arr[i],i);
	    }
	    
	    Collections.sort(ar);
	    int swaps = 0;
	    
	    for (int i=0; i<arr.length; i++) {
	        if (arr[i] == ar.get(i)) continue;
	        else {
	            swaps++;
	            int reqIndex = arrMap.get(ar.get(i));
	            
	            int temp = arr[i];
	            arr[i] = arr[reqIndex];
	            arr[reqIndex] = temp;
	            
	            arrMap.put(temp, reqIndex);
	            arrMap.put(ar.get(i), i);
	        }
	    }
	    
	    return swaps;
	    
	}
	
}