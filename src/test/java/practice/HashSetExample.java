package practice;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetExample {
    public static void main(String args[])
    {
        Set<String> set = new HashSet<String>();
        set.add("Khushboo");
        set.add("aakash");
        set.add("abc");
        set.add("xyx");
        set.add("Khushboo");
        System.out.println(set);
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext())
        {
            String next = iterator.next();
            if(next.contains("Khushboo"))
            {
                System.out.println("passed");
            }

        }
    }
}
