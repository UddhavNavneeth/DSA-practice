#include<iostream>
using namespace std;

void bubbleSort(int* arr, int n) {
	int i,j;
	for (i=0;i<n-1;i++) {
		for (j=0;j<n-1-i;j++) {
			if (arr[j]>arr[j+1]) {
				int temp = arr[j+1];
				arr[j+1]=arr[j];
				arr[j]=temp;
			}
		}
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
	bubbleSort(arr,n);
	return 0;
}
