package practice;

import java.util.Set;
import java.util.TreeSet;

public class TreeSetExample {
    public static void main(String args[])
    {
        Set<Integer> set = new TreeSet<Integer>();
        set.add(5);
        set.add(1);
        set.add(2);
        set.add(6);
        System.out.println(set);
    }
}
