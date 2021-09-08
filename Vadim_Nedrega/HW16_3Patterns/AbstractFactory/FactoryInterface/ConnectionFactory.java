package vadim_nedrega.HW16_3Patterns.AbstractFactory.FactoryInterface;

import vadim_nedrega.HW16_3Patterns.AbstractFactory.ConnectionInterfaces.MobilePhone;
import vadim_nedrega.HW16_3Patterns.AbstractFactory.ConnectionInterfaces.RadioCommutation;
import vadim_nedrega.HW16_3Patterns.AbstractFactory.ConnectionInterfaces.Telegraph;

public interface ConnectionFactory {
    MobilePhone createMobilePhone();

    RadioCommutation createRadioCommutation();

    Telegraph createTelegraph();
}
