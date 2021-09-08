package vadim_nedrega.HW16_3Patterns.FactoryMethod.ManagerFactory;

import vadim_nedrega.HW16_3Patterns.FactoryMethod.Manager.SportManager;
import vadim_nedrega.HW16_3Patterns.FactoryMethod.Manager.WaterPoloManager;

public class WaterPoloManagerFactory extends ManagerFactory {
    @Override
    public SportManager create() {
        return new WaterPoloManager();
    }
}
