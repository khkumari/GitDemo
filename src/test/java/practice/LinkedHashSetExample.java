package practice;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class LinkedHashSetExample {
    public static void main(String args[])
    {
        Set<Integer> set= new LinkedHashSet<Integer>();
        int a=1;
        for(int i=0; i<9;i++)
        {
            set.add(a);
            a=a+1;
        }
        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext())
        {
            Integer next = iterator.next();
            System.out.println(next);

        }
        
    }
}
