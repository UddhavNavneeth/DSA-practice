using namespace std;
#include<iostream>
#include<stack>

//#define ARRAY_SIZE 10
//stack<int> s;

//class Stack {
//	
//	private:
//		int top=-1;
//		int num[ARRAY_SIZE];
//	public:
//		int push(int);
//		int pop();
//		int display();
//	
//};
//
//int Stack::push(int n) {
//	if (top == 9) {
//		return 0;
//	}
//	top++;
//	num[top] = n;
//	return n;
//}
//
//int Stack::pop() {
//	if (top == -1) {
//		return 0;
//	}
//	top--;
//	return num[top+1];
//}
//
//int Stack::display() {
//	for (int i=0; i<10; i++) {
//		cout<<num[i]<<endl;
//	}
//}

int main() {
//	Stack s;
//	s.push(1);
//	s.push(2);
//	s.display();
	stack<int> s;
	s.push(1);
	s.push(2);
	cout<<s.top();
	
}
