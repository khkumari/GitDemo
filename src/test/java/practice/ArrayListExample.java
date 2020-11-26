package practice;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayListExample {
    public static void main(String[] args)
    {
/*        List<String> list = new ArrayList<String>();
        list.add("Khushboo");
        list.add("yadav");
        list.add("Ram");
        System.out.println(list);
        list.add(0,"hello");
        System.out.println(list);
        System.out.println(list.get(3));
        System.out.println(list.isEmpty());
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext())
        {
            System.out.println(iterator.next());
        }
        if(list.contains("Khushboo"))
        {
            System.out.println("true");
        }*/
        ArrayList list1 = new ArrayList();
        list1.add(35);
        list1.add("khushboo");
        for(Object o: list1)
        {
            if(o instanceof Integer)
            {
                System.out.println(o);
            }
            if(o instanceof  String)
            {
                System.out.println(o);
            }
        }


    }

}
