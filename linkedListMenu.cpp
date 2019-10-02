#include<iostream.h>
#include<process.h>
#include<conio.h>
struct Node
{
 int EmpNo;
 char EmpName[20];
 Node *link;
} *np,*temp;

class List
{
 Node *start,*rear;
 public:
  List()
  {
     start=NULL;
     rear=NULL;
  }
  void Insert_Beg();
  void Insert_End();
  void Delete();
  void Display();
};

void List :: Insert_End()
{
   np=new Node;
   if(np==NULL)
    {  cout<<"\n Memory Overflow";
       getch();
       exit(0);
    }
    cout<<"Enter the EmpNo and EmpName to be inserted";
    cin>>np->EmpNo;
    cin>>np->EmpName;
    np->link=NULL;
    if(start==NULL)
     {
      start=np;
      rear=np;
     }
    else
     { rear->link=np;
       rear=np;
     }
 }
void List :: Insert_Beg()
{
   np=new Node;
   if(np==NULL)
    {  cout<<"\n Memory Overflow";
       getch();
       exit(0);
    }
    cout<<"Enter the EmpNo and EmpName to be inserted";
    cin>>np->EmpNo;
    cin>>np->EmpName;
    np->link=NULL;
    if(start==NULL)
     {
      start=np;
      rear=np;
     }
    else
     { np->link=np;
       start=np;
     }
 }

 void List::Delete()
 {if(start==NULL)
   {
      cout<<"\nUnderflow";
      getch();
       exit(0);
   }
   temp=start;
   start=start->link;
   cout<<"The deleted element = "<<temp->EmpNo<<" "<<temp->EmpName;
   delete temp;}
void List::Display()
 { if (start==NULL)
   {
     cout<<"\nUnderflow";
     getch();
     exit(0);
    }
    cout<<" \n START";
    temp=start;
    while(temp!=NULL)
    {
      cout<<"<-"<<temp->EmpNo<<" "<<temp->EmpName;
      temp=temp->link;
    }
    cout<<"<-Rear";}
 void main()
 {int choice;
   clrscr();
   List L;
   do
   {  clrscr();
      cout<<"IMPLEMENTATION OF LINKED LIST\n=============================\n";
      cout<<"\nM A I N  M E N U \n";
      cout<<"\n1----> Insert Node at the Beginning\n";
      cout<<"\n2----> Insert Node at the End\n";
      cout<<"\n3----> Delete a Node from the Beginning\n";
      cout<<"\n4----> Display all the Nodes \n";
      cout<<"\n5----> Exit\n\n";
      cout<<"Select your choice :";
      cin>>choice;
      cout<<"\n";
      switch(choice)
      {
       case 1: L.Insert_Beg();
	       break;
       case 2: L.Insert_End();
	       break;
       case 3: L.Delete();
	       break;
       case 4: L.Display();
      }
      cout<<"\n \n Press any key to continue ...";
      getch();
 }while(choice!=5);
}
