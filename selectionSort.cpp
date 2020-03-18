#include<iostream>
using namespace std;

void selectionSort(int* arr, int n) {
	int i,j;
	for (i=0;i<n;i++) {
		for (j=i+1;j<n;j++) {
			if (arr[j]<arr[i]) {
				int temp=arr[j];
				arr[j]=arr[i];
				arr[i]=temp;
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
	selectionSort(arr,n);
	return 0;
}
