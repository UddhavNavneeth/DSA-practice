using namespace std;
#include<cstddef>
#include <bits/stdc++.h> 
#include<math.h>

class Node
{
	public:
		float data;
		Node *next;
};

Node* newNode(int data) {
	Node* temp = new Node();
	temp->data=data;
	temp->next=NULL;
}

void display(Node* head)
	{
		cout << head->data << endl;
		if (head->next == NULL) 
		{
			return;
		}
		display(head->next);
	}

void deleteNode(Node* head, int x)
{
	cout<<"deleting node: "<<x<<endl;
	if (x==1) 
	{
		head=head->next;
		display(head);
	}
	else 
	{
		int c=1;
		Node* tmp4;
		Node* tmp5;
		tmp4 = head;
		while(c!=x)
		{
			tmp5 = tmp4;
			tmp4 = tmp4->next;		
			c++;
		}
		tmp5->next = tmp4->next;
		display(head);	
	}	
	
}

void sqrtpos(Node* head)
{
	int c=0;
	Node* tmp;
	tmp = head;
	while(tmp != NULL)
	{
		c++;
		tmp = tmp->next;
	}
	int pos = floor(sqrt(c));
	
	int c2 = 1;
	tmp = head;
	while(c2 != pos)
	{
		c2++;
		tmp = tmp->next;
	}
	cout<<"SQRTPOS is: "<<tmp->data<<endl;
} 

void findmid(Node* head) 
{
	cout<<"-----"<<endl;
	Node* fastptr;
	Node* slowptr;
	fastptr = head;
	slowptr = head;
	if (head != NULL)
	{
		while(fastptr != NULL and fastptr->next != NULL)
		{
			cout<<fastptr->data<<" "<<slowptr->data<<endl;
			fastptr=fastptr->next->next;
			slowptr=slowptr->next;
		}
		cout<<"\n"<<"The middle entry is "<<slowptr->data<<endl;
	}
	
}

void findmid2(Node* head)
{
	Node* tmp;
	Node* mid;
	mid = head;
	tmp = head;
	int c = 0;
	while (tmp != NULL)
	{
		if (c%2 != 0)
		{
			mid = mid->next;
		}
		c++;
		tmp = tmp->next;
	}
	cout<<"--Mid is--"<<mid->data<<endl;
}

void swap2values(Node* head, int x, int y)
{
	cout<<endl<<endl<<"---"<<endl;
	Node* tmp;
	Node* tmp2;
	tmp2 = head;
	tmp = head;
	while (tmp != NULL)
	{
		if (tmp->data == x)
		{
			while (tmp2 != NULL)
			{
				if (tmp2->data == y)
				{
					tmp2->data = x;
					tmp->data = y;
				}
				tmp2 = tmp2->next;
			}
		}
		tmp = tmp->next;
	}
	display(head);
}

int main()
{
//	Node* head = NULL;
//	Node* second = NULL;
//	Node* third = NULL;
//	Node* fourth = NULL;
	
	Node* head = newNode(1);
	Node* second = newNode(2);
	Node* third = newNode(3);
	Node* fourth = newNode(4);
	
//	head->data = 1;
	head->next = second;
	
//	second->data = 2;
	second->next = third;
	
//	third->data = 3;
	third->next = fourth;
	
//	fourth->data = 4;
	fourth->next = NULL;
	
//	Node* tmp;
//	tmp = head;
//	
//	do
//	{
//		cout << tmp->data << endl;
//		tmp=tmp->next;
//		
//	}while(tmp != NULL);

	display(head);
	
	cout<<"Adding new node"<<endl;
	
	Node* end = NULL;
	end = new Node();
	end->data = 5;
	end->next = NULL;
	
	Node* tmp3;
	tmp3 = head;
//	int c=0;
	
	while(tmp3!=NULL)
	{
//		cout<<tmp3->data<<endl;
//		c++;
		if(tmp3->next == NULL) {
			tmp3->next = end;
			break;
		}
		tmp3=tmp3->next;
	}

//	Node* tmp2;
//	tmp2 = head;
//	
//	do
//	{
//		cout << tmp2->data << endl;
//		tmp2=tmp2->next;
//		
//	}while(tmp2 != NULL);

	display(head);
	
//	sqrtpos(head);
//	
//	findmid(head);
//	
//	findmid2(head);
	
//	deleteNode(head, 4);

	swap2values(head, 1, 5);
	
	return 0;
}
