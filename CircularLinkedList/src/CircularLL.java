
public class CircularLL {
	public ListNode last;
	public int length;
	public class ListNode
	{
		ListNode next;
		int data;
		public ListNode(int data)
		{
			this.data=data;
		}
	}
	public  CircularLL()
	{
		last=null;
		length=0;
	}
	public int lengthCLL()
	{
		return length;
	}
	public boolean isEmpty()
	{
		return length==0;
	}
	public void circularLinkedList()
	{
		ListNode first=new ListNode(1);
		ListNode second=new ListNode(2);
		ListNode third=new ListNode(3);
		ListNode fourth=new ListNode(4);
		first.next=second;
		second.next=third;
		third.next=fourth;
		fourth.next=first;
		
		last=fourth;
	}
	public void insertCLL(int data)
	{
		ListNode newNode=new ListNode(data);
		if(length==0)
		{
			last=newNode;
			last.next=newNode;
		}
		else
		{
			newNode.next=last.next;
			last.next=newNode;
			last=newNode;
		}
		length++;
	}
	public void insertAtBeginning(int data)
	{
		ListNode newNode=new ListNode(data);
		if (length==0)
		{
			last=newNode;
		}
		else
		{
			newNode.next=last.next;
		}
		last.next=newNode;
		length++;
	}
	public void insertAtLast(int data)
	{
		ListNode newNode =new ListNode(data);
		if(length==0)
		{
			last=newNode;
			last.next=newNode;
		}
		else
		{
			newNode.next=last.next;
			last.next=newNode;
			last=newNode;
		}
		length++;
	}
	public void deleteAtBegining()
	{
		if(length==0)
		{
			System.out.println("CLL is empty cant be deleted");
		}
		if(length==1)
		{
			last=null;
			length--;
		}
		else
		{
			last.next=last.next.next;
			length--;
		}
	}
	public void deletAtBeginingII() 
	{
		if(isEmpty())
		{
			System.out.println("CLL is empty cant be deleted");
		}
		ListNode temp=last.next;
		if(last.next==last)
		{
			last=null;
		}
		else
		{
			last.next=temp.next;
		}
		temp.next=null;
		length--;
	}
	public void deletAtLast()
	{

		if(isEmpty())
		{
			System.out.println("CLL is empty cant be deleted");
		}
		
		if(last.next==last)
		{
			last=null;
			
		}
		else
		{
			ListNode temp=last.next;
			ListNode head=last.next;
			while(temp.next!=last)
			{
				temp=temp.next;
			}
			last.next=null;
			temp.next=head;
			last=temp;	
		}
		length--;
	}
	public void deletAtGivenPosition(int position)
	{
		if(position==1)
		{
			last.next=last.next.next;;
		}
		
		else if(position==length)
		{
			deletAtLast();
		}
		else
		{
			ListNode temp=last.next;
			int count=1;
			System.out.println("Lenght"+ length);
			while(count<position-1)
			{
				temp=temp.next;
				count++;
			}
			System.out.println("count"+count);
			ListNode curr=temp.next;
			temp.next=curr.next;
			curr.next=null;
		}
		length--;
	}
	public void showLL()
	{
		
		if(last==null)
		{
			System.out.println("null");
			return;
		}
		ListNode first=last.next;
		while(first!=last)
		{
			System.out.print(first.data+"->");
			first=first.next;
		}
		System.out.println(first.data);
	}

	public static void main(String[] args) {
		CircularLL obj=new CircularLL();
		obj.showLL();
	    //obj.circularLinkedList();
		//obj.showLL();
		
		//obj.insertCLL(1);
		//obj.insertCLL(2);
		//obj.showLL();
		
		//obj.insertAtBeginning(1);
		//obj.insertAtBeginning(2);
		//obj.insertAtBeginning(3);
		//obj.showLL();
		
		//obj.insertAtLast(5);
		//obj.insertAtLast(6);
		//obj.insertAtBeginning(1);
		//obj.showLL();
		
		//obj.insertAtLast(1);
		//obj.insertAtLast(2);
		//obj.insertAtBeginning(3);
		//obj.showLL();
		//obj.deleteAtBegining();
		//obj.showLL();
		
		//obj.insertAtLast(1);
		//obj.insertAtLast(2);
		//obj.showLL();
		//obj.deletAtBeginingII();
		//obj.showLL();
		 
		//obj.insertCLL(1);
	    //obj.insertCLL(2);
		//obj.insertCLL(3);
		//obj.showLL();
		//obj.deletAtLast();
		//obj.showLL();
		
		/*obj.insertCLL(1);
		obj.insertCLL(2);
		obj.insertCLL(3);
		obj.insertCLL(4);
		obj.showLL();
		obj.deletAtGivenPosition(4);
		obj.showLL();*/

	}


}
