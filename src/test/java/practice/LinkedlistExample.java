package practice;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class LinkedlistExample {
    public static void main(String args[])
    {
        List<String> list = new LinkedList<String>();
        list.add("Khushboo");
        list.add("yadav");
        list.add("Ram");
        System.out.println(list);
        list.add(1,"hi");
        System.out.println(list);
        ListIterator<String> iterator =list.listIterator(list.size());
        while ((iterator.hasPrevious()))
        {
            String str= iterator.previous();
            System.out.println(str);
        }
    }
}
