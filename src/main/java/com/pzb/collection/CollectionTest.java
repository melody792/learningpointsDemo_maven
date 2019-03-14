package com.pzb.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class CollectionTest {
    public static void main(String[] args) {
        Collection c = new ArrayList();
//        c.add("小明");
//        c.add(6);
//        System.out.println("c集合的元素个数为：" + c.size());
//        c.remove(6);
//        System.out.println("c集合的元素个数为：" + c.size());
//        System.out.println("c集合是否包含\"小明\"字符串：" + c.contains("小明"));
//        c.add("JavaEE");
//        System.out.println("c集合的元素：" + c);

        Collection books = new HashSet();
        books.add(null);
        books.add("JavaEE");
        books.add("Android");
        Iterator t = books.iterator();
        Object str =null;

        str = t.next();
        System.out.println("========================"+str);
//        System.out.println("c集合是否完全包含books集合？" + c.containsAll(books));
//        c.removeAll(books);
//        System.out.println("c集合的元素：" + c);
//        c.clear();
//        System.out.println("c集合的元素：" + c);
//        //books集合里只剩下c集合里也包含的元素
//        books.retainAll(c);
//        System.out.println("books集合的元素：" + books);
        Map<String, Integer> unsortMap = new TreeMap<>((o1,o2)->o2.compareTo(o1));
        unsortMap.put("z", 10);
        unsortMap.put("b", 5);
        unsortMap.put("a", 6);
        unsortMap.put("c", 20);
        unsortMap.put("d", 1);
        unsortMap.put("e", 7);
        unsortMap.put("y", 8);
        unsortMap.put("n", 99);
        unsortMap.put("g", 50);
        unsortMap.put("user_apply", 2);
        unsortMap.put("user_rank", 9);
        Comparator<Entry<String, Integer>> comparator = (k1,k2)->k1.getKey().compareTo(k2.getKey());
        Map<String, Integer> result = unsortMap.entrySet().stream()
                .sorted(comparator.reversed())
                .collect(Collectors.toMap(Entry::getKey, Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
        Iterator<Entry<String, Integer>> it = unsortMap.entrySet().iterator();
        while(it.hasNext()) {
            Entry<String, Integer> entry = it.next();
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}
