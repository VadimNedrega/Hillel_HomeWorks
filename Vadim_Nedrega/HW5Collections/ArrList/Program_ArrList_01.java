package vadim_nedrega.HW5Collections.ArrList;

import java.util.Arrays;

public class Program_ArrList_01 {
    public static void main(String[] args) {
        MyArrList.ArrList<String> list = new MyArrList.ArrList<>();
        MyArrList.ArrList<String> list1 = new MyArrList.ArrList<>();
        list.add("First");
        list.add("First");
        list.add("First");
        System.out.println(Arrays.toString(list.toArray()));
        list.add(1, "Zero");
        list1.add("Second");
        list.addAll(2, list1);
        System.out.println(Arrays.toString(list.toArray()));
        list.remove(4);
        System.out.println(Arrays.toString(list1.toArray()));
        list.addAll(list1);
        System.out.println(list);
        System.out.println(list.isEmpty());
        System.out.println(list.contains("Second"));
        System.out.println(list.set(0, "New"));
        list.clear();
        System.out.println(Arrays.toString(list.toArray()));
        System.out.println(list.contains("Second"));
    }
}
