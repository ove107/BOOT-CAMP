package Collections;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

    class MinStack<T>
    {
        List<T> stackList;
        List<T> stackList2;
        int size;
        int top;
        MinStack(int size)
        {
            this.size=size;
            this.top=-1;
            stackList=new ArrayList<T>(size);
            stackList2=new ArrayList<T>(size);
        }
        public int push(T obj) throws ArrayIndexOutOfBoundsException
        {
            if(top==size-1)
                throw new ArrayIndexOutOfBoundsException("Overflow");
            else {
                if(top==-1)
                {
                    //first element here
                    stackList.add(obj);
                    stackList2.add(obj);
                }
                else {
                    stackList.add(obj);
                    if(obj instanceof String){
                        if(obj.toString().compareTo(stackList.get(top).toString())<0)//greater than
                            stackList2.add(obj);
                        else
                            stackList2.add(stackList.get(top));
                    }
                    else {
                        if((obj.toString().compareTo(stackList2.get(top).toString())<0))//greater than
                        {
                            stackList2.add(obj);
                        } else
                            stackList2.add(stackList.get(top));
                    }


                }
                return  ++top;
                //returns length
            }
        }
        public T pop()
        {

            T obj;
            if(top==-1)
                throw new ArrayIndexOutOfBoundsException("Underflow");
            else{
                stackList2.remove(top);
                obj=stackList.remove(top);
                top--;
            }
            return obj;
        }
        public boolean isEmpty()
        {
            if(top<0)
                return true;
            else
                return false;
        }
        public boolean isFull()
        {
            if(top==size)
                return true;
            else
                return false;
        }
        public T getMin() throws ArrayIndexOutOfBoundsException
        {
            if(isEmpty())
                throw new ArrayIndexOutOfBoundsException("underflow");
            else
                return stackList2.get(top);
        }
        public void show()
        {
            System.out.println("");
            for(int i=top;i>=0;i--)
                System.out.println("Stack: "+stackList.get(i)+" Aux: "+stackList2.get(i));
        }

    }
    public class Que8 {
        static BufferedReader br;
        // static  MinStack<Integer> minStack;
        static <T> void  menu(MinStack minStack) throws IOException {
            int i=0;
            do{
                System.out.println("Enter 1 to Push: ");
                System.out.println("Enter 2 to Pop: ");
                System.out.println("Enter 3 for isEmpty : ");
                System.out.println("Enter 4 for isFull: ");
                System.out.println("Enter 5 to getMin: ");
                System.out.println("Enter any to break: ");
                System.out.print("Enter value: ");
                i=Integer.parseInt(br.readLine());
                switch (i)
                {
                    case 1:
                        System.out.print("Enter value to push: ");
                        T o=(T)br.readLine();
                        System.out.println("Top is: "+minStack.push(o));
                        minStack.show();
                        break;
                    case 2:
                        System.out.println(minStack.pop().toString());
                        minStack.show();
                        break;
                    case 3:
                        System.out.println(minStack.isEmpty());
                        break;
                    case 4:
                        System.out.println(minStack.isFull());
                        break;
                    case 5:
                        System.out.println(minStack.getMin().toString());
                        break;
                    default:
                        i=9;
                        break;
                }

            }
            while (i!=9);
        }
        public static void main(String[] args) throws IOException {
            br=new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Enter size: ");
            MinStack<String> minStack=new MinStack<String>(Integer.parseInt(br.readLine()));
            menu(minStack);
        }
    }
