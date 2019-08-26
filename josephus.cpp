#include<iostream>
using namespace std;

class Node {
	public:
		int data;
		Node* next;
};

Node* newNode(int data) {
	Node* temp = new Node();
	temp->data=data;
	temp->next=NULL;
	return temp;
}

void display(Node* temp) {
	while (temp!=NULL) {
		cout<<temp->data<<endl;
		temp=temp->next;
	}
}

int main() {
//	printf("%d", findLeader(8,2));
	Node* nextNode = NULL;
	for (int i=5; i>0; i--) {
		Node* temp = newNode(i);
		if (i=5) {
			temp->next=NULL;
		}
		else {
			nextNode = temp;
		}
		nextNode = temp;
		
	}
	display(nextNode);
}
