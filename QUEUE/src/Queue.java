
public class Queue {
	
    int[] queue=new int[5];
	int size;
	int front=-1;// set front and rear as-1, there is no element in queue
	int rear=-1;
	public void enQueue(int data)
	{
		if( rear== queue.length-1)
		{
			System.out.println("Queue is fulll, OVERFLOW!!");
			return;
		}
		else if(rear == -1 && front == -1)
		{
			front=rear=0;
			queue[rear]=data;		
		}
		else
		{
			rear++;
			queue[rear]=data;		
		}
	}
	
	
	public void deQueue()
	{
		if(front==-1 && rear==-1)
		{
			System.out.println("Queue is empty,UNDERFLOW!!");
			return;
		}
		else if(front==rear)
		{
			front=rear=-1;
		}
		else
		{
			front++;
		}
	}
	public void front()
	{
		if(front==-1 && rear==-1)
		{
			System.out.println("There is no element the Queue ");
			return;
		}
		else
		{
			System.out.println("Front element is:"+queue[front]);
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
			for(int i=front;i<=rear;i++)
			{
				System.out.print(queue[i]+" ");
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
          Queue q= new Queue();
          q.enQueue(1);
          q.enQueue(2);
       //front();
          q.enQueue(3);
          q.enQueue(4);
          q.enQueue(5);
         // q.enQueue(6);// full
         q.deQueue();
     //    q.front();
         q.deQueue();
         q.deQueue();
         q.deQueue();
        // q.front();
         q.deQueue();
         q.front();
         //q.deQueue();//underflow
         q.show();
	}

}
