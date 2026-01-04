//Singly Circular

class node
{
    int data;
    public node next;

    public node(int no)
    {
        this.data = no;
        this.next = null;
    }
}

class SinglyCL
{
    private node first;
    private node last;
    private int iCount;

    public SinglyCL()
    {
        System.out.println("Object of SinglyLL gets created");
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
            first = newn;
        }

        last.next = first;

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
            last = newn;
        }

        last.next = first;

        iCount++;
    }

    public void DeleteFirst()
    {
        if((first == null) && (last == null))
        {
            return;
        }

        else if(first==last)
        {
            first = null;
            last = null;
        }

        else
        {
            first = first.next;
            last.next = first;
        }

        System.gc();

        iCount--;
    }

    public void DeleteLast()
    {
        node temp = null;
        if((first == null) && (last == null))
        {
            return;
        }

        else if(first==last)
        {
            first = null;
            last = null;
        }

        else
        {
            temp = first;

            while(temp.next != last)
            {
                temp = temp.next;
            }
            last = temp;
            last.next = first;   
        }

        System.gc();

        iCount--;
    }

    public void Display()
    {
        node temp = null;

        temp = first;
        do
        {
            System.out.print("| "+temp.data+" | -> ");
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
        node temp = null;
        node newn = null;
        int iCnt = 0;
        if((pos<1) || (pos>iCount + 1))
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
            temp.next = newn;

            iCount++;
        }
    }

    public void DeleteAtPos(int pos)
    {
        node temp = null;
        int iCnt = 0;
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
            System.gc();
            iCount--;
        }
    }


}

class program447
{
    public static void main(String A[])
    {
        SinglyCL obj = null;

        obj = new SinglyCL();

        int iRet=0;


        obj.InsertFirst(51);
        obj.InsertFirst(21);
        obj.InsertFirst(11);

        obj.Display();

        iRet = obj.Count();

        System.out.println("Number of nodes are : "+iRet);

        obj.InsertLast(101);
        obj.InsertLast(111);
        obj.InsertLast(121);

        obj.Display();

        iRet = obj.Count();

        System.out.println("Number of nodes are : "+iRet);

        obj.DeleteFirst();
        obj.Display();

        iRet = obj.Count();

        System.out.println("Number of nodes are : "+iRet);

        obj.DeleteLast();
        obj.Display();

        iRet = obj.Count();

        System.out.println("Number of nodes are : "+iRet);

        obj.InsertAtPos(105, 4);
        obj.Display();

        iRet = obj.Count();

        System.out.println("Number of nodes are : "+iRet);

        obj.DeleteAtPos(4);
        obj.Display();

        iRet = obj.Count();

        System.out.println("Number of nodes are : "+iRet);


        //Important for memory deallocation
        obj = null;
        System.gc();
    
    }
}