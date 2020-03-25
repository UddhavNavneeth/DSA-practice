#include<iostream>
using namespace std;

void insertionSort(int* arr, int n) {
	int i;
	for (i=1;i<n;i++) {
		int hole = i;
		int value = arr[i];
		while (hole>0 && value<arr[hole-1]) {
			arr[hole] = arr[hole-1];
			hole = hole - 1;	
		}
		arr[hole] = value;	
	}
	
	for (i=0;i<n;i++) {
		cout<<arr[i]<<" ";
	}
}

int main() {
	int i,n;
	cout<<"Size of array: ";
	cin>>n;
	int arr[n];
	for (i=0;i<n;i++) {
		cin>>arr[i];
	}
	insertionSort(arr,n);
	return 0;
}
