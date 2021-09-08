package vadim_nedrega.HW5Collections.LinkList;

import java.util.Arrays;
import java.util.Iterator;

public class Program_LinkList_01 {
    public static void main(String[] args) {
        MyLinkList<String> list = new MyLinkList<>();
        list.add("First");
        list.add("Second");
        list.add("Third");
        MyLinkList<String> list1 = new MyLinkList<>();
        list1.add("Fourth");
        list1.add("Fifth");
        list1.add("First");
        System.out.println(Arrays.toString(list.toArray()));
        list.addFirst("zero");
        System.out.println(Arrays.toString(list.toArray()));
        System.out.println(list.isEmpty());

        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext())
        {
            String text = iterator.next();

            System.out.println(text);
        }

        System.out.println(list.contains("Bla-bla"));
        System.out.println(list);
//        list.remove("Second"); //не работает, пока не знаю как исправить    ???
        System.out.println(list);
        System.out.println(list.contains("Second"));
        System.out.println(Arrays.toString(list.toArray()));
        list.clear();
        System.out.println(Arrays.toString(list.toArray()));
        System.out.println(list.get(2));
        System.out.println(list.get(0));
        System.out.println(Arrays.toString(list.toArray()));
        System.out.println(list.indexOf("Second"));
        System.out.println(list.lastIndexOf("Third"));
//        System.out.println(list.subList(0,1)); //не работает, пока не знаю как исправить    ???
    }
}
