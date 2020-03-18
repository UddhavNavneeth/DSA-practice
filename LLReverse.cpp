#include<bits/stdc++.h>

using namespace std;

class Node {
	public:
	int data;
	Node* next;
};

Node *head = NULL;
Node *tail = NULL;

vector<Node*> nodes;

void insertVal(int data){
	Node *temp = new Node;
	temp->data = data;
	temp->next = NULL;
	if(head == NULL) {
		head = temp;
		tail = temp;
		cout << "Inserted " << head->data << endl;
	}
	else{
		tail->next = temp;
		tail = temp;
		cout << "Inserted " << temp->data << endl;
	}
	return;
}

void displayRecursive(Node *temp){
	if(head == NULL){
		return;
	}
	else{
		cout << temp->data << endl;
		displayRecursive(temp->next);
	}
}

void displayList(){
	Node *temp = new Node;
	temp = head;
	while(temp != NULL){
		cout << temp->data << " ";
		temp = temp->next;
	}
}


void reverse(){
	Node *temp = new Node;
	temp = head;
	while(temp != tail){
		nodes.push_back(temp);
		temp = temp->next;
	}
	nodes.push_back(temp);
	head = tail;
	temp = head;
	temp->next = NULL;
	//cout << nodes.size() << endl;
	for(int i = nodes.size() - 1; i >= 0; i--){
		temp->next = nodes[i];
		temp = temp->next;
		temp->next = NULL;
	}
	cout << endl;
}

int main(){
	insertVal(1);
	insertVal(2);
	insertVal(3);
	insertVal(4);
	insertVal(5);
	//displayList();
	//curr = head;
	reverse();
	displayRecursive(head);
}