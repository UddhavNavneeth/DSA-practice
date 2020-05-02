import java.util.*;


class Heap{
	public int[] heap;
	public int size;
	public int maxSize;
	Heap(int maxSize) {
		this.heap = new int[maxSize];
		this.maxSize=maxSize;
		this.size=0;
	}
	
	public boolean isLeaf(int pos) { 
        if (pos >= (size / 2) && pos <= size) { 
            return true; 
        } 
        return false; 
    } 
	
	public int parent(int pos) {
		return pos/2;
	}
	
	public int leftChild(int pos) {
		return pos*2+1;
	}
	
	public int rightChild(int pos) {
		return pos*2+2;
	}
	
	public void swap(int n1, int n2) {
		int temp=heap[n1];
		heap[n1]=heap[n2];
		heap[n2]=temp;
		return;
	}
	
//	Look at the minimum value
	public int peek() {
		return heap[0];
	}
	
//	We add val to the end of heap.
//	We then restore order by bubbling upwards
//	or heapifyUpwards
	public void insert(int val) {
//		if we have reached heap max capacity, then return
		if (size>=maxSize) {
			return;
		}
		
		heap[size]=val;
		int current=size;
		size++;
		
//		upwards restoration or heapifyUpwards
		while(heap[current]<heap[parent(current)]) {
			swap(current,parent(current));
			current=parent(current);
		}
		return;
		
	}
	
//	heapify the tree from the given position
//	basically ensuring order in node
//	and its subtree
	public void minHeapify(int pos) {
		if (!isLeaf(pos)) {
			if (heap[pos]>heap[leftChild(pos)]
					|| heap[pos]>heap[rightChild(pos)]) {
				if(heap[leftChild(pos)]<heap[rightChild(pos)]) {
					swap(pos,leftChild(pos));
					minHeapify(leftChild(pos));
				}else {
					swap(pos,rightChild(pos));
					minHeapify(rightChild(pos));
				}
			}
		}
		return;
	}
	
// 	Return minimum value then restore order
//	stores min value, exchanges first and last element
//	decreases size, so value is removed
//	then we need to restore order so we bubble down
//	or heapifyDownwards or also known as
//	minHeapify
	public int poll() {
		int ans=heap[0];
		heap[0]=heap[size-1];
		size--;
		minHeapify(0);
		return ans;
	}
	
	public void display() {
		for (int i=0;i<size;i++) {
			System.out.print(heap[i]+" ");
		}
		System.out.println();
		return;
	}

//	NOT SO SURE ABOUT USE OF THIS
// Function to build the min heap using 
// the minHeapify 
    public void minHeap() 
    { 
        for (int pos = (size / 2); pos >= 1; pos--) { 
            minHeapify(pos); 
        } 
    } 
}


public class minHeap {
	public static void main(String args[]) {
		Heap heap = new Heap(10);
		heap.insert(4);
		heap.insert(10);
		heap.insert(3);
		heap.insert(15);
		heap.insert(9);
		heap.display();
		
		heap.poll();
		heap.display();
	}
}