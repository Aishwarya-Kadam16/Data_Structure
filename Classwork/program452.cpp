//Doubly Circular

#include<iostream>
using namespace std;

struct node
{
    int data;
    struct node *next;
    struct node *prev;
};

typedef struct node NODE;
typedef struct node* PNODE;

class DoublyCL
{
    private:
        PNODE first;
        PNODE last;
        int iCount;

    public:
        DoublyCL()
        {
            first = NULL;
            last = NULL;
            iCount = 0;
        }    

        void InsertFirst(int no)
        {
            PNODE newn = NULL;
            newn = new NODE;

            newn -> data = no;
            newn -> next = NULL;
            newn -> prev = NULL;

            if((first == NULL) && (last == NULL))
            {
                first = newn;
                last = newn;
            }

            else
            {
                newn -> next = first;
                first -> prev = newn;
                first = newn;
            }
            (last) -> next = first;
            (first) -> prev = last;

            iCount++;
        }

        void InsertLast(int no)
        {
            PNODE newn = NULL;
            newn = new NODE;

            newn -> data = no;
            newn -> next = NULL;
            newn -> prev = NULL;

            if((first == NULL) && (last == NULL))
            {
                first = newn;
                last = newn;
            }

            else
            {
                last -> next = newn;
                newn -> prev = last;
                last = newn;
            }
            (last) -> next = first;
            (first) -> prev = last;

            iCount++;
        }

        void DeleteFirst()
        {
            if((first == NULL) && (last == NULL))
            {
                return;
            }

            else if(first == last)
            {
                delete first;
                first = NULL;
                last = NULL;
            }

            else
            {
                first = first -> next;
                delete first -> prev;
                last -> next = first;
                first -> prev = last;
            }

            iCount--;
        }

        void DeleteLast()
        {
            if((first == NULL) && (last == NULL))
            {
                return;
            }

            else if(first == last)
            {
                delete first;
                first = NULL;
                last = NULL;
            }

            else
            {
                last = last -> prev;
                delete last -> next;
                last -> next = first;
                first -> prev = last;
            }

            iCount--;
        }

        void Display()
        {
            if((first == NULL) && (last == NULL))
            {
                cout<<"Linked List is Empty\n";
                return;
            }

            PNODE temp = NULL;

            cout<<"<=> ";

            temp = first;
            do
            {
                cout<<"| "<<temp->data<<" | <=>";
                temp = temp -> next;
            } while (temp != last->next);
            cout<<"\n";
        }

        int Count()
        {
            return iCount;
        }

        void InsertAtPos(int no,int pos)
        {
            int iCnt = 0;
            PNODE temp = NULL;
            PNODE newn = NULL;
            if((pos<1) || (pos>iCount + 1))
            {
                cout<<"Invalid Position\n";
                return;
            }

            if(pos == 1)
            {
                InsertFirst(no);
            }

            else if(pos == iCount + 1)
            {
                InsertLast(no);
            }

            else
            {
                newn = new NODE;

                newn -> data = no;
                newn -> next = NULL;
                newn -> prev = NULL;
                temp = first;

                for(iCnt = 1; iCnt<pos-1;iCnt++)
                {
                    temp = temp -> next;
                }
                newn -> next = temp -> next;
                newn -> next -> prev = newn;
                temp -> next = newn;
                newn -> prev = temp;

                iCount++;
            }
        }

        void DeleteAtPos(int pos)
        {
            int iCnt = 0;
            PNODE temp = NULL;
            if((pos<1) || (pos>iCount))
            {
                cout<<"Invalid Position\n";
                return;
            }

            if(pos == 1)
            {
                DeleteFirst();
            }

            else if(pos == iCount)
            {
                DeleteLast();
            }

            else
            {
                temp = first;

                for(iCnt = 1; iCnt<pos-1;iCnt++)
                {
                    temp = temp -> next;
                }
                temp -> next = temp -> next -> next;
                delete temp -> next -> prev;
                temp -> next -> prev = temp;

                iCount--;
            }
        }

};
int main()
{
    DoublyCL obj;
    int iRet = 0;

    obj.InsertFirst(51);
    obj.InsertFirst(21);
    obj.InsertFirst(11);

    obj.Display();
    iRet = obj.Count();
    cout<<"Number of Nodes are : "<<iRet<<"\n";

    obj.InsertLast(101);
    obj.InsertLast(111);
    obj.InsertLast(121);

    obj.Display();
    iRet = obj.Count();
    cout<<"Number of Nodes are : "<<iRet<<"\n";

    obj.DeleteFirst();

    obj.Display();
    iRet = obj.Count();
    cout<<"Number of Nodes are : "<<iRet<<"\n";

    obj.DeleteLast();

    obj.Display();
    iRet = obj.Count();
    cout<<"Number of Nodes are : "<<iRet<<"\n";

    obj.InsertAtPos(105 , 4);

    obj.Display();
    iRet = obj.Count();
    cout<<"Number of Nodes are : "<<iRet<<"\n";

    obj.DeleteAtPos(4);

    obj.Display();
    iRet = obj.Count();
    cout<<"Number of Nodes are : "<<iRet<<"\n";

    return 0;
}