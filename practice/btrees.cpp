#include<iostream>
using namespace std;

class node {
	public:
		int data;
		node *right;
		node *left;
};

class node* newNode(int n) {
	node* temp = new node;
	temp->data=n;
	temp->left = temp->right = NULL;
	return temp;
}

void inorder(node *temp) {
	if (!temp) {
		return;
	}
	
	inorder(temp->left);
	cout<<" "<<temp->data<<" ";
	inorder(temp->right);
}



int main() {
	node* root = newNode(10);
	root->left = newNode(7);
	root->right = newNode(13);

	inorder(root);	
//	one.right = three;
	return 0;
}
