package stringOperation;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindString {
    public static void main(String[] args) {
/*        boolean output = findWord("QTP");
        System.out.println(output);
        System.out.println(replaceWordInString("Selenium", "QTP"));
        String str = "This is Testing done from Selenium";
        //remove space from string
        String str1 = str.replaceAll("\\s", "");
        System.out.println(str1);
        System.out.println(removeWordFromString(str, "done from Selenium"));
        System.out.println(findOccurenceOfWord("This is Testing is Testing", "Testing"));
        System.out.println(findAnyNumberInDynamicString("This 1 is Testing 123"));
        System.out.println(findAnyWordInString("This 1 is Testing 123"));
        String trim = "   This is Testing by me   ";
        String string =trim.trim();
        System.out.println(string);
        System.out.println(compareTwoString("This is Testing","This Testing"));
        System.out.println(countNumberOfWords("Testing is Testing"));
        System.out.println(countNumberOfCharacter(" Testing "));
        System.out.println(reverseString("Selenium"));
        System.out.println(reverseSubString("Selenium is testing"));
        System.out.println(findMaximumOccurring("Seleniumistestingii"));*/
        // System.out.println(removeDuplicateWord("testing Selenium is testing is hello"));
        //System.out.println(getRandomString(7));
        //System.out.println(getRandomInteger(4));
        System.out.println(countNumberOfWords("Testing is Testing"));
    }

    public static int getRandomInteger(int length) {

        int minimum = 0;
        int maximum = 0;

        StringBuilder min = new StringBuilder();
        StringBuilder max = new StringBuilder();

        min.append("1");
        for(int i =0; i < length-1 ; i++){
            min = min.append("0");
        }
        for(int i =0; i < length ; i++){
            max = max.append("9");
        }
        minimum = Integer.parseInt(min.toString());
        maximum = Integer.parseInt(max.toString());
        return ((int) (Math.random() * (maximum - minimum))) + minimum;
    }

    static String getRandomString(int n) {

        // chose a Character random from this String
        String randomString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "abcdefghijklmnopqrstuvxyz";

        // create StringBuffer size of AlphaNumericString
        StringBuilder sb = new StringBuilder(n);

        for (int i = 0; i < n; i++) {

            // generate a random number between
            // 0 to AlphaNumericString variable length
            int index
                    = (int) (randomString.length()
                    * Math.random());

            // add Character one by one in end of sb
            sb.append(randomString
                    .charAt(index));
        }

        return sb.toString();
    }




    static String removeDuplicateWord(String str) {
        String[] strWords = str.split(" ");
        int count = 0;
        HashMap<String, Integer> wordCountMap = new HashMap<String, Integer>();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < strWords.length; i++) {
            String str1 = strWords[i];
            if (wordCountMap.containsKey(str1)) {
                count = wordCountMap.get(str1);
                count++;
                wordCountMap.put(str1, count);

            } else
                wordCountMap.put(str1, 1);

        }
        Set<String> set = wordCountMap.keySet();
        Iterator<String> iterator = set.iterator();
        String s = null;
        while (iterator.hasNext()) {
            String key = iterator.next();
            if (wordCountMap.get(key) > 1) {
                s = str.replace(key, "");
                str = s;
            }
        }
        return s;


    }

    public static boolean findWord(String word) {
        String str = "This is Testing done from Selenium";
        String[] str1 = str.split(" ");
        boolean value = false;
        for (String find : str1) {
            if (find.contains(word)) {
                value = true;
            }
        }
        return value;

    }

    public static String replaceWordInString(String word, String replaceWord) {
        String str = "This is Testing done from Selenium";
        String replaceNewString = null;
        if (str.contains(word)) {
            replaceNewString = str.replace(word, replaceWord);
        }
        return replaceNewString != null ? replaceNewString : "Word not found in String";

    }

    public static String removeWordFromString(String str, String word) {
        if (str.contains(word)) {
            String tempWord = word + " ";
            str = str.replace(tempWord, "");
            tempWord = " " + word;
            str = str.replace(tempWord, "");
        } else
            str = null;

        return str != null ? str : "Word not found to remove in String";

    }

    public static int findOccurenceOfWord(String str, String word) {
        int count = 0;
        String[] str1 = str.split(" ");
        for (String string : str1) {
            if (string.contains(word)) {
                count++;
            }
        }
        return count;
    }

    public static List findAnyNumberInDynamicString(String str) {
        List newString = new ArrayList();
        String pattern = "([0-9]+)";
        Pattern compiledPattern = Pattern.compile(pattern);
        Matcher matcher = compiledPattern.matcher(str);
        while (matcher.find()) {
            newString.add(matcher.group() + " ");
        }
        return newString;

    }

    public static StringBuilder findAnyWordInString(String str) {
        StringBuilder newString = new StringBuilder();
        String[] array = str.split(" ");
        String pattern = "([0-9]+)";
        Pattern compiledPattern = Pattern.compile(pattern);
        for (String value : array) {
            if (compiledPattern.matcher(value).matches()) {
                continue;
            }
            newString.append(value);
            newString.append(" ");
        }
        return newString;
    }

    public static boolean compareTwoString(String str, String str1) {
        boolean value = false;
        if (str.equals(str1)) {
            value = true;
        }
        return value;

    }

    public static int countNumberOfWords(String str) {
        int count = 0;
        char[] ch = new char[str.length()];
        for (int i = 0; i < str.length(); i++) {
            ch[i] = str.charAt(i);
            if (((i > 0) && (ch[i] != ' ') && (ch[i - 1] == ' ')) || ((ch[0] != ' ') && (i == 0))) {
                count++;
            }
        }
        return count;
    }

    public static int countNumberOfCharacter(String str) {
        int count = 0;
        String[] string = str.split(" ");
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != ' ') {
                count++;
            }
        }


        return count;
    }

    public static StringBuilder reverseString(String str) {
        StringBuilder str1 = new StringBuilder();
        str1.append(str);
        str1 = str1.reverse();
        return str1;
    }

    public static String reverseSubString(String str) {
        String[] str1 = str.split(" ");
        String reverse = "";
        for (int i = str1.length - 1; i >= 0; i--) {
            reverse += str1[i] + " ";
        }
        return reverse;

    }

    static String findMaximumOccurring(String str) {
        int maximumCount = 0;
        HashMap<Character, Integer> characterCountMap = new HashMap<Character, Integer>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (characterCountMap.containsKey(c)) {
                int count = characterCountMap.get(c);
                count++;
                if (maximumCount < count)
                    maximumCount++;
                characterCountMap.put(c, count);
            } else {
                characterCountMap.put(c, 1);
            }
        }

        Set<Character> set = characterCountMap.keySet();
        Iterator<Character> iterator = set.iterator();
        String key1 = null;
        while (iterator.hasNext()) {
            char key = iterator.next();
            //check count
            if (characterCountMap.get(key) == maximumCount) {
                key1 = String.valueOf(key);
            }
        }
        return key1;
    }


}
