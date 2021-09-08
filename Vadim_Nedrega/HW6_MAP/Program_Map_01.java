package vadim_nedrega.HW6_MAP;

import java.util.LinkedList;
import java.util.Set;

public class Program_Map_01 {
    public static void main(String[] args) {


        MyMapa<Integer, String> myMapa = new MyMapa<>();
        myMapa.put(1, "First");
        myMapa.put(2, "Second");
        myMapa.put(3, "Third");
        myMapa.put(4, null);
        myMapa.put(5, null);
        myMapa.put(6, "Sixth");

        System.out.println("Текущий размер: " + myMapa.size());
        System.out.println("Пустая? " + myMapa.isEmpty());
        System.out.println("Ключ по значению: " + myMapa.containsKey(3));
        System.out.println("Value по значению: " + myMapa.containsValue("Second"));
        System.out.println("Получить значение по ключу: " + myMapa.get(2));
        System.out.println(myMapa.remove(3));


        Set<Integer> keys = myMapa.keySet();
        System.out.println("Ключи: " + keys);

        LinkedList<String> values = new LinkedList<>(myMapa.values());
        System.out.println("Значения: " + values);

        myMapa.clear();
        System.out.println("Проверка удаления, размер = " + myMapa.size());
        System.out.println("___________________________________________________________");



    }
}
