package practice;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class TreeMapExample {
    public static void main(String[] args)
    {
        TreeMap treeMap=new TreeMap();
        treeMap.put(1,"xyz");
        treeMap.put(5,"def");
        treeMap.put(2,"cva");
        System.out.println(treeMap);
        compareArrayList();
    }
    //compare two array list
    static void compareArrayList()
    {
        List<String> list1 = new ArrayList<String>();
        list1.add("Hi");
        list1.add("How are you");
        list1.add("Good Morning");
        list1.add("bye");
        list1.add("Good night");
        List<String> list2 = new ArrayList<String>();
        list2.add("Howdy");
        list2.add("Good Evening");
        list2.add("bye");
        list2.add("Good night");
        List<String> list3 = new ArrayList<String>();
        for(String temp : list1)
        {
            list3.add(list2.contains(temp)?"Yes" :"No");
        }
        System.out.println(list3);

    }
}
