package com.mantis.lambda.util;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

/**
 * @Description:使用labmda进行排序
 * @author: wei.wang
 * @since: 2020/7/27 9:40
 * @history: 1.2020/7/27 created by wei.wang
 */
public class SortUtil {

    private static List<String> stringList1 = new ArrayList<>();
    private static List<Integer> integerList1 = new ArrayList<>();
    static Random r = new Random(1);

    public SortUtil() {
        for (int i = 0; i < 100000; i++) {
            integerList1.add(r.nextInt(100000));
            stringList1.add(String.valueOf(r.nextInt(100000)));
        }
    }

    /**
     * 排序
     * Comparator.comparing(类::属性一).reversed(); 得到排序结果后再排序
     * Comparator.comparing(类::属性一,Comparator.reverseOrder());  直接进行排序，所以效率更高
     * Integer因为没有类型转换，所以更快
     * 排100000个数可以明显看到效果
     */
    public static void sort() {
        System.out.println("String排序");

//        stringList1.sort(Comparator.comparing(String::toString));
//        System.out.println(stringList1);

        //stringList1.stream().sorted().forEach(s -> System.out.print(s + " "));
//        stringList1.stream().sorted();
//        System.out.println();

        //stringList1.sort((a, b) -> Integer.valueOf(a) - Integer.valueOf(b));
        //System.out.println(stringList1);

        Long current = System.currentTimeMillis();
        //stringList1.stream().sorted(Comparator.comparing(s -> Integer.parseInt(String.valueOf(s))).reversed()).forEach(s -> System.out.print(s + " "));
        stringList1.stream().sorted(Comparator.comparing(s -> Integer.parseInt(String.valueOf(s))));
        System.out.println();
        System.out.println(System.currentTimeMillis() - current);

        current = System.currentTimeMillis();
        //stringList1.stream().sorted(Comparator.comparing(Integer::valueOf, Comparator.reverseOrder())).forEach(s -> System.out.print(s + " "));
        stringList1.stream().sorted(Comparator.comparing(Integer::valueOf, Comparator.reverseOrder()));
        System.out.println();
        System.out.println(System.currentTimeMillis() - current);

        System.out.println("Integer排序");
        current = System.currentTimeMillis();
        //integerList1.stream().sorted(Comparator.reverseOrder()).forEach(s -> System.out.print(s + " "));
        integerList1.stream().sorted(Comparator.reverseOrder());
        System.out.println();
        System.out.println(System.currentTimeMillis() - current);
    }

    public static void main(String[] args) {
        new SortUtil();
        sort();
    }
}
