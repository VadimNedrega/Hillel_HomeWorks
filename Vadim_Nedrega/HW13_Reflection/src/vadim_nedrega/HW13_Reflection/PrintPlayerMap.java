package vadim_nedrega.HW13_Reflection.src.vadim_nedrega.HW13_Reflection;

import vadim_nedrega.HW13_Reflection.src.vadim_nedrega.HW13_Reflection.Player.Player;

import java.util.Map;

public class PrintPlayerMap implements PrintMap<Player, Integer> {

    @Override
    public void print(Map<?, ? extends Number> map) {
        for (Map.Entry<?, ? extends Number> entry : map.entrySet()) {
            Player key = (Player) entry.getKey();
            Integer value = (Integer) entry.getValue();
            System.out.println("key = " + key + " ______value = " + value);
        }
    }
}
