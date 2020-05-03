import java.util.*;

class Tuple{
	int x;
	int y;
	Tuple(int a, int b) {
		x=a;
		y=b;
	}
	
	public void display() {
		System.out.print(" ("+x+" "+y+") ");
	};
}

class sort implements Comparator<Tuple> {
	
	public int compare(Tuple a, Tuple b) {
		if (a.x==b.x) {
			return a.y-b.y;    //if x was a string we would compare them like this: return a.x.compareTo(b.x);
                                // to get it sorted lexicographically
		}else {
			return a.x-b.x;
		}
	}
}
	

public class compare {
	public static void main(String args[]) {
		ArrayList<Tuple> arr = new ArrayList<Tuple>();
		
		Tuple t1 = new Tuple(4,5);
		Tuple t2 = new Tuple(3,1);
		Tuple t3 = new Tuple(1,9);
		Tuple t4 = new Tuple(2,3);
		Tuple t5 = new Tuple(2,7);
		
		arr.add(t1);
		arr.add(t2);
		arr.add(t3);
		arr.add(t4);
		arr.add(t5);
		
//		before sorting
		for (int i=0;i<arr.size();i++) {
			arr.get(i).display();
		}
		System.out.println();
//		output:  (4 5)  (3 1)  (1 9)  (2 3)  (2 7) 
		
		Collections.sort(arr, new sort());
		
//		after sorting
		for (int i=0;i<arr.size();i++) {
			arr.get(i).display();
		}
		System.out.println();
	}
//	 	output: (1 9)  (2 3)  (2 7)  (3 1)  (4 5) 
	
	
}