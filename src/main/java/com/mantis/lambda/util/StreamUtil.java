package com.mantis.lambda.util;

import com.mantis.lambda.pojo.Student;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Description:
 * @author: wei.wang
 * @since: 2020/6/16 13:29
 * @history: 1.2020/6/16 created by wei.wang
 */
public class StreamUtil {


    private static List<String> stringList1 = new ArrayList<>();

    private static List<String> stringList2 = new ArrayList<>();

    private static List<String> stringList3 = new ArrayList<>();

    private static int[] intArray = {4, 5, 3, 6, 2, 5, 1};

    private static List<Integer> list = new ArrayList<>();

    private static Integer[] integerArray = {4, 5, 3, 6, 2, 5, 1};

    private static String[] stringArray = {"a", "b", "c"};

    private static List<String> stringList = Arrays.asList(stringArray);

    public StreamUtil() {

        stringList1.add("A");
        stringList1.add("B");
        stringList1.add("C");
        stringList1.add("E");
        stringList1.add("H");

        stringList2.add("D");
        stringList2.add("F");
        stringList2.add("G");
        stringList2.add("H");
        stringList2.add("A");

        stringList3.add("R");
        stringList3.add("F");
        stringList3.add("V");
        stringList3.add("B");
        stringList3.add("H");

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
    }


    /**
     * int[] 转 List<Integer>
     */
    private static void intArrayToIntegerList() {
        List<Integer> list1 = Arrays.stream(intArray).boxed().collect(Collectors.toList());
        // Arrays.stream(arr) 可以替换成IntStream.of(arr)。
        // 1.使用Arrays.stream将int[]转换成IntStream。
        // 2.使用IntStream中的boxed()装箱。将IntStream转换成Stream<Integer>。
        // 3.使用Stream的collect()，将Stream<T>转换成List<T>，因此正是List<Integer>。
        System.out.println("int[] 转 List<Integer>");
        list1.forEach(o -> System.out.print(o + " "));
        System.out.println();
    }

    /**
     * int[] 转 Integer[]
     */
    private static void intArrayToIntegerArray() {
        Integer[] integers1 = Arrays.stream(intArray).boxed().toArray(Integer[]::new);
        // 前两步同上，此时是Stream<Integer>。
        // 然后使用Stream的toArray，传入IntFunction<A[]> generator。
        // 这样就可以返回Integer数组。
        // 不然默认是Object[]。
        System.out.println("int[] 转 Integer[]");
        Arrays.stream(integers1).forEach(o -> System.out.print(o + " "));
        System.out.println();
    }

    /**
     * List<Integer> 转 Integer[]
     */
    private static void integerListToIntegerArray() {
        Integer[] integers2 = list.toArray(new Integer[0]);
        //  调用toArray。传入参数T[] a。这种用法是目前推荐的。
        // List<String>转String[]也同理。
        System.out.println("List<Integer> 转 Integer[]");
        Arrays.stream(integers2).forEach(o -> System.out.print(o + " "));
        System.out.println();
    }

    /**
     * List<Integer> 转 int[]
     */
    private static void integerListToIntArray() {
        int[] arr1 = list.stream().mapToInt(Integer::valueOf).toArray();
        // 想要转换成int[]类型，就得先转成IntStream。
        // 这里就通过mapToInt()把Stream<Integer>调用Integer::valueOf来转成IntStream
        // 而IntStream中默认toArray()转成int[]。
        System.out.println("List<Integer> 转 int[]");
        Arrays.stream(arr1).forEach(o -> System.out.print(o + " "));
        System.out.println();
    }

    /**
     * Integer[] 转 int[]
     */
    private static void integerArrayToIntArray() {
        int[] arr2 = Arrays.stream(integerArray).mapToInt(Integer::valueOf).toArray();
        // 思路同上。先将Integer[]转成Stream<Integer>，再转成IntStream。
        System.out.println("Integer[] 转 int[]");
        Arrays.stream(arr2).forEach(o -> System.out.print(o + " "));
        System.out.println();
    }

    /**
     * String[] 转 List<String>
     */
    private static void stringArrayToStringList() {
        List<String> list = Arrays.asList(stringArray);
        System.out.println("String[] 转 List<String>");
        list.forEach(o -> System.out.print(o + " "));
        System.out.println();
    }

    /**
     * List<String> 转 String[]
     */
    private static void stringListToStringArray() {
        String[] strings = stringList.toArray(new String[0]);
        System.out.println("List<String> 转 String[]");
        Arrays.stream(strings).forEach(o -> System.out.print(o + " "));
        System.out.println();

    }

    /**
     * 两个List<String>合并成一个(拍扁)
     */
    private static void mergeList1() {
        System.out.println("两个List<String>合并成一个(拍扁)");
        List<List<String>> listList = new ArrayList<>();
        listList.add(stringList1);
        listList.add(stringList2);
        List<String> mergeList = listList.stream().flatMap(Collection::stream).collect(Collectors.toList());
        mergeList.forEach(o -> System.out.print(o + " "));
        System.out.println();
    }


    /**
     * 三个List<String>合并成一个(拍扁)
     */
    private static void mergeList2() {
        System.out.println("三个List<String>合并成一个(拍扁)");
        List<String> mergeList1 = Stream.of(stringList1, stringList2, stringList3).flatMap(Collection::stream).collect(Collectors.toList());
        mergeList1.forEach(o -> System.out.print(o + " "));
        System.out.println();
    }

