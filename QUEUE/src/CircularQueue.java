/*
public class CircularQueue {
	int[] queue= new int[5];
	int front=-1;
	int rear=-1;
	
	public void enQueue(int data)
	{
		if(front==-1 && rear==-1)
		{
			front=rear=0;
			queue[rear]=data;
		}
		else if((rear+1)%5==front)
		{
			System.out.println("Queue is full, OVERFULL!!");
		    return;
		}
		else
		{
			rear=(rear+1)%queue.length;
			queue[rear]=data;
		}
	}
	public void deQueue()
	{
		if(front==-1 && rear==-1)
		{
			System.out.println("Queue is empty, UNDERFLOW");
			return;
		}
		else if(front==rear)
		{
			front=rear=-1;
		}
		else
		{
			front=(front+1)%queue.length;
			
		}
	}
	public void front()
	{
		if(front==-1 && rear==-1)
		{
			System.out.println("Queue is empty");
			return;
		}
		else
		{
			System.out.println("Front element is: "+queue[front]);
		}
	}
	public void show()

	{
		if(front==-1 && rear==-1)
		{
			System.out.println("Queue is empty");
		}
		else
		{
		int i=front;
			while(i!=rear)
			{
				System.out.print(queue[i]+" ");
				i=(i+1)%queue.length;
			}
			System.out.println(queue[rear]);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
       CircularQueue q=new CircularQueue();
       q.enQueue(1);
       q.enQueue(2);
       q.enQueue(3);
       q.front();
       q.enQueue(4);
       q.enQueue(5);
       //q.enQueue(1);// overflow
       q.deQueue();
       q.front();
       q.deQueue();
       q.deQueue();
       q.deQueue();
       q.deQueue(); 
       q.enQueue(4);
       q.show();
       
	}

}*/
// QUEUE USING TWO STACK
import java.io.*;
import java.util.*;

public class Solution {
    int[] s1=new int[100];
        int[] s2=new int[100];
        int top1,top2=-1;
        int count=0;
    public void push1(int data)
    {
        if(top1==s1.length-1)
        {
            return;
        }
        else
        {
            top1++;
            s1[top1]=data;
        }
    }
     public void push2(int data)
    {
        if(top2==s2.length-1)
        {
            return;
        }
        else
        {
            top2++;
            s2[top2]=data;
        }
    }
    public int pop1()
    {
        return s1[top1--];
        
    }
     public int pop2()
    {
        return s2[top2--];
    
    }
    public void enQueue(int x)
    {
        push1(x);
        count++;
    }
    public void deQueue()
    {
        if(top1==-1 && top2==1-1)
        {
            return;
        }
        else
        {
        for(int i=0;i<count;i++)
        {
            int r=pop1();
            push2(r);
        }
       
        //System.out.println("poped in s2 is "+pop2());
        count--;
        for(int j=0;j<count;j++)
        {
            int t=pop2();
            push1(t);
        }
        }
    }
    public void display()
    {
        
       if(top1==-1 && top2==1-1)
        {
            return;
        }
        else
        {
        for(int i=0;i<count;i++)
        {
            int r=pop1();
            push2(r);
        }
       
        System.out.println(s2[top2]);
        //count--;
        for(int j=0;j<count;j++)
        {
            int t=pop2();
            push1(t);
        }
        }
    }
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Solution obj=new Solution();
        Scanner s=new Scanner(System.in);
        
        int n=s.nextInt();
        while(n-->0)
        {
            int a=s.nextInt();
            if(a==1)
            {
                int b=s.nextInt();
             obj.enQueue(b);
            }
            if(a==2)
            {
              obj.deQueue();
            }    
            if(a==3)
            {
                obj.display();
            }  
        }
    }
}
/*
 10
1 42
2
1 14
3
1 28
3
1 60
1 78
2
2
 */

