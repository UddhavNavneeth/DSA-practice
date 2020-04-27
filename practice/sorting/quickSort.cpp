#include<iostream>
using namespace std;

int partition(int* arr, int start, int end) {
	int i,pInd = start;
	for (i=start;i<end;i++) {
		if (arr[i]<=arr[end]) {
			swap(arr[i],arr[pInd]);
			pInd++;
		}
	}
	swap(arr[pInd],arr[end]);
	return pInd;
	
}

void quickSort(int* arr, int start, int end) {
	if (start<end) {
		int pInd = partition(arr,start,end);
		quickSort(arr, start, pInd-1);
		quickSort(arr, pInd+1, end);
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
	quickSort(arr,0,n-1);
	
	for (i=0;i<n;i++) {
		cout<<arr[i]<<" ";
	}
	return 0;
}
