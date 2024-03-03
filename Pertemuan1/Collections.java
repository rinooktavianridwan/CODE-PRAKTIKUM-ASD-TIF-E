//package Pertemuan1;
//
//import java.util.*;
//
//public class Collections {
//    public static void main(String[] args) {
//
//        //List
//        LinkedList <String> ll = new LinkedList<String>();
//        ll.add("rino");
//        ll.add("irul");
//
//        System.out.println(ll);
//        ll.addLast("terkahir");
//        System.out.println(ll);
//        ll.remove("terakhir");
//
//        LinkedList<Integer> llint = new LinkedList<Integer>();
//        llint.add(1);
//        llint.add(2);
//        System.out.println(llint);
//        llint.clear();
//        System.out.println(llint);
//
//        //Stack
//        Stack <String> s = new Stack<String>();
//        s.push("pertama");
//        s.push("kedua");
//        System.out.println(s);
//
//        s.peek();
//        s.pop();
//        System.out.println(s);
//
//        //Queue
//        Queue<String> q = new LinkedList<>();
//        System.out.println(q.isEmpty());
//        q.add("A");
//        q.add("B");
//        q.add("C");
//        System.out.println(q);
//        System.out.println(q.peek());
//
//        //Set
//        Set <String> st = new HashSet<>();
//        st.add("pisang");
//        st.add("apel");
//        st.add("semangka");
//        st.add("semangka");
//        st.add("nanas");
//        System.out.println(st);
//        st.remove("apel");
//        System.out.println(st);
//
//        Set <Integer> stree = new TreeSet<>();
//        stree.add(1);
//        stree.add(100);
//        stree.add(2);
//        stree.add(10);
//
//        System.out.println(stree);
//
//        //Map
//        Map<String, Integer> m = new HashMap<String, Integer>();
//        m.put("ernu" , 69);
//        m.put("rino" , 60);
//        m.put("irul" , 6);
//        m.put("nanta" , 16);
//        System.out.println(m);
//
//        Map<String, Integer> m1 = new TreeMap<>();
//        m1.put("ernu" , 69);
//        m1.put("rino" , 60);
//        m1.put("irul" , 6);
//        m1.put("nanta" , 16);
//        System.out.println(m1);
//
//        Map<String, Integer> m2 = new LinkedHashMap<>();
//        m2.put("ernu" , 69);
//        m2.put("ernu" , 61);
//        m2.put("rino" , 60);
//        m2.put("irul" , 6);
//        m2.put("nanta" , 16);
//        System.out.println(m2);
//
//        System.out.println();
//        Map<String, List<Integer>> m3 = new HashMap<>();
//        m3.put("A", new ArrayList<>(Arrays.asList(1, 2, 3)));
//        m3.put("B", new ArrayList<>(Arrays.asList(4, 5)));
//        m3.put("C", new ArrayList<>(Arrays.asList(6, 7, 8)));
//        System.out.println(m3);
//
//        m3.get("A").add(1);
//        System.out.println(m3);
//
//
//    }
//}
