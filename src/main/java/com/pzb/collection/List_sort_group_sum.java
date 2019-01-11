package com.pzb.collection;

import java.math.BigDecimal;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * 描述:
 * Java 8 – List分组GroupBy
 * @author pzb
 * @create 2019-01-10 5:46 PM
 */
public class List_sort_group_sum {
    static class Report{
        String id;
        String title;
        String kind;
        int count;
    }
    public static void main(String[] args) {
        //listGroup();
        //listGroupByObject();
        listGroupCount();
    }

    private static void listGroupCount() {
        List<Item> items = Arrays.asList(
                new Item("111er","apple", "click"),
                new Item("111er","apple", "click"),
                new Item("111er","apple", "click"),
                new Item("111er","apple", "apply"),
                new Item("111er","apple", "apply"),
                new Item("222er","banana", "click"),
                new Item("222er","banana", "click"),
                new Item("222er","banana", "apply"),
                new Item("333er","papaya", "apply"),
                new Item("333er","papaya", "click")
        );
        Map<String ,Map<String, List<Item>>> groupbyKind = items.stream().collect(Collectors.groupingBy(Item::getKind,
                Collectors.groupingBy(Item::getId)));
        Map<String, Map<String, Item>> newGroupKind = new HashMap<>();
        groupbyKind.forEach((kind, itemMap)->{
            Map<String, Item> newItemMap = new HashMap<>();
            itemMap.forEach((jobId, newItemList)->{
                newItemList.get(0).setQty(newItemList.size());
                Item item = newItemList.get(0);
                newItemMap.put(jobId, item);
            });
            newGroupKind.put(kind, newItemMap);
        });
        List<Item> listAfterGroup = new ArrayList<>();
//        groupbyKind.forEach((kind,list) -> {
//            list.stream().collect(Collectors.groupingBy(Item::getId)).forEach((id, itemList)->{
//                Optional<Item> newItem = itemList.stream().reduce((v1, v2)->{
//                     v1.setQty(1);
//                     return v1;
//                });
//                listAfterGroup.add(newItem.orElse(new Item("","","")));
//            });
//        });
        Map<String, Report> reports = new HashMap<>();
//        for (Item item :items){
//            Report report = reports.get(item.getId());
//            if (report==null){
//                report = new Report();
//                report.id=item.getId();
//                report.title=item.getName();
//            }
//            if ("click".equals(item.getKind())){
//                report.count++;
//                report.kind = item.getKind();
//            } else {
//                report.count++;
//                report.kind = item.getKind();
//            }
//            reports.put(item.getId(), report);
//        }
        System.out.println("============================");
    }

    private static void listGroupByObject() {
        //3 apple, 2 banana, others 1
        System.out.println("=================================");
        List<Item> items = Arrays.asList(
                new Item("111er","apple", 10, new BigDecimal("9.99")),
                new Item("222er","banana", 20, new BigDecimal("19.99")),
                new Item("555er","orang", 10, new BigDecimal("29.99")),
                new Item("444er","watermelon", 10, new BigDecimal("29.99")),
                new Item("333er","papaya", 20, new BigDecimal("9.99")),
                new Item("111er","apple", 10, new BigDecimal("9.99")),
                new Item("222er","banana", 10, new BigDecimal("19.99")),
                new Item("111er","apple", 20, new BigDecimal("9.99"))
        );

        Map<String, Long> counting = items.stream().collect(
                Collectors.groupingBy(Item::getName, Collectors.counting()));

        System.out.println(counting);

        Map<String, Integer> sum = items.stream().collect(
                Collectors.groupingBy(Item::getName, Collectors.summingInt(Item::getQty)));

        System.out.println(sum);

        System.out.println("================group by Name=================");
        //group by price
        Map<String , List<Item>> groupByPriceMap =
                items.stream().collect(Collectors.groupingBy(Item::getName));

        System.out.println(groupByPriceMap);

        System.out.println("================group by price, uses 'mapping' to convert List<item> to Set<string>=================");
        // group by price, uses 'mapping' to convert List<item> to Set<string>
        Map<BigDecimal, Set<String>> result =
                items.stream().collect(Collectors.groupingBy(Item::getPrice, Collectors.mapping(Item::getName, Collectors.toSet())));

        System.out.println(result);
    }

    private static void listGroup() {
        //3 apple, 2 banana, others 1
        System.out.println("=================================");
        List<String> items = Arrays.asList("apple", "apple", "banana",
                        "apple", "orange", "banana", "papaya");

        Map<String, Long> result = items.stream().collect(
                        Collectors.groupingBy(Function.identity(), Collectors.counting())
                );

        System.out.println(result);
    }

}