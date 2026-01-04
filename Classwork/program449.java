//Doubly Circular

class node
{
    int data;
    public node next;
    public node prev;

    public node(int no)
    {
        this.data = no;
        this.next = null;
        this.prev = null;
    }
}

class DoublyCL
{
    private node first;
    private node last;
    private int iCount;

    public DoublyCL()
    {
        System.out.println("Object of DoublyCL  gets created");
        first = null;
        last = null;
        iCount = 0;
    }

    public void InsertFirst(int no)
    {
        node newn = null;
        newn = new node(no);

        if((first == null) && (last == null))
        {
            first = newn;
            last = newn;
        }

        else
        {
            newn.next = first;
            first.prev = newn;
            first = newn;
        }
        last.next = first;
        first.prev = last;

        iCount++;
    }

    public void InsertLast(int no)
    {
        node newn = null;
        newn = new node(no);

        if((first == null) && (last == null))
        {
            first = newn;
            last = newn;
        }

        else
        {
            last.next = newn;
            newn.prev =last;
            last = newn;
        }
        last.next = first;
        first.prev = last;

        iCount++;
    }

    public void DeleteFirst()
    {
        if((first==null)&&(last==null))
        {
            return;
        }

        else if(first == last)
        {
            first = null;
            last = null;
        }

        else
        {
            first = first.next;
            last.next = first;
            first.prev = last;
        }

        System.gc();

        iCount--;
    }

    public void DeleteLast()
    {
        if((first==null)&&(last==null))
        {
            return;
        }

        else if(first == last)
        {
            first = null;
            last = null;
        }

        else
        {
            last = last.prev;
            last.next = first;
            first.prev = last;
        }

        System.gc();

        iCount--;
    }

    public void Display()
    {
        if((first == null)&& (last == null))
        {
            System.out.println("Linked List is Empty");
            return;
        }

        node temp = null;
        temp = first;

        System.out.print("<=> ");
        do
        {
            System.out.print("| "+temp.data+" | <=>");
            temp = temp.next;
        }while(temp != last.next);
        System.out.println("");
    }

    public int Count()
    {
        return iCount;
    }

    public void InsertAtPos(int no , int pos)
    {
        int iCnt = 0;
        node newn = null;
        node temp = null;
        if((pos<1) || (pos>iCount+1))
        {
            System.out.println("Invalid Position");
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
            newn = new node(no);
            temp = first;

            for(iCnt = 1; iCnt<pos-1;iCnt++)
            {
                temp = temp.next;
            }
            newn.next = temp.next;
            newn.next.prev = newn;
            temp.next = newn;
            newn.prev = temp;

            iCount++;

        }
    }

    public void DeleteAtPos(int pos)
    {
        int iCnt = 0;
        node temp = null;
        if((pos<1) || (pos>iCount))
        {
            System.out.println("Invalid Position");
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
                temp = temp.next;
            }
            temp.next = temp.next.next;
            temp.next.prev = temp;

            System.gc();

            iCount--;
        }
    }
}

class program449
{
    public static void main(String A[])
    {
        DoublyCL obj = null;
        obj = new DoublyCL();
        int iRet = 0;

        obj.InsertFirst(51);
        obj.InsertFirst(21);
        obj.InsertFirst(11);

        obj.Display();
        iRet = obj.Count();
        System.out.println("Number of Nodes are : "+iRet);

        obj.InsertLast(101);
        obj.InsertLast(111);
        obj.InsertLast(121);

        obj.Display();
        iRet = obj.Count();
        System.out.println("Number of Nodes are : "+iRet);

        obj.DeleteFirst();

        obj.Display();
        iRet = obj.Count();
        System.out.println("Number of Nodes are : "+iRet);

        obj.DeleteLast();

        obj.Display();
        iRet = obj.Count();
        System.out.println("Number of Nodes are : "+iRet);

        obj.InsertAtPos(105, 4);

        obj.Display();
        iRet = obj.Count();
        System.out.println("Number of Nodes are : "+iRet);

        obj.DeleteAtPos(4);

        obj.Display();
        iRet = obj.Count();
        System.out.println("Number of Nodes are : "+iRet);

        obj = null;
        System.gc();

    }
}