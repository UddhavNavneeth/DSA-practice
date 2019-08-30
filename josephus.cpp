

#include<iostream>
using namespace std;

//Here by returning 0 we assume that the elements in the circle start from index 0
int josephus(int n, int k) {
	if (n==1) {
		return 0;
	}
	else {
		return (josephus(n-1,k)+k)%n;
	}
}

int main() {
	cout<<josephus(12,2);//n=12, k=2, are just sample inputs.
						// n is the number of people, k is kth person to be removed from the circle 
}


