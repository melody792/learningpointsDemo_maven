package com.pzb.collection;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 描述:
 *
 * @author pzb
 * @create 2019-01-10 11:01 PM
 */
public class ListGroupLamda {
    public static void main(String[] args) {
        test1();
    }

    private static void test1() {
        List<BlogPost> blogPostList = Lists.newArrayList();
        blogPostList.add(new BlogPost("post1", "zhuoli", 1, 30));
        blogPostList.add(new BlogPost("post2", "zhuoli", 1, 40));
        blogPostList.add(new BlogPost("post3", "zhuoli", 2, 15));
        blogPostList.add(new BlogPost("post4", "zhuoli", 3, 33));
        blogPostList.add(new BlogPost("post5", "Alice", 1, 99));
        blogPostList.add(new BlogPost("post6", "Michael", 3, 65));

        Map<String, Map<Integer, List<BlogPost>>> map = blogPostList.stream()
                .collect(Collectors.groupingBy(BlogPost::getAuthor, Collectors.groupingBy(BlogPost::getType)));
        System.out.println(map);
    }
}
