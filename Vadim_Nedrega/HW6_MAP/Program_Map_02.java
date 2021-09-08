package vadim_nedrega.HW6_MAP;

import java.util.LinkedList;
import java.util.Set;

public class Program_Map_02 {

    public static void main(String[] args) {
        Cat sea = new Cat();
        Cat vaska = new Cat();

        sea.setId(1234);
        vaska.setId(1235);

        sea.setAge(4);
        vaska.setAge(4);

        sea.setName("Sea");
        vaska.setName("Sea");

        sea.setColor("Grey");
        vaska.setColor("Grey");

        System.out.println(sea.equals(vaska));

        MyMapa<Integer, Cat> myMapa = new MyMapa<>();
        myMapa.put(1, sea);
        myMapa.put(2, vaska);
        myMapa.put(3, vaska);

        Set<Integer> keys = myMapa.keySet();
        System.out.println("Ключи: " + keys);

        LinkedList<Cat> values = new LinkedList<>(myMapa.values());
        System.out.println("Значения: " + values.toString());

        System.out.println(sea.hashCode()==vaska.hashCode());
    }
}
