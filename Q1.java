package Collections;
// Write Java code to define List . Insert 5 floating point numbers in List, and using an iterator,
// find the sum of the numbers in List.
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Q1
{
    static  float total;
    public static void main(String[] args)
    {
        System.out.println("enter 5 numbers");
        Scanner  sc = new Scanner(System.in);
        List<Float> list = new LinkedList<>();
        for (int i=0;i<5;i++)
        {
            list.add(sc.nextFloat());

        }
        Iterator<Float> iterator = list.iterator();
        while (iterator.hasNext())
        {
            total+=iterator.next();
        }
        System.out.println("Sum of the numbers is the list is "+total);
    }
}