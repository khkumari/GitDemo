package practice;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LinkedHashMapExample {
    public static void main(String[] args)
    {
        HashMap<Integer, String> hashMap = new HashMap<>();
        hashMap.put(1,"abc");
        hashMap.put(3,"def");
        hashMap.put(2,"ghi");
        hashMap.put(4,"jkl");
//        System.out.println(hashMap.keySet());
        String st="Hi i am Khushboo Kumari";
        String st1="khushboo kumari";
        //System.out.println(st.toLowerCase().contains(st1.toLowerCase()));
        String paragraph = "Hi i am Khushboo Kumari! I have a list of words to match: dog, cat, leopard. But blackdog or catwoman shouldn't match. Dog may bark at the start! Is that meow at the end my cat? Some bonus sentence matches shouldn't hurt. My dog gets jumpy at times and behaves super excited!! My cat sees my goofy dog and thinks WTF?! Leopard likes to quote, \"I'm telling you these Lions suck bro!\" Sometimes the dog asks too, \"Cat got your tongue?!\"";
        Pattern p = Pattern.compile("(?i)(^|\\s+)(khushboo|kumari)(\\s+|[.?!]$)");
        Matcher m = p.matcher(paragraph);
        while (m.find()) {
            System.out.println(m.group());
        }
/*        Set<Map.Entry<Integer, String>> entries = hashMap.entrySet();
        Iterator<Map.Entry<Integer, String>> iterator = entries.iterator();
        while (iterator.hasNext())
        {
            Map.Entry<Integer, String> next = iterator.next();
            System.out.println(next.getKey() +"-----"+ next.getValue());

        }*/



    }
}
