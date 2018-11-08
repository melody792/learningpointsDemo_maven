package com.pzb.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

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
        System.out.println(str);
//        System.out.println("c集合是否完全包含books集合？" + c.containsAll(books));
//        c.removeAll(books);
//        System.out.println("c集合的元素：" + c);
//        c.clear();
//        System.out.println("c集合的元素：" + c);
//        //books集合里只剩下c集合里也包含的元素
//        books.retainAll(c);
//        System.out.println("books集合的元素：" + books);
    }
}
