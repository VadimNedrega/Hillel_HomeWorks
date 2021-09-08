package vadim_nedrega.HW16_3Patterns.FactoryMethod;

import vadim_nedrega.HW16_3Patterns.FactoryMethod.ManagerFactory.FootballManagerFactory;
import vadim_nedrega.HW16_3Patterns.FactoryMethod.ManagerFactory.ManagerFactory;
import vadim_nedrega.HW16_3Patterns.FactoryMethod.ManagerFactory.WaterPoloManagerFactory;
import vadim_nedrega.HW16_3Patterns.FactoryMethod.Player.FootballPlayer;
import vadim_nedrega.HW16_3Patterns.FactoryMethod.Player.Player;
import vadim_nedrega.HW16_3Patterns.FactoryMethod.Player.WaterPoloPlayer;

public class Program_16_04 {
    public static void main(String[] args) {
        Player player1 = new FootballPlayer("Vasja", true, 21);
        Player player2 = new WaterPoloPlayer("Petja", true, 21);

        ManagerFactory[] managerFactories = {new WaterPoloManagerFactory(), new FootballManagerFactory()};
        for (ManagerFactory managerFactory : managerFactories) {
            managerFactory.create().coach(player2);
            managerFactory.create().kickAss(player1);
        }
    }
}
