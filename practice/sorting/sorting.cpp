#include<iostream>
using namespace std;

void display(int array[], int n) {
	for (int i=0; i<n; i++) {
		cout<<array[i]<<" ";
	}
	cout<<"\n"<<endl;
}

void bubblesort(int array[], int n) {
	cout<<"This is bubble sort: "<<endl;
	
	for (int i=0; i<n-1; i++) {
		for (int j=0; j<n-i; j++) {
			if (array[j]>array[j+1]) {
				int tmp = array[j+1];
				array[j+1] = array[j];
				array[j] = tmp;
			}
		}
	}
	display(array, 8);
}

void selectionsort(int array[], int n) {
	cout<<"This is selection sort: "<<endl;
	
	for (int i=0; i<n; i++) {
		int min = array[i];
		for (int j=i+1; j<n; j++) {
			if (array[j]<min) {
				array[i] = array[j];
				int tmp = min;
				min = array[j];
				array[j] = tmp;
			}
		}
	}
	display(array, 8);
}

void insertionsort(int array[], int n) {
	cout<<"This is insertion sort: "<<endl;
	
	for (int i=1; i<n; i++) {
		int value = array[i];
		int hole = i;
		while (hole>0 && value<array[hole-1]) {
			array[hole] = array[hole-1];
			hole = hole-1;
		}
		array[hole]=value;
	}
	
	display(array, 8);
}

void merge(int array[], int l, int r) {
	int i, j ,k;
	int mid = (r+l)/2;
	int n1=mid-l+1;
	int n2=r-mid;
//	cout<<"-----"<<mid<<endl;
	int left[n1];
	for (i=0; i<n1; i++) {
		left[i] = array[l+i];
	}
	int right[n2];
	for (i=0; i<n2; i++) {
		right[i] = array[i+mid+1];
	}
//	cout<<"Left Right Arrays: "<<endl;
//	display(left, n1);
//	display(right, n2);
	i = 0;
	j = 0;
	k = l;
	while ( i<n1 && j<n2 ) {
		if (left[i]<right[j]) {
			array[k] = left[i];
			i++;
			k++;
		}
		else {
			array[k] = right[j];
			j++;
			k++;
		}
	}
	while (i<n1) {
		array[k] = left[i];
		i++;
		k++;
	}
	while (j<n2) {
		array[k] = right[j];
		j++;
		k++;
	}
//	display(array, 8);
	
}

void mergesort(int array[], int l, int r) {
	
	if (l<r) {
		int mid = (l+r)/2;
		mergesort(array, l, mid);
		mergesort(array, mid+1, r);
		merge(array, l, r);
	}
}

int main() {
	int array[] = {10, 1, 3, 5, 7, 4, 13, 6};
	display(array, 8);
	
	bubblesort(array, 8);
	
	int array2[] = {10, 1, 3, 5, 7, 4, 13, 6};
	selectionsort(array2, 8);
	
	int array3[] = {10, 1, 3, 5, 7, 4, 13, 6};
	insertionsort(array3, 8);
	
//	int array4[] = {1, 3, 5, 10, 4, 6, 7, 13};
//	merge(array4, 0, 7);
//	display(array4, 8);

	int array5[] = {10, 1, 3, 5, 7, 4, 13, 6};
	cout<<"This is merge sort: "<<endl;
	mergesort(array5, 0, 7);
	
	display(array5, 8);
	
	int array5[] = {10, 1, 3, 5, 7, 4, 13, 6};
	cout<<"This is quick sort: "<<endl;
//	quicksort(array5, 0, 7);
}
