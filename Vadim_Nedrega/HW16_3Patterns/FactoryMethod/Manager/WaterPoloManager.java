package vadim_nedrega.HW16_3Patterns.FactoryMethod.Manager;

import vadim_nedrega.HW16_3Patterns.FactoryMethod.Player.Player;

public class WaterPoloManager implements SportManager {
    @Override
    public void coach(Player player) {
        System.out.println("Ща покажу как батя делает");
    }

    @Override
    public void kickAss(Player player) {
        System.out.println("Тони, или сам утоплю");
    }

}
