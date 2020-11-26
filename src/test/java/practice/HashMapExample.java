package practice;

import java.util.*;

public class HashMapExample {
    public static void main(String[] args)
    {
        Map<String,String> map = new HashMap<String, String>();
        map.put("comp1","abc");
        map.put("comp1","def");
        map.put("comp2", "efg");
        map.put("comp4","xyz");
        map.put("comp3","dghi");
        System.out.println(map);
        Set<Map.Entry<String, String>> entries = map.entrySet();
        Iterator<Map.Entry<String, String>> iterator = entries.iterator();
        while (iterator.hasNext())
        {
            Map.Entry<String, String> next = iterator.next();
            System.out.println(next.getKey());
            System.out.println(next.getValue());

        }


        Set<String> strings = map.keySet();
        for(String key: strings)
        {
            System.out.println(key);
        }
        Collection<String> values = map.values();
        for(String value: values)
        {
            System.out.println(value);
        }



    }

}