    /**
     * 遍历一个List，根据List返回列表构成新的列表
     */
    private static void mergeList3() {
        List<String> stringList = new ArrayList<>();
        stringList.add("1");
        stringList.add("2");
        stringList.add("3");
        System.out.println("遍历一个List，根据List返回列表构成新的列表");
        List<String> result = stringList.stream().map(StreamUtil::queryList).flatMap(Collection::stream).sorted().distinct().collect(Collectors.toList());
        result.forEach(str -> {
            System.out.print(str + " ");
        });
        System.out.println();
    }

    /**
     * 使用Map进行合并
     */
    private static void mapToStringList() {
        System.out.println("使用Map进行合并");
        Map<Integer, List<String>> map = new HashMap<>(16);
        map.put(1, stringList1);
        map.put(2, stringList2);
        List<String> mergeList2 = map.values().stream().flatMap(Collection::stream).collect(Collectors.toList());
        mergeList2.forEach(str -> {
            System.out.print(str + " ");
        });
        System.out.println();
    }

    /**
     * 将Stream转换成容器或Map
     * 1. Java 8允许在接口中加入具体方法。接口中的具体方法有两种，default方法和static方法，identity()就是Function接口的一个静态方法。
     * 2. Function.identity()返回一个输出跟输入一样的Lambda表达式对象，等价于形如t -> t形式的Lambda表达式。
     */
    private static void switchStreamToMap() {
        Stream<String> stream = Stream.of("A12", "F4", "F1", "SU35");
        Map<String, Integer> map = stream.filter(o -> o.length() > 1).collect(Collectors.toMap(Function.identity(), String::length));
        System.out.println(String.format("将Stream转换成容器或Map %s", map));
    }


    /**
     * 交集
     *
     * @return
     */
    private static void intersectResult() {
        List<String> intersectResult = stringList1.stream().filter(stringList2::contains).collect(Collectors.toList());
        System.out.println(String.format("stringList1和stringList2的交集 %s", intersectResult));
    }

    /**
     * 并集
     *
     * @return
     */
    private static void unionResult() {
        List<String> unionResult = Stream.of(stringList1, stringList2).flatMap(Collection::stream).distinct().collect(Collectors.toList());
        System.out.println(String.format("stringList1和stringList2的并集 %s", unionResult));
    }

    /**
     * 差集
     *
     * @return
     */
    private static void differenceResult() {
        List<String> differenceResult = stringList1.stream().filter(x -> !stringList2.contains(x)).collect(Collectors.toList());
        System.out.println(String.format("stringList1和stringList2的差集 %s", differenceResult));

    }

    private static void groupStudent() {

        Student student1 = new Student("AK47", 90, "SU");
        Student student2 = new Student("56", 88, "SU");
        Student student3 = new Student("M14", 90, "M");
        Student student4 = new Student("M16", 89, "M");
        Student student5 = new Student("AK74", 85, "SU");
        Student student6 = new Student("AK74", 85, "SU");

        List<Student> studentList = new ArrayList<>();
        studentList.add(student1);
        studentList.add(student2);
        studentList.add(student3);
        studentList.add(student4);
        studentList.add(student5);
        studentList.add(student6);

        //根据部门分组对象
        Map<String, List<Student>> byDept1 = studentList.stream()
                .collect(Collectors.groupingBy(Student::getDepartment));
        System.out.println("根据部门分组对象 " + byDept1);

        //根据部门计算数量
        Map<String, Long> studentMap = studentList.stream()
                .collect(Collectors.groupingBy(Student::getDepartment,
                        Collectors.counting()));
        System.out.println("根据部门分组数量 " + studentMap);

        //根据分数分组
        Map<Integer, List<String>> studentMap1 = studentList.stream()
                .collect(Collectors.groupingBy(Student::getGrade,
                        Collectors.mapping(Student::getName,
                                Collectors.toList())));
        System.out.println("根据分数分组 " + studentMap1);

        //根据部门分组姓名
        Map<String, List<String>> byDept2 = studentList.stream()
                .collect(Collectors.groupingBy(Student::getDepartment,
                        Collectors.mapping(Student::getName,
                                Collectors.toList())));
        System.out.println("根据部门分组姓名 " + byDept2);
    }

    /**
     * 使用Collectors.joining()拼接字符串
     */
    public static void joinStr() {
        System.out.println("使用Collectors.joining()拼接字符串");
        System.out.println(stringList1.stream().collect(Collectors.joining(",", "{", "}")));
        System.out.println(String.join(",", stringList1));
        System.out.println(String.join("", stringList1));
    }

    /**
     * 模拟根据不同code返回不同数据
     *
     * @param code
     * @return
     */
    public static List<String> queryList(String code) {
        List<String> stringList = new ArrayList<>();
        if ("1".equals(code)) {
            stringList.add("C1");
            stringList.add("C6");
        } else if ("2".equals(code)) {
            stringList.add("C1");
            stringList.add("C2");
            stringList.add("C5");
        } else {
            stringList.add("C1");
            stringList.add("C2");
            stringList.add("C3");
            stringList.add("C4");
        }
        return stringList;
    }


    public static void main(String[] args) {

        new StreamUtil();

        intArrayToIntegerList();
        intArrayToIntegerArray();
        integerListToIntegerArray();
        integerListToIntArray();
        integerArrayToIntArray();
        stringArrayToStringList();
        stringListToStringArray();

        mergeList1();
        mergeList2();
        mergeList3();

        mapToStringList();
        switchStreamToMap();

        intersectResult();
        unionResult();
        differenceResult();

        groupStudent();

        joinStr();
    }
}
