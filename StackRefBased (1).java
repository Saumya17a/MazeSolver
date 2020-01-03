public class StackRefBased<T> implements Stack<T> {
    StackNode<T> top;
    int size;
    public StackRefBased() 
    {
        top=null;
        size=0;

    }

    public int size() {
        return size;
    }


    public boolean isEmpty() 
    {
        if(top==null)
        {
            return true;
        }
        else{
            return false;
        }
    }


    public void push(T data) {
        StackNode<T> n = new StackNode<T>(data);
        if(top!=null)
        {
            n.next= top;
            top= n;
        }
        else
        {
            top = n;
        }
        size++;
    }


    public T pop() throws StackEmptyException {
        
		if(top != null)
		{
            StackNode<T> tmp = top;
            top = top.next;
            size--;
            return (tmp.getValue());
        }
		else
		{
            throw new StackEmptyException();
            
		}
    }


    public T peek() throws StackEmptyException {
        if(top != null)
		{
			return top.getValue();
		}
		else
		{
			throw new StackEmptyException();		
		}	
    }

    //removes the top reference thus, there is no more contact with linked list
    public void makeEmpty() {
        top =null;
        size=0;
    }


    public String toString() {
        
        String toS = "";
        StackNode<T> tmp = top;
        if(tmp!= null)
        {
            toS=top.toString()+ toS;
            tmp=tmp.next;
        }
        while(tmp!= null)
        {
            
                toS= tmp.toString()+" "+toS ;
              
            
            tmp=tmp.next;
        }
        return toS;
    }
    
}

