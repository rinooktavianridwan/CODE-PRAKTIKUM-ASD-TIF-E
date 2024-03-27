package Pertemuan1;
import java.util.*;
public class TestCollections {
    public static void main(String[] args) {
     LinkedList <Integer> ll = new LinkedList<>();
     ll.add(1);
     ll.add(2);


     //Stack
        Stack <String> s = new Stack<>();
        s.push("a");
        s.push("b");
        s.pop();
        System.out.println(s.isEmpty());

        System.out.println(s);

        //Queue
        Queue <String> q = new LinkedList<>();
        q.add("a");


        //Set
        Set <String> set = new HashSet<>();
        set.add("a");
        set.add("a");
        set.add("a");
        set.add("a");
        set.add("a");
        System.out.println(set);
        System.out.println();
        //Map
        //key : value
//        Map<String, Integer> m = new HashMap<>();
//        m.put("FF", 8);
//        m.put("A", 12);
//        m.put("B", 2);
//        m.put("C", 112);
//        m.put("D", 123);
//        m.put("E", 1233);
//        System.out.println(m);
        System.out.println();
        Map<String, Integer> m1 = new TreeMap<>();
        m1.put("FF", 8);
        m1.put("A", 12);
        m1.put("B", 2);
        m1.put("C", 112);
        m1.put("D", 123);
        m1.put("E", 1233);
        System.out.println(m1);
        System.out.println();

        Map<String, Integer> m2 = new LinkedHashMap<>();
        m2.put("FF", 8);
        m2.put("A", 12);
        m2.put("B", 2);
        m2.put("C", 112);
        m2.put("D", 123);
        m2.put("E", 1233);
        System.out.println(m2);

        Map <String, List<Integer>> ml = new HashMap<>();
        ml.put("A", new ArrayList<>(Arrays.asList(1,2,3)));
        System.out.println(ml);

        ml.get("A").add(70);
        System.out.println(ml);







    }

}
