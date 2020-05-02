import java.util.*;

public class heapInJava {
	public static void main(String args[]) {
//		Using Heaps through inbuilt libraries
//		Here we use PriorityQueue which by 
//		default is a minHeap.
		
//		We can make it a max heap using Collections.reverseOrder()
//		new PriorityQueue<Integer>(Collections.reverseOrder());
		
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		
//		Lets sort an array by using this heap
		int[] arr = {2,5,1,8,9,3,10,7,4};
		
		for (int i=0;i<arr.length;i++) {
			pq.add(arr[i]);
		}
		
		for (int i=0;i<arr.length;i++) {
			arr[i]=pq.poll();
		}
		
		for (int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
//		1 2 3 4 5 7 8 9 10 
	}
}