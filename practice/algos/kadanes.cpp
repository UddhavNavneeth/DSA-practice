#include<iostream>
#include<vector>
#include <bits/stdc++.h>
using namespace std;


//Max contigous sub array sum

void cubicTime(int array[], int n) {
	int max=array[0];
	for (int i=0; i<n; i++) {
		for (int j=i;j<n;j++) {
			int sum=0;
			for (int k=i; k<=j; k++) {
				sum = sum+array[k];
			}
			if (sum>=max) {
				max=sum;
			}	
		}
		
	}
	cout<<max<<endl;
}

void quadTime(int array[], int n) {
	int max=array[0];
	for (int i=0; i<n; i++) {
		int runningSum=0;
		for (int j=i; j<n ;j++) {
			runningSum=runningSum+array[j];
			if (runningSum>=max) {
				max=runningSum;
			}
			
		}
	}
	cout<<max<<endl;
}

void kadanes(int array[], int n) {
	int max=array[0];
	int maxSum=array[0];
	for (int i=0; i<n; i++) {
		if (maxSum+array[i]>array[i]) {
			maxSum = maxSum+array[i];
		} else {
			maxSum = array[i];
		}
		
		if (maxSum>max) {
			max = maxSum;
		}
	}
	cout<<max<<endl;
}

int main() {
	int array[8] = {-2,-3,4,-1,-2,1,5,-3};
	cubicTime(array,8);
	quadTime(array,8);
	kadanes(array,8);
	
	return 0;
	
}
