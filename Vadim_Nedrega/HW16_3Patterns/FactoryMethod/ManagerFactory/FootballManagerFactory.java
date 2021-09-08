package vadim_nedrega.HW16_3Patterns.FactoryMethod.ManagerFactory;

import vadim_nedrega.HW16_3Patterns.FactoryMethod.Manager.FootballManager;
import vadim_nedrega.HW16_3Patterns.FactoryMethod.Manager.SportManager;

public class FootballManagerFactory extends ManagerFactory {
    @Override
    public SportManager create() {
        return new FootballManager();
    }
}
